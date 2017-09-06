package cn.com.demo.dto;

import java.util.List;

import cn.com.demo.po.ExaPaper;

/**
 * ExaPaperµÄÀ©Õ¹Àà
 * @author Administrator
 *
 */
public class ExtendExaPaper extends ExaPaper{
	
	private List<ExtendExaPaperInfo> extendExaPaperInfos;


	public List<ExtendExaPaperInfo> getExtendExaPaperInfos() {
		return this.extendExaPaperInfos;
	}

	public void setExtendExaPaperInfos(List<ExtendExaPaperInfo> extendExaPaperInfos) {
		this.extendExaPaperInfos = extendExaPaperInfos;
	}
	
}
