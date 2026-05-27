package org.openapitools.api;

import fr.ans.psc.amar.v2.model.AbstractEim;
import fr.ans.psc.amar.v2.model.AbstractEimObject;
import org.junit.jupiter.api.Test;

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
}
