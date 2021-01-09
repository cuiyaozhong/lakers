package com.microservice.cyz.user.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.microservice.cyz.dto.DTO;
import com.microservice.cyz.user.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
@Api(tags = {"用户中心：用户管理"},value = "用户中心：用户管理")
public interface UserResource {

    String PREFIX = "${user-center:}/v2/userManager";

    @GetMapping(PREFIX)
    @ApiOperation(value = "查询用户信息",notes = "查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo",value = "账号",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "姓名",paramType = "query")
    })
    UserDTO qryUserInfo(@ApiIgnore @RequestParam Map<String, Object> paramMap);

    @GetMapping(PREFIX+ "/{userNo}")
    @ApiOperation(value = "查询用户详细信息",notes = "查询用户详细信息")
    @ApiImplicitParam(name = "userNo",value = "账号",required = true,paramType = "path")
    UserDTO qryUserDetail(@PathVariable String userNo);

    @PostMapping(PREFIX)
    @ApiOperation(value = "新增用户信息",notes = "新增用户信息")
    DTO addUser(@RequestBody UserDTO userDTO);

    @PutMapping(PREFIX)
    @ApiOperation(value = "修改人员信息",notes = "修改人员信息")
    DTO modUser(@RequestBody UserDTO userDTO);

    @DeleteMapping(PREFIX + "/{userNo}")
    @ApiOperation(value = "删除人员信息",notes = "删除人员信息")
    @ApiImplicitParam(name = "userNo",value = "账号",required = true,paramType = "path")
    DTO delUser(@PathVariable String userNo);

}
