package fr.ans.psc.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.ans.psc.amar.v2.model.ContactInfo;
import fr.ans.psc.amar.v2.model.User;

/**
 * Extension de User AMAR qui expose contactInfo séparément
 * et nettoie les email/phone de civilStatus pour éviter la duplication
 */
public class UserWithContactInfo extends User {
    
    @JsonProperty("contactInfo")
    private ContactInfo contactInfo;
    
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
        
        // Nettoyer email et phone de civilStatus pour éviter la duplication
        if (this.getCivilStatus() != null) {
            this.getCivilStatus().setEmail(null);
            this.getCivilStatus().setPhone(null);
        }
    }
    
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
