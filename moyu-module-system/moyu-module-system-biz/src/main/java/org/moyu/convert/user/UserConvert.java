package org.moyu.convert.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.moyu.api.user.dto.AdminUserRespDTO;
import org.moyu.dal.dataobject.user.AdminUser;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    AdminUserRespDTO convert(AdminUser bean);

}
