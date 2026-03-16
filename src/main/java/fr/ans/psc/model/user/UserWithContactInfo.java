package fr.ans.psc.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.ans.psc.amar.v2.model.CivilStatus;
import fr.ans.psc.amar.v2.model.ContactInfo;
import fr.ans.psc.amar.v2.model.User;

/**
 * Extension de User AMAR qui expose contactInfo séparément
 * et masque les email/phone de civilStatus pour éviter la duplication
 */
public class UserWithContactInfo extends User {
    
    @JsonProperty("contactInfo")
    private ContactInfo contactInfo;
    
    /**
     * Override getCivilStatus pour masquer email et phone dans la sérialisation JSON
     */
    @Override
    @JsonProperty("civilStatus")
    @JsonIgnoreProperties({"email", "phone"})
    public CivilStatus getCivilStatus() {
        return super.getCivilStatus();
    }
    
    public UserWithContactInfo(User user, String email, String phone) {
        // Copier toutes les propriétés du User source
        this.setNationalId(user.getNationalId());
        this.setCivilStatus(user.getCivilStatus());
        this.setPractices(user.getPractices());
        this.setAlternativeIdentifiers(user.getAlternativeIdentifiers());
        this.setEims(user.getEims());
        
        // Créer ContactInfo avec email et phone
        this.contactInfo = new ContactInfo();
        this.contactInfo.setEmail(email);
        this.contactInfo.setPhone(phone);
        
        // Note: email et phone restent dans civilStatus en interne (modèle AMAR v2)
        // mais sont masqués lors de la sérialisation JSON grâce à @JsonIgnoreProperties
    }
    
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
