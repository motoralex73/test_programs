package example.moc_test_project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void testAddTransaction_validTransaction_returnsSavedTransaction() {
        // Arrange
        Transaction transaction = new Transaction(1L, "INCOME", 500.0, "Salary", LocalDate.now());

        when(transactionRepository.save(transaction)).thenReturn(Optional.of(transaction));

        // Act
        Optional<Transaction> result = transactionService.addTransaction(transaction);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(500.0, result.get().getAmount());
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    public void testAddTransaction_negativeAmount_throwsException() {
        // Arrange
        Transaction transaction = new Transaction(1L, "EXPENSE", -100.0, "Invalid expense", LocalDate.now());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            transactionService.addTransaction(transaction);
        });
    }

    @Test
    public void testGetAllTransactions_returnsAll() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1L, "INCOME", 500.0, "Salary", LocalDate.now()));
        transactions.add(new Transaction(2L, "EXPENSE", 200.0, "Coffee", LocalDate.now()));

        when(transactionRepository.findAll()).thenReturn(transactions);

        // Act
        List<Transaction> result = transactionService.getAllTransactions();

        // Assert
        assertEquals(2, result.size());
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    public void testCalculateBalance_validTransactions_returnsCorrectBalance() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1L, "INCOME", 500.0, "Salary", LocalDate.now()));
        transactions.add(new Transaction(2L, "EXPENSE", 200.0, "Coffee", LocalDate.now()));

        when(transactionRepository.findAll()).thenReturn(transactions);

        // Act
        double balance = transactionService.calculateBalance();

        // Assert
        assertEquals(300.0, balance);
    }

    @Test
    public void testCalculateBalance_noTransactions_returnsZero() {
        // Arrange
        when(transactionRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        double balance = transactionService.calculateBalance();

        // Assert
        assertEquals(0.0, balance);
    }
}
