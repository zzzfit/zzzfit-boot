package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.exception.ServiceException;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.ObjectUtils;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.common.utils.SecurityUtils;
import com.ceam.sport.entity.CeamStore;
import com.ceam.sport.mapper.CeamStoreMapper;
import com.ceam.sport.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.utils.CourseWeekUtil;
import com.ceam.sport.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 门店表 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@Service
@AllArgsConstructor
public class CeamStoreServiceImpl
        extends ServiceImpl<CeamStoreMapper, CeamStore> implements ICeamStoreService {

    private ICeamVipService vipService;
    private ICeamCoursePlanService coursePlanService;
    private ICeamCommentsService commentsService;
    private ICeamCoachService coachService;

    @Override
    public StoreDetailVO getStoreDetail(Long storeId) {
        Long userId = SecurityUtils.getUserId();
//        if (ObjectUtils.isEmpty(userId)) {
//            throw new ServiceException("未登录");
//        }

        LambdaQueryWrapper<CeamStore> queryWrapper = Wrappers.<CeamStore>lambdaQuery()
                .eq(CeamStore::getDeleted, GlobalConstants.FALSE)
                .eq(CeamStore::getId, storeId);
        CeamStore ceamStore = baseMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(ceamStore)) {
            throw new ServiceException("店铺信息不存在，逛逛其他店铺吧！");
        }
        StoreDetailVO storeDetailVO = BeanCopyUtil
                .copyProperties(ceamStore, StoreDetailVO.class);
        List<CeamVipVO> ceamVipVOS = vipService.listCeamVipVO();
        List<CeamCoursePlanVO> coursePlanVOS = coursePlanService.listCeamCoursePlanVO();
        Map<Integer, List<CeamCoursePlanVO>> courseMap = coursePlanVOS.stream()
                .collect(Collectors.groupingBy(CeamCoursePlanVO::getWeekday));

        List<CeamCommentsVO> ceamCommentsVOS = commentsService
                .listComments(GlobalConstants.ZERO, GlobalConstants.LONG_ONE, storeId);

        List<CeamCoachVO> ceamCoachVOS = coachService.listCeamCoachVO();

        storeDetailVO.setVips(ceamVipVOS);
        storeDetailVO.setCourseMap(courseMap);
        storeDetailVO.setNavDayList(CourseWeekUtil.navDayList());
        storeDetailVO.setCommentsList(ceamCommentsVOS);
        storeDetailVO.setCoachList(ceamCoachVOS);
        return storeDetailVO;
    }

    @Override
    public List<CeamStoreVO> listCeamStoreVO() {
        LambdaQueryWrapper<CeamStore> queryWrapper = Wrappers.<CeamStore>lambdaQuery()
                .eq(CeamStore::getDeleted, GlobalConstants.FALSE);
        List<CeamStore> ceamStores = baseMapper.selectList(queryWrapper);
        List<CeamStoreVO> ceamStoreVOS = BeanCopyUtil
                .copyListProperties(ceamStores, CeamStoreVO.class);

        Map<Long, CeaMLocationVO> map = new HashMap<>();
        ceamStoreVOS.forEach(item -> {
            List<Integer> list = null;
            if (ObjectUtils.isNotEmpty(item.getStar())) {
                list = new LinkedList<>();
                Integer star = item.getStar();
                for (Integer i = 0; i < star; i++) {
                    list.add(i);
                }
            }
            item.setStars(list);
            CeaMLocationVO locationVO = new CeaMLocationVO();
            locationVO.setLatitude(item.getLatitude());
            locationVO.setLongitude(item.getLongitude());

            locationVO.setMarkers(locationVO.newMarkers(item.getId(),
                    item.getLatitude(),
                    item.getLongitude(),
                    locationVO.newLabel(item.getName() + " 34km"),
                    locationVO.newCallout(item.getName() + " 34km")));
            map.put(item.getId(), locationVO);
            item.setLocation(map);
        });
        return ceamStoreVOS;
    }

    @Override
    public IPage<CeamStoreVO> page(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamStore> queryWrapper = Wrappers.<CeamStore>lambdaQuery()
                .eq(CeamStore::getDeleted, GlobalConstants.FALSE);
        Page<CeamStore> page = new Page<>();
        page.setCurrent((long)pageableDTO.getPage() + 1);
        Page<CeamStore> ceamStorePage = baseMapper.selectPage(page, queryWrapper);
        IPage<CeamStoreVO> ceamStoreVOIPage = PageVOUtil
                .copyToPageVO(ceamStorePage, CeamStoreVO.class);
        return ceamStoreVOIPage;
    }
}
