package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column(length = 30)
	@NotBlank
	private String firstName;
	@Column(length = 30)
   @NotBlank
	private String lastName;
	@Column(length = 30, unique = true)
	@NotBlank
	@Email
	private String email ;
	@Column(unique =true)
	
	//@Length(min = 10,max = 10, message = "please provide a valid no")
	//@NotBlank
//	@Pattern(message = "please provide a valid no")
	private long phoneNo;
	
	@Enumerated(EnumType.STRING)
	@NotNull
    private ServiceApp serviceApp;
    
	@JsonIgnore
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactions= new ArrayList<>();
	
}
