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
		//删除角色和权限关联表
		roleAuthorityMapper.delRoleOfAuthorByAuthorityId(authorityid);
		//删除权限和资源关联表
		authorityResourceMapper.delAuthorOfResByAuthorityId(authorityid);
		//删除权限表
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

	/**
	 * 获取一个自增长的权限ID
	 * @return
	 */
	public String getAuthorId() {
		return authorityMapper.getAuthorId();
	}

	/**
	 * 添加权限
	 * @param author
	 */
	public void addAuthor(Authority author) {
		authorityMapper.addAuthor(author);
	}
	
	/**
	 * 分页查询
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
