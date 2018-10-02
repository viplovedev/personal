package dev.viplove.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.viplove.springbootstarter.model.UrlRoleMap;
import dev.viplove.springbootstarter.repository.UrlRoleRepository;

@Component
public class UrlService {

	@Autowired
	UrlRoleRepository uRR;
	
	public Map<String,String> getRoleUrlMap(){
		
		List<UrlRoleMap> urlRoleMapping = (ArrayList<UrlRoleMap>)uRR.findAll();
		
		return urlRoleMapping.stream().collect(Collectors.toMap(UrlRoleMap::getUrl,UrlRoleMap::getRole));
	}
}
