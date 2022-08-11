package com.etiya.northwind.business.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCategoryResponse {
    @NotNull
    private int categoryId;
    @NotNull
    private String categoryName;
    @NotNull
    private String description;


}
