/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author user
 */

public class DatabaseHelper {

    Connection connection = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public DatabaseHelper() throws SQLException {
        connection = DBConnect.getConnnection();
    }

    public int getRowCount(String word) throws SQLException {
        int rowCount;
        preparedStatement = connection.prepareStatement(SQL.GET_ROW_COUNT);
        preparedStatement.setString(1, word);
        resultSet = preparedStatement.executeQuery();
        resultSet.first();
        rowCount = (int) resultSet.getLong(Column.ROW_COUNT);
        connection.close();
        return rowCount;
    }

    public int getRowCount(ResultSet result) throws SQLException {
        int length = 0;
        while (result.next()) {
            length++;
        }
        return length;
    }

    public String getWordFeature(String word) throws SQLException {
        String properties=null;
        //System.out.println(word);
        preparedStatement = connection.prepareStatement(SQL.GET_FEATURE);
        preparedStatement.setString(1, word);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.first()) {
            properties = resultSet.getString(Column.FEATURE);
            connection.close();
        }
        return properties;
    }

//    public String getWordFeatureByBangla(String word) throws SQLException {
//        String properties;
//        System.out.println(word);
//        preparedStatement = connection.prepareStatement(SQL.GET_FEATURE_BY_BANGLA);
//        preparedStatement.setString(1, word);
//        resultSet = preparedStatement.executeQuery();
//        if (resultSet.first()) {
//            properties = resultSet.getString(Column.FEATURE);
//            connection.close();
//            return properties;
//        }
//        return "null";
//    }

    public String getWordMeaning(String word) throws SQLException {
        String properties=null;
        preparedStatement = connection.prepareStatement(SQL.GET_ENGLISH_WORD);
        preparedStatement.setString(1, word);
        resultSet = preparedStatement.executeQuery();
        resultSet.first();
      //  System.out.print(resultSet.toString());
        properties = resultSet.getString(Column.ENGLISH_WORD);
        connection.close();
        return properties;
        
        
        
        
    }

    public String getWordPerson(String word) throws SQLException {
        String properties;
        preparedStatement = connection.prepareStatement(SQL.GET_PERSON);
        preparedStatement.setString(1, word);
        resultSet = preparedStatement.executeQuery();
        resultSet.first();
        properties = resultSet.getString(Column.PERSON);
        connection.close();
        return properties;
    }

//    public String getWordTense(String word) throws SQLException {
//        String properties;
//        preparedStatement = connection.prepareStatement(SQL.GET_TENSE);
//        preparedStatement.setString(1, word);
//        resultSet = preparedStatement.executeQuery();
//        resultSet.first();
//        properties = resultSet.getString(Column.TENSE);
//        connection.close();
//        return properties;
//    }
//
//    public String getWordType(String word) throws SQLException {
//        String properties;
//        preparedStatement = connection.prepareStatement(SQL.GET_TYPE);
//        preparedStatement.setString(1, word);
//        resultSet = preparedStatement.executeQuery();
//        resultSet.first();
//        properties = resultSet.getString(Column.TYPE);
//        connection.close();
//        return properties;
//    }
    public String getVerb(String word,String form) throws SQLException {
        String properties;
        preparedStatement = connection.prepareStatement(SQL.GET_VERB);
        preparedStatement.setString(1, word);
        resultSet = preparedStatement.executeQuery();
        resultSet.first();
        properties = resultSet.getString(form);
        connection.close();
        
       // System.out.println(properties);
        return properties;
    }
    
    public String getRule(String rule) throws SQLException {
        String properties;
        preparedStatement = connection.prepareStatement(SQL.GET_RULE);
        preparedStatement.setString(1, rule);
        resultSet = preparedStatement.executeQuery();
        resultSet.first();
        properties = resultSet.getString(Column.ENGLISH_RULE);
        connection.close();
        return properties;
    }
     public String getProbability(String rule) throws SQLException {
        String properties;
        preparedStatement = connection.prepareStatement(SQL.GET_RULE);
        preparedStatement.setString(1, rule);
        resultSet = preparedStatement.executeQuery();
        resultSet.first();
        properties = resultSet.getString(Column.PROBABILITY);
        connection.close();
        return properties;
    }
     
       public HashMap getProbababilityFromRuleTable(String rule) throws SQLException {
        String properties;
        String probability;
        HashMap<String,String> hashmap = new HashMap<>();
        preparedStatement = connection.prepareStatement(SQL.GET_PROBABILITY);
        preparedStatement.setString(1, rule);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        properties = resultSet.getString(Column.ENGLISH_RULE);
        probability = resultSet.getString(Column.PROBABILITY);
        hashmap.put(properties, probability);
        }
        connection.close();
        return hashmap;
    }
}
