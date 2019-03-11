package com.learn.springboot.mapper.test2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.learn.springboot.entity.User;
@Mapper
public interface User2Mapper {
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Select("select * from user2 where id=#{id}")
	public User getUserById(@Param("id")Integer id);
	
	/**
	 * 插入语句
	 * @param name
	 * @param sex
	 * @return
	 */
	@Insert("insert into user2(id,name,sex) values(NULL,#{name},#{sex});")
	public int insert(@Param("name")String name,@Param("sex")String sex);
}
