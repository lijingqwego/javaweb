package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import cn.com.demo.po.ExaQuestions;

public interface ExaQuestionsMapper {
	void addQuestionsDetail(Map<String,Object> map);
	
	int getQuestionsCount(ExaQuestions exaQuestions);
	
	List<ExaQuestions> findQuestionsList(Map<String,Object> map);
	
	String getQuestionsNo();
	
	void addQuestions(ExaQuestions exaQuestions);
}