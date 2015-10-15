package no.nith.pg5100.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class ContactInfo {
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
