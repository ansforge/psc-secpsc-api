package org.openapitools.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.ans.psc.amar.v2.model.AbstractEim;
import fr.ans.psc.amar.v2.model.AbstractEimObject;
import fr.ans.psc.amar.v2.model.EimsSummary;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class EimsMappingTest {

    @Test
    void toAbstractEim_mapsAllFields() {
        OffsetDateTime creation = OffsetDateTime.parse("2026-05-21T08:20:21Z");
        OffsetDateTime endValidity = OffsetDateTime.parse("2029-05-20T08:20:21Z");
        Map<String, Object> attributes = new LinkedHashMap<>();
        attributes.put("deviceName", "2412DPC0AG");
        attributes.put("operatingSystem", "Android 16");
        attributes.put("appVersion", "3.17.16");
        attributes.put("activationMode", "CONTACTS");

        AbstractEimObject source = new AbstractEimObject();
        source.setNationalId("81020201019");
        source.setType("WALLET");
        source.setCreationDate(creation);
        source.setEndOfValidityDate(endValidity);
        source.setEidasLevel(AbstractEimObject.EidasLevelEnum.fromValue(1));
        source.setAttributes(attributes);

        AbstractEim target = PsiApiController.toAbstractEim(source);

        assertThat(target.getNationalId()).isEqualTo("81020201019");
        assertThat(target.getType()).isEqualTo("WALLET");
        assertThat(target.getCreationDate()).isEqualTo(creation);
        assertThat(target.getEndOfValidityDate()).isEqualTo(endValidity);
        assertThat(target.getEidasLevel()).isEqualTo(AbstractEim.EidasLevelEnum.fromValue(1));
        assertThat(target.getAttributes()).isEqualTo(attributes);
    }

    @Test
    void toAbstractEim_handlesNullEidasLevel() {
        AbstractEimObject source = new AbstractEimObject();
        source.setNationalId("81020201019");
        source.setType("WALLET");

        AbstractEim target = PsiApiController.toAbstractEim(source);

        assertThat(target.getNationalId()).isEqualTo("81020201019");
        assertThat(target.getEidasLevel()).isNull();
    }

    /**
     * Reproduit la désérialisation faite par le RestTemplate du client AMAR sur la
     * vraie réponse /users/eims : le champ attributes (JsonNullable) nécessite le
     * JsonNullableModule, sinon InvalidDefinitionException (bug rencontré en preprod).
     * Le mapper est configuré comme le converter Spring (Jackson2ObjectMapperBuilder
     * + JsonNullableModule + JavaTimeModule).
     */
    @Test
    void eimsSummary_deserializesRealAmarResponse() throws Exception {
        String json = "{\"nationalId\":\"81020201019\","
                + "\"alternativeIdentifiers\":[{\"identifier\":\"81020201019\",\"origine\":\"RPPS\",\"quality\":1}],"
                + "\"eims\":[{\"nationalId\":\"81020201019\",\"type\":\"WALLET\","
                + "\"creationDate\":\"2026-05-21T08:20:21Z\",\"endOfValidityDate\":\"2029-05-20T08:20:21Z\","
                + "\"eidasLevel\":1,\"attributes\":{\"deviceName\":\"2412DPC0AG\",\"operatingSystem\":\"Android 16\","
                + "\"appVersion\":\"3.17.16\",\"activationMode\":\"CONTACTS\"}}],"
                + "\"correlationId\":\"a0423951-94d4-4f07-be65-710c913ced0d\"}";

        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
        mapper.registerModule(new JsonNullableModule());
        mapper.registerModule(new JavaTimeModule());

        EimsSummary summary = mapper.readValue(json, EimsSummary.class);

        assertThat(summary.getNationalId()).isEqualTo("81020201019");
        assertThat(summary.getEims()).hasSize(1);
        AbstractEimObject eim = summary.getEims().iterator().next();
        assertThat(eim.getType()).isEqualTo("WALLET");
        assertThat(eim.getEidasLevel().getValue()).isEqualTo(1);
        assertThat(eim.getAttributes()).isInstanceOf(Map.class);
        @SuppressWarnings("unchecked")
        Map<String, Object> attrs = (Map<String, Object>) eim.getAttributes();
        assertThat(attrs).containsEntry("deviceName", "2412DPC0AG");

        // Et la conversion vers le modèle User doit préserver les champs
        AbstractEim mapped = PsiApiController.toAbstractEim(eim);
        assertThat(mapped.getType()).isEqualTo("WALLET");
        assertThat(mapped.getEidasLevel()).isEqualTo(AbstractEim.EidasLevelEnum.fromValue(1));
        assertThat(mapped.getCreationDate()).isEqualTo(OffsetDateTime.parse("2026-05-21T08:20:21Z"));
    }
}
