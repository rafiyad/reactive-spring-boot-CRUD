package com.rafiyad.reactivespringbootcrud.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("customer")
public class Customer {

    @Id
    private int id;
    private String name;

}
