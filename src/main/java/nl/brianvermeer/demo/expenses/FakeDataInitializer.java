package nl.brianvermeer.demo.expenses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeDataInitializer implements CommandLineRunner {

    private final ExpenseRepository expenseRepository;

    public FakeDataInitializer(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Expense> expenses = new ArrayList<>();

        expenses.add(new Expense("Groceries", "Food", new BigDecimal("55.00"), LocalDate.now().minusDays(1)));
        expenses.add(new Expense("Gasoline", "Transportation", new BigDecimal("35.00"), LocalDate.now().minusDays(2)));
        expenses.add(new Expense("Movie tickets", "Entertainment", new BigDecimal("22.50"), LocalDate.now().minusDays(3)));
        expenses.add(new Expense("Clothing", "Shopping", new BigDecimal("125.00"), LocalDate.now().minusDays(4)));
        expenses.add(new Expense("Dinner at a restaurant", "Food", new BigDecimal("75.00"), LocalDate.now().minusDays(5)));
        expenses.add(new Expense("Uber ride", "Transportation", new BigDecimal("18.00"), LocalDate.now().minusDays(6)));
        expenses.add(new Expense("Gym membership", "Fitness", new BigDecimal("40.00"), LocalDate.now().minusDays(7)));

        expenseRepository.saveAll(expenses);

        expenseRepository.findAll().forEach(System.out::println);
    }
}
