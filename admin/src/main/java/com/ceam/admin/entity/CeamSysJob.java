package com.ceam.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 岗位
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CeamSysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位状态
     */
    private Boolean enabled;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 创建日期
     */
    private LocalDateTime addTime;

    private LocalDateTime updTime;

    private Boolean deleted;


}
