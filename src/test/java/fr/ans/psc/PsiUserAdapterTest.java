package fr.ans.psc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ans.psc.amar.model.Activity;
import fr.ans.psc.amar.model.CivilStatus;
import fr.ans.psc.amar.model.ContactInfo;
import fr.ans.psc.amar.model.Practice;
import fr.ans.psc.amar.model.User;
import fr.ans.psc.model.Ps;
import fr.ans.psc.model.ps.PsiPsAdapter;
import fr.ans.psc.model.user.PsiUserAdapter;

public class PsiUserAdapterTest implements PsiAdapterDefaultTestValue {

	// Ps
	Ps ps = new Ps();

	// User
	User user = new User();

	@BeforeEach
	public void setup() {
		ps = PsiAdapterDefaultTestValueService.buildTestPs();
		user = PsiAdapterDefaultTestValueService.buildTestUser();
	}

	/**
	 * 
	 */
	@Test
	public void TestPsiUserAdapterByUser() {
		testUserEqualUserByPs(ps);
	}

	/**
	 * 
	 */
	@Test
	public void TestPsiUserAdapterDoubleConvert() {
		Ps psTmp = new PsiPsAdapter(user);
		testUserEqualUserByPs(psTmp);
	}

	/**
	 * 
	 * @param userForBuild
	 */
	public void testUserEqualUserByPs(Ps psForBuild) {
		User userByPs = new PsiUserAdapter(psForBuild);

		assertEquals(userByPs.getNationalId(), user.getNationalId());

		ContactInfo userContactInfo = user.getContactInfo();
		ContactInfo userByPsContactInfo = userByPs.getContactInfo();

		assertEquals(userByPsContactInfo.getEmail(), userContactInfo.getEmail());
		assertEquals(userByPsContactInfo.getPhone(), userContactInfo.getPhone());

		CivilStatus userCivilStatus = user.getCivilStatus();
		CivilStatus userByPsCivilStatus = userByPs.getCivilStatus();

		assertEquals(userByPsCivilStatus.getLastName(), userCivilStatus.getLastName());
		assertEquals(userByPsCivilStatus.getFirstNames(), userCivilStatus.getFirstNames());
		assertEquals(userByPsCivilStatus.getBirthdate(), userCivilStatus.getBirthdate());
		assertEquals(userByPsCivilStatus.getBirthTownCode(), userCivilStatus.getBirthTownCode());
		assertEquals(userByPsCivilStatus.getBirthCountryCode(), userCivilStatus.getBirthCountryCode());
		assertEquals(userByPsCivilStatus.getBirthplace(), userCivilStatus.getBirthplace());
		assertEquals(userByPsCivilStatus.getGenderCode(), userCivilStatus.getGenderCode());
		assertEquals(userByPsCivilStatus.getPersonalCivilityTitle(), userCivilStatus.getPersonalCivilityTitle());

		List<Practice> userPractices = user.getPractices();
		List<Practice> userByPsPractices = userByPs.getPractices();
		for (int i = 0; i < userPractices.size(); i++) {

			Practice userPractice = userPractices.get(i);
			Practice userByPsPractice = userByPsPractices.get(i);

			assertEquals(userPractice.getProfessionCode(), userByPsPractice.getProfessionCode());
			assertEquals(userPractice.getProfessionalCategoryCode(), userByPsPractice.getProfessionalCategoryCode());
			//assertEquals(userPractice.getExpertiseTypeCode(), userByPsPractice.getExpertiseTypeCode());
			//assertEquals(userPractice.getExpertiseCode(), userByPsPractice.getExpertiseCode());
			assertEquals(userPractice.getProfessionalCivilityTitle(), userByPsPractice.getProfessionalCivilityTitle());
			assertEquals(userPractice.getProfessionalLastName(), userByPsPractice.getProfessionalLastName());
			assertEquals(userPractice.getProfessionalFirstName(), userByPsPractice.getProfessionalFirstName());

			List<Activity> userActivities = userPractice.getActivities();
			List<Activity> userByPsActivities = userByPsPractice.getActivities();
			for (int j = 0; j < userByPsActivities.size(); j++) {

				Activity userActivity = userActivities.get(j);
				Activity userByPsActivity = userByPsActivities.get(j);

				assertEquals(userActivity.getProfessionalModeCode(), userByPsActivity.getProfessionalModeCode());
				assertEquals(userActivity.getActivitySectorCode(), userByPsActivity.getActivitySectorCode());
				assertEquals(userActivity.getActivityTypeCode(), userByPsActivity.getActivityTypeCode());
				assertEquals(userActivity.getPharmacistTableSectionCode(),
						userByPsActivity.getPharmacistTableSectionCode());
				assertEquals(userActivity.getRoleCode(), userByPsActivity.getRoleCode());
				assertEquals(userActivity.getSiretSiteNumber(), userByPsActivity.getSiretSiteNumber());
				assertEquals(userActivity.getSirenSiteNumber(), userByPsActivity.getSirenSiteNumber());
				assertEquals(userActivity.getFinessSiteNumber(), userByPsActivity.getFinessSiteNumber());
				assertEquals(userActivity.getFinessLegalCompanyNumber(),
						userByPsActivity.getFinessLegalCompanyNumber());
				assertEquals(userActivity.getCompanyTechnicalIdentifier(),
						userByPsActivity.getCompanyTechnicalIdentifier());
				assertEquals(userActivity.getCompanyName(), userByPsActivity.getCompanyName());
				assertEquals(userActivity.getCompanyCommercialSign(), userByPsActivity.getCompanyCommercialSign());

				assertEquals(userActivity.getCompanyAdditionalAddress(),
						userByPsActivity.getCompanyAdditionalAddress());
				assertEquals(userActivity.getCompanyGeographicalPointComplement(),
						userByPsActivity.getCompanyGeographicalPointComplement());
				assertEquals(userActivity.getCompanyWayNumber(), userByPsActivity.getCompanyWayNumber());
				assertEquals(userActivity.getCompanyRepeatIndex(), userByPsActivity.getCompanyRepeatIndex());
				assertEquals(userActivity.getCompanyWayType(), userByPsActivity.getCompanyWayType());
				assertEquals(userActivity.getCompanyWayLabel(), userByPsActivity.getCompanyWayLabel());
				assertEquals(userActivity.getCompanyDistributionMention(),
						userByPsActivity.getCompanyDistributionMention());
				assertEquals(userActivity.getCompanyCedexOffice(), userByPsActivity.getCompanyCedexOffice());
				assertEquals(userActivity.getCompanyPostalCode(), userByPsActivity.getCompanyPostalCode());

				assertEquals(userActivity.getCompanyTownCode(), userByPsActivity.getCompanyTownCode());
				assertEquals(userActivity.getCompanyCountryCode(), userByPsActivity.getCompanyCountryCode());
				assertEquals(userActivity.getCompanyPhone1(), userByPsActivity.getCompanyPhone1());
				assertEquals(userActivity.getCompanyPhone2(), userByPsActivity.getCompanyPhone2());

				assertEquals(userActivity.getCompanyFax(), userByPsActivity.getCompanyFax());
				assertEquals(userActivity.getCompanyEmail(), userByPsActivity.getCompanyEmail());
				assertEquals(userActivity.getCompanyCountyCode(), userByPsActivity.getCompanyCountyCode());
				assertEquals(userActivity.getCompanyOldIdentifier(), userByPsActivity.getCompanyOldIdentifier());
				assertEquals(userActivity.getCompanyRegistrationAuthority(),
						userByPsActivity.getCompanyRegistrationAuthority());
			}
		}

		List<fr.ans.psc.amar.model.AlternativeIdentifier> userAlternativeIdentifiers = user.getAlternativeIdentifiers();
		List<fr.ans.psc.amar.model.AlternativeIdentifier> userByPsAlternativeIdentifiers = userByPs
				.getAlternativeIdentifiers();
		for (int i = 0; i < userByPsAlternativeIdentifiers.size(); i++) {

			fr.ans.psc.amar.model.AlternativeIdentifier userAlternativeIdentifier = userAlternativeIdentifiers.get(i);
			fr.ans.psc.amar.model.AlternativeIdentifier userByPsAlternativeIdentifier = userByPsAlternativeIdentifiers
					.get(i);

			assertEquals(userAlternativeIdentifier.getIdentifier(), userByPsAlternativeIdentifier.getIdentifier());
			assertEquals(userAlternativeIdentifier.getOrigine(), userByPsAlternativeIdentifier.getOrigine());
			assertEquals(userAlternativeIdentifier.getQuality(), userByPsAlternativeIdentifier.getQuality());
		}
	}
}