package fr.ans.psc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ans.psc.amar.v2.model.User;
import fr.ans.psc.model.Expertise;
import fr.ans.psc.model.FirstName;
import fr.ans.psc.model.Profession;
import fr.ans.psc.model.Ps;
import fr.ans.psc.model.Structure;
import fr.ans.psc.model.WorkSituation;
import fr.ans.psc.model.ps.PsiPsAdapter;
import fr.ans.psc.model.user.PsiUserAdapter;

public class PsiPsAdapterTest implements PsiAdapterDefaultTestValue {

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
	public void TestPsiPsAdapterByUser() {
		testPsEqualPsByUser(user);
	}

	/**
	 * 
	 */
	@Test
	public void TestPsiPsAdapterDoubleConvert() {
		User userTmp = new PsiUserAdapter(ps);
		testPsEqualPsByUser(userTmp);
	}

	/**
	 * 
	 * @param userForBuild
	 */
	public void testPsEqualPsByUser(User userForBuild) {
		Ps psByUser = new PsiPsAdapter(userForBuild);

		assertEquals(psByUser.getNationalId(), ps.getNationalId());
		assertEquals(psByUser.getLastName(), ps.getLastName());
		assertEquals(psByUser.getDateOfBirth(), ps.getDateOfBirth());
		assertEquals(psByUser.getBirthAddressCode(), ps.getBirthAddressCode());
		assertEquals(psByUser.getBirthCountryCode(), ps.getBirthCountryCode());
		assertEquals(psByUser.getBirthAddress(), ps.getBirthAddress());
		assertEquals(psByUser.getGenderCode(), ps.getGenderCode());
		assertEquals(psByUser.getSalutationCode(), ps.getSalutationCode());
		// Note: phone et email sont null dans PsiPsAdapter car ils sont nettoyés de CivilStatus
		// par PsiUserAdapter.cleanContactInfoFromCivilStatus() pour éviter la duplication
		// Les données de contact sont accessibles via getContactInfo() dans PsiUserAdapter
		assertEquals(psByUser.getPhone(), null);
		assertEquals(psByUser.getEmail(), null);

		assertEquals(psByUser.getIds(), ps.getIds());

		List<FirstName> firstNamePs = ps.getFirstNames();
		List<FirstName> firstNamePsByUser = psByUser.getFirstNames();
		for (int i = 0; i < firstNamePs.size(); i++) {
			assertEquals(firstNamePs.get(i).getFirstName(), firstNamePsByUser.get(i).getFirstName());
			assertEquals(firstNamePs.get(i).getOrder(), firstNamePsByUser.get(i).getOrder());
		}

		List<Profession> psProfessions = ps.getProfessions();
		List<Profession> psByUserProfessions = psByUser.getProfessions();
		for (int i = 0; i < firstNamePs.size(); i++) {

			Profession psProfession = psProfessions.get(i);
			Profession psByUserProfession = psByUserProfessions.get(i);

			// Information qui n'existe pas dans le user :
			// assertEquals(psByUserProfession.getExProId(), psProfession.getExProId());
			assertEquals(psByUserProfession.getCode(), psProfession.getCode());
			assertEquals(psByUserProfession.getCategoryCode(), psProfession.getCategoryCode());
			assertEquals(psByUserProfession.getSalutationCode(), psProfession.getSalutationCode());
			assertEquals(psByUserProfession.getLastName(), psProfession.getLastName());
			assertEquals(psByUserProfession.getFirstName(), psProfession.getFirstName());

			List<Expertise> psExpertises = psProfession.getExpertises();
			List<Expertise> psByUserExpertises = psByUserProfession.getExpertises();
			for (int j = 0; j < psExpertises.size(); j++) {

				Expertise psExpertise = psExpertises.get(j);
				Expertise psByUserExpertise = psByUserExpertises.get(j);

				// Information qui n'existe pas dans le user :
				// assertEquals(psByUserExpertise.getExpertiseId(),
				// psExpertise.getExpertiseId());
				assertEquals(psByUserExpertise.getTypeCode(), psExpertise.getTypeCode());
				assertEquals(psByUserExpertise.getCode(), psExpertise.getCode());
			}

			List<WorkSituation> psWorkSituations = psProfession.getWorkSituations();
			List<WorkSituation> psByUserWorkSituations = psByUserProfession.getWorkSituations();
			for (int j = 0; j < psWorkSituations.size(); j++) {

				WorkSituation psWorkSituation = psWorkSituations.get(j);
				WorkSituation psByUserWorkSituation = psByUserWorkSituations.get(j);

				// Information qui n'existe pas dans le user :
				// assertEquals(psByUserWorkSituation.getSituId(), psWorkSituation.getSituId());
				assertEquals(psByUserWorkSituation.getModeCode(), psWorkSituation.getModeCode());
				assertEquals(psByUserWorkSituation.getActivitySectorCode(), psWorkSituation.getActivitySectorCode());
				assertEquals(psByUserWorkSituation.getPharmacistTableSectionCode(),
						psWorkSituation.getPharmacistTableSectionCode());
				assertEquals(psByUserWorkSituation.getRoleCode(), psWorkSituation.getRoleCode());
				assertEquals(psByUserWorkSituation.getActivityKindCode(), psWorkSituation.getActivityKindCode());
				assertEquals(psByUserWorkSituation.getRegistrationAuthority(),
						psWorkSituation.getRegistrationAuthority());

				Structure psStructure = psWorkSituation.getStructure();
				Structure psByUserStructure = psByUserWorkSituation.getStructure();

				assertEquals(psByUserStructure.getSiteSIRET(), psStructure.getSiteSIRET());
				assertEquals(psByUserStructure.getSiteSIREN(), psStructure.getSiteSIREN());
				assertEquals(psByUserStructure.getSiteFINESS(), psStructure.getSiteFINESS());
				assertEquals(psByUserStructure.getLegalEstablishmentFINESS(),
						psStructure.getLegalEstablishmentFINESS());
				assertEquals(psByUserStructure.getStructureTechnicalId(), psStructure.getStructureTechnicalId());
				assertEquals(psByUserStructure.getLegalCommercialName(), psStructure.getLegalCommercialName());
				assertEquals(psByUserStructure.getPublicCommercialName(), psStructure.getPublicCommercialName());
				assertEquals(psByUserStructure.getRecipientAdditionalInfo(), psStructure.getRecipientAdditionalInfo());
				assertEquals(psByUserStructure.getGeoLocationAdditionalInfo(),
						psStructure.getGeoLocationAdditionalInfo());
				assertEquals(psByUserStructure.getStreetNumber(), psStructure.getStreetNumber());
				assertEquals(psByUserStructure.getStreetNumberRepetitionIndex(),
						psStructure.getStreetNumberRepetitionIndex());
				assertEquals(psByUserStructure.getStreetCategoryCode(), psStructure.getStreetCategoryCode());
				assertEquals(psByUserStructure.getStreetLabel(), psStructure.getStreetLabel());
				assertEquals(psByUserStructure.getDistributionMention(), psStructure.getDistributionMention());
				assertEquals(psByUserStructure.getCedexOffice(), psStructure.getCedexOffice());
				assertEquals(psByUserStructure.getPostalCode(), psStructure.getPostalCode());
				assertEquals(psByUserStructure.getCommuneCode(), psStructure.getCommuneCode());
				assertEquals(psByUserStructure.getCountryCode(), psStructure.getCountryCode());
				assertEquals(psByUserStructure.getPhone(), psStructure.getPhone());
				assertEquals(psByUserStructure.getPhone2(), psStructure.getPhone2());
				assertEquals(psByUserStructure.getFax(), psStructure.getFax());
				assertEquals(psByUserStructure.getEmail(), psStructure.getEmail());
				assertEquals(psByUserStructure.getDepartmentCode(), psStructure.getDepartmentCode());
				assertEquals(psByUserStructure.getOldStructureId(), psStructure.getOldStructureId());

			}
		}

		// Information qui n'existe pas dans le user :
		// assertEquals(psByUser.getProfessions(), ps.getProfessions());

		// Information qui n'existe pas dans le user :
		// assertEquals(psByUser.getIdType(), ps.getIdType());
		// Information qui n'existe pas dans le user : assertEquals(psByUser.getId(),
		// ps.getId());
		// Information qui n'existe pas dans le user :
		// assertEquals(psByUser.getActivated(), ps.getActivated());
		// Information qui n'existe pas dans le user :
		// assertEquals(psByUser.getDeactivated(), ps.getDeactivated());

		// Information qui n'existe pas dans le user : assertEquals(psByUser, ps);
	}
}