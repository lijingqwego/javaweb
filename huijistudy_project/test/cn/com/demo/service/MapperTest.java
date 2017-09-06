package cn.com.demo.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.demo.mapper.ExaQuestionsMapper;
import cn.com.demo.mapper.ExaminationInfoMapper;
import cn.com.demo.mapper.SubjectInfoMapper;
import cn.com.demo.po.SubjectInfo;
import cn.com.demo.utils.PoiXSSFUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-dao.xml","classpath:spring/application-service.xml"})
public class MapperTest {
	
	@Autowired
	SubjectInfoMapper subjectInfoMapper;
	@Autowired
	ExaQuestionsMapper exaQuestionsMapper;
	
	@Autowired
	ExaminationInfoMapper examinationInfoMapper;
	
	

	@Test
	public void testAddSubjectInfo(){
		try {
			List<SubjectInfo> list = PoiXSSFUtils.readXls();
			System.out.println("=================================>"+list.get(0).getSubject_name());
			subjectInfoMapper.addSubjectInfo(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testQuestionsList(){
	}
	
	@Test
	public void testAddQuestionInfo(){
		try {
			String subList = PoiXSSFUtils.readXls2("C:/Users/Administrator/Desktop/题目信息.xlsx");
			Map<String,Object> map=new HashMap<>();
			map.put("subject_list",subList);
			map.put("questions_no", "1");
			map.put("state", 1L); 
			exaQuestionsMapper.addQuestionsDetail(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSubjectInfoList(){
		
	}
	
	@Test
	public void testAddSubjectInfo2(){
		SubjectInfo subject = new SubjectInfo();
		
		subject.setSubject_no(100605L);
		subject.setSubject_code("oracle11g");
		subject.setSubject_name("oracle数据库");
		subject.setClass_content("数据库练习");
		subject.setCalss_target("学习数据库");
		subject.setClass_hour(90);
		subject.setFather_subject(1001L);
		subject.setCreate_time(new Date());
		subject.setUpdate_time(new Date());
		
		subjectInfoMapper.addSubject(subject);
	}
	
	
	@Test
	public void testfindExamQuestionList(){
		/*ExaPaper list = examinationInfoMapper.findExamQuestionList("20170831000001");
		int sum=0;
		for (ExaPaperInfo epi : list.getExaPaperInfos()) {
			sum+=epi.getQuestion_nscore();
		}
		System.out.println(sum);*/
	
	}
	
}
