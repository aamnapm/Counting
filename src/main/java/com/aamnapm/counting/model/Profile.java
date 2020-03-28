package com.aamnapm.counting.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "profile")
@AttributeOverrides({
        @AttributeOverride(name = "uuid", column = @Column(name = "uuid"))
})
public class Profile extends BaseEntity {

    @Column(name = "age", unique = false)
    private int age;

    @Column(name = "name", unique = false)
    private String name;

    @Column(name = "family", unique = false)
    private String family;

    @Column(name = "national_ode", unique = true)
    @NotEmpty(message = "nationalCode must be required and unique")
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
