package com.example.ApnaShow.in.Security;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtAuthResponse {
	private String jwttoken;

	private String username;

	private String email;
	private String name;
	private long id;
	private List<String> roles;
}
