package dev.viplove.springbootstarter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.viplove.springbootstarter.model.UrlRoleMap;

@Repository
public interface UrlRoleRepository extends CrudRepository<UrlRoleMap, Integer> {

	Optional<List<UrlRoleMap>> findByUrl(String url);
	
	
}
