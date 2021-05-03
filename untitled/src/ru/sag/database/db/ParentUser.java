package ru.sag.database.db;

public class ParentUser {
    private String surnameParent;
    private String firstnameParent;
    private String patronymicParent;
    private String numberParent;
    private String registrationParent;
    private String addressParent;
    private String jobParent;
    private String representative;
    private String guardianship;

    public ParentUser(String surnameParent, String firstnameParent, String patronymicParent, String numberParent, String registrationParent, String addressParent, String jobParent, String representative, String guardianship) {
        this.surnameParent = surnameParent;
        this.firstnameParent = firstnameParent;
        this.patronymicParent = patronymicParent;
        this.numberParent = numberParent;
        this.registrationParent = registrationParent;
        this.addressParent = addressParent;
        this.jobParent = jobParent;
        this.representative = representative;
        this.guardianship = guardianship;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getSurnameParent() {
        return surnameParent;
    }

    public void setSurnameParent(String surnameParent) {
        this.surnameParent = surnameParent;
    }

    public String getFirstnameParent() {
        return firstnameParent;
    }

    public void setFirstnameParent(String firstnameParent) {
        this.firstnameParent = firstnameParent;
    }

    public String getPatronymicParent() {
        return patronymicParent;
    }

    public void setPatronymicParent(String patronymicParent) {
        this.patronymicParent = patronymicParent;
    }

    public String getNumberParent() {
        return numberParent;
    }

    public void setNumberParent(String numberParent) {
        this.numberParent = numberParent;
    }

    public String getRegistrationParent() {
        return registrationParent;
    }

    public void setRegistrationParent(String registrationParent) {
        this.registrationParent = registrationParent;
    }

    public String getAddressParent() {
        return addressParent;
    }

    public void setAddressParent(String addressParent) {
        this.addressParent = addressParent;
    }

    public String getJobParent() {
        return jobParent;
    }

    public void setJobParent(String jobParent) {
        this.jobParent = jobParent;
    }

    public String getGuardianship() {
        return guardianship;
    }

    public void setGuardianship(String guardianship) {
        this.guardianship = guardianship;
    }
}
