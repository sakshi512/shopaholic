package com.shop.Shopaholic.utilities;

public enum  ErrorCodes {
    SIGN_UP_CONTROLLER_INVALID_INPUT("REGISTRATION EMAIL GIVEN IS EITHER DUPLICATE/OR DETAILS ARE INVALID"),
    INCORRECT_DETAILS ("INCORRECT DETAILS FORMAT"),
    INCORRECT_FIELD_FORMAT("INCORRECT FORMAT FOR A FIELD"),
    INVALID_CREDENTIALS("KINDLY CHECK USERNAME/PASSWORD!!"),
    CART_CONTROLLER("DB OPERATION ERROR");

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