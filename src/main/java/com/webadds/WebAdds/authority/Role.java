package com.webadds.WebAdds.authority;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

	USER(com.google.common.collect.Sets.newHashSet("USER")),
	ADMIN(com.google.common.collect.Sets.newHashSet("ADMIN")),
	CLIENT(com.google.common.collect.Sets.newHashSet("CLIENT"));
	
	private Set<String> roleName;

	private Role(Set<String> roleName) {
		this.roleName = roleName;
	}

	public Set<String> getRoleName() {
		return roleName;
	}
	
	public Set<SimpleGrantedAuthority> getAuthorities(){ 
		 return this.getRoleName()
				 .stream()
				 .map(authority -> new SimpleGrantedAuthority("ROLE_"+this.name()))
				 .collect(Collectors.toSet());
	}	
}
