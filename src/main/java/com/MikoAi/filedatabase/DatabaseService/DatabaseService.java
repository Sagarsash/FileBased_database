//package com.MikoAi.filedatabase.DatabaseService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.nio.file.Path;
//import java.nio.file.StandardOpenOption;
//import java.util.Arrays;
//import java.util.List;
//import java.nio.file.Files;
//import java.io.FileWriter;
//import java.io.IOException;
//
//@Service
//public class DatabaseService {
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    // Path to store metadata and data files
//    private final Path metaFilePath = Path.of("meta.txt");
//    private final Path dataFilePath = Path.of("data.txt");
//
//    public void executeDatabaseStatements(String statements) {
//        // Assuming each statement is separated by a semicolon
//        String[] statementArray = statements.split(";");
//
//        for (String statement : statementArray) {
//            // Trim statement to remove leading/trailing whitespaces
//            statement = statement.trim();
//
//            if (!statement.isEmpty()) {
//                // Assuming CREATE TABLE and INSERT INTO statements for simplicity
//                if (statement.toUpperCase().startsWith("CREATE TABLE")) {
//                    parseAndCreateTable(statement);
//                } else if (statement.toUpperCase().startsWith("INSERT INTO")) {
//                    parseAndInsertData(statement);
//                }
//            }
//        }
//    }
//
//    private void parseAndCreateTable(String createTableStatement) {
//        // Example: CREATE TABLE country_info (country_name STRING, population INT);
//        String[] parts = createTableStatement.split("\\(");
//        String tableName = parts[0].replace("CREATE TABLE", "").trim();
//        String columnsPart = parts[1].replace(")", "").trim();
//
//        List<String> columnDefinitions = Arrays.asList(columnsPart.split(","));
//
//        // Creating meta.txt file to insert the column names and their data types
//        writeToFile(metaFilePath, tableName + ":" + String.join(",", columnDefinitions) + "\n");
//    }
//
//    private void parseAndInsertData(String insertStatement) {
//        // Example: INSERT INTO country_info VALUES ('India', 140);
//        String[] parts = insertStatement.split("VALUES");
//        String tableName = parts[0].replace("INSERT INTO", "").trim();
//        String valuesPart = parts[1].replace("(", "").replace(")", "").trim();
//
//        List<String> values = Arrays.asList(valuesPart.split(","));
//
//        // Inserting the data into the data file
//        writeToFile(dataFilePath, tableName + ":" + String.join(",", values) + "\n");
//    }
//
//    private void writeToFile(Path filePath, String content) {
//        try {
//            Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveResultToRedis(String key, String value) {
//        redisTemplate.opsForValue().set(key, value);
//    }
//}
