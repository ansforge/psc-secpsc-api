package fr.ans.psc.model.ps;

import fr.ans.psc.model.AttributeEncoding;

public class PsiAlternativeIdentifierPsAdapter extends fr.ans.psc.model.AlternativeIdentifier {

	public PsiAlternativeIdentifierPsAdapter(fr.ans.psc.amar.model.AlternativeIdentifier alternativeIdentifierAmar) {
		this.setIdentifier(AttributeEncoding.encodeStringAttribute(alternativeIdentifierAmar.getIdentifier()));
		this.setOrigine(AttributeEncoding.encodeStringAttribute(alternativeIdentifierAmar.getOrigine()));
		this.setQuality(alternativeIdentifierAmar.getQuality());
	}
}