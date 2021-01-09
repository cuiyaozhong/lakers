package com.microservice.cyz.user.dto;

import com.microservice.cyz.dto.DTO;
import com.microservice.cyz.util.RetCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
@Data
@ApiModel(value = "用户实体类",description = "用户实体类")
public class UserDTO extends DTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号",example = "账号")
    private String userNo;

    @ApiModelProperty(value = "姓名",example = "姓名")
    private String name;

    @ApiModelProperty(value = "密码",example = "密码")
    private String password;

    @ApiModelProperty(value = "用户状态：1-启用，2-停用",example = "1")
    private int status;

    @ApiModelProperty(value = "在线状态：1-在线，2-离线",example = "1")
    private int onlineFlag;

    @ApiModelProperty(value = "电话",example = "13813838869")
    private String phone;

    @ApiModelProperty(value = "电子邮件",example = "yzcui@zjft.com")
    private String emil;

    @ApiModelProperty(value = "上次登录时间")
    private String loginTime;

    @ApiModelProperty(value = "密码错误次数")
    private int passwordError;

    public UserDTO(){

    }

    public UserDTO(RetCodeEnum re) {
        super(re);
    }

}
