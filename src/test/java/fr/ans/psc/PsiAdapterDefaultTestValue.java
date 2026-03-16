package fr.ans.psc;

import java.util.List;
import java.util.Map;

public interface PsiAdapterDefaultTestValue {
	
	// Informations - Identification : Ps
	public final static String ID = "aaa";
	public final static String ID_TYPE = "aaa";
	public final static Long ACTIVATED = 0L;
	public final static Long DEACTIVATED = 0L;
	
	// Informations - Identification : Ps & User
	public final static String NATIONAL_ID = "1234567890123";
	public final static String LAST_NAME = "Dupont";
	public final static String DATE_OF_BIRTH = "1980-05-14";
	public final static String BIRTH_ADDRESS_CODE = "75056";
	public final static String BIRTH_COUNTRY_CODE = "FR";
	public final static String BIRTH_ADDRESS = "Paris";
	public final static String GENDER_CODE = "M";
	public final static String PHONE = "+33612345678";
	public final static String EMAIL = "jean.dupont@example.com";
	public final static String SALUTATION_CODE = "M";
	public final static List<String> FIRSTNAMES = List.of("Jean","Michel");
	
	
	
	// Professions + Expertise : Ps
	public final static String EXPERTISE1_EXPERTISE_ID = "aaa";
	
	// Professions + Expertise && Practice : Ps & User
	public final static String PROFESSION1_EX_PRO_ID = "aaa";
	public final static String PROFESSION1_CODE = "MED";
	public final static String PROFESSION1_CATEGORY_CODE = "GEN";
	public final static String PROFESSION1_SALUTATION_CODE = "Dr";
	public final static String PROFESSION1_LAST_NAME = "Dupont";
	public final static String PROFESSION1_FIRST_NAME = "Jean";
	
	public final static String EXPERTISE1_CODE = "C01";
	public final static String EXPERTISE1_TYPE_CODE = "CARDIO";
	

	
	// WorkSituation : Ps
	public final static String WORK_SITUATION_SITU_ID = "aaa";
	
	// WorkSituation + Structure & Activity : Ps & User
	public final static String WORK_SITUATION_MODE_CODE = "CAB";
	public final static String WORK_SITUATION_ACTIVITY_SECTOR_CODE = "PRIV";
	public final static String WORK_SITUATION_PHARMACIST_TABLE_SECTION_CODE = "aaa";
	public final static String WORK_SITUATION_ROLE_CODE = "GEN";
	public final static String WORK_SITUATION_ACTIVITY_KIND_CODE = "CONS";
	public final static String WORK_SITUATION_REGISTRATION_AUTHORITY = "aaa";

	public final static String STRUCTURE_SITE_SIRET = "12345678900011";
	public final static String STRUCTURE_SITE_SIREN = "123456789";
	public final static String STRUCTURE_SITE_FINESS = "123456789";
	public final static String STRUCTURE_LEGAL_ESTABLISHMENT = "aaa";
	public final static String STRUCTURE_STRUCTURE_TECHNICAL_ID = "aaa";
	public final static String STRUCTURE_LEGAL_COMMERCIAL_NAME = "Cabinet Médical Dupont";
	public final static String STRUCTURE_PUBLIC_COMMERCIAL_NAME = "aaa";
	public final static String STRUCTURE_RECIPIENT_ADDITIONAL_INFO = "aaa";
	public final static String STRUCTURE_GEO_LOCALISATION_ADDITIONAL_INFO = "aaa";
	public final static String STRUCTURE_STREET_NUMBER = "aaa";
	public final static String STRUCTURE_STREET_NUMBER_REPETITION_INDEX = "aaa";
	public final static String STRUCTURE_STREET_CATEGORY_CODE = "aaa";
	public final static String STRUCTURE_STREET_LABEL = "aaa";
	public final static String STRUCTURE_DISTRIBUTION_MENTION = "aaa";
	public final static String STRUCTURE_CEDEX_OFFICE = "aaa";
	public final static String STRUCTURE_POSTAL_CODE = "aaa";
	public final static String STRUCTURE_COMMUNE_CODE = "aaa";
	public final static String STRUCTURE_COUNTRY_CODE = "aaa";
	public final static String STRUCTURE_PHONE = "aaa";
	public final static String STRUCTURE_PHONE2 = "aaa";
	public final static String STRUCTURE_FAX = "aaa";
	public final static String STRUCTURE_EMAIL = "aaa";
	public final static String STRUCTURE_DEPARTMENT_CODE = "aaa";
	public final static String STRUCTURE_OLD_STRUCTURE_ID = "aaa";
	
	public final static List<Map<String, Object>> IDENTIFIERS = List.of(Map.of("identifier", "ALT-987654", "origine", "AMELI", "quality", "1"));
}