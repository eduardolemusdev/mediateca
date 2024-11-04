package com.aurora.database;

import java.util.Map;

public interface DatabaseModel {
    public String getTableName();
    public Map<String, String> getColumnsValuesStructure();
}
