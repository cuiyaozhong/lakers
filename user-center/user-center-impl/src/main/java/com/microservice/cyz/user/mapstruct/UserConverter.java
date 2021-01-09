package com.microservice.cyz.user.mapstruct;

import com.microservice.cyz.user.dto.UserDTO;
import com.microservice.cyz.user.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author 崔耀中
 * @since 2021-01-08
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);
    @Mappings({

    })

    /**
     * @Description po转dto
     * @Param
     */
    UserDTO op2dto(UserPO userPO);

    /**
     * @Description dto转po
     * @Param
     */
    UserPO dto2po(UserDTO userDTO);

}
