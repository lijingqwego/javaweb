package cn.com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.demo.po.ExaPaper;
import cn.com.demo.po.ExaminationInfo;
import cn.com.demo.service.ExamService;
import cn.com.demo.service.PaperService;

@RequestMapping("/exam")
@Controller
public class PaperController {

	@Resource
	private PaperService paperService;
	
	@Resource
	private ExamService examService;
	
	
	/**
	 * 试卷模板列表
	 * @param pn
	 * @param examination_no
	 * @param examination_name
	 * @return
	 */
	@RequestMapping("/papermodeList")
	public ModelAndView paperModeList(@RequestParam(value="pn" ,defaultValue="1")Integer pn,String examination_no,String examination_name ){
		PageHelper.startPage(pn, 3);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("examination_no", examination_no);
		map.put("examination_name", examination_name);
		List<ExaPaper> list=paperService.findPapaerModeList(map);
		PageInfo<ExaPaper> pageInfo = new PageInfo<ExaPaper>(list,3);
		ModelAndView mv = new ModelAndView();
		mv.addObject("examination_no", examination_no);
		mv.addObject("examination_name", examination_name);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("exam.paperModeList");
		return mv;
	}
	
	/**
	 * 生成试卷
	 * @param examination_no
	 * @return
	 */
	@RequestMapping("/makePaper")
	public String makePaper(String examination_no){
		paperService.makePaper(examination_no);
		return "redirect:/exam/paperList.action";
	}
	
	/**
	 * 试卷列表
	 * @param pn
	 * @param examination_no
	 * @param examination_name
	 * @return
	 */
	@RequestMapping("/paperList")
	public ModelAndView paperList(@RequestParam(value="pn" ,defaultValue="1")Integer pn,String examination_no,String examination_name ){
		PageHelper.startPage(pn, 3);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("examination_no", examination_no);
		map.put("examination_name", examination_name);
		List<ExaPaper> list=paperService.findPapaerList(map);
		PageInfo<ExaPaper> pageInfo = new PageInfo<ExaPaper>(list,3);
		ModelAndView mv = new ModelAndView();
		mv.addObject("examination_no", examination_no);
		mv.addObject("examination_name", examination_name);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("exam.paperList");
		return mv;
	}
	
	/**
	 * 添加考试编号数量
	 * @param examination_no
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addExamInfoNo")
	public String addExamInfoNo(String examination_no,int num){
		System.out.println("++++++++++++examination_no="+examination_no+"++++++++num="+num);
		int count=paperService.addExamInfoNo(examination_no,num);
		return ""+count;
	}
	
	/**
	 * 获取所有的考试编号（未使用过的）
	 * @param examination_no
	 * @return
	 */
	@RequestMapping("/findExamInfoNoList")
	public ModelAndView findExamInfoNoList(String examination_no){
		List<ExaminationInfo> list = examService.findExamInfoNoList(examination_no);
		ModelAndView mv = new ModelAndView();
		mv.addObject("examInfoNoList", list);
		mv.addObject("examination_no", examination_no);
		mv.setViewName("exam.addExamInfo");
		return mv;
	}
	
	/**
	 * 修改考试信息
	 * @param examination_user
	 * @param examination_info_no
	 * @param examination_no
	 * @return
	 */
	@RequestMapping("/commExamInfo")
	public String commExamInfo(String examination_user,String examination_info_no,String examination_no){
		System.out.println("=====commExamInfo========examination_info_no=============examination_user============="+examination_info_no+"|"+examination_user);
		examService.updateExamInfo(examination_user,examination_info_no);
		return "redirect:/exam/startExam.action?examination_no="+examination_no+"&examination_info_no="+examination_info_no+"&examination_user="+examination_user;
	}
	
}
