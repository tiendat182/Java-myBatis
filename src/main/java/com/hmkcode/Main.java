package com.hmkcode;

import com.hmkcode.dao.PersonDAO;
import com.hmkcode.mybatis.MyBatisConnectionFactory;
import com.hmkcode.vo.Person;

public class Main {

	public static void main(String[] args) {
		PersonDAO personDAO = new PersonDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		Person person = new Person();
		person.setName("Person 2");
		person.setId(1);
		// personDAO.insert(person);
		personDAO.update(person);
		// person.setName("Person 2");
		// personDAO.insert(person);

		// List<Person> persons = personDAO.selectAll();
		// for (int i = 0; i < persons.size(); i++) {
		// persons.get(i).setName("Person Name " + i);
		// // ( 4 ) update person
		// personDAO.update(persons.get(i));
		// }

		// **check update
		// persons = personDAO.selectAll();
	}

}
