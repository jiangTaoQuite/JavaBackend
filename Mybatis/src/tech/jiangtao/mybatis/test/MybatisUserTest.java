package tech.jiangtao.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import tech.jiangtao.mybatis.pojo.User;

public class MybatisUserTest {
	
	private SqlSessionFactory sessionFactory;

	@Before
	public void init(){
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test(){
		SqlSession session = sessionFactory.openSession();
		User user = session.selectOne("test.findUserById",1);
		System.out.println(user.toString());
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindUserByName(){
		SqlSession sqlSession = sessionFactory.openSession();
		List userList = (List) sqlSession.selectList("test.findUserByName", "张");
		for (int i = 0; i<userList.size(); i++) {
			System.out.println(userList.get(i).toString());
		}
		sqlSession.close();
	}
	
	/**
	 * 插入完成后，如何进行主键返回
	 * mysql: 可以使用LAST_INSERT_ID()来得到
	 * oracle: 可以使用LAST_INSERT_ID()来得到
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void insertUser(){
		SqlSession session = sessionFactory.openSession();
		User user = new User();
		user.setUsername("Kevin");
		user.setSex("男");
		user.setBirthday(new Date(1993, 10, 3));
		user.setAddress("四川省宜宾市");
		session.insert("test.insertUser", user);
		session.commit();
		session.close();
		System.out.println(user.toString());
	}
	
	@Test
	public void deleteUserById(){
		SqlSession session = sessionFactory.openSession();
		session.delete("test.deleteUserById",28);
		session.commit();
		session.close();
	}
	
	@Test
	public void  updateUser() {
		SqlSession session = sessionFactory.openSession();
		User user = new User();
		user.setId(1);
		user.setUsername("我那么个去");
		user.setSex("男");
		user.setBirthday(new Date(0));
		user.setAddress("北京市海淀区");
		session.update("test.updateUser", user);
		session.commit();
		session.close();
	}
}
