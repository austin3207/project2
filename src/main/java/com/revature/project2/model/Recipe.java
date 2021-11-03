package com.revature.project2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="recipe")
@Data
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recipeId;
	@Column(name= "name")
	private String name;
	@Column(name= "category")
	private String category;
	@Column(name= "number_of_likes")
	private int numberOfLikes;
	@Column(name= "prep_method")
	private String prepMethod;
	@Column(name= "description")
	private String description;
	@Column(name= "ingredients")
	private String[] ingredients;
	@Column(name= "user_id")
	private int userId;
}
