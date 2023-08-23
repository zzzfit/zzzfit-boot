package com.ceam.admin.service;

import com.ceam.admin.dto.CeamSysDeptDTO;
import com.ceam.admin.entity.CeamSysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
public interface ICeamSysDeptService extends IService<CeamSysDept> {

    List<CeamSysDept> queryAll();

    Object buildTree(List<CeamSysDeptDTO> data);
}
