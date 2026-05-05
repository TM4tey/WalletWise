package org.example.walletwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * Expense entity.
 */
@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    /** The identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The description of the expense. */
    @NotBlank(message = "A leírás nem lehet üres!")
    private String description;

    /** The amout of money spent. */
    @Min(value = 1, message = "Az összegnek legalább 1-nek kell lennie!")
    private double amount;

    /** Expense date. */
    @NotNull(message = "A dátum megadása kötelező!")
    private LocalDate date;

    /** Expense Category. */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
