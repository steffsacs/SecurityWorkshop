package com.workshop.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table (name="passwords")
@Data
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pass")
    @ApiModelProperty(hidden = true) 
    private int id;
    @ApiModelProperty(hidden = true) 
	private int idUser;
    @ApiModelProperty(position = 1, required = true, example= "steff123")
	private String user;
    @ApiModelProperty(position = 2, required = true, example= "Facebook")
	private String domain;
    @ApiModelProperty(position = 3, required = true, example= "pass123")
	private String password;
}
