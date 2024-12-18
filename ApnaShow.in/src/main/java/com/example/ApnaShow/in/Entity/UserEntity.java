package com.example.ApnaShow.in.Entity;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class UserEntity implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String password;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "users", cascade = CascadeType.ALL)

	private Set<UserRole> userrole;

	@Override

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userrole.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
				.collect(Collectors.toSet());
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // Implement according to your requirements
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // Implement according to your requirements
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // Implement according to your requirements
	}

	@Override
	public boolean isEnabled() {
		return true; // Implement according to your requirements
	}

}
