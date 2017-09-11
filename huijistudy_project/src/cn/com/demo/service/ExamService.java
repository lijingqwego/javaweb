package cn.com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.dto.ExtendExaPaper;
import cn.com.demo.mapper.ExaminationInfoMapper;
import cn.com.demo.po.ExamDetail;
import cn.com.demo.po.ExaminationInfo;

@Service
public class ExamService {

	@Resource
	ExaminationInfoMapper examinationInfoMapper;

	public ExtendExaPaper findExamQuestionList(String exam_no) {
		return examinationInfoMapper.findExamQuestionList(exam_no);
	}

	
	/**
	 * 交卷
	 * @param arrAnswerStr
	 * @param exam_info_no
	 * @param create_user
	 * @return
	 */
	public int[] submitPaper(String arrAnswerStr, String exam_info_no,String create_user) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("v_exam_user", create_user);
		map.put("v_exam_info_no",exam_info_no);
		map.put("answer_list", arrAnswerStr);
		map.put("right_num", 0);
		map.put("error_num", 0);
		map.put("total_score", 0);
		examinationInfoMapper.submitPaperMap(map);
		int[] arr=new int[3];
		arr[0]=(int) map.get("right_num");
		arr[1]=(int) map.get("error_num");
		arr[2]=(int) map.get("total_score");
		return arr;
	}
	
	/**
	 * 获取考生号
	 * @param exam_no
	 * @return
	 */
	public List<ExaminationInfo> findExamInfoNoList(String exam_no){
		return examinationInfoMapper.findExamInfoNoList(exam_no);
	}

	/**
	 * 修改考试信息（）
	 * @param examination_user
	 * @param examination_info_no
	 */
	public void updateExamInfo(String examination_user, String examination_info_no) {
		ExaminationInfo info=new ExaminationInfo();
		info.setExamination_user(examination_user);
		info.setExamination_info_no(examination_info_no);
		examinationInfoMapper.updateExamInfo(info);
	}


	public List<ExamDetail> findexamResult(String examination_info_no) {
		
		return examinationInfoMapper.findexamResult(examination_info_no);
	}


	/**
	 * 查看所有学生考试成绩
	 * @param map
	 * @return
	 */
	public List<ExaminationInfo> findScoreListAll(Map<String, Object> map) {
		return examinationInfoMapper.findScoreListAll(map);
	}
	
}
