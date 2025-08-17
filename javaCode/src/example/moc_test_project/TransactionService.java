package example.moc_test_project;

import java.util.List;
import java.util.Optional;

//@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Optional<Transaction> addTransaction(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public double calculateBalance() {
        double totalIncome = 0.0;
        double totalExpense = 0.0;

        for (Transaction transaction : transactionRepository.findAll()) {
            if (transaction.getType().equals("INCOME")) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getType().equals("EXPENSE")) {
                totalExpense += transaction.getAmount();
            }
        }

        return totalIncome - totalExpense;
    }
}
