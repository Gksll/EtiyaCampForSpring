package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String name);
}
