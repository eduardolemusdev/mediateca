package com.aurora.database.models;

import com.aurora.database.DatabaseModel;

import java.util.HashMap;
import java.util.Map;

public class BookModel extends MaterialMetadata implements DatabaseModel {

    public String Author;
    public Integer PageNumber;
    public String Editorial;
    public String Isbn;
    public Integer Stock;
    public String YearPublication;

    public BookModel(String title, ResourceTypeEnum resourceType, String author, Integer pageNumber, String editorial, String isbn, Integer stock, String yearPublication) {
        super(title, resourceType);
        Author = author;
        PageNumber = pageNumber;
        Editorial = editorial;
        Isbn = isbn;
        Stock = stock;
        YearPublication = yearPublication;
    }

    public String getAuthor() {
        return Author;
    }

    public Integer getPageNumber() {
        return PageNumber;
    }

    public String getEditorial() {
        return Editorial;
    }

    public String getIsbn() {
        return Isbn;
    }

    public Integer getStock() {
        return Stock;
    }

    public String getYearPublication() {
        return YearPublication;
    }




    @Override
    public String getTableName() {
        return "books";
    }

    @Override
    public Map<String, String> getColumnsValuesStructure() {
        Map<String, String> columnsValues = new HashMap<String, String>();
        columnsValues.put("author", this.getAuthor());
        columnsValues.put("num_pages", this.getPageNumber().toString());
        columnsValues.put("editorial", this.getEditorial());
        columnsValues.put("isbn", this.getIsbn());
        columnsValues.put("stock", this.getStock().toString());
        columnsValues.put("publication_date", this.getYearPublication());
        return columnsValues;
    }
}
