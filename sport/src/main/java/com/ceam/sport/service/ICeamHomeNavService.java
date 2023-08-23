package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.entity.CeamHomeNav;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamHomeNavVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-19
 */
public interface ICeamHomeNavService extends IService<CeamHomeNav> {

    List<CeamHomeNavVO> listCeamHomeNavVO();

    IPage<CeamHomeNavVO> page(PageableDTO pageableDTO);
}
