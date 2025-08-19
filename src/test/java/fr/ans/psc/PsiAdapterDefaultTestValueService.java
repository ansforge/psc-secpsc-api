package fr.ans.psc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.ans.psc.amar.model.Activity;
import fr.ans.psc.amar.model.CivilStatus;
import fr.ans.psc.amar.model.ContactInfo;
import fr.ans.psc.amar.model.Practice;
import fr.ans.psc.amar.model.User;
import fr.ans.psc.model.Expertise;
import fr.ans.psc.model.FirstName;
import fr.ans.psc.model.Profession;
import fr.ans.psc.model.Ps;
import fr.ans.psc.model.Structure;
import fr.ans.psc.model.WorkSituation;

@Service
public class PsiAdapterDefaultTestValueService implements PsiAdapterDefaultTestValue {
	
	// Ps
	private static Ps ps = new Ps();

	// User
	private static User user = new User();

	public static Ps buildTestPs() {
		ps.setId(ID);
		ps.setIdType(ID_TYPE);
		ps.setNationalId(NATIONAL_ID);

		ps.setLastName(LAST_NAME);
		ps.setDateOfBirth(DATE_OF_BIRTH);
		ps.setBirthAddressCode(BIRTH_ADDRESS_CODE);
		ps.setBirthCountryCode(BIRTH_COUNTRY_CODE);
		ps.setBirthAddress(BIRTH_ADDRESS);
		ps.setGenderCode(GENDER_CODE);
		ps.setPhone(PHONE);
		ps.setEmail(EMAIL);

		List<String> ids = new ArrayList<String>();
		for (Map<String, Object> identifier : IDENTIFIERS) {
			ids.add(identifier.get("identifier").toString());
		}
		ps.setIds(ids);

		List<fr.ans.psc.model.AlternativeIdentifier> alternativeIdentifiers = new ArrayList<fr.ans.psc.model.AlternativeIdentifier>();
		for (Map<String, Object> identifier : IDENTIFIERS) {
			fr.ans.psc.model.AlternativeIdentifier alternativeIdentifier = new fr.ans.psc.model.AlternativeIdentifier();
			alternativeIdentifier.setIdentifier(identifier.get("identifier").toString());
			alternativeIdentifier.setOrigine(identifier.get("origine").toString());
			alternativeIdentifier.setQuality(Integer.valueOf(identifier.get("quality").toString()));
			alternativeIdentifiers.add(alternativeIdentifier);
		}
		ps.setAlternativeIds(alternativeIdentifiers);

		ps.setSalutationCode(SALUTATION_CODE);
		ps.setActivated(ACTIVATED);
		ps.setDeactivated(DEACTIVATED);

		List<FirstName> firstNames = buildTestPsFirstName();
		ps.setFirstNames(firstNames);
		
		List<Profession> professions = buildTestPsProfessions();
		ps.setProfessions(professions);
		
		return ps;
	}

	public static List<FirstName> buildTestPsFirstName() {
		List<FirstName> firstNames = new ArrayList<FirstName>();

		for (int i = 0; i < FIRSTNAMES.size(); i++) {
			FirstName firstName = new FirstName();
			firstName.setFirstName(FIRSTNAMES.get(i));
			firstName.setOrder(i);
			firstNames.add(firstName);
		}

		return firstNames;
	}

	public static List<Profession> buildTestPsProfessions() {
		List<Profession> professions = new ArrayList<Profession>();

		Profession profession = new Profession();
		profession.setExProId(PROFESSION1_EX_PRO_ID);
		profession.setCode(PROFESSION1_CODE);
		profession.setCategoryCode(PROFESSION1_CATEGORY_CODE);
		profession.setSalutationCode(PROFESSION1_SALUTATION_CODE);
		profession.setLastName(PROFESSION1_LAST_NAME);
		profession.setFirstName(PROFESSION1_FIRST_NAME);

		Expertise expertise = new Expertise();
		expertise.setExpertiseId(EXPERTISE1_EXPERTISE_ID);
		expertise.setCode(EXPERTISE1_CODE);
		expertise.setTypeCode(EXPERTISE1_TYPE_CODE);
		profession.setExpertises(List.of(expertise));

		List<WorkSituation> workSituations = new ArrayList<WorkSituation>();

		WorkSituation workSituation = new WorkSituation();
		workSituation.setSituId(WORK_SITUATION_SITU_ID);
		workSituation.setModeCode(WORK_SITUATION_MODE_CODE);
		workSituation.setActivitySectorCode(WORK_SITUATION_ACTIVITY_SECTOR_CODE);
		workSituation.setPharmacistTableSectionCode(WORK_SITUATION_PHARMACIST_TABLE_SECTION_CODE);
		workSituation.setRoleCode(WORK_SITUATION_ROLE_CODE);
		workSituation.setActivityKindCode(WORK_SITUATION_ACTIVITY_KIND_CODE);
		workSituation.setRegistrationAuthority(WORK_SITUATION_REGISTRATION_AUTHORITY);

		Structure structure = new Structure();
		structure.setSiteSIRET(STRUCTURE_SITE_SIRET);
		structure.setSiteSIREN(STRUCTURE_SITE_SIREN);
		structure.setSiteFINESS(STRUCTURE_SITE_FINESS);
		structure.setLegalEstablishmentFINESS(STRUCTURE_LEGAL_ESTABLISHMENT);
		structure.setStructureTechnicalId(STRUCTURE_STRUCTURE_TECHNICAL_ID);
		structure.setLegalCommercialName(STRUCTURE_LEGAL_COMMERCIAL_NAME);
		structure.setPublicCommercialName(STRUCTURE_PUBLIC_COMMERCIAL_NAME);
		structure.setRecipientAdditionalInfo(STRUCTURE_RECIPIENT_ADDITIONAL_INFO);
		structure.setGeoLocationAdditionalInfo(STRUCTURE_GEO_LOCALISATION_ADDITIONAL_INFO);
		structure.setStreetNumber(STRUCTURE_STREET_NUMBER);
		structure.setStreetNumberRepetitionIndex(STRUCTURE_STREET_NUMBER_REPETITION_INDEX );
		structure.setStreetCategoryCode(STRUCTURE_STREET_CATEGORY_CODE);
		structure.setStreetLabel(STRUCTURE_STREET_LABEL);
		structure.setDistributionMention(STRUCTURE_DISTRIBUTION_MENTION);
		structure.setCedexOffice(STRUCTURE_CEDEX_OFFICE);
		structure.setPostalCode(STRUCTURE_POSTAL_CODE);
		structure.setCommuneCode(STRUCTURE_COMMUNE_CODE);
		structure.setCountryCode(STRUCTURE_COUNTRY_CODE);
		structure.setPhone(STRUCTURE_PHONE);
		structure.setPhone2(STRUCTURE_PHONE2);
		structure.setFax(STRUCTURE_FAX);
		structure.setEmail(STRUCTURE_EMAIL);
		structure.setDepartmentCode(STRUCTURE_DEPARTMENT_CODE);
		structure.setOldStructureId(STRUCTURE_OLD_STRUCTURE_ID);

		workSituation.setStructure(structure);
		
		workSituations.add(workSituation);

		profession.setWorkSituations(workSituations);

		professions.add(profession);

		return professions;
	}

	public static User buildTestUser() {
		user.setNationalId(NATIONAL_ID);
		
		
		List<fr.ans.psc.amar.model.AlternativeIdentifier> alternativeIdentifiers = new ArrayList<fr.ans.psc.amar.model.AlternativeIdentifier>();
		for (Map<String, Object> identifier : IDENTIFIERS) {
			fr.ans.psc.amar.model.AlternativeIdentifier alternativeIdentifier = new fr.ans.psc.amar.model.AlternativeIdentifier();
			alternativeIdentifier.setIdentifier(identifier.get("identifier").toString());
			alternativeIdentifier.setOrigine(identifier.get("origine").toString());
			alternativeIdentifier.setQuality(Integer.valueOf(identifier.get("quality").toString()));
			alternativeIdentifiers.add(alternativeIdentifier);
		}
		user.setAlternativeIdentifiers(alternativeIdentifiers);

		ContactInfo contactInfo = buildTestUserContactInfo();
		user.setContactInfo(contactInfo);
		
		CivilStatus civilStatus = buildTestUserCivilStatus();
		user.setCivilStatus(civilStatus);
		
		List<Practice> practices = buildTestUserPracticeSetup();
		user.setPractices(practices);
		
		return user;
	}

	public static ContactInfo buildTestUserContactInfo() {
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setEmail(EMAIL);
		contactInfo.setPhone(PHONE);
		return contactInfo;
	}

	public static CivilStatus buildTestUserCivilStatus() {
		CivilStatus civilStatus = new CivilStatus();
		civilStatus.setLastName(LAST_NAME);
		civilStatus.setBirthdate(DATE_OF_BIRTH);
		civilStatus.setBirthTownCode(BIRTH_ADDRESS_CODE);
		civilStatus.setBirthCountryCode(BIRTH_COUNTRY_CODE);
		civilStatus.setBirthplace(BIRTH_ADDRESS);
		civilStatus.setGenderCode(GENDER_CODE);
		civilStatus.setPersonalCivilityTitle(SALUTATION_CODE);
		
		List<String> firstnames = new ArrayList<String>();
		for (String firstname : FIRSTNAMES) {
			firstnames.add(firstname);
		}
		civilStatus.setFirstNames(firstnames);
		
		return civilStatus;
	}

	public static List<Practice> buildTestUserPracticeSetup() {
		List<Practice> practices = new ArrayList<>();

		Practice practice1 = new Practice();
		practice1.setProfessionCode(PROFESSION1_CODE);
		practice1.setProfessionalCategoryCode(PROFESSION1_CATEGORY_CODE);
		practice1.setExpertiseTypeCode(EXPERTISE1_TYPE_CODE);
		practice1.setExpertiseCode(EXPERTISE1_CODE);
		practice1.setProfessionalCivilityTitle(PROFESSION1_SALUTATION_CODE);
		practice1.setProfessionalLastName(PROFESSION1_LAST_NAME);
		practice1.setProfessionalFirstName(PROFESSION1_FIRST_NAME);

		List<Activity> activities = new ArrayList<>();

		Activity activity1 = new Activity();
		activity1.setProfessionalModeCode(WORK_SITUATION_MODE_CODE);
		activity1.setActivitySectorCode(WORK_SITUATION_ACTIVITY_SECTOR_CODE);
		activity1.setPharmacistTableSectionCode(WORK_SITUATION_PHARMACIST_TABLE_SECTION_CODE);
		activity1.setRoleCode(WORK_SITUATION_ROLE_CODE);
		activity1.setCompanyRegistrationAuthority(WORK_SITUATION_REGISTRATION_AUTHORITY);
		activity1.setActivityTypeCode(WORK_SITUATION_ACTIVITY_KIND_CODE);
		activity1.setSiretSiteNumber(STRUCTURE_SITE_SIRET);
		activity1.setSirenSiteNumber(STRUCTURE_SITE_SIREN);
		activity1.setFinessSiteNumber(STRUCTURE_SITE_FINESS);
		activity1.setFinessLegalCompanyNumber(STRUCTURE_LEGAL_ESTABLISHMENT);
		activity1.setCompanyTechnicalIdentifier(STRUCTURE_STRUCTURE_TECHNICAL_ID);
		activity1.setCompanyName(STRUCTURE_LEGAL_COMMERCIAL_NAME);
		activity1.setCompanyCommercialSign(STRUCTURE_PUBLIC_COMMERCIAL_NAME);
		activity1.setCompanyAdditionalAddress(STRUCTURE_RECIPIENT_ADDITIONAL_INFO);
		activity1.setCompanyGeographicalPointComplement(STRUCTURE_GEO_LOCALISATION_ADDITIONAL_INFO);
		activity1.setCompanyWayNumber(STRUCTURE_STREET_NUMBER);
		activity1.setCompanyRepeatIndex(STRUCTURE_STREET_NUMBER_REPETITION_INDEX);
		activity1.setCompanyWayType(STRUCTURE_STREET_CATEGORY_CODE);
		activity1.setCompanyWayLabel(STRUCTURE_STREET_LABEL);
		activity1.setCompanyDistributionMention(STRUCTURE_DISTRIBUTION_MENTION);
		activity1.setCompanyCedexOffice(STRUCTURE_CEDEX_OFFICE);
		activity1.setCompanyPostalCode(STRUCTURE_POSTAL_CODE);
		activity1.setCompanyTownCode(STRUCTURE_COMMUNE_CODE);
		activity1.setCompanyCountryCode(STRUCTURE_COUNTRY_CODE);
		activity1.setCompanyPhone1(STRUCTURE_PHONE);
		activity1.setCompanyPhone2(STRUCTURE_PHONE2);
		activity1.setCompanyFax(STRUCTURE_FAX);
		activity1.setCompanyEmail(STRUCTURE_EMAIL);
		activity1.setCompanyCountyCode(STRUCTURE_DEPARTMENT_CODE);
		activity1.setCompanyOldIdentifier(STRUCTURE_OLD_STRUCTURE_ID);

		activities.add(activity1);

		practice1.activities(activities);
		practices.add(practice1);

		return practices;
	}
}