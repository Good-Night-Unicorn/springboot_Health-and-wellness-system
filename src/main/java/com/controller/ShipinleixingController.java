package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShipinleixingEntity;
import com.entity.view.ShipinleixingView;

import com.service.ShipinleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 视频类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-11 22:16:35
 */
@RestController
@RequestMapping("/shipinleixing")
public class ShipinleixingController {
    @Autowired
    private ShipinleixingService shipinleixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinleixingEntity shipinleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShipinleixingEntity> ew = new EntityWrapper<ShipinleixingEntity>();


        //查询结果
		PageUtils page = shipinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinleixingEntity shipinleixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShipinleixingEntity> ew = new EntityWrapper<ShipinleixingEntity>();

        //查询结果
		PageUtils page = shipinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinleixingEntity shipinleixing){
       	EntityWrapper<ShipinleixingEntity> ew = new EntityWrapper<ShipinleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinleixing, "shipinleixing")); 
        return R.ok().put("data", shipinleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinleixingEntity shipinleixing){
        EntityWrapper< ShipinleixingEntity> ew = new EntityWrapper< ShipinleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinleixing, "shipinleixing")); 
		ShipinleixingView shipinleixingView =  shipinleixingService.selectView(ew);
		return R.ok("查询视频类型成功").put("data", shipinleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinleixingEntity shipinleixing = shipinleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shipinleixing,deSens);
        return R.ok().put("data", shipinleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinleixingEntity shipinleixing = shipinleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shipinleixing,deSens);
        return R.ok().put("data", shipinleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipinleixingEntity shipinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinleixing);
        shipinleixingService.insert(shipinleixing);
        return R.ok().put("data",shipinleixing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipinleixingEntity shipinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinleixing);
        shipinleixingService.insert(shipinleixing);
        return R.ok().put("data",shipinleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipinleixingEntity shipinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinleixing);
        //全部更新
        shipinleixingService.updateById(shipinleixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipinleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
