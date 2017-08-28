package cn.com.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.demo.po.ExaQuestions;
import cn.com.demo.po.SubjectInfo;
import cn.com.demo.service.QuestionsService;
import cn.com.demo.service.SubjectService;
import cn.com.demo.utils.PageBean;

@RequestMapping("/exam")
@Controller
public class QuestionsController {

	@Resource
	private QuestionsService questionsService;
	
	@Resource
	private SubjectService subjectService;
	
	@RequestMapping("/questionsList")
	public ModelAndView questionsList(@RequestParam(value="currPage",defaultValue="1")int currPage,String questions_no,String questions_name){
		ExaQuestions exaQuestions = new ExaQuestions();
		exaQuestions.setQuestions_no(questions_no);
		exaQuestions.setQuestions_name(questions_name);
		PageBean vo = questionsService.findSubjectList(currPage, 3,exaQuestions);
		ModelAndView mv=new ModelAndView();
		mv.addObject("questionsList", vo.getList());
		mv.addObject("currPage", currPage);
		mv.addObject("questions_no", questions_no);
		mv.addObject("questions_name", questions_name);
		mv.addObject("totalPage", vo.getTotalPage());
		mv.setViewName("exam.questionsList");
		return mv;
	}
	
	@RequestMapping("/addQuestions")
	public ModelAndView addQuestions(){
		String questionsNo= questionsService.getQuestionsNo();
		List<SubjectInfo> list = subjectService.findSubjectListAll();
		ModelAndView mv=new ModelAndView();
		mv.addObject("questions_no", questionsNo);
		mv.addObject("subjectList", list);
		mv.setViewName("exam.addQuestions");
		return mv;
	}
	
	@RequestMapping("/commQuestions")
	public String commQuestions(ExaQuestions exaQuestions){
		questionsService.addQuestions(exaQuestions);
		return "redirect:/exam/questionsList.action";
	}
}