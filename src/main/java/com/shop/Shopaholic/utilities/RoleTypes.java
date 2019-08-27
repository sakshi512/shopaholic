package com.shop.Shopaholic.utilities;

public enum RoleTypes {
    USERS,
    ADMIN;

    public int getIndex() { return ordinal() + 1; }

};