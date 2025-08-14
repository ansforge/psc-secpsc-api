package fr.ans.psc.model.ps;

import fr.ans.psc.model.FirstName;

public class PsiFirstNameAdapter extends FirstName {

	public PsiFirstNameAdapter(String firstName, Integer order) {
		this.setFirstName(firstName);
		this.setOrder(order);
	}
}