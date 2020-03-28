package com.aamnapm.counting.dto;

import com.aamnapm.counting.model.WithdrawDeposit;

public class RecordDTO {

    private String title;
    private String price;
    private WithdrawDeposit type;

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
