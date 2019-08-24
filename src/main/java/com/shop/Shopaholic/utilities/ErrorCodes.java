package com.shop.Shopaholic.utilities;

public enum  ErrorCodes {
    INCORRECT_DETAILS ("INCORRECT DETAILS FORMAT"),
    INCORRECT_FIELD_FORMAT("INCORRECT FORMAT FOR A FIELD");

    private final String errorDescription;

    ErrorCodes(String errorDescription)
    {
        this.errorDescription = errorDescription;
    }
    public String getErrorDescription()
    {
        return errorDescription;
    }
}