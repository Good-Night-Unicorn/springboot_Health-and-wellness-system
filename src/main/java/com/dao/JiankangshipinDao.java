package com.dao;

import com.entity.JiankangshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangshipinVO;
import com.entity.view.JiankangshipinView;


/**
 * 健康视频
 * 
 * @author 
 * @email 
 * @date 2025-04-11 22:16:35
 */
public interface JiankangshipinDao extends BaseMapper<JiankangshipinEntity> {
	
	List<JiankangshipinVO> selectListVO(@Param("ew") Wrapper<JiankangshipinEntity> wrapper);
	
	JiankangshipinVO selectVO(@Param("ew") Wrapper<JiankangshipinEntity> wrapper);
	
	List<JiankangshipinView> selectListView(@Param("ew") Wrapper<JiankangshipinEntity> wrapper);

	List<JiankangshipinView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangshipinEntity> wrapper);

	
	JiankangshipinView selectView(@Param("ew") Wrapper<JiankangshipinEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshipinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshipinEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangshipinEntity> wrapper);



}
