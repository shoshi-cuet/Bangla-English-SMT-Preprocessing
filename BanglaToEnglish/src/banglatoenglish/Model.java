/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banglatoenglish;


import java.util.HashMap;

/**
 *
 * @author user
 */
public class Model {
    
    public static HashMap<String,String> map=new HashMap<>();
    
    public   HashMap<String,String> tense=new HashMap<>();
    
 

    
   
    public  String Tense(String Biv){
    
        tense.put("য়", "11");
        tense.put("ে", "11");
        tense.put("ই", "11");
        tense.put("চ্ছে", "12");
        tense.put("চ্ছি", "12");
        tense.put("চ্ছি", "12");
        tense.put("ছে","13");
        tense.put("ল","21");
        tense.put("য়াছি", "13");
        tense.put("য়াছে", "13");
        tense.put("য়েছিল", "21");
        tense.put("েছিল", "21");
        tense.put("ছিলাম", "22");
        tense.put("ছিলেন", "22");
        tense.put("চ্ছেছিল", "22");
        tense.put("চ্ছেছিলাম", "22");
        tense.put("য়াছিলাম", "23");
        tense.put("য়াছিল", "23");
        tense.put("ব", "3");
        tense.put("বে", "3");
                      
        
        
        
        return tense.get(Biv);
       
    }
    
    
   
    
    
}
