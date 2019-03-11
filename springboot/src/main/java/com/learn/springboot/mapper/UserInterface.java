package com.learn.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import com.learn.springboot.entity.User;

/**
 * Mybatis使用注解方式
 * @author nuri
 *
 */
@Mapper
public interface UserInterface {
	@Select("select * from user where id=#{id}")
	public User getUserById(@Param("id")Integer id);
	
	// INSERT INTO `user`(`name`, `sex`) VALUES ('nh2', '55');
	@Insert("INSERT INTO user(id,name,sex) VALUES (NULL,#{name},#{sex});")
	public int Insert(@Param("name")String name,@Param("sex")String sex); 
	
	@Update("UPDATE user SET name =#{name} WHERE id = #{id}")
	int update(@Param("name") String name, @Param("id") Integer id);
	
	@Delete("delete from user where id = #{id}")
	public int Delete(@Param("id")Integer id);
}
