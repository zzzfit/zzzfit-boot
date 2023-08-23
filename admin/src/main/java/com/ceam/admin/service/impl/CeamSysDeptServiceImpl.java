package com.ceam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ceam.admin.dto.CeamSysDeptDTO;
import com.ceam.admin.entity.CeamSysDept;
import com.ceam.admin.mapper.CeamSysDeptMapper;
import com.ceam.admin.service.ICeamSysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.common.constants.GlobalConstants;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@Service
public class CeamSysDeptServiceImpl extends ServiceImpl<CeamSysDeptMapper, CeamSysDept> implements ICeamSysDeptService {

    @Override
    public List<CeamSysDept> queryAll() {
        LambdaQueryWrapper<CeamSysDept> queryWrapper = Wrappers.<CeamSysDept>lambdaQuery()
                .eq(CeamSysDept::getDeleted, GlobalConstants.FALSE);
        List<CeamSysDept> ceamSysDepts = baseMapper.selectList(queryWrapper);
        return ceamSysDepts;
    }

    @Override
    public Object buildTree(List<CeamSysDeptDTO> data) {
        Set<CeamSysDeptDTO> trees = new LinkedHashSet<>();
        Set<CeamSysDeptDTO> depts = new LinkedHashSet<>();
        List<String> deptNames = data.stream().map(CeamSysDeptDTO::getName).collect(Collectors.toList());
        boolean isChild;
        List<CeamSysDept> deptList = this.queryAll();
        for (CeamSysDeptDTO deptDTO : data) {
            isChild = false;
            if ("0".equals(deptDTO.getPid().toString())) {
                trees.add(deptDTO);
            }
            for (CeamSysDeptDTO it : data) {
                if (it.getPid().equals(deptDTO.getId())) {
                    isChild = true;
                    if (deptDTO.getChildren() == null) {
                        deptDTO.setChildren(new ArrayList<>());
                    }
                    deptDTO.getChildren().add(it);
                }
            }
            if (isChild) {
                depts.add(deptDTO);
                for (CeamSysDept dept : deptList) {
                    if (dept.getId().equals(deptDTO.getPid()) && !deptNames.contains(dept.getName())) {
                        depts.add(deptDTO);
                    }
                }
            }
        }

        if (CollectionUtils.isEmpty(trees)) {
            trees = depts;
        }

        Integer totalElements = data.size();

        Map<String, Object> map = new HashMap<>(2);
        map.put("total", totalElements);
        map.put("records", CollectionUtils.isEmpty(trees) ? data : trees);
        return map;
    }
}
