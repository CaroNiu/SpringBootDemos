package com.springboot.mybatisplus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@Select("select * from user where uid=#{uid}")
	public User getUserById(@Param("uid")Integer uid);
	
	/**
	 * 插入语句
	 * @param name
	 * @param sex
	 * @return
	 */
	@Insert("insert into user2(id,name,sex) values(NULL,#{name},#{sex});")
	public int insert(@Param("name")String name,@Param("sex")String sex);
	
	/**
	 * 更新
	 * @param username
	 * @return
	 */
	@Update("update user u set u.username=#{username} where u.uid = #{uid};")
	public int updateUser(@Param("username")String username,@Param("uid")int uid);
	
	@Select("select * from user u where u.username = #{username};")
	public User selectLoginUser(@Param("username")String username);
	
	
	
}
