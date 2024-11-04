package com.aurora.database.models;

import com.aurora.database.DatabaseModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CDModel extends MaterialMetadata implements DatabaseModel {

    public String Artist;
    public String Genre;
    public String Duration;
    public String NumSongs;
    public String Stock;

    public CDModel(String title, ResourceTypeEnum resourceType, String artist, String genre, String duration, String numSongs, String stock) {
        super(title, resourceType);
        Artist = artist;
        Genre = genre;
        Duration = duration;
        NumSongs = numSongs;
        Stock = stock;
    }

    public String getArtist() {
        return Artist;
    }

    public String getGenre() {
        return Genre;
    }

    public String getDuration() {
        return Duration;
    }

    public String getNumSongs() {
        return NumSongs;
    }

    public String getStock() {
        return Stock;
    }

    @Override
    public String getTableName() {
        return "cds";
    }

    @Override
    public Map<String, String> getColumnsValuesStructure() {
        Map<String, String> columnsValues = new HashMap<String, String>();
        columnsValues.put("artist", this.getArtist());
        columnsValues.put("gender", this.getGenre());
        columnsValues.put("duration", this.getDuration());
        columnsValues.put("num_songs", this.getNumSongs());
        columnsValues.put("stock", this.getStock());
        return columnsValues;
    }
}
