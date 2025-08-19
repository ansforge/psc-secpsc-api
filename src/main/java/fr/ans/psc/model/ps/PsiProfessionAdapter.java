package fr.ans.psc.model.ps;

import java.util.ArrayList;
import java.util.List;

import fr.ans.psc.amar.model.Practice;
import fr.ans.psc.model.AttributeEncoding;
import fr.ans.psc.model.Expertise;
import fr.ans.psc.model.Profession;
import fr.ans.psc.model.WorkSituation;

public class PsiProfessionAdapter extends Profession {

	public PsiProfessionAdapter(Practice practice) {
		this.setCode(AttributeEncoding.encodeStringAttribute(practice.getProfessionCode()));
		this.setCategoryCode(AttributeEncoding.encodeStringAttribute(practice.getProfessionalCategoryCode()));
		this.setSalutationCode(AttributeEncoding.encodeStringAttribute(practice.getProfessionalCivilityTitle()));
		this.setLastName(AttributeEncoding.encodeStringAttribute(practice.getProfessionalLastName()));
		this.setFirstName(AttributeEncoding.encodeStringAttribute(practice.getProfessionalFirstName()));

		// Expertises
		Expertise mainExpertise = new Expertise();
		mainExpertise.setCode(AttributeEncoding.encodeStringAttribute(practice.getExpertiseCode()));
		mainExpertise.setTypeCode(AttributeEncoding.encodeStringAttribute(practice.getExpertiseTypeCode()));
		// mainExpertise.setExpertiseId(""); TODO : pas utilisé..
		this.setExpertises(List.of(mainExpertise));

		// WorkSituations
		List<WorkSituation> workSituations = new ArrayList<WorkSituation>();
		practice.getActivities().forEach(activity -> workSituations.add(new PsiWorkSituationAdapter(activity)));
		this.setWorkSituations(workSituations);

		// TODO : que faire d'eux ?
		this.setExProId(""); // TODO
	}
}