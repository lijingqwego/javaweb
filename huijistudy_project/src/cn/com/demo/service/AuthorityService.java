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
	 * 获取权限列表
	 * @return
	 */
	public List<Authority> findAuthorityList(){
		return authorityMapper.findAuthorityList();
	}

	/**
	 * 根据id删除权限
	 * @param authorityid
	 */
	public void delAuthorById(String authorityid) {
		authorityMapper.delAuthorById(authorityid);
	}

	/**
	 * 根据id查找权限
	 * @param authorityid
	 * @return
	 */
	public Authority findAuthorById(String authorityid) {
		return authorityMapper.findAuthorById(authorityid);
	}

	/**
	 * 更新权限
	 * @param author
	 */
	public void updAuthor(Authority author) {
		authorityMapper.updAuthor(author);
	}
}
