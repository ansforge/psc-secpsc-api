package fr.ans.psc.model.ps;

import java.util.ArrayList;
import java.util.List;

import fr.ans.psc.amar.model.CivilStatus;
import fr.ans.psc.amar.model.ContactInfo;
import fr.ans.psc.amar.model.Practice;
import fr.ans.psc.amar.model.User;
import fr.ans.psc.model.AttributeEncoding;
import fr.ans.psc.model.FirstName;
import fr.ans.psc.model.Profession;
import fr.ans.psc.model.Ps;

public class PsiPsAdapter extends Ps {

	public PsiPsAdapter(User user) {

		// Mapping Identifier
		this.setNationalId(AttributeEncoding.encodeStringAttribute(user.getNationalId()));
		CivilStatus civilStatus = user.getCivilStatus();
		ContactInfo contactInfo = user.getContactInfo();
		List<Practice> practices = user.getPractices();
		List<fr.ans.psc.amar.model.AlternativeIdentifier> alternativeIdentifiers = user.getAlternativeIdentifiers();

		// Mapping CivilStatus
		if(civilStatus != null) {
			this.setLastName(AttributeEncoding.encodeStringAttribute(civilStatus.getLastName()));
			this.setDateOfBirth(AttributeEncoding.encodeStringAttribute(civilStatus.getBirthdate()));
			this.setBirthAddressCode(AttributeEncoding.encodeStringAttribute(civilStatus.getBirthTownCode()));
			this.setBirthCountryCode(AttributeEncoding.encodeStringAttribute(civilStatus.getBirthCountryCode()));
			this.setBirthAddress(AttributeEncoding.encodeStringAttribute(civilStatus.getBirthplace()));
			this.setGenderCode(AttributeEncoding.encodeStringAttribute(civilStatus.getGenderCode()));
			this.setSalutationCode(AttributeEncoding.encodeStringAttribute(civilStatus.getPersonalCivilityTitle()));
			
			// Mapping FirstName
			int i = 0;
			List<FirstName> firstNames = new ArrayList<FirstName>();
			for (String firstname : civilStatus.getFirstNames()) {
				firstNames.add(new PsiFirstNameAdapter(AttributeEncoding.encodeStringAttribute(firstname), i));
				i++;
			}
			this.setFirstNames(firstNames);
		}

		// Mapping ContactInfos
		if(contactInfo != null) {
			this.setPhone(AttributeEncoding.encodeStringAttribute(contactInfo.getPhone()));
			this.setEmail(AttributeEncoding.encodeStringAttribute(contactInfo.getEmail()));
		}

		// Mapping Practice
		if(practices != null && !practices.isEmpty()) {
			List<Profession> professions = new ArrayList<Profession>();
			practices.forEach(practice -> professions.add(new PsiProfessionAdapter(practice)));
			this.setProfessions(professions);
		}

		// Mapping Ids
		List<String> ids = new ArrayList<String>();
		if (alternativeIdentifiers != null) {
			alternativeIdentifiers.forEach(alternativeIdentifier -> {
				if (alternativeIdentifier != null && alternativeIdentifier.getIdentifier() != null && !alternativeIdentifier.getIdentifier().trim().isEmpty()) {
					String encodedId = AttributeEncoding.encodeStringAttribute(alternativeIdentifier.getIdentifier());
					if (encodedId != null) {
						ids.add(encodedId);
					}
				}
			});
		}
		this.setIds(ids);

		// Mapping AlternativeIdentifiers
		if(alternativeIdentifiers != null && !alternativeIdentifiers.isEmpty()) {
			List<fr.ans.psc.model.AlternativeIdentifier> alternativeIdentifierPS = new ArrayList<fr.ans.psc.model.AlternativeIdentifier>();
			alternativeIdentifiers.forEach(alternativeIdentifier -> {
				if (alternativeIdentifier != null) {
					alternativeIdentifierPS.add(new PsiAlternativeIdentifierPsAdapter(alternativeIdentifier));
				}
			});
			this.setAlternativeIds(alternativeIdentifierPS);
		}
		
		// TODO : que faire d'eux ?
		this.setIdType("");
		this.setId("");
		this.setActivated(0L);
		this.setDeactivated(0L);
	}
}