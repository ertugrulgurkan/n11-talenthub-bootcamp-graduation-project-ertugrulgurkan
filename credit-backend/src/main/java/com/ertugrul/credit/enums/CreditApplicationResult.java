package com.ertugrul.credit.enums;

public enum CreditApplicationResult {
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String result;

    CreditApplicationResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
