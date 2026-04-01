package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO représentant un lieu d'exercice dans la réponse /user/search.
 */
public class WorkLocationDto {

    @JsonProperty("professionCode")
    private String professionCode;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("companyCedexOffice")
    private String companyCedexOffice;

    public WorkLocationDto() {
    }

    public WorkLocationDto(String professionCode, String companyName, String companyCedexOffice) {
        this.professionCode = professionCode;
        this.companyName = companyName;
        this.companyCedexOffice = companyCedexOffice;
    }

    public String getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(String professionCode) {
        this.professionCode = professionCode;
    }

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
