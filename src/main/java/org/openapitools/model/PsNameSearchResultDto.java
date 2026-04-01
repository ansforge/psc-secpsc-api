package org.openapitools.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO de réponse pour la recherche par nom/prénom exposé via psc-secpsc-api.
 */
public class PsNameSearchResultDto {

    @JsonProperty("nationalId")
    private String nationalId;

    @JsonProperty("companyNames")
    private List<WorkLocationDto> companyNames;

    public PsNameSearchResultDto() {
    }

    public PsNameSearchResultDto(String nationalId, List<WorkLocationDto> companyNames) {
        this.nationalId = nationalId;
        this.companyNames = companyNames;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public List<WorkLocationDto> getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(List<WorkLocationDto> companyNames) {
        this.companyNames = companyNames;
    }
}
