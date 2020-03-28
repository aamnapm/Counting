package com.aamnapm.counting.model;

public enum WithdrawDeposit {

    WITHDRAW(0), DEPOSIT(1);


    private Integer id;

    WithdrawDeposit(Integer id) {
        this.id = id;
    }

    public static WithdrawDeposit fromValue(int value) {
        switch (value) {
            case 0:
                return WithdrawDeposit.WITHDRAW;
            case 1:
                return WithdrawDeposit.DEPOSIT;
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
