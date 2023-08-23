package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.entity.CeamStore;
import com.ceam.sport.vo.CeamStoreVO;
import com.ceam.sport.vo.StoreDetailVO;

import java.util.List;

/**
 * <p>
 * 门店表 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
public interface ICeamStoreService extends IService<CeamStore> {

    StoreDetailVO getStoreDetail(Long storeId);

    List<CeamStoreVO> listCeamStoreVO();

    IPage<CeamStoreVO> page(PageableDTO pageableDTO);
}
