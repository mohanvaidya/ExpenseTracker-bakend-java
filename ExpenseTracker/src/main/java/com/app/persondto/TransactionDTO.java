package com.app.persondto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

import com.app.entity.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

	private long transactionID;

	private String receiversName;

	private TransactionType transactionType;
//
//	private LocalDate date;
//	
//	private LocalTime time;
	
	private String bank;

}
