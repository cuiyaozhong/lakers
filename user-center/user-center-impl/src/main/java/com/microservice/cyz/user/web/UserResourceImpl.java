package com.microservice.cyz.user.web;

import com.microservice.cyz.dto.DTO;
import com.microservice.cyz.user.dto.UserDTO;
import com.microservice.cyz.user.service.UserService;
import com.microservice.cyz.util.RetCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
@Slf4j
@RestController
public class UserResourceImpl implements UserResource {

    @Resource
    private UserService userService;

    @Override
    public UserDTO qryUserInfo(Map<String, Object> paramMap) {
        return userService.qryUserInfo(paramMap);
    }

    @Override
    public UserDTO qryUserDetail(String userNo) {
        if ("".equals(userNo) || null == userNo){
            return new UserDTO(RetCodeEnum.PARAM_LACK);
        }else {
            return userService.qryUserDetail(userNo);
        }
    }

    @Override
    public DTO addUser(UserDTO userDTO) {
        if (userDTO != null){
            return userService.addUser(userDTO);
        }else {
            return new DTO(RetCodeEnum.PSW_EMPTY);
        }
    }

    @Override
    public DTO modUser(UserDTO userDTO) {
        if (userDTO != null){
            return userService.modUser(userDTO);
        }else {
            return new DTO(RetCodeEnum.PSW_EMPTY);
        }
    }

    @Override
    public DTO delUser(String userNo) {
        if ("".equals(userNo) || null == userNo){
            return new DTO(RetCodeEnum.PSW_EMPTY);
        }else {
           return userService.delUser(userNo);
        }
    }
}
