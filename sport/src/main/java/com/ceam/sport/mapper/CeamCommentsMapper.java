package com.ceam.sport.mapper;

import com.ceam.sport.entity.CeamComments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceam.sport.vo.CeamCommentsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CeaM
 * @since 2023-02-23
 */
public interface CeamCommentsMapper extends BaseMapper<CeamComments> {

    List<CeamCommentsVO> listComments(@Param("type") Integer type,
                                      @Param("coachId") Long coachId,
                                      @Param("storeId") Long storeId);
}
