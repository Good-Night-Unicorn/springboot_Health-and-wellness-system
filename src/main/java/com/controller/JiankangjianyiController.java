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

import com.entity.JiankangjianyiEntity;
import com.entity.view.JiankangjianyiView;

import com.service.JiankangjianyiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健康建议
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-11 22:16:35
 */
@RestController
@RequestMapping("/jiankangjianyi")
public class JiankangjianyiController {
    @Autowired
    private JiankangjianyiService jiankangjianyiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiankangjianyiEntity jiankangjianyi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jianyishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jianyishijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiankangjianyi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JiankangjianyiEntity> ew = new EntityWrapper<JiankangjianyiEntity>();
        if(jianyishijianstart!=null) ew.ge("jianyishijian", jianyishijianstart);
        if(jianyishijianend!=null) ew.le("jianyishijian", jianyishijianend);


        //查询结果
		PageUtils page = jiankangjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangjianyi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JiankangjianyiEntity jiankangjianyi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jianyishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jianyishijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JiankangjianyiEntity> ew = new EntityWrapper<JiankangjianyiEntity>();
        if(jianyishijianstart!=null) ew.ge("jianyishijian", jianyishijianstart);
        if(jianyishijianend!=null) ew.le("jianyishijian", jianyishijianend);

        //查询结果
		PageUtils page = jiankangjianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiankangjianyi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiankangjianyiEntity jiankangjianyi){
       	EntityWrapper<JiankangjianyiEntity> ew = new EntityWrapper<JiankangjianyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiankangjianyi, "jiankangjianyi")); 
        return R.ok().put("data", jiankangjianyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiankangjianyiEntity jiankangjianyi){
        EntityWrapper< JiankangjianyiEntity> ew = new EntityWrapper< JiankangjianyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiankangjianyi, "jiankangjianyi")); 
		JiankangjianyiView jiankangjianyiView =  jiankangjianyiService.selectView(ew);
		return R.ok("查询健康建议成功").put("data", jiankangjianyiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiankangjianyiEntity jiankangjianyi = jiankangjianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangjianyi,deSens);
        return R.ok().put("data", jiankangjianyi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiankangjianyiEntity jiankangjianyi = jiankangjianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jiankangjianyi,deSens);
        return R.ok().put("data", jiankangjianyi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangjianyiEntity jiankangjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangjianyi);
        jiankangjianyiService.insert(jiankangjianyi);
        return R.ok().put("data",jiankangjianyi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangjianyiEntity jiankangjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangjianyi);
        jiankangjianyiService.insert(jiankangjianyi);
        return R.ok().put("data",jiankangjianyi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiankangjianyiEntity jiankangjianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiankangjianyi);
        //全部更新
        jiankangjianyiService.updateById(jiankangjianyi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiankangjianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
