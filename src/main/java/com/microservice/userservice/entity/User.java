package com.microservice.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="micro_user")
public class User {
	@Id
	private String userId;
	@Column(name="user_name", length = 20)
	private String name;
	private String email;
	private String about;
	
	@Transient
	private List<Rating> rating = new ArrayList<>();
}
