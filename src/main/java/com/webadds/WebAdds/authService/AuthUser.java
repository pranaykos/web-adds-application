package com.webadds.WebAdds.authService;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUser implements UserDetails {
	
	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	
	
	public AuthUser() {
		super();
	}
	
	public AuthUser(Collection<? extends GrantedAuthority> authorities, String username, String password,
			boolean isAccountNonExpired, boolean isCredentialsNonExpired, boolean isEnabled,
			boolean isAccountNonLocked) {
		super();
		this.authorities = authorities;
		this.username = username;
		this.password = password;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
		this.isAccountNonLocked = isAccountNonLocked;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
	
	
	
	
	
}
