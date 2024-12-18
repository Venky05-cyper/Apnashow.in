package com.example.ApnaShow.in.Security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@AllArgsConstructor

@Builder
@ToString
public class JwtAuthRequest {

	private String email;

	private String password;
}
