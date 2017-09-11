package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import cn.com.demo.dto.ExtendExaPaper;
import cn.com.demo.po.ExamDetail;
import cn.com.demo.po.ExaminationInfo;

public interface ExaminationInfoMapper {

	ExtendExaPaper findExamQuestionList(String exam_no);

	void submitPaperMap(Map<String, Object> map);
	
	List<ExaminationInfo> findExamInfoNoList(String exam_no);

	void updateExamInfo(ExaminationInfo info);

	List<ExamDetail> findexamResult(String examination_info_no);

	List<ExaminationInfo> findScoreListAll(Map<String, Object> map);
    
}