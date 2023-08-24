package com.ceam.admin.mapper;

import com.ceam.admin.entity.CeamSysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CeaM
 * @since 2023-01-28
 */
public interface CeamSysMenuMapper extends BaseMapper<CeamSysMenu> {

    List<CeamSysMenu> listByRoleIds(@Param("id") Long id,
                                    @Param("type") Integer type);
}
