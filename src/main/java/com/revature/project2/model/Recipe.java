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
@Table(name="recipe", schema="project2")
@Data
public class Recipe extends SQLTypes{
	@Id
	@Column(name="recipe_id")
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
	@Type(type="string-array")
	@Column(name= "ingredients",
			columnDefinition = "string[]")
	private String[] ingredients;
	@Column(name= "user_id")
	private int userId;
	
}
