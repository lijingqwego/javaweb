package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import cn.com.demo.po.ExaPaperAnswer;
import cn.com.demo.po.ExaQuestion;
import cn.com.demo.po.ExaQuestions;

public interface ExaQuestionsMapper {
	void addQuestionsDetail(Map<String,Object> map);
	
	int getQuestionsCount(ExaQuestions exaQuestions);
	
	List<ExaQuestions> findQuestionsList(Map<String,Object> map);
	
	String getQuestionsNo();
	
	void addQuestions(ExaQuestions exaQuestions);
	
	List<ExaQuestion> findQuestionListByNo(Map<String,Object> map);

	List<ExaPaperAnswer> findAnswerListByNo(String question_no);
}