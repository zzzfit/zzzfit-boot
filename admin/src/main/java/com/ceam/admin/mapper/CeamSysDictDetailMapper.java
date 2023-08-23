package com.ceam.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.entity.CeamSysDictDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceam.admin.vo.CeamSysDictDetailVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 数据字典详情 Mapper 接口
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
public interface CeamSysDictDetailMapper extends BaseMapper<CeamSysDictDetail> {


    @Select("        SELECT\n" +
            "            t.* , d.name deptName\n" +
            "        FROM ceam_sys_dict_detail t\n" +
            "        LEFT JOIN ceam_sys_dict d ON d.id = t.dict_id\n" +
            "        WHERE d.name = #{dictName}")
    IPage<CeamSysDictDetailVO> pageCeamSysDictDetailVO(@Param("dictName") String dictName,
                                                       Page page);
}
