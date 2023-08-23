package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.entity.CeamCustomer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamCustomerVO;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-20
 */
public interface ICeamCustomerService extends IService<CeamCustomer> {

    IPage<CeamCustomerVO> page(PageableDTO pageableDTO);
}
