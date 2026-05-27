package fr.ans.psc.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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
		ApiClient client = new ApiClient();
		client.setBasePath(amarApiUrl);
		client.addDefaultHeader("ANS-Api-Key", amarApiKey);
		return new TheEimsManagementApiApi(client);
	}
}