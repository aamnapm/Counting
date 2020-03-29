package com.aamnapm.counting.model;


import javax.persistence.*;

@Entity
@Table(name = "record")
@AttributeOverrides({
        @AttributeOverride(name = "uuid", column = @Column(name = "uuid"))
})
public class Record extends BaseEntity {

    @Column(name = "title", unique = false)
    private String title;

    @Column(name = "price", unique = false)
    private String price;

    @Column(name = "type", unique = false)
    private WithdrawDeposit type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public WithdrawDeposit getType() {
        return type;
    }

    public void setType(WithdrawDeposit type) {
        this.type = type;
    }
}
