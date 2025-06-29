package com.Adepu.Customer.Service.Model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {
    private String phoneNumber;
    private int age;
    private String gender;

    public BaseModel(String phoneNumber, int age, String gender) {
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }

    public BaseModel() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "phoneNumber=" + phoneNumber +
                ", age=" + age +
                ", Gender='" + gender + '\'' +
                '}';
    }
}
