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
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("v_exam_user", "abc");
		map.put("v_exam_info_no","20170906000001");
		map.put("answer_list", "20170905000008,2$,20170905000009,2$,|,,@20170905000021@,1,4,,@20170905000019@,1,2|20170905000032,2$,20170905000040,1$,20170905000031,2$,");
		map.put("right_num", 0);
		map.put("error_num", 0);
		map.put("total_score", 0);
		examinationInfoMapper.submitPaperMap(map);
		int[] arr=new int[3];
		arr[0]=(int) map.get("right_num");
		arr[1]=(int) map.get("error_num");
		arr[2]=(int) map.get("total_score");
		System.out.println(arr[0]+"|"+arr[1]+"|"+arr[2]);
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
