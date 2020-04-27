package com.aamnapm.counting.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
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

}
