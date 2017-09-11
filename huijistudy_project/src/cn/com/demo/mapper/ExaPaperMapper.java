package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.demo.po.ExaPaper;

public interface ExaPaperMapper {
    
	List<ExaPaper> findPaperModeList(Map<String,Object> map);

	void makePaper(@Param("examination_no")String examination_no);

	void addExamInfoNo(Map<String,Object> map);

	List<ExaPaper> findPaperList(Map<String, Object> map);
	
}