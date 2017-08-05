package cn.com.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.demo.mapper.AuthorityMapper;
import cn.com.demo.po.Authority;

@Service
public class AuthorityService {
	@Resource
	AuthorityMapper authorityMapper;
	
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
}
