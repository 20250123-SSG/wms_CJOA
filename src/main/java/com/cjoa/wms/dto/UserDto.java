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
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String userType;
    private String userName;
}

