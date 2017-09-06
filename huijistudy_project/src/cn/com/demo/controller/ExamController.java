package cn.com.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.demo.dto.ExtendExaPaper;
import cn.com.demo.dto.ExtendExaPaperInfo;
import cn.com.demo.po.ExaPaper;
import cn.com.demo.po.ExamDetail;
import cn.com.demo.po.Student;
import cn.com.demo.service.ExamService;
import cn.com.demo.utils.ExportExcelTwoSheet;

@RequestMapping("/exam")
@Controller
public class ExamController {

	@Resource
	private ExamService examService;
	
	@RequestMapping("/startExam")
	public ModelAndView startExam(String examination_no,String examination_info_no,String examination_user){
		//System.out.println("=====startExam========examination_info_no=============examination_user============="+examination_info_no+"|"+examination_user);
		//获取考试题题目信息
		ExtendExaPaper exaPaper=examService.findExamQuestionList(examination_no);
		int sumScore=0;
		for (ExtendExaPaperInfo epi : exaPaper.getExtendExaPaperInfos()) {
			sumScore+=epi.getQuestion_nscore();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("sumScore", sumScore);
		mv.addObject("exaPaper", exaPaper);
		mv.addObject("examination_info_no",examination_info_no);
		mv.addObject("examination_user",examination_user);
		mv.setViewName("exam.startExam");
		return mv;
	}
	@ResponseBody
	@RequestMapping("/submitPaper")
	public int[] submitPaper(String single,String multi,String judge,String examination_info_no,String examination_user){
		//System.out.println("======================================="+single+"|"+multi+"|"+judge);
		String arrAnswerStr=single+"|"+multi+"|"+judge;
		int[] arr=examService.submitPaper(arrAnswerStr,examination_info_no,examination_user);
		System.out.println(arrAnswerStr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		return arr;
	}
	
	@RequestMapping("/examResult")
	public ModelAndView examResult(@RequestParam(value="pn" ,defaultValue="1")Integer pn,String examination_info_no){
		PageHelper.startPage(pn, 5);
		List<ExamDetail> list=examService.findexamResult(examination_info_no);
		PageInfo<ExamDetail> pageInfo = new PageInfo<ExamDetail>(list,5);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("examination_info_no", examination_info_no);
		mv.setViewName("exam.examResult");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/expModel")
	public String expModel(String examination_info_no){
		List<ExamDetail> list=examService.findexamResult(examination_info_no);
        ExportExcelTwoSheet<ExamDetail> ex = new ExportExcelTwoSheet<ExamDetail>(); 
        String[] headers = { "编号", "题目类型", "选择答案", "正确答案"};  
        String fileName = "E://"+examination_info_no+".xls";  
        try {  
            ex.exportExcel("考试结果"+examination_info_no, headers, list, fileName, "new");  
            JOptionPane.showMessageDialog(null, "导出成功!");  
            System.out.println("excel导出成功！");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		return fileName;
	}
	
	
}
