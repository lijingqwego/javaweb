package cn.com.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.ExaQuestionsMapper;
import cn.com.demo.po.ExaPaperAnswer;
import cn.com.demo.po.ExaQuestion;
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
	 * ��ȡһ���µ������
	 * @return
	 */
	public String getQuestionsNo(){
		return exaQuestionsMapper.getQuestionsNo();
	}
	
	/**
	 * ������
	 * @param exaQuestions
	 */
	public void addQuestions(ExaQuestions exaQuestions){
		exaQuestionsMapper.addQuestions(exaQuestions);
	}
	/**
	 * ������Ŀ��ϸ
	 * @param questions_no
	 * @param questionsfile
	 */
	public int uploadQuestions(Map<String,Object> map, String questionsfile) {
		try {
			String subList = PoiXSSFUtils.readXls2(questionsfile);
			if(subList==null){
				return -1;//��ȡExcel�ļ�ʧ��
			}
			map.put("question_list",subList);
			exaQuestionsMapper.addQuestionsDetail(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	/**
	 * �鿴��Ŀ��Ϣ
	 * @param question_type 
	 * @param question_name 
	 * @return
	 */
	public List<ExaQuestion> findQuestionListByNo(String questions_no, String question_name, Long question_type){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("questions_no", questions_no);
		map.put("question_name", question_name);
		map.put("question_type", question_type);
		return exaQuestionsMapper.findQuestionListByNo(map);
	}

	public List<ExaPaperAnswer> findAnswerListByNo(String question_no) {
		return exaQuestionsMapper.findAnswerListByNo(question_no);
	}
}
