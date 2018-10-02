package dev.viplove.springbootstarter.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.viplove.springbootstarter.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,String>{

	Optional<User> findByUsername(String username);

}
