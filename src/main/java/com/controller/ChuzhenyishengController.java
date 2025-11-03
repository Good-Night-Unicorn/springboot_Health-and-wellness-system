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

import com.entity.ChuzhenyishengEntity;
import com.entity.view.ChuzhenyishengView;

import com.service.ChuzhenyishengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 出诊医生
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-11 22:16:35
 */
@RestController
@RequestMapping("/chuzhenyisheng")
public class ChuzhenyishengController {
    @Autowired
    private ChuzhenyishengService chuzhenyishengService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuzhenyishengEntity chuzhenyisheng,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			chuzhenyisheng.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
        if(chuzhenriqistart!=null) ew.ge("chuzhenriqi", chuzhenriqistart);
        if(chuzhenriqiend!=null) ew.le("chuzhenriqi", chuzhenriqiend);


        //查询结果
		PageUtils page = chuzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuzhenyisheng), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChuzhenyishengEntity chuzhenyisheng, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqiend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
        if(chuzhenriqistart!=null) ew.ge("chuzhenriqi", chuzhenriqistart);
        if(chuzhenriqiend!=null) ew.le("chuzhenriqi", chuzhenriqiend);

        //查询结果
		PageUtils page = chuzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuzhenyisheng), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuzhenyishengEntity chuzhenyisheng){
       	EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuzhenyisheng, "chuzhenyisheng")); 
        return R.ok().put("data", chuzhenyishengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuzhenyishengEntity chuzhenyisheng){
        EntityWrapper< ChuzhenyishengEntity> ew = new EntityWrapper< ChuzhenyishengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuzhenyisheng, "chuzhenyisheng")); 
		ChuzhenyishengView chuzhenyishengView =  chuzhenyishengService.selectView(ew);
		return R.ok("查询出诊医生成功").put("data", chuzhenyishengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuzhenyishengEntity chuzhenyisheng = chuzhenyishengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chuzhenyisheng,deSens);
        return R.ok().put("data", chuzhenyisheng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuzhenyishengEntity chuzhenyisheng = chuzhenyishengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chuzhenyisheng,deSens);
        return R.ok().put("data", chuzhenyisheng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuzhenyisheng);
        chuzhenyishengService.insert(chuzhenyisheng);
        return R.ok().put("data",chuzhenyisheng.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuzhenyisheng);
        chuzhenyishengService.insert(chuzhenyisheng);
        return R.ok().put("data",chuzhenyisheng.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuzhenyisheng);
        //全部更新
        chuzhenyishengService.updateById(chuzhenyisheng);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuzhenyishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
