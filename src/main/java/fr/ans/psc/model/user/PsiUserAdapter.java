package fr.ans.psc.model.user;

import java.util.ArrayList;
import java.util.List;

import fr.ans.psc.amar.model.AlternativeIdentifier;
import fr.ans.psc.amar.model.CivilStatus;
import fr.ans.psc.amar.model.ContactInfo;
import fr.ans.psc.amar.model.Practice;
import fr.ans.psc.amar.model.User;
import fr.ans.psc.model.AttributeEncoding;
import fr.ans.psc.model.Ps;

public class PsiUserAdapter extends User {
	
	private final int DEFAULT_QUALITY = 1;

    public PsiUserAdapter(Ps ps) {
        ContactInfo contactInfo = new PsiContactInfoAdapter(ps);
        CivilStatus civilStatus = new PsiCivilStatusAdapter(ps);
        List<Practice> practices = new ArrayList<>();
        ps.getProfessions().forEach(profession -> practices.add(new PsiPracticeAdapter(profession)));
        List<AlternativeIdentifier> alternativeIdentifiers = new ArrayList<>();
        ps.getIds().forEach(id ->
        {
            AlternativeIdentifier identifier = new AlternativeIdentifier();
            identifier.setIdentifier(id);
            identifier.setOrigine(getOriginFromId(id));
            identifier.setQuality(DEFAULT_QUALITY);
            alternativeIdentifiers.add(identifier);
        });

        setNationalId(AttributeEncoding.encodeStringAttribute(ps.getNationalId()));
        setContactInfo(contactInfo);
        setCivilStatus(civilStatus);
        setPractices(practices);
        setAlternativeIdentifiers(alternativeIdentifiers);
    }

    private String getOriginFromId(String id) {
        switch (id.charAt(0)) {
            case ('0'):
                return "ADELI";
            case ('3'):
                return "FINESS";
            case ('4'):
                return "SIREN";
            case ('5'):
                return "SIRET";
            case ('8'):
                return "RPPS";
            default:
                return "";
        }
    }
}