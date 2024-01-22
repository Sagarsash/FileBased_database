package com.MikoAi.filedatabase.DatabaseController;

import com.MikoAi.filedatabase.Column.Column;
import com.MikoAi.filedatabase.createTableRequest.CreateTableRequest;
import com.MikoAi.filedatabase.InsertDataRequest.InsertDataRequest;
import com.MikoAi.filedatabase.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.util.List;

@RestController
public class DatabaseController {
    //creating the meta file to store the table names and its columns
    private static final String metaData = "meta.txt";

    //using redisservice class to store the results in the redis
    @Autowired
    private RedisService redisService;

    //postmapping to create table
    @PostMapping("/createTable")
    public String createTable(@RequestBody CreateTableRequest request) {
        List<Column> columns = request.getColumns();
        String tableName = request.getTableName();

        try (FileWriter metaFile = new FileWriter(metaData, true)) {
            metaFile.write(tableName + ":");
            for (Column column : columns) {
                metaFile.write(column.getName() + ":" + column.getType() + ",");
            }
            metaFile.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating table";
        }

        return "Table created successfully";
    }

    //PostMapping to insert data into the specified table
    @PostMapping("/insertData")
    public String insertData(@RequestBody InsertDataRequest request){
        List<Object> values= request.getValues();
        String tableName= request.getTableName();

        String dataFile= tableName+".txt";
        try(FileWriter data = new FileWriter(dataFile,true)){
            for(Object val:values){
                data.write(val.toString()+",");
            }
            data.write("\n");
        }catch(Exception c){
            c.printStackTrace();
            return "Error inserting data";
        }
        return "Data Inserted successfully";
    }

    //mapping the end results and returning success or failure
    @GetMapping("/executeStatements")
    public String executeStatements(@RequestBody String statements){
        return "Execution Successful";
    }

}
