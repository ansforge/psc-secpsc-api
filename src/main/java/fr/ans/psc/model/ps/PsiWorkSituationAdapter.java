package fr.ans.psc.model.ps;

import fr.ans.psc.amar.model.Activity;
import fr.ans.psc.model.AttributeEncoding;
import fr.ans.psc.model.Structure;
import fr.ans.psc.model.WorkSituation;

public class PsiWorkSituationAdapter extends WorkSituation {

	public PsiWorkSituationAdapter(Activity activity) {
		this.setSituId("");
		this.setModeCode(activity.getProfessionalModeCode());
		this.setActivitySectorCode(activity.getActivitySectorCode());
		this.setPharmacistTableSectionCode(activity.getPharmacistTableSectionCode());
		this.setRoleCode(activity.getRoleCode());
		this.setActivityKindCode(activity.getActivityTypeCode());
		this.setRegistrationAuthority(activity.getCompanyRegistrationAuthority());

		Structure structure = new Structure();
		structure.setSiteSIRET(AttributeEncoding.encodeStringAttribute(activity.getSiretSiteNumber()));
		structure.setSiteSIREN(AttributeEncoding.encodeStringAttribute(activity.getSirenSiteNumber()));
		structure.setSiteFINESS(AttributeEncoding.encodeStringAttribute(activity.getFinessSiteNumber()));
		structure.setLegalEstablishmentFINESS(AttributeEncoding.encodeStringAttribute(activity.getFinessLegalCompanyNumber()));
		structure.setStructureTechnicalId(AttributeEncoding.encodeStringAttribute(activity.getCompanyTechnicalIdentifier()));
		structure.setLegalCommercialName(AttributeEncoding.encodeStringAttribute(activity.getCompanyName()));
		structure.setPublicCommercialName(AttributeEncoding.encodeStringAttribute(activity.getCompanyCommercialSign()));
		structure.setRecipientAdditionalInfo(AttributeEncoding.encodeStringAttribute(activity.getCompanyAdditionalAddress()));
		structure.setGeoLocationAdditionalInfo(AttributeEncoding.encodeStringAttribute(activity.getCompanyGeographicalPointComplement()));
		structure.setStreetNumber(AttributeEncoding.encodeStringAttribute(activity.getCompanyWayNumber()));
		structure.setStreetNumberRepetitionIndex(AttributeEncoding.encodeStringAttribute(activity.getCompanyRepeatIndex()));
		structure.setStreetCategoryCode(AttributeEncoding.encodeStringAttribute(activity.getCompanyWayType()));
		structure.setStreetLabel(AttributeEncoding.encodeStringAttribute(activity.getCompanyWayLabel()));
		structure.setDistributionMention(AttributeEncoding.encodeStringAttribute(activity.getCompanyDistributionMention()));
		structure.setCedexOffice(AttributeEncoding.encodeStringAttribute(activity.getCompanyCedexOffice()));
		structure.setPostalCode(AttributeEncoding.encodeStringAttribute(activity.getCompanyPostalCode()));
		structure.setCommuneCode(AttributeEncoding.encodeStringAttribute(activity.getCompanyTownCode()));
		structure.setCountryCode(AttributeEncoding.encodeStringAttribute(activity.getCompanyCountryCode()));
		structure.setPhone(AttributeEncoding.encodeStringAttribute(activity.getCompanyPhone1()));
		structure.setPhone2(AttributeEncoding.encodeStringAttribute(activity.getCompanyPhone2()));
		structure.setFax(AttributeEncoding.encodeStringAttribute(activity.getCompanyFax()));
		structure.setEmail(AttributeEncoding.encodeStringAttribute(activity.getCompanyEmail()));
		structure.setDepartmentCode(AttributeEncoding.encodeStringAttribute(activity.getCompanyCountyCode()));
		structure.setOldStructureId(AttributeEncoding.encodeStringAttribute(activity.getCompanyOldIdentifier()));
		this.setStructure(structure);
	}
}