package com.app.dao;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Address;
import com.app.entities.Gender;
import com.app.entities.Role;
import com.app.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest {
	@Autowired
	private UserDao dao;
	@Autowired
	private AddressDao adrDao;

	@Test
	void testSaveUser() {
		/*
		 *  String userName, String s_d_w, String email, String password, String phoneNo, Role role, Gender gender,
			LocalDate birthDate, Address permanentAddress, Address correspondAdd
		 */
//		List<User> list = List.of(
//				new User("Unnati Kurekar","Dnyaneshwar Kurekar","unnati@gmail.com","unnati@123","9689393813",Role.ADMIN,Gender.FEMALE,LocalDate.parse("1996-01-03") )
//				);
		
//		List<User> list2 = dao.saveAll(list);
//		List<Address> adrList = List.of(
//				new Address("Tilak Rd", "Pune", "MH", "India", "411020"),
//				new Address("M G Rd", "Bangalore", "KA", "India", "566020"),
//				new Address("Laxmi Rd", "Pune", "MH", "India", "411001"));
//		assertEquals(3, list2.size());
//		for(int i=0;i<list2.size();i++)
//		{
//			adrList.get(i).setEmp(list2.get(i));//setting up uni dir asso from Adr -->Emp
//			adrDao.save(adrList.get(i));//saving adr details explicitly
//		}	
	}	}



//new User(LocalDate.parse("1996-01-03"),"unnati@gmail.com", Gender.FEMALE,"unnati@123","9689393813",Role.ADMIN,"Dnyaneshwar Kurekar","Unnati Kurekar"),
//new User(default, LocalDate.parse("1996-01-03"),"unnati@gmail.com", Gender.FEMALE,"unnati@123","9689393813",Role.ADMIN,"Dnyaneshwar Kurekar","Unnati Kurekar",
//		null,null),
//new User(default, LocalDate.parse("1996-01-03"),"unnati@gmail.com", Gender.FEMALE,"unnati@123","9689393813",Role.ADMIN,"Dnyaneshwar Kurekar","Unnati Kurekar",
//		null,null)
