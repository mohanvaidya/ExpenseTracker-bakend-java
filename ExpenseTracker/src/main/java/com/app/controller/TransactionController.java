package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Transaction;
import com.app.persondto.TransactionDTO;
import com.app.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	@Autowired
	private TransactionService service;

	public TransactionController() {
		System.out.println("inside a transaction controller...!!!");

	}

	@PostMapping("/")
	ResponseEntity<?>savetrans(@Valid @RequestBody Transaction transaction){
		Transaction addTransaction=this.service.saveTransaction(transaction);
		
		return new ResponseEntity<>(addTransaction,HttpStatus.CREATED);
		
	}
	@GetMapping("/")
	public List<TransactionDTO>getAlltransactions(){
		System.out.println("----- All Transactions-----");
		return service.getallTransactions();
	}
}
