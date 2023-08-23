package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.entity.CeamCoach;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamCoachVO;

import java.util.List;

/**
 * <p>
 * 教练表 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
public interface ICeamCoachService extends IService<CeamCoach> {

    List<CeamCoachVO> listCeamCoachVO();

    IPage<CeamCoachVO> page(PageableDTO pageableDTO);
}
