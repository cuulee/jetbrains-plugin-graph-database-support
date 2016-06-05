package com.neueda.jetbrains.plugin.graphdb.component.datasource;

import java.util.HashMap;
import java.util.Map;

public final class DataSource {

    public DataSourceType dataSourceType = DataSourceType.UNKNOWN;
    public String name = "unknown";
    public Map<String, Object> configuration = new HashMap<>();

    /**
     * Default constructor for serialization.
     */
    public DataSource() {
    }

    public DataSource(DataSourceType dataSourceType, String name,
                               Map<String, Object> configuration) {
        this.dataSourceType = dataSourceType;
        this.name = name;
        this.configuration = configuration;
    }

    public DataSourceType getDataSourceType() {
        return dataSourceType;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getConfiguration() {
        return configuration;
    }
}