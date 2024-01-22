package com.MikoAi.filedatabase.Column;

// column class to get the specific column name and type of that column
public class Column {
    private String nameColumn;
    private String typeColumn;
    public Column(String name,String type){
        this.nameColumn=name;
        this.typeColumn=type;
    }
    public String getName(){
        return nameColumn;
    }
    public String getType(){
        return typeColumn;
    }
}
