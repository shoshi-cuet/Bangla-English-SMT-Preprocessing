//
///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
// */
//package banglatoenglish;
//
//
//import database.DatabaseHelper;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//
//import java.nio.charset.Charset;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//import java.sql.SQLException;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author user
// */
//public class BanglaToEnglish {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static HashMap<String, String[]> hm = new HashMap<String, String[]>();
//
//    public static void main(String[] args) throws SQLException {
//
//        // TODO code application logic here
//        Scanner reader = new Scanner(System.in);    // Reading from System.in
//
//        while (true) {
//            System.out.println("Enter Bangla Sentence: ");
//
//            String        input = reader.nextLine();
//            StringBuilder banglaPOS;
//            StringBuilder englishTranslate;
//            StringBuilder english_sentence;
//
//            banglaPOS        = new StringBuilder("");
//            englishTranslate = new StringBuilder("");
//
//            String demo = input;
//
//            Stemmed();
//
//            StringTokenizer   st    = new StringTokenizer(demo);
//            ArrayList<String> token = new ArrayList<>();
//
//            while (st.hasMoreTokens()) {
//                String str = st.nextToken();
//
//                if (hm.containsKey(str)) {
//                    String[] stem = new String[2];
//
//                    stem = hm.get(str);
//                    token.add(stem[0]);
//                    token.add(stem[1]);
//                } else {
//                    token.add(str);
//                }
//
//                System.out.println(token.toString());
//            }
//
//            for (int i = 0; i < token.size() - 1; i++) {
//                String word         = token.get(i);
//                String feature      = new DatabaseHelper().getWordFeature(word);
//                String english_word = new DatabaseHelper().getWordMeaning(word);
//
//                banglaPOS.append(feature + " ");
//                englishTranslate.append(english_word + " ");
//                Model.map.put(feature, english_word);
//            }
//
//            System.out.println("Bangla POS: " + banglaPOS.toString());
//            System.out.println("Correspondent English Words: " + englishTranslate.toString());
//
//            String person = new DatabaseHelper().getWordPerson(token.get(0));
//            String verb   = Model.map.get("V");
//            String tense  = checkTense(token.get(token.size() - 1));
//
//            verb(tense, verb, person);
//
//            String rule        = new DatabaseHelper().getRule(banglaPOS.toString());
//            String probability = new DatabaseHelper().getProbability(banglaPOS.toString());
//
//            System.out.println("English Rule: " + rule);
//            System.out.println("Probability: " + probability);
//
//            StringTokenizer eng_rule = new StringTokenizer(rule);
//
//            english_sentence = new StringBuilder("");
//
//            while (eng_rule.hasMoreTokens()) {
//                String str = eng_rule.nextToken();
//
//                english_sentence.append(Model.map.get(str) + " ");
//            }
//
//            System.out.println("English Translation: " + english_sentence.toString());
//            System.out.println("...................................................................");
//        }
//    }
//
//    public static void Stemmed() {
//        String[] total;
//        String   ruleFilePath =
//            "G:/New folder/BanglaToEnglishTranslation/BanglaToEnglish/src/banglatoenglish/common1.rules";    // args[0];
//        Charset  charset = Charset.forName("UTF-8");
//        Path     path    = FileSystems.getDefault().getPath(ruleFilePath);
//        String[] numb    = new String[2];
//
//        try (BufferedReader reader = Files.newBufferedReader(path, charset))    // File Manipulation
//        {
//            String line = null;
//
//            while ((line = reader.readLine()) != null) {
//                String          mainWord      = null;
//                String          rootWord      = null;
//                String          postFixOfWord = null;
//                StringTokenizer st            = new StringTokenizer(line, " ");
//
//                if (st.hasMoreElements()) {
//                    mainWord      = st.nextToken();
//                    rootWord      = st.nextToken();
//                    postFixOfWord = st.nextToken();
//                }
//
//                total    = new String[2];
//                total[0] = rootWord;
//                total[1] = postFixOfWord;
//                hm.put(mainWord, total);
//            }
//
//            // numb  = hm.get(word);
//        } catch (IOException x) {
//            x.printStackTrace();
//        }
//    }
//
//    public static String checkTense(String Biv) {
//        Model model = new Model();
//
//        return model.Tense(Biv);
//    }
//
//    public static void verb(String tense, String root_verb, String person) throws SQLException {
//        String check = person + tense;
//
//        System.out.println("Person: " + person + "\n" + "Tense: " + tense);
//
//        if (tense.equals("3")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "root");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "will");
//        } else if (check.equals("1111") || check.equals("2111") || check.equals("2211") || check.equals("3211")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "root");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "");
//        } else if (check.equals("2112") || check.equals("2212") || check.equals("3212")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "continuous");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "are");
//        } else if (check.equals("3111")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "person");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "");
//        } else if (check.equals("1112")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "continuous");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "am");
//        } else if (check.equals("3112")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "continuous");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "is");
//        } else if (check.equals("3122") || check.equals("1122")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "continuous");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "was");
//        } else if (check.equals("1222") || check.equals("3222")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "continuous");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "were");
//        } else if (check.equals("3113")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "participle");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "has");
//        } else if (check.equals("3121") || check.equals("3221") || check.equals("1121") || check.equals("1221")
//                   || check.equals("2121") || check.equals("2221")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "past");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "");
//        } else if (check.equals("1113") || check.equals("1213") || check.equals("2113") || check.equals("2213")
//                   || check.equals("3213")) {
//            String verb = new DatabaseHelper().getVerb(root_verb, "participle");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "have");
//        } else {
//            String verb = new DatabaseHelper().getVerb(root_verb, "root");
//
//            // System.out.println(verb);
//            Model.map.put("V", verb);
//            Model.map.put("Aux", "");
//        }
//    }
//}
//
//
//
