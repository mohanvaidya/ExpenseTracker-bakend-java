package com.app.serviceIpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Transaction;
import com.app.persondto.TransactionDTO;
import com.app.repository.TransactionRepo;
import com.app.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo repo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<TransactionDTO> getallTransactions() {
		List<Transaction> transaction = this.repo.findAll();
		List<TransactionDTO> transactions = transaction.stream()
				.map(pay -> this.mapper.map(transaction, TransactionDTO.class)).collect(Collectors.toList());
		return transactions;
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return this.repo.save(transaction) ;
	}

	
	

}
