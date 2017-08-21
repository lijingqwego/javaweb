package cn.com.demo.mapper;

import java.util.List;

import cn.com.demo.po.Resources;

public interface ResourcesMapper {
	
	void addResource(Resources resource);
	
	void updResource(Resources resource);
	
	void delResource(String resource_id);

	List<Resources> findResourceList();

	String getResourceId();

	Resources findResourceById(String resource_id);

	void resourceEnable(Resources resource);
}
