package com.webadds.WebAdds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.webadds.WebAdds.authService.ApplicationUserService;
import com.webadds.WebAdds.authority.Role.*;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authServiceProvider")
	private ApplicationUserService appUserService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/register").permitAll()
		.antMatchers("/client/register").permitAll()
//		.antMatchers(HttpMethod.POST, "/register").permitAll()
		.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
		.antMatchers("/user/**").hasAnyRole(
				com.webadds.WebAdds.authority.Role.USER.name())
		.antMatchers("/client/**").hasAnyRole(
				com.webadds.WebAdds.authority.Role.CLIENT.name())
		.antMatchers("/admin/**").hasAnyRole(
				com.webadds.WebAdds.authority.Role.ADMIN.name())
		.anyRequest()
		.authenticated()
		.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.loginProcessingUrl("/login-process")
				.defaultSuccessUrl("/", true)
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
				.clearAuthentication(true)
				.invalidateHttpSession(false)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = 
				new DaoAuthenticationProvider();
		provider.setUserDetailsService(appUserService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	


}
