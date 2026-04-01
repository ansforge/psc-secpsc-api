package org.openapitools.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO local pour désérialiser la réponse de psc-ps-api /v2/ps/search/name (PsSearchResult).
 */
public class PsSearchResultFromPsApiDto {

    @JsonProperty("nationalId")
    private String nationalId;

    @JsonProperty("professionCode")
    private String professionCode;

    @JsonProperty("workLocations")
    private List<WorkLocationFromPsApiDto> workLocations;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(String professionCode) {
        this.professionCode = professionCode;
    }

    public List<WorkLocationFromPsApiDto> getWorkLocations() {
        return workLocations;
    }

    public void setWorkLocations(List<WorkLocationFromPsApiDto> workLocations) {
        this.workLocations = workLocations;
    }

    public static class WorkLocationFromPsApiDto {

        @JsonProperty("companyName")
        private String companyName;

        @JsonProperty("companyCedexOffice")
        private String companyCedexOffice;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyCedexOffice() {
            return companyCedexOffice;
        }

        public void setCompanyCedexOffice(String companyCedexOffice) {
            this.companyCedexOffice = companyCedexOffice;
        }
    }
}
