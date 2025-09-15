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

    public PsiUserAdapter(Ps ps) {
        ContactInfo contactInfo = new PsiContactInfoAdapter(ps);
        CivilStatus civilStatus = new PsiCivilStatusAdapter(ps);
        List<Practice> practices = new ArrayList<>();
        if (ps.getProfessions() != null) {
            ps.getProfessions().forEach(profession -> practices.add(new PsiPracticeAdapter(profession)));
        }
        List<AlternativeIdentifier> alternativeIdentifiers = new ArrayList<>();
        // Utiliser les alternativeIds réels de la base qui contiennent les bonnes origines et qualités
        if (ps.getAlternativeIds() != null) {
            ps.getAlternativeIds().forEach(altId -> {
                AlternativeIdentifier identifier = new AlternativeIdentifier();
                identifier.setIdentifier(altId.getIdentifier());
                identifier.setOrigine(altId.getOrigine());
                identifier.setQuality(altId.getQuality());
                alternativeIdentifiers.add(identifier);
            });
        }

        setNationalId(AttributeEncoding.encodeStringAttribute(ps.getNationalId()));
        setContactInfo(contactInfo);
        setCivilStatus(civilStatus);
        setPractices(practices);
        setAlternativeIdentifiers(alternativeIdentifiers);
    }
}