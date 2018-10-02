package dev.viplove.springbootstarter.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import dev.viplove.springbootstarter.model.UrlRoleMap;
import dev.viplove.springbootstarter.repository.UrlRoleRepository;

@Component
public class UserRoleMapFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Inject
	UrlRoleRepository uRR;
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		FilterInvocation fi = (FilterInvocation) object;
		String url = fi.getRequestUrl();
		String httpMethod = fi.getRequest().getMethod();
		
		List<ConfigAttribute> attributes = new ArrayList<>();
		
		
		Optional<List<UrlRoleMap>> uRs = uRR.findByUrl(url);
		
		uRs.orElse(new ArrayList<>());
		
		List<String> roles = uRs.get().stream().map(uR -> uR.role).collect(Collectors.toList());
		
		return SecurityConfig.createList(roles.toArray(new String[0]));
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
