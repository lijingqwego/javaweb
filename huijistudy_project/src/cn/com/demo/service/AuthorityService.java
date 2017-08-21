package cn.com.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.AuthorityMapper;
import cn.com.demo.mapper.AuthorityResourceMapper;
import cn.com.demo.mapper.RoleAuthorityMapper;
import cn.com.demo.po.Authority;
import cn.com.demo.utils.PageBean;

@Service
public class AuthorityService {
	@Resource
	AuthorityMapper authorityMapper;
	@Resource
	RoleAuthorityMapper roleAuthorityMapper;
	@Resource
	AuthorityResourceMapper authorityResourceMapper;
	
	/**
	 * ��ȡȨ���б�
	 * @return
	 */
	public List<Authority> findAuthorityList(){
		return authorityMapper.findAuthorityList();
	}

	/**
	 * ����idɾ��Ȩ��
	 * @param authorityid
	 */
	public void delAuthorById(String authorityid) {
		//ɾ����ɫ��Ȩ�޹�����
		roleAuthorityMapper.delRoleOfAuthorByAuthorityId(authorityid);
		//ɾ��Ȩ�޺���Դ������
		authorityResourceMapper.delAuthorOfResByAuthorityId(authorityid);
		//ɾ��Ȩ�ޱ�
		authorityMapper.delAuthorById(authorityid);
	}

	/**
	 * ����id����Ȩ��
	 * @param authorityid
	 * @return
	 */
	public Authority findAuthorById(String authorityid) {
		return authorityMapper.findAuthorById(authorityid);
	}

	/**
	 * ����Ȩ��
	 * @param author
	 */
	public void updAuthor(Authority author) {
		authorityMapper.updAuthor(author);
	}

	/**
	 * ��ȡһ����������Ȩ��ID
	 * @return
	 */
	public String getAuthorId() {
		return authorityMapper.getAuthorId();
	}

	/**
	 * ���Ȩ��
	 * @param author
	 */
	public void addAuthor(Authority author) {
		authorityMapper.addAuthor(author);
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param currPage
	 * @param authorityid
	 * @param authorityname
	 * @return
	 */
	public PageBean findAuthorListByPage(int currPage,int pageSize,Authority authority){
		int count=authorityMapper.getAuthorCount(authority);
		PageBean pageBean = new PageBean(currPage,pageSize,count);
		Map<String,Object> map=new HashMap<>();
		map.put("currPage", currPage);
		map.put("pageSize", pageSize);
		map.put("authority", authority);
		List<Authority> list = authorityMapper.findAuthorListByPage(map);
		pageBean.setList(list);
		return pageBean;
	}

	public void authorEnable(Authority authority) {
		authorityMapper.authorEnable(authority);
	}
}
