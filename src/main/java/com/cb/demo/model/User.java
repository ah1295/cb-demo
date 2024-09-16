package com.cb.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    private Boolean processed;

    @Version
    private Long version;

    public User(String name, Boolean processed) {
        this.name = name;
        this.processed = processed;
    }
}
