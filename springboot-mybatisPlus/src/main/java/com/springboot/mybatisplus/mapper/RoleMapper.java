package com.springboot.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springboot.mybatisplus.entity.Role;
@Mapper
public interface RoleMapper {
	/**
	 * 查询当前用户的角色
	 * @param rid
	 * @return
	 */
	@Select("select * from role where rid = #{rid}")
	public Role seletRoleByRid(@Param("rid")int rid);
}
