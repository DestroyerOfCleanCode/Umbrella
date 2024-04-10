package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patient {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String phoneNumber;
    private String email;
    private String address;
    private String insuranceNumber;
    private String pharmacyAddress;
    private String pharmacyPhoneNumber;
    private Double weight;
    private Double height;
    private Double bodyTemp;
    private Double bloodPressureHi;
    private Double bloodPressureLo;
    private String healthHistory;
    private String immunization;

    public Patient(Integer id, String firstName, String lastName, String dob,
            String phoneNumber, String email, String address, String insuranceNumber,
            String pharmacyAddress, String pharmacyPhoneNumber, Double weight, Double height,
            Double bodyTemp, Double bloodPressureHi, Double bloodPressureLo,
            String healthHistory, String immunization) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);
        this.phoneNumber = parseString(phoneNumber);
        this.email = parseString(email);
        this.address = parseString(address);
        this.insuranceNumber = parseString(insuranceNumber);
        this.pharmacyAddress = parseString(pharmacyAddress);
        this.pharmacyPhoneNumber = parseString(pharmacyPhoneNumber);
        this.weight = weight;
        this.height = height;
        this.bodyTemp = bodyTemp;
        this.bloodPressureHi = bloodPressureHi;
        this.bloodPressureLo = bloodPressureLo;
        this.healthHistory = parseString(healthHistory);
        this.immunization = parseString(immunization);
    }

    private String parseString(String input) {
        return (input == null || input.equals("null")) ? null : input;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyPhoneNumber() {
        return pharmacyPhoneNumber;
    }

    public void setPharmacyPhoneNumber(String pharmacyPhoneNumber) {
        this.pharmacyPhoneNumber = pharmacyPhoneNumber;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(Double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public Double getBloodPressureHi() {
        return bloodPressureHi;
    }

    public void setBloodPressureHi(Double bloodPressureHi) {
        this.bloodPressureHi = bloodPressureHi;
    }

    public Double getBloodPressureLo() {
        return bloodPressureLo;
    }

    public void setBloodPressureLo(Double bloodPressureLo) {
        this.bloodPressureLo = bloodPressureLo;
    }

    public String getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(String healthHistory) {
        this.healthHistory = healthHistory;
    }

    public String getImmunization() {
        return immunization;
    }

    public void setImmunization(String immunization) {
        this.immunization = immunization;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Patient {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", pharmacyAddress='" + pharmacyAddress + '\'' +
                ", pharmacyPhoneNumber='" + pharmacyPhoneNumber + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", bodyTemp=" + bodyTemp +
                ", bloodPressureHi=" + bloodPressureHi +
                ", bloodPressureLo=" + bloodPressureLo +
                ", healthHistory='" + healthHistory + '\'' +
                ", immunization='" + immunization + '\'' +
                '}';
    }
}
