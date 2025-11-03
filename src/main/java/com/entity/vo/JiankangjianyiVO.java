package com.entity.vo;

import com.entity.JiankangjianyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康建议
 * @author 
 * @email 
 * @date 2025-04-11 22:16:35
 */
public class JiankangjianyiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 健康评估
	 */
	
	private String jiankangpinggu;
		
	/**
	 * 饮食建议
	 */
	
	private String yinshijianyi;
		
	/**
	 * 营养建议
	 */
	
	private String yingyangjianyi;
		
	/**
	 * 运动方案
	 */
	
	private String yundongfangan;
		
	/**
	 * 建议时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jianyishijian;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：健康评估
	 */
	 
	public void setJiankangpinggu(String jiankangpinggu) {
		this.jiankangpinggu = jiankangpinggu;
	}
	
	/**
	 * 获取：健康评估
	 */
	public String getJiankangpinggu() {
		return jiankangpinggu;
	}
				
	
	/**
	 * 设置：饮食建议
	 */
	 
	public void setYinshijianyi(String yinshijianyi) {
		this.yinshijianyi = yinshijianyi;
	}
	
	/**
	 * 获取：饮食建议
	 */
	public String getYinshijianyi() {
		return yinshijianyi;
	}
				
	
	/**
	 * 设置：营养建议
	 */
	 
	public void setYingyangjianyi(String yingyangjianyi) {
		this.yingyangjianyi = yingyangjianyi;
	}
	
	/**
	 * 获取：营养建议
	 */
	public String getYingyangjianyi() {
		return yingyangjianyi;
	}
				
	
	/**
	 * 设置：运动方案
	 */
	 
	public void setYundongfangan(String yundongfangan) {
		this.yundongfangan = yundongfangan;
	}
	
	/**
	 * 获取：运动方案
	 */
	public String getYundongfangan() {
		return yundongfangan;
	}
				
	
	/**
	 * 设置：建议时间
	 */
	 
	public void setJianyishijian(Date jianyishijian) {
		this.jianyishijian = jianyishijian;
	}
	
	/**
	 * 获取：建议时间
	 */
	public Date getJianyishijian() {
		return jianyishijian;
	}
			
}
