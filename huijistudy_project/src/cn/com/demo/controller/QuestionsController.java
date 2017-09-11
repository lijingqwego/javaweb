package cn.com.demo.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.demo.po.ExaPaperAnswer;
import cn.com.demo.po.ExaQuestion;
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
	
	private static final Logger logger = Logger.getLogger(PaperController.class);

	
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
		if(questionsNo==null){
			questionsNo="1"; 
		}
		List<SubjectInfo> list = subjectService.findSubjectListAll();
		ModelAndView mv=new ModelAndView();
		mv.addObject("questions_no", questionsNo);
		mv.addObject("subjectList", list);
		mv.setViewName("exam.addQuestions");
		return mv;
	}
	
	/*@RequestMapping("/commQuestions")
	public String commQuestions(Long subject_no,String questions_no,String questions_name,String questions_desc ){
		ExaQuestions exaQuestions = new ExaQuestions();
		exaQuestions.setQuestions_no(questions_no);
		exaQuestions.setQuestions_name(questions_name);
		exaQuestions.setSubject_no(subject_no);
		exaQuestions.setQuestions_desc(questions_desc);
		System.out.println(exaQuestions);
		questionsService.addQuestions(exaQuestions);
		return "redirect:/exam/questionsList.action";
	}*/
	
	@RequestMapping("/uploadQuestions")
	public String uploadQuestions(@RequestBody MultipartFile uploadfile,HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		String questions_no = request.getParameter("questions_no");
		String questions_name = request.getParameter("questions_name");
		String subject_no = request.getParameter("subject_no");
		String questions_desc = request.getParameter("questions_desc");
		map.put("questions_no", questions_no);
		map.put("questions_name", questions_name);
		map.put("subject_no", Long.parseLong(subject_no));
		map.put("questions_desc", questions_desc);
		if(uploadfile.getSize()>0){
			String filename = uploadfile.getOriginalFilename();
			if(filename.endsWith(".xls")||filename.endsWith(".xlsx")){
				String path = request.getServletContext().getRealPath("/");
				logger.info(filename+"+++++++++++++"+path);
				File file = new File(path,filename);
				try {
				//上传文件
				FileUtils.copyInputStreamToFile(uploadfile.getInputStream(), file);
				//上传题库
				questionsService.uploadQuestions(map, file.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/exam/questionsList.action";
		
	}
	
	@RequestMapping("/questionList")
	public ModelAndView findQuestions(@RequestParam(value="pn" ,defaultValue="1")Integer pn,String questions_no,String question_name,Long question_type){
		//System.out.println("=============question_name============="+question_name);
		if(question_name==null){
			question_name="";
		}
		try {
			question_name=new String(question_name.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PageHelper.startPage(pn, 5);
		List<ExaQuestion> list = questionsService.findQuestionListByNo(questions_no,question_name,question_type);
		PageInfo<ExaQuestion> pageInfo = new PageInfo<ExaQuestion>(list,5);
		ModelAndView mv=new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("questions_no", questions_no);
		mv.addObject("question_name", question_name);
		mv.addObject("question_type", question_type);
		mv.setViewName("exam.questionList");
		return mv;
	}
	
	/**
	 * 查看答案选项
	 * @param question_no
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/answerList")
	public List<ExaPaperAnswer> answerList(String question_no){
		System.out.println("=========================question_no================"+question_no);
		List<ExaPaperAnswer> list=questionsService.findAnswerListByNo(question_no);
		return list;
	}
		
}
