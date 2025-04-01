package com.cjoa.wms.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private int userCode;
    private String userId;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String userType;
    private String userName;
}

