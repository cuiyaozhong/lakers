package com.microservice.cyz.user.service;

import com.microservice.cyz.dto.DTO;
import com.microservice.cyz.user.dto.UserDTO;

import javax.xml.crypto.Data;
import java.util.Map;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
public interface UserService {

    UserDTO qryUserInfo(Map<String, Object> paramMap);

    UserDTO qryUserDetail(String userNo);

    DTO addUser(UserDTO userDTO);

    DTO modUser(UserDTO userDTO);

    DTO delUser(String userNo);

}
