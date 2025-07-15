package example.moc_test_project;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Optional<Transaction> save(Transaction transaction);
    List<Transaction> findAll();
}