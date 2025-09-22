package com.ss.splitexpense.entities;
// Expense.java
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id @GeneratedValue
    private Long id;

    private String description;
    private Double amount;

    @ManyToOne
    private User paidBy;

    @ManyToMany
    private List<User> participants;

    @ManyToOne
    private GroupEntity group;
}
