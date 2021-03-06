package tech.jiangtao.mybatis.mapper;

import java.util.List;

import tech.jiangtao.mybatis.pojo.User;
import tech.jiangtao.mybatis.pojo.UserQuery;

public interface UserMapper {

	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUserById(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public List<User> findUserByCustom(UserQuery userQuery) throws Exception;
	
	public int findUserCount(UserQuery userQuery) throws Exception;
	
	public List<User> findUserListByResultMap(String name) throws Exception;
}
