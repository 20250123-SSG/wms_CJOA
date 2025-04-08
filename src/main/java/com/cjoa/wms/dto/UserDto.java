package com.cjoa.wms.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int userCode;
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String userType;
    private String userName;

    @Override
    public String toString() {
        return "유저코드: " + userCode +
                " | 아이디: " + userId +
                " | 비밀번호: " + userPassword +
                " | 이메일: " + userEmail +
                " | 전화번호: " + userPhone +
                " | 주소: " + userAddress +
                " | 사용자 유형: " + userType +
                " | 이름: " + userName + '\n';
    }

}

