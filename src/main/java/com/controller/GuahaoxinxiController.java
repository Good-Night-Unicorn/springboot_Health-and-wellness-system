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

import com.entity.GuahaoxinxiEntity;
import com.entity.view.GuahaoxinxiView;

import com.service.GuahaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 挂号信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-11 22:16:35
 */
@RestController
@RequestMapping("/guahaoxinxi")
public class GuahaoxinxiController {
    @Autowired
    private GuahaoxinxiService guahaoxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuahaoxinxiEntity guahaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			guahaoxinxi.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			guahaoxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<GuahaoxinxiEntity> ew = new EntityWrapper<GuahaoxinxiEntity>();


        //查询结果
		PageUtils page = guahaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guahaoxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GuahaoxinxiEntity guahaoxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GuahaoxinxiEntity> ew = new EntityWrapper<GuahaoxinxiEntity>();

        //查询结果
		PageUtils page = guahaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guahaoxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuahaoxinxiEntity guahaoxinxi){
       	EntityWrapper<GuahaoxinxiEntity> ew = new EntityWrapper<GuahaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guahaoxinxi, "guahaoxinxi")); 
        return R.ok().put("data", guahaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuahaoxinxiEntity guahaoxinxi){
        EntityWrapper< GuahaoxinxiEntity> ew = new EntityWrapper< GuahaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guahaoxinxi, "guahaoxinxi")); 
		GuahaoxinxiView guahaoxinxiView =  guahaoxinxiService.selectView(ew);
		return R.ok("查询挂号信息成功").put("data", guahaoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuahaoxinxiEntity guahaoxinxi = guahaoxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guahaoxinxi,deSens);
        return R.ok().put("data", guahaoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuahaoxinxiEntity guahaoxinxi = guahaoxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(guahaoxinxi,deSens);
        return R.ok().put("data", guahaoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuahaoxinxiEntity guahaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guahaoxinxi);
        guahaoxinxiService.insert(guahaoxinxi);
        return R.ok().put("data",guahaoxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuahaoxinxiEntity guahaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guahaoxinxi);
        guahaoxinxiService.insert(guahaoxinxi);
        return R.ok().put("data",guahaoxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuahaoxinxiEntity guahaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guahaoxinxi);
        //全部更新
        guahaoxinxiService.updateById(guahaoxinxi);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<GuahaoxinxiEntity> list = new ArrayList<GuahaoxinxiEntity>();
        for(Long id : ids) {
            GuahaoxinxiEntity guahaoxinxi = guahaoxinxiService.selectById(id);
            guahaoxinxi.setSfsh(sfsh);
            guahaoxinxi.setShhf(shhf);
            list.add(guahaoxinxi);
        }
        guahaoxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guahaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
