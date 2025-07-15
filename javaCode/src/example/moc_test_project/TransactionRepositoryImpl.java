package example.moc_test_project;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public Optional<Transaction> save(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            return Optional.empty();
        }
        transactions.add(transaction);
        return Optional.of(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return new ArrayList<>(transactions);
    }
}
