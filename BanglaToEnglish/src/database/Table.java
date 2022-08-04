/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author user
 */

public class Table {
    public static String WORD_MEANING ="word_meaning";
    public static String VERB ="verb";
    public static String RULE ="rule";
    public static String RULE_PROBABILITY = "rule_proability";
}

//  public static String[] Stem(String word) {
//   
//           
//           
//           String ruleFilePath="/Users/user/NetBeansProjects/BanglaToEnglish/src/banglatoenglish/common.rules";//args[0];
//           //String inputFilePath="C:/Users/Mahtabul Sohan/Desktop/Bangla-Stemmer-master/input";//args[1];
//           
//           //RuleFileParser parser = new RuleFileParser(ruleFilePath);
//
//           
//           
//           
//           
//           
//           String root=parser.stemOfWord(word);
//             
//           
////         String postfix = word.replaceFirst(root, "");
//           
//           String postfix = word.substring(root.length(),word.length());
//             
//             String [] stem=new String[2];
//             stem[0]=root;
//             stem[1]=postfix;
//             
//             
//             
//           
//           return stem;
//           //System.out.print(parser.stemOfWord(root) + " " +  postfix);
//   }