package com.MikoAi.filedatabase.InsertDataRequest;

import java.util.List;

//to send the post request to save the data into the specified table as user ask
public class InsertDataRequest {
    private String tableName;
    private List<Object> values;

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public List<Object> getValues() {
        return values;
    }
    public void setValues(List<Object> values) {
        this.values = values;
    }
}
