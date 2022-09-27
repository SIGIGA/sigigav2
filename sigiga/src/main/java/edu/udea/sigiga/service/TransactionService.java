package edu.udea.sigiga.service;

import edu.udea.sigiga.model.Employee;
import edu.udea.sigiga.model.Transaction;
import edu.udea.sigiga.repository.EmployeeRepository;
import edu.udea.sigiga.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    //Variable que implementa el repositorio
    private TransactionRepository transactionRepository;

    //Hay que pasar un repositorio al servicio
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //Métodos
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction findById(Long id) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        return transactionOptional.orElse(null);
    }

    public Boolean deleteTransaction(Long id){
        this.transactionRepository.deleteById(id);
        return true;
    }

}
