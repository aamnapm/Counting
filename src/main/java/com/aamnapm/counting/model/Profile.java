package com.aamnapm.counting.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile extends BaseEntity{

    private int age;
    private String name;
    private String family;
    private String nationalCode;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
