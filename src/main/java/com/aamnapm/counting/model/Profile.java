package com.aamnapm.counting.model;


import net.logstash.logback.encoder.org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import net.logstash.logback.encoder.org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

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

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Record> records;

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

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
    }
}
