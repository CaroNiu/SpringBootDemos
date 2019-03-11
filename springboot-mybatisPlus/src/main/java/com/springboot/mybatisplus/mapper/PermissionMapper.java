package com.springboot.mybatisplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springboot.mybatisplus.entity.Permission;

@Mapper
public interface PermissionMapper {
	
	@Select("select * from permission where rid = #{rid}")
	public List<Permission> selectByRid(int rid);
}
