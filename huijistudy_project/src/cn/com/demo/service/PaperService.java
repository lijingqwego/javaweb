package cn.com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.ExaPaperMapper;
import cn.com.demo.po.ExaPaper;

@Service
public class PaperService {
	
	@Resource
	private ExaPaperMapper exaPaperMapper;

	public List<ExaPaper> findPapaerModeList(Map<String,Object> map) {
		return exaPaperMapper.findPaperModeList(map);
	}

	public void makePaper(String examination_no) {
		exaPaperMapper.makePaper(examination_no);
	}

	public void addExamInfoNo(String examination_no, int num) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("examination_no", examination_no);
		map.put("num", num);
		exaPaperMapper.addExamInfoNo(map);
	}

	public List<ExaPaper> findPapaerList(Map<String, Object> map) {
		return exaPaperMapper.findPaperList(map);
	}
	
}
