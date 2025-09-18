package fr.ans.psc.model.user;

import java.util.ArrayList;
import java.util.List;

import fr.ans.psc.amar.v2.model.AlternativeIdentifier;
import fr.ans.psc.amar.v2.model.CivilStatus;
import fr.ans.psc.amar.v2.model.ContactInfo;
import fr.ans.psc.amar.v2.model.Practice;
import fr.ans.psc.amar.v2.model.User;
import fr.ans.psc.model.AttributeEncoding;
import fr.ans.psc.model.Ps;

public class PsiUserAdapter extends User {
    
    // Champs privés pour stocker les données de contact originales
    private final String originalEmail;
    private final String originalPhone;

    public PsiUserAdapter(Ps ps) {
        // Stocker les données originales
        this.originalEmail = AttributeEncoding.encodeStringAttribute(ps.getEmail());
        this.originalPhone = AttributeEncoding.encodeStringAttribute(ps.getPhone());
        
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

        // Intégrer les données de contact dans CivilStatus (nouveau modèle AMAR v2)
        if (civilStatus != null) {
            civilStatus.setEmail(AttributeEncoding.encodeStringAttribute(ps.getEmail()));
            civilStatus.setPhone(AttributeEncoding.encodeStringAttribute(ps.getPhone()));
        }

        setNationalId(AttributeEncoding.encodeStringAttribute(ps.getNationalId()));
        setCivilStatus(civilStatus);
        setPractices(practices);
        setAlternativeIdentifiers(alternativeIdentifiers);
        
        // Pour les réponses API : nettoyer les données de contact de CivilStatus
        // car elles seront exposées via getContactInfo() pour compatibilité
        cleanContactInfoFromCivilStatus();
    }

    /**
     * Nettoie les données de contact de CivilStatus pour éviter la duplication
     * dans les réponses API (contact info sera accessible via getContactInfo())
     */
    private void cleanContactInfoFromCivilStatus() {
        CivilStatus civilStatus = getCivilStatus();
        if (civilStatus != null) {
            civilStatus.setEmail(null);
            civilStatus.setPhone(null);
        }
    }

    /**
     * Méthode helper pour récupérer ContactInfo depuis les données originales du PS
     * pour maintenir la compatibilité API PSI
     */
    public ContactInfo getContactInfo() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmail(originalEmail);
        contactInfo.setPhone(originalPhone);
        return contactInfo;
    }
}