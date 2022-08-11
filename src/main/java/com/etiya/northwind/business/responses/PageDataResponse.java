package com.etiya.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDataResponse<T> {
    List<T> data;
    int totalPageNumber;
    long dataAmount;
    int currentPage;
}
