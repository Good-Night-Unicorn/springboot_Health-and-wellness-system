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

import com.entity.ZixunjiluEntity;
import com.entity.view.ZixunjiluView;

import com.service.ZixunjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询记录
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-11 22:16:35
 */
@RestController
@RequestMapping("/zixunjilu")
public class ZixunjiluController {
    @Autowired
    private ZixunjiluService zixunjiluService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunjiluEntity zixunjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zixunjilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yisheng")) {
			zixunjilu.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ZixunjiluEntity> ew = new EntityWrapper<ZixunjiluEntity>();


        //查询结果
		PageUtils page = zixunjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunjilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunjiluEntity zixunjilu, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zixunjilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yisheng")) {
			zixunjilu.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ZixunjiluEntity> ew = new EntityWrapper<ZixunjiluEntity>();

        //查询结果
		PageUtils page = zixunjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunjilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunjiluEntity zixunjilu){
       	EntityWrapper<ZixunjiluEntity> ew = new EntityWrapper<ZixunjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunjilu, "zixunjilu")); 
        return R.ok().put("data", zixunjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunjiluEntity zixunjilu){
        EntityWrapper< ZixunjiluEntity> ew = new EntityWrapper< ZixunjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunjilu, "zixunjilu")); 
		ZixunjiluView zixunjiluView =  zixunjiluService.selectView(ew);
		return R.ok("查询咨询记录成功").put("data", zixunjiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunjiluEntity zixunjilu = zixunjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zixunjilu,deSens);
        return R.ok().put("data", zixunjilu);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunjiluEntity zixunjilu = zixunjiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zixunjilu,deSens);
        return R.ok().put("data", zixunjilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunjiluEntity zixunjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunjilu);
        zixunjiluService.insert(zixunjilu);
        return R.ok().put("data",zixunjilu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZixunjiluEntity zixunjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunjilu);
    	zixunjilu.setUserid((Long)request.getSession().getAttribute("userId"));
        zixunjiluService.insert(zixunjilu);
        return R.ok().put("data",zixunjilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZixunjiluEntity zixunjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunjilu);
        //全部更新
        zixunjiluService.updateById(zixunjilu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
