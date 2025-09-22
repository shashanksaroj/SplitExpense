package com.ss.entities;

// GroupEntity.java
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupEntity {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    private List<User> members;
}
