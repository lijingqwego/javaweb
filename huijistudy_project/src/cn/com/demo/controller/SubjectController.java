package cn.com.demo.controller;

import java.util.List;

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
}
