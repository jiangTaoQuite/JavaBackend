package tech.jiangtao.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import tech.jiangtao.mybatis.mapper.UserMapper;
import tech.jiangtao.mybatis.pojo.User;
import tech.jiangtao.mybatis.pojo.UserCustom;
import tech.jiangtao.mybatis.pojo.UserQuery;

public class UserMapperTest {
	
	private SqlSessionFactory sessionFactory;

	@Before
	public void init(){
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			System.out.println(mapper.findUserById(1).toString());
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindUserByName() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<User> list = mapper.findUserByName("张三");
			for(int i = 0;i<list.size();i++){
				System.out.println(list.get(i).toString());
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testInsertUser() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("梁上播");
		try {
			mapper.insertUser(user);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindUserByCustom() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserQuery query = new UserQuery();
		UserCustom custom = new UserCustom();
		custom.setUsername("梁上播");
		query.setUserCustom(custom);
		try {
			mapper.findUserByCustom(query);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindUserCount() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserQuery query = new UserQuery();
		UserCustom custom = new UserCustom();
		custom.setUsername("梁上播");
		query.setUserCustom(custom);
		try {
			System.out.println(mapper.findUserCount(query));
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindUserListByResultMap() {
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<User> list = mapper.findUserListByResultMap("张三");
			for(int i = 0;i<list.size();i++){
				System.out.println(list.get(i).toString());
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
