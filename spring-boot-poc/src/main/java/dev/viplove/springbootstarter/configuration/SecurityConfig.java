package dev.viplove.springbootstarter.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import dev.viplove.springbootstarter.repository.UserRepository;
import dev.viplove.springbootstarter.security.UserRoleMapFilterSecurityMetadataSource;
import dev.viplove.springbootstarter.security.tracking.ActiveUserStore;
import dev.viplove.springbootstarter.security.tracking.MySimpleUrlAuthenticationSuccessHandler;
import dev.viplove.springbootstarter.service.UrlService;
import dev.viplove.springbootstarter.service.UserService;

@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfig extends  WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Autowired
	UserRoleMapFilterSecurityMetadataSource metadataSource;
	
	@Autowired
	private UrlService urlService;
	
	@Autowired
	private MySimpleUrlAuthenticationSuccessHandler successHandler;
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Bean
    public ActiveUserStore activeUserStore(){
        return new ActiveUserStore();
    }
	
	@Bean
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> decisionVoters 
          = Arrays.asList(
            new WebExpressionVoter(),
            new RoleVoter(),
            new AuthenticatedVoter());
        UnanimousBased unanimousBased = new UnanimousBased(decisionVoters);
        unanimousBased.setAllowIfAllAbstainDecisions(true);
		return unanimousBased;
    }

    @Override
	public void configure(HttpSecurity http) throws Exception {
		
		Map<String, String> roleUrlMap = urlService.getRoleUrlMap();
    	
    	ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http
		.authorizeRequests();
    	
    	for(Entry<String,String> a:roleUrlMap.entrySet()){
    		authorizeRequests.antMatchers(a.getKey()).hasRole(a.getValue());
    	}
    	
		authorizeRequests.anyRequest().authenticated()
			.and()
		.formLogin()
		.successHandler(successHandler);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
		.passwordEncoder(new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return false;
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				
				return rawPassword.toString();
			}
		});
	}
	
	/**
     * Creates the {@link FilterSecurityInterceptor}
    *
    * @param http the builder to use
    * @param metadataSource the {@link FilterInvocationSecurityMetadataSource} to use
    * @param authenticationManager the {@link AuthenticationManager} to use
    * @return the {@link FilterSecurityInterceptor}
    * @throws Exception
    */
   private FilterSecurityInterceptor createFilterSecurityInterceptor(FilterInvocationSecurityMetadataSource metadataSource,
                                                                     AuthenticationManager authenticationManager) throws Exception {
       FilterSecurityInterceptor securityInterceptor = new FilterSecurityInterceptor();
       securityInterceptor.setSecurityMetadataSource(metadataSource);
       securityInterceptor.setAuthenticationManager(authenticationManager);
       securityInterceptor.setAccessDecisionManager(accessDecisionManager());
       securityInterceptor.afterPropertiesSet();
       return securityInterceptor;
   }
}
