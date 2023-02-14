package com.springboot.lolcommunity.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN,ROLE_USER"),
    USER("ROLE_USER");

    private String value;
}
