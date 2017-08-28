package cn.com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.SubjectInfoMapper;
import cn.com.demo.po.SubjectInfo;
import cn.com.demo.utils.PageBean;

@Service
public class SubjectService {

	@Resource
	SubjectInfoMapper subjectInfoMapper;
	
	/**
	 * 分页查询
	 * @param currPage
	 * @param pageSize
	 * @param subject
	 * @return
	 */
	public PageBean findSubjectInfoList(int currPage,int pageSize,SubjectInfo subject){
		int count=subjectInfoMapper.getSubjectCount(subject);
		PageBean pageBean = new PageBean(currPage,pageSize,count);
		Map<String,Object> map=new HashMap<>();
		map.put("currPage", currPage);
		map.put("pageSize", pageSize);
		map.put("subject", subject);
		List<SubjectInfo> list = subjectInfoMapper.findSubjectList(map);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 添加科目信息
	 * @param subject
	 */
	public void addSubjectInfo(SubjectInfo subject){
		subjectInfoMapper.addSubject(subject);
	}
	
	/**
	 * 查询所有的科目
	 * @return
	 */
	public List<SubjectInfo> findSubjectListAll(){
		return subjectInfoMapper.findSubjectListAll();
	}
	
	/**
	 * 获取一个新的科目编号
	 * @return
	 */
	public Long getSubjectNo(){
		return subjectInfoMapper.getSubjectNo();
	}
}
