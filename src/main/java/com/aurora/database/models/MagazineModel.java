package com.aurora.database.models;

import com.aurora.database.DatabaseModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MagazineModel extends MaterialMetadata implements DatabaseModel {
    String Editorial;
    String Periodicity;
    String PublicationDate;
    Integer Stock;

    public String getEditorial() {
        return Editorial;
    }

    public String getPeriodicity() {
        return Periodicity;
    }

    public String getPublicationDate() {
        return PublicationDate;
    }

    public Integer getStock() {
        return Stock;
    }

    public MagazineModel(String title, ResourceTypeEnum resourceType, String editorial, String periodicity, String publicationDate, Integer stock) {
        super(title, resourceType);
        Editorial = editorial;
        Periodicity = periodicity;
        PublicationDate = publicationDate;
        Stock = stock;
    }

    @Override
    public String getTableName() {
        return "magazines";
    }

    @Override
    public Map<String, String> getColumnsValuesStructure() {
        Map<String, String> columnsValues = new HashMap<String, String>();
        columnsValues.put("editorial", this.getEditorial());
        columnsValues.put("publication_date", this.getPublicationDate());
        columnsValues.put("stock", this.getStock().toString());
        columnsValues.put("periodicity", this.getPeriodicity());
        return columnsValues;
    }
}
