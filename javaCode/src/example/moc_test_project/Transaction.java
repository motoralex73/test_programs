package example.moc_test_project;

import java.time.LocalDate;

public class Transaction {
    private Long id;
    private String type; // "INCOME" or "EXPENSE"
    private double amount;
    private String description;
    private LocalDate date;

    // Конструкторы, геттеры и сеттеры

    public Transaction(Long id, String type, double amount, String description, LocalDate date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
