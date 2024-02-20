package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {

	
	@Id
	
	private long transactionID;
	@Column(length = 30)
	private String receiversName;
	@Column(length = 30)
	private TransactionType transactionType;
	//@Column(length = 30)
	//private LocalDate date ;
	//@Column(length = 30)
	//private LocalTime time;
	@Column(length = 30)
	private String bank;
	
	
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;	
	
}
