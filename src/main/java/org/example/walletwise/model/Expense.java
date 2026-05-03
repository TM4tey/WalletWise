package org.example.walletwise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A leírás nem lehet üres!")
    private String description;

    @Min(value = 1, message = "Az összegnek legalább 1-nek kell lennie!")
    private double amount;

    @NotNull(message = "A dátum megadása kötelező!")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}