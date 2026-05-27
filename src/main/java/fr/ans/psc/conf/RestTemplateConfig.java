package fr.ans.psc.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.openapitools.jackson.nullable.JsonNullableModule;

import fr.ans.psc.amar.v2.ApiClient;
import fr.ans.psc.amar.v2.api.TheEimsManagementApiApi;

@Configuration
public class RestTemplateConfig {

	@Value("${in.amar.url:https://api.ppd.iss.esante.gouv.fr/v1/amar}")
	private String amarApiUrl;

	@Value("${in.amar.api.key:}")
	private String amarApiKey;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public TheEimsManagementApiApi eimsApi() {
		// On reproduit la config du buildRestTemplate() du client généré (buffering +
		// encodage URL VALUES_ONLY) et on enregistre en plus JsonNullableModule sur le
		// converter Jackson : le RestTemplate par défaut du client AMAR ne le configure pas,
		// ce qui casse la désérialisation du champ attributes (JsonNullable<Object>) d'AbstractEimObject.
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
		uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
		restTemplate.setUriTemplateHandler(uriBuilderFactory);

		restTemplate.getMessageConverters().stream()
				.filter(MappingJackson2HttpMessageConverter.class::isInstance)
				.map(MappingJackson2HttpMessageConverter.class::cast)
				.forEach(converter -> {
					ObjectMapper mapper = converter.getObjectMapper();
					mapper.registerModule(new JsonNullableModule());
					mapper.registerModule(new JavaTimeModule());
					mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
				});

		ApiClient client = new ApiClient(restTemplate);
		client.setBasePath(amarApiUrl);
		client.addDefaultHeader("ANS-Api-Key", amarApiKey);
		return new TheEimsManagementApiApi(client);
	}
}
