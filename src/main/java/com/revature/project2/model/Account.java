package com.revature.project2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="account")
@Data
public class Account {
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
	@Column(name="liked_recipes")
	private int[] likedRecipes;

}
