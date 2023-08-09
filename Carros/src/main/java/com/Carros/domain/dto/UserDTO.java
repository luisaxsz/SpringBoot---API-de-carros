package com.Carros.domain.dto;

import org.modelmapper.ModelMapper;

import com.Carros.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class UserDTO {
	private String nome;
	private String email;
	private String login;

	private String token;

	public static UserDTO create(User u, String token) {
		ModelMapper modelMapper = new ModelMapper();
		UserDTO dto = modelMapper.map(u, UserDTO.class);
		dto.token = token;
		return dto;
	}
	
	public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }
}
