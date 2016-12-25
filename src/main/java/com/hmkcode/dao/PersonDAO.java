package com.hmkcode.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hmkcode.vo.Person;

public class PersonDAO {
	private SqlSessionFactory sqlSessionFactory = null;

	public PersonDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Person> selectAll() {
		List<Person> list = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("Person.selectAll");
		} finally {
			sqlSession.close();
		}
		System.out.println("selectAll->" + list);
		return list;
	}

	public void update(Person person) {
		int id = -1;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			id = sqlSession.update("Person.update", person);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		System.out.println("update(" + person + ") --> updated");
	}

	public int insert(Person person) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			id = session.insert("Person.insert", person);
		} finally {
			session.commit();
			session.close();
		}
		System.out.println("insert(" + person + ") --> " + person.getId());
		return id;
	}
}
