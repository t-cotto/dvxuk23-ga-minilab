package nl.brianvermeer.demo.expenses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExpenseTrackerController {

    private final ExpenseRepository expenseRepository;

    public ExpenseTrackerController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/")
    public String listExpenses(Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        return "list-expenses";
    }

    @GetMapping("/add")
    public String addExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "add-expense";
    }

    @PostMapping("/add")
    public String addExpenseSubmit(@ModelAttribute Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid expense id: " + id));
        model.addAttribute("expense", expense);
        return "edit-expense";
    }

    @PostMapping("/update")
    public String updateExpense(@ModelAttribute("expense") Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/";
    }
}

