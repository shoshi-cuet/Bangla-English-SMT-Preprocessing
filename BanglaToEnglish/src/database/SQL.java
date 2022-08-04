/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author user
 */

public class SQL {

    public static String GET_ROW_COUNT = "SELECT count(*) as " + Column.ROW_COUNT + " FROM " + Table.WORD_MEANING + " WHERE " + Column.ENGLISH_WORD + " = ?";
    public static String GET_ENGLISH_WORD = "SELECT * FROM " + Table.WORD_MEANING + " WHERE " + Column.BANGLA_WORD + " = ?";
    public static String GET_FEATURE = "SELECT * FROM " + Table.WORD_MEANING + " WHERE " + Column.BANGLA_WORD + " = ?";
   // public static String GET_FEATURE_BY_BANGLA = "SELECT * FROM " + Table.WORD_MEANING + " WHERE " + Column.MEANING + " = ?";
    public static String GET_PERSON = "SELECT * FROM " + Table.WORD_MEANING + " WHERE " + Column.BANGLA_WORD + " = ?";
    public static String GET_TENSE = "SELECT * FROM " + Table.WORD_MEANING + " WHERE " + Column.ENGLISH_WORD + " = ?";
    public static String GET_TYPE = "SELECT * FROM " + Table.WORD_MEANING + " WHERE " + Column.ENGLISH_WORD + " = ?";
    
    
    public static String GET_RULE = "SELECT * FROM " + Table.RULE + " WHERE " + Column.BANGLA_RULE + " = ?";
     
    public static String GET_VERB = "SELECT * FROM " + Table.VERB + " WHERE " + Column.VERB_ROOT + " = ?";
    
     public static String GET_PROBABILITY = "SELECT * FROM " + Table.RULE_PROBABILITY + " WHERE " + Column.BANGLA_RULE + " = ?";
}
