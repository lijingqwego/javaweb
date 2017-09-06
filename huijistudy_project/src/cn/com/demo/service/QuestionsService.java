package cn.com.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.ExaQuestionsMapper;
import cn.com.demo.po.ExaQuestions;
import cn.com.demo.utils.PageBean;
import cn.com.demo.utils.PoiXSSFUtils;

@Service
public class QuestionsService {

	@Resource
	ExaQuestionsMapper exaQuestionsMapper;
		
	public PageBean findSubjectList(int currPage,int pageSize,ExaQuestions exaQuestions){
		int count=exaQuestionsMapper.getQuestionsCount(exaQuestions);
		PageBean pageBean = new PageBean(currPage,pageSize,count);
		Map<String,Object> map=new HashMap<>();
		map.put("currPage", currPage);
		map.put("pageSize", pageSize);
		map.put("exaQuestions", exaQuestions);
		List<ExaQuestions> list = exaQuestionsMapper.findQuestionsList(map);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 获取一个新的题库编号
	 * @return
	 */
	public String getQuestionsNo(){
		return exaQuestionsMapper.getQuestionsNo();
	}
	
	/**
	 * 添加题库
	 * @param exaQuestions
	 */
	public void addQuestions(ExaQuestions exaQuestions){
		exaQuestionsMapper.addQuestions(exaQuestions);
	}

	/**
	 * 导入题目明细
	 * @param questions_no
	 * @param questionsfile
	 */
	public void uploadQuestions(String questions_no, String questionsfile) {
		try {
			String subList = PoiXSSFUtils.readXls2(questionsfile);
			Map<String,Object> map=new HashMap<>();
			map.put("question_list",subList);
			map.put("questions_no", questions_no);
			map.put("state", 1L); 
			exaQuestionsMapper.addQuestionsDetail(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
