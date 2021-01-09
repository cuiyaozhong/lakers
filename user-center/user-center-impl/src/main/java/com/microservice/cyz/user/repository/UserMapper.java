package com.microservice.cyz.user.repository;

import com.microservice.cyz.user.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
@Mapper
public interface UserMapper {

    UserPO qryUserInfo(Map<String, Object> paramMap);

    UserPO qryUserDetail(String userNo);

    int insert(UserPO userPO);

    int update(UserPO userPO);

    int delete(String userNo);

}
