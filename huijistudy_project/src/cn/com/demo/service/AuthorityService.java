package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.AuthorityMapper;
import cn.com.demo.mapper.AuthorityResourceMapper;
import cn.com.demo.mapper.RoleAuthorityMapper;
import cn.com.demo.po.Authority;
import cn.com.demo.utils.PageBeanVO;

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
	public PageBeanVO findAuthorListByPage(int currPage,String authorityid,String authorityname){
		PageBeanVO page = new PageBeanVO();
		page.setCurrPage(currPage);
		page.setPageSize(3);
		page.setAuthorityid(authorityid);
		page.setAuthorityname(authorityname);
		int count = authorityMapper.getAuthorCount(page);
		int totalPage=(int) Math.ceil(count*1.0/3);
		page.setTotalPage(totalPage);
		List<Authority> list = authorityMapper.findAuthorListByPage(page);
		page.setList(list);
		return page;
	}

	public void authorEnable(Authority authority) {
		authorityMapper.authorEnable(authority);
	}
}
