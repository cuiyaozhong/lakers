package com.microservice.cyz.user.service.impl;

import com.microservice.cyz.dto.DTO;
import com.microservice.cyz.user.dto.UserDTO;
import com.microservice.cyz.user.mapstruct.UserConverter;
import com.microservice.cyz.user.po.UserPO;
import com.microservice.cyz.user.repository.UserMapper;
import com.microservice.cyz.user.service.UserService;
import com.microservice.cyz.util.EncryptUtil;
import com.microservice.cyz.util.RetCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO qryUserInfo(Map<String, Object> paramMap) {
//        int id = Integer.valueOf(paramMap.get("id").toString());
        UserPO userPO = userMapper.qryUserInfo(paramMap);
        UserDTO userDTO = UserConverter.INSTANCE.op2dto(userPO);
        return userDTO;
    }

    @Override
    public UserDTO qryUserDetail(String userNo) {
        UserDTO userDTO = new UserDTO(RetCodeEnum.FAIL);
        UserPO userPO = userMapper.qryUserDetail(userNo);
        if (userPO == null){
            userDTO.setRetMsg("账号查询为空");
            return userDTO;
        }
        userDTO = UserConverter.INSTANCE.op2dto(userPO);
        userDTO.setResult(RetCodeEnum.SUCCEED);
        return userDTO;
    }

    @Override
    public DTO addUser(UserDTO userDTO) {
        DTO dto = new DTO(RetCodeEnum.FAIL);
        String password = userDTO.getPassword();
        password = EncryptUtil.MD5(password);
        userDTO.setPassword(password);
        UserPO userPO = UserConverter.INSTANCE.dto2po(userDTO);
        int x= userMapper.insert(userPO);
        if (x !=1){
            return dto;
        }
        dto.setResult(RetCodeEnum.SUCCEED);
        return dto;
    }

    @Override
    public DTO modUser(UserDTO userDTO) {
        DTO dto = new DTO(RetCodeEnum.FAIL);
        String password = userDTO.getPassword();
        if (!"".equals(password) || password != null){
            password = EncryptUtil.MD5(password);
            userDTO.setPassword(password);
        }
        UserPO userPO = UserConverter.INSTANCE.dto2po(userDTO);
        int x= userMapper.update(userPO);
        if (x !=1){
            return dto;
        }
        dto.setResult(RetCodeEnum.SUCCEED);
        return dto;
    }

    @Override
    public DTO delUser(String userNo) {
        DTO dto = new DTO(RetCodeEnum.FAIL);
        int x= userMapper.delete(userNo);
        if (x !=1){
            return dto;
        }
        dto.setResult(RetCodeEnum.SUCCEED);
        return dto;
    }
}
