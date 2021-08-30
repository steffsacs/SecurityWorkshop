package com.workshop.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table (name="users")
@Data
public class UserData {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true) 
	@Column(name = "id_users")
	private int id;

	@ApiModelProperty(position = 1, required = true, example = "Steff")
	@Column(name = "user_name")
	private String userName;
	@ApiModelProperty(position = 2, required = true, example = "pass123?")
	private String password;
	@ApiModelProperty(position = 3, required = true, example = "true")
	private boolean active;
	@ApiModelProperty(position = 4, required = true, example = "ROLE_ADMIN")
	private String roles;
	
	//One to many relationship idUser is field in Credentials table
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idUser")
	private List<Credentials> credentials;
    
}
