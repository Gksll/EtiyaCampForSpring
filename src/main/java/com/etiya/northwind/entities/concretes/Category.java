package com.etiya.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private int categoryId;

   @Column(name="category_name")
    private String categoryName;

   @Column(name = "description")
   private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
