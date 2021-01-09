package com.microservice.cyz.user.po;


import lombok.Data;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
@Data
public class UserPO {

    private static final long serialVersionUID = 1L;

    private String userNo;

    private String name;

    private String password;

    private int status;

    private int onlineFlag;

    private String phone;

    private String email;

    private String loginTime;

    private int passwordError;

}
