package com.microservice.cyz.user.repository;

import com.microservice.cyz.user.po.WebLogPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 崔耀中
 * @since 2021-01-10
 */
@Mapper
public interface WebLogMapper {

    @Insert({
            "insert into  ",
            "SYS_WEB_LOG (USER_NO, TID, METHOD, URL, RESULT, START_TIME, COST_TIME, " +
                    "CLIENT_IP, SERVER_IP, DESCRIPTION, REQUEST)",
            "values (#{username,jdbcType=VARCHAR}, #{tid,jdbcType=VARCHAR}, " +
                    "#{method,jdbcType=VARCHAR},#{url,jdbcType=VARCHAR}, #{result,jdbcType=VARCHAR}, " +
                    "#{startTime,jdbcType=VARCHAR},#{costTime,jdbcType=VARCHAR},  " +
                    "#{clientIp,jdbcType=VARCHAR},#{serverIp,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, " +
                    "#{request,jdbcType=VARCHAR} )"
    })
    int insert(WebLogPO webLogPO);


}
