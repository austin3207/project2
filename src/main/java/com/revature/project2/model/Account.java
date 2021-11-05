package com.revature.project2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="account", schema="project2")
@Data
public class Account extends SQLTypes{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name= "email")
	private String email;
	@Column(name= "first_name")
	private String firstName;
	@Column(name= "last_name")
	private String lastName;
	@Column(name= "password")
	private String password;
	@Type(type="int-array")
	@Column(name="liked_recipes",
			columnDefinition="int[]")
	private int[] likedRecipes;

}
