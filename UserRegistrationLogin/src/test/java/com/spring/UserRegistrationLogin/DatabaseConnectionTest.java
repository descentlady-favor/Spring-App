package com.spring.UserRegistrationLogin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

public class DatabaseConnectionTest {
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user =new User();
		user.setEmail("favor.nantongo@gmail.com");
		user.setPassword("descentlady12");
		user.setFirstname("Annet");
		user.setLastname("Nantongo");
		
		User saveuser= repo.save(user);
		User existuser=entityManager.find(User.class,saveuser.getId());
		
		assertThat(existuser.getEmail()).isEqualTo(user.getEmail());
		;
		
	}
}


