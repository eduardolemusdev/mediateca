package com.aurora.database.models;

import com.aurora.database.DatabaseModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DVDModel extends MaterialMetadata implements DatabaseModel {
    public String Director;
    public String Duration;
    public String Genre;

    public DVDModel(String title, ResourceTypeEnum resourceType, String director, String duration, String genre) {
        super(title, resourceType);
        Director = director;
        Duration = duration;
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public String getDuration() {
        return Duration;
    }

    public String getGenre() {
        return Genre;
    }

    @Override
    public String getTableName() {
        return "dvds";
    }

    @Override
    public Map<String, String> getColumnsValuesStructure() {
        Map<String, String> columnsValues = new HashMap<String, String>();
        columnsValues.put("director", this.getDirector());
        columnsValues.put("gender", this.getGenre());
        columnsValues.put("duration", this.getDuration());
        return columnsValues;
    }
}
