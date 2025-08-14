package fr.ans.psc.model.ps;

import fr.ans.psc.amar.model.User;
import fr.ans.psc.model.Expertise;

public class PsiExpertiseAdapter extends Expertise {
	
	public PsiExpertiseAdapter(User user) {
		this.setExpertiseId("");
		this.setTypeCode("");
		this.setCode("");
	}
}