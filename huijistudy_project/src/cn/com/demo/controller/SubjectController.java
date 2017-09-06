package cn.com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.SubjectInfo;
import cn.com.demo.service.SubjectService;
import cn.com.demo.utils.PageBean;

@RequestMapping("/exam")
@Controller
public class SubjectController {

	@Resource
	SubjectService subjectService;
	@RequestMapping("/subjectList")
	public ModelAndView subjectList(@RequestParam(value="currPage",defaultValue="1")int currPage,Long subject_no,String subject_name){
		SubjectInfo subject =new SubjectInfo();
		subject.setSubject_no(subject_no);
		subject.setSubject_name(subject_name);
		PageBean vo = subjectService.findSubjectInfoList(currPage, 3, subject);
		ModelAndView mv=new ModelAndView();
		mv.addObject("subjectList", vo.getList());
		mv.addObject("currPage", currPage);
		mv.addObject("subject_no", subject_no);
		mv.addObject("subject_name", subject_name);
		mv.addObject("totalPage", vo.getTotalPage());
		mv.setViewName("exam.subjectList");
		return mv;
	}
	
	@RequestMapping("/addSubject")
	public ModelAndView addSubject(){
		Long subjectNo = subjectService.getSubjectNo();
		List<SubjectInfo> list = subjectService.findSubjectListAll();
		ModelAndView mv=new ModelAndView();
		mv.addObject("subjectList", list);
		mv.addObject("subject_no", subjectNo);
		mv.setViewName("exam.addSubject");
		return mv;
	}
	
	@RequestMapping("/commAddSubject")
	public String commAddSubject(SubjectInfo subject){
		subjectService.addSubjectInfo(subject);
		return "redirect:/exam/subjectList.action";
	}
	
	@RequestMapping("/makePaperModel")
	public ModelAndView makePaperModel(Long subject_no){
		ModelAndView mv=new ModelAndView();
		mv.addObject("subject_no", subject_no);
		mv.setViewName("exam.makePaperModel");
		return mv;
	}
				      
	@RequestMapping("/commMakePaperModel")
	public String makePaperModel
	(
			Long subject_no,
			String examination_name,
			String examination_content,
			Long exam_length,
			Long question_score1,
			Long question_score2,
			Long question_score3,
			Long question_num1,
			Long question_num2,
			Long question_num3
	){
		String score_list="1|"+question_num1+"|"+question_score1+"#"
				+"2|"+question_num2+"|"+question_score2+"#"
				+"3|"+question_num3+"|"+question_score3+"#";
		System.out.println("score_list===========>"+score_list);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("subject_no", subject_no);
		map.put("exam_name", examination_name);
		map.put("exam_content", examination_content);
		map.put("exam_length", exam_length);
		map.put("create_user", "teacher");
		map.put("score_list", score_list);
		subjectService.addPaperModel(map);
		
		return "redirect:/exam/papermodeList.action";
	}
	
}
