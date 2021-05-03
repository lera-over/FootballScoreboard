package ru.sag.database.db;

public class User {
    private String surname;
    private String firstname;
    private String patronymic;
    private String dob;
    private String number;
    private String registration;
    private String address;
    private String passportData;
    private String averageScore;
    private Object speciality;
    private String gender;
    private String hostel;
    private String education;
    private String surnameParents;

    public User(String surname, String firstname, String patronymic, String dob, String number, String registration,
                String address, String passportData, String averageScore, Object speciality, String gender,
                String hostel, String education, String surnameParents) {
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.dob = dob;
        this.number = number;
        this.registration = registration;
        this.address = address;
        this.passportData = passportData;
        this.averageScore = averageScore;
        this.speciality = speciality;
        this.gender = gender;
        this.hostel = hostel;
        this.education = education;
        this.surnameParents = surnameParents;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSurnameParents() {
        return surnameParents;
    }

    public void setSurnameParents(String surnameParents) {
        this.surnameParents = surnameParents;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    public Object getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
