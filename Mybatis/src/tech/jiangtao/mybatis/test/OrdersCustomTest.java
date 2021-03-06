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

import tech.jiangtao.mybatis.mapper.OrderMapperCustom;
import tech.jiangtao.mybatis.pojo.Orders;
import tech.jiangtao.mybatis.pojo.OrdersCustom;
import tech.jiangtao.mybatis.pojo.User;

public class OrdersCustomTest {

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
	public void testFindOrdersUserList() {
		SqlSession session = sessionFactory.openSession();
		OrderMapperCustom orderMapperCustom = session.getMapper(OrderMapperCustom.class);
		try {
			List<OrdersCustom> list = orderMapperCustom.findOrdersUserList();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 使用ResultMap进行1-1查询
	 */
	@Test
	public void testFindOrdersUserListResultMap() {
		SqlSession session = sessionFactory.openSession();
		OrderMapperCustom orderMapperCustom = session.getMapper(OrderMapperCustom.class);
		try {
			List<Orders> list = orderMapperCustom.findOrdersUserListResultMap();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 使用ResultMap进行一对多查询
	 */
	@Test
	public void testFindOrderAndOrdersDetailListResultMap() {
		SqlSession session = sessionFactory.openSession();
		OrderMapperCustom orderMapperCustom = session.getMapper(OrderMapperCustom.class);
		try {
			List<Orders> list = orderMapperCustom.findOrderAndOrdersDetailListResultMap();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFindUserOrderAndOrdersDetailAndItemsListResultMap() {
		SqlSession session = sessionFactory.openSession();
		OrderMapperCustom orderMapperCustom = session.getMapper(OrderMapperCustom.class);
		try {
			List<User> list = orderMapperCustom.findUserOrderAndOrdersDetailAndItemsListResultMap();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 延迟加载
	 */
	@Test
	public void testFindOrdersUserListLazyLoading() {
		SqlSession session = sessionFactory.openSession();
		OrderMapperCustom orderMapperCustom = session.getMapper(OrderMapperCustom.class);
		try {
			List<Orders> list = orderMapperCustom.findOrdersUserListLazyLoading();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
				User user = list.get(i).getUser();
				System.out.println(user.toString());
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
