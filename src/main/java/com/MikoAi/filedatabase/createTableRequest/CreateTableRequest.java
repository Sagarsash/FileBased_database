package com.MikoAi.filedatabase.createTableRequest;

import com.MikoAi.filedatabase.Column.Column;

import java.util.List;
//sending the request to create a table and set the name of tables and columns from the column class in the project
public class CreateTableRequest {
    private String tableName;
    private List<Column> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
