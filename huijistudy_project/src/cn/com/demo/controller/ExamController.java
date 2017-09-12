package cn.com.demo.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.demo.dto.ExtendExaPaper;
import cn.com.demo.dto.ExtendExaPaperInfo;
import cn.com.demo.po.ExamDetail;
import cn.com.demo.po.ExaminationInfo;
import cn.com.demo.service.ExamService;
import cn.com.demo.utils.ExportExcelTwoSheet;

@RequestMapping("/exam")
@Controller
public class ExamController {
	private static final Logger logger = Logger.getLogger(ExamController.class);

	@Resource
	private ExamService examService;
	
	/**
	 * ��ʼ����
	 * @param examination_no
	 * @param examination_info_no
	 * @param examination_user
	 * @return
	 */
	@RequestMapping("/startExam")
	public ModelAndView startExam(String examination_no,String examination_info_no,String examination_user){
		System.out.println("=====startExam========examination_info_no=============examination_user============="+examination_info_no+"|"+examination_user);
		//��ȡ��������Ŀ��Ϣ
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
	
	/**
	 * �ύ�Ծ�
	 * @param single
	 * @param multi
	 * @param judge
	 * @param examination_info_no
	 * @param examination_user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/submitPaper")
	public int[] submitPaper(String single,String multi,String judge,String examination_info_no,String examination_user){
		System.out.println("======================================="+single+"|"+multi+"|"+judge);
		String arrAnswerStr=single+"|"+multi+"|"+judge;
		int[] arr=examService.submitPaper(arrAnswerStr,examination_info_no,examination_user);
		System.out.println(arrAnswerStr);
		logger.info(arr[0]);
		logger.info(arr[1]);
		logger.info(arr[2]);
		return arr;
	}
	
	/**
	 * ���Խ��
	 * @param pn
	 * @param examination_info_no
	 * @return
	 */
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
	
	/**
	 * ����Excel
	 * @param examination_info_no
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/expModel")
	public String expModel(String examination_info_no){
		List<ExamDetail> list=examService.findexamResult(examination_info_no);
        ExportExcelTwoSheet<ExamDetail> ex = new ExportExcelTwoSheet<ExamDetail>(); 
        String[] headers = { "���", "��Ŀ����", "ѡ���", "��ȷ��","�Ƿ���"};  
        FileSystemView fsv = FileSystemView.getFileSystemView();
		File desktop=fsv.getHomeDirectory();    //����Ƕ�ȡ����·���ķ�����
//		System.out.println("========desktop.getAbsolutePath()========="+desktop.getAbsolutePath());
        String fileName = desktop.getAbsolutePath()+"\\"+examination_info_no+".xls";  
//        System.out.println("=================fileName==========="+fileName);
        try {  
            ex.exportExcel("���Խ��"+examination_info_no, headers, list, fileName, "new");  
//            JOptionPane.showMessageDialog(null, "�����ɹ�!");  
//            System.out.println("excel�����ɹ���");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		return fileName;
	}
	
	/**
	 * �鿴����ѧ�����Գɼ�
	 * @param pn
	 * @param examination_info_no
	 * @param examination_user
	 * @return
	 */
	@RequestMapping("/scoreList")
	public ModelAndView scoreList(@RequestParam(value="pn" ,defaultValue="1")Integer pn,String examination_info_no,String examination_user){
		PageHelper.startPage(pn, 3);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("examination_info_no", examination_info_no);
		map.put("examination_user", examination_user);
		List<ExaminationInfo> list=examService.findScoreListAll(map);
		PageInfo<ExaminationInfo> pageInfo = new PageInfo<ExaminationInfo>(list,3);
		ModelAndView mv = new ModelAndView();
		mv.addObject("examination_info_no", examination_info_no);
		mv.addObject("examination_user", examination_user);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("exam.scoreList");
		return mv;
	}
	
}
