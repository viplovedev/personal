package dev.viplove.springbootstarter.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import dev.viplove.springbootstarter.model.User;
import dev.viplove.springbootstarter.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestUserRepository {

	@Autowired
	UserRepository uS;
	
	@Test
	public void testGetUsers() {
		
		Optional<User> usrs = uS.findById("shobhitj");
		
		assertThat(usrs.isPresent());
	}
}
