package com.app.service;

import java.util.List;

import com.app.entity.Transaction;
import com.app.persondto.TransactionDTO;

public interface TransactionService {

	List<TransactionDTO> getallTransactions();

//	TransactionDTO saveTransaction(TransactionDTO Tdto);

	Transaction saveTransaction(Transaction Transaction);

	
}
