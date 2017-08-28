package cn.com.demo.mapper;

import java.util.List;
import java.util.Map;

import cn.com.demo.po.SubjectInfo;

public interface SubjectInfoMapper {
    
	void addSubjectInfo(List<SubjectInfo> list);

	List<SubjectInfo> findSubjectList(Map<String,Object> map);
	
	List<SubjectInfo> findSubjectListAll();
	
	Long getSubjectNo();
	
	int getSubjectCount(SubjectInfo subject);
	
	void addSubject(SubjectInfo subject);
}