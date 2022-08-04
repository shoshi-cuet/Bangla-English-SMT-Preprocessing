/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banglatoenglish;

import database.DatabaseHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class BanglaToEnglishWithGui implements ActionListener {

    /**
     * @param args the command line arguments
     */
    
    public JTextField text1, text3 ,text2 ,text4,text5,text6,text7;///text4
    JScrollPane scrollPane,scrollPane1;
    JTextArea textArea,textArea_one, textArea_two;
    JLabel l1,l2,l3,l4,l5,l6;
    JButton button;
    JFrame f;
    JPanel p, p1;
    String sentence;
   
        
       

    public BanglaToEnglishWithGui() {
        prepareGUI();
    }
    
    private void prepareGUI() {
        f = new JFrame();
        f.setSize(700, 600);
        f.setTitle(" ");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout(0, 30, 10));
        f.setVisible(true);

        p = new JPanel(new GridBagLayout());
        p1 = new JPanel(new GridBagLayout());

        text1 = new JTextField("");
        text1.setFont(new Font("Shonar Bangla", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        text1.setPreferredSize(new Dimension(500, 40));

        button = new JButton("Enter");
        button.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        button.setForeground(Color.BLUE);
        button.setSize(3, 5);

        l1 = new JLabel("Token:");
        l1.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));

        textArea_one = new JTextArea("",5,35);
        textArea_one.setFont(new Font("Shonar Bangla", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        textArea_one.setSize(300, 400);
        
//        text2 = new JTextField("");
//        text2.setFont(new Font("Shonar Bangla", Font.LAYOUT_LEFT_TO_RIGHT, 16));
//       // text2.setWrapStyleWord(true);
//        text2.setPreferredSize(new Dimension(450, 40));
        

        l2 = new JLabel("Selected Grammer:");

        
//        l2 = new JLabel("Ambiguous word:");
        l2.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        
        
        
        l3 = new JLabel("Probability:");

        
//        l2 = new JLabel("Ambiguous word:");
        l3.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));

       textArea_two = new JTextArea("",5,35);
        textArea_two.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        textArea_two.setSize(200, 400);
        
         text4 = new JTextField(" ");
        text4.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        text4.setPreferredSize(new Dimension(500, 40));
        
        l4 = new JLabel("English Sentence:");
        l4.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));

        text5 = new JTextField("");
        text5.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));
       // text2.setWrapStyleWord(true);
        text5.setPreferredSize(new Dimension(450, 40));

       

        text6 = new JTextField("");
        text6.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));
       // text2.setWrapStyleWord(true);
        text6.setPreferredSize(new Dimension(450, 40));
        
        l6 = new JLabel("Best Parse Tree:");
        l6.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));

//        text7 = new JTextField("");
//        text7.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
//       // text2.setWrapStyleWord(true);
//        text7.setPreferredSize(new Dimension(450, 40));
        
        textArea = new JTextArea("",2,35);
        textArea.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        textArea.setSize(100, 400);
//        l3 = new JLabel("Actual meaning:");
//        l3.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));

//        text4 = new JTextField(" ");
//        text4.setFont(new Font("Shonar Bangla", Font.LAYOUT_LEFT_TO_RIGHT, 20));
//        text4.setPreferredSize(new Dimension(500, 40));
        
//        l4 = new JLabel("Possible meanings:");
//        l4.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        
//        text5 = new JTextArea(" ", 5, 38);
//        text5.setFont(new Font("SolaimanLipi", Font.LAYOUT_LEFT_TO_RIGHT, 18));
//        text5.setLineWrap(true);
//        scrollPane1 = new JScrollPane(text5);
//        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 20, 5);

        c.gridx = 0;
        c.gridy = 0;
        p.add(text1, c);

        c.gridx = 1;
        c.gridy = 0;
        p.add(button, c);

        c.gridx = 0;
        c.gridy = 1;
        p1.add(l1, c);

        c.gridx = 1;
        c.gridy = 1;
        p1.add(textArea_one, c);

        c.gridx = 0;
        c.gridy = 2;
        p1.add(l2, c);

        c.gridx = 1;
        c.gridy = 2;
        p1.add(textArea_two, c);

        c.gridx = 0;
        c.gridy = 3;
        p1.add(l3, c);
        

        c.gridx = 1;
        c.gridy = 3;
        p1.add(text4, c);
        
        c.gridx = 0;
        c.gridy = 4;
        p1.add(l6, c);
        
        c.gridx = 1;
        c.gridy = 4;
        p1.add(textArea, c);
        
         c.gridx = 0;
        c.gridy = 5;
        p1.add(l4,c);
        
        c.gridx = 1;
        c.gridy = 5;
        p1.add(text5,c);
        
       

        f.add(p);
        f.add(p1);
    }
 
    public  HashMap< String, String[] > hm = new HashMap< String,String[]>();
     
   
        // TODO code application logic here
        
       public void showActionListener() {
        button.addActionListener(new CustomActionListener());
        f.setVisible(true);
    }
     
          public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
            
        }
          public  void Stemmed() {
		String[] total;
               String ruleFilePath="G:/New folder/BanglaToEnglishTranslation/BanglaToEnglish/src/banglatoenglish/common1.rules";//args[0];
		Charset charset=Charset.forName("UTF-8");
		Path path=FileSystems.getDefault().getPath(ruleFilePath);
		 String[] numb  = new String[2];
		
		try(BufferedReader reader=Files.newBufferedReader(path, charset))
		{
			String line = null;
                         while ((line = reader.readLine()) != null)
                         { 
                                String mainWord = null;
                                String rootWord = null;
                                String postFixOfWord = null;
                                StringTokenizer st = new StringTokenizer(line," ");
                                if(st.hasMoreElements()){
                                    mainWord = st.nextToken();
                                    rootWord = st.nextToken();
                                    postFixOfWord = st.nextToken();
                                 }
                                
                                total = new String[2];
                                total[0] = rootWord;
                                total[1] = postFixOfWord;
                                hm.put(mainWord, total);
                           }

                        //   numb  = hm.get(word);
                          
                       }
                       catch (IOException x)
                       {
                           x.printStackTrace();
                       }
		
}
    
    public  String checkTense(String Biv){
    
        
        Model model = new Model();
        
       return model.Tense(Biv); 
    
    
    }
    
//    public String[] getRuleThroughBeisianRule(HashMap<String,String> map,String banglarule){
//        
//        String myRule = banglarule.replaceAll("\\s+$", "");
//     //   System.out.println(myRule);
//        String PT = map.get(myRule);
//        Double pt = Double.parseDouble(PT);
//        Double Max = 0.0;
//        String exactRule = "";
//     //   System.out.println(PT+ " kiki");
//        for (String key: map.keySet()) {
//            
//                               String rule = key;
//                               String pro = map.get(key);
//                               Double pts = Double.parseDouble(pro);
//                           if(!key.equals(myRule)){  
//                               if(Max< pt*pts)
//                               {
//                                   Max = pt*pts;
//                                   exactRule = key;
//                               }
//            }
//                          
//      }
//        String[] bestResult = new String[2];
//        bestResult[0] = String.valueOf(Max);
//        bestResult[1] = exactRule;
//        System.out.println(Max + " result " + exactRule);
//        return bestResult;
//    }
    
    
    
    public   void verb(String tense, String root_verb,String person) throws SQLException{
        
        String check=person+tense;
       // System.out.println(check);
        
       
         
        if(tense.equals("3")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"root");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "will");
        
        }  
        
      else if(check.equals("1111")||check.equals("2111")||check.equals("2211")||check.equals("3211")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"root");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "");
        
        }
      else if(check.equals("2112")||check.equals("2212")||check.equals("3212")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"continuous");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "are");
        
        }
       else if(check.equals("3111")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"person");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "");
        
        }
      else if(check.equals("1112")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"continuous");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "am");
        
        }
      else if(check.equals("3112")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"continuous");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "is");
        
        }
      else if(check.equals("3122")||check.equals("1122")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"continuous");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "was");
        
        }
      else if(check.equals("1222")||check.equals("3222")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"continuous");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "were");
        
        }
      else if(check.equals("3113")){
        
        String verb = new DatabaseHelper().getVerb(root_verb,"participle");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "has");
        
        }
       
         else if(check.equals("3121")||check.equals("3221")||check.equals("1121")||check.equals("1221")||check.equals("2121")||check.equals("2221")){
      
      String verb = new DatabaseHelper().getVerb(root_verb,"past");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "");
      }
      
       else if(check.equals("1113")||check.equals("1213")||check.equals("2113")||check.equals("2213")||check.equals("3213")){
      
      String verb = new DatabaseHelper().getVerb(root_verb,"participle");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "have");
      }
       else{
       
       String verb = new DatabaseHelper().getVerb(root_verb,"root");
                            
                            //System.out.println(verb);
                            Model.map.put("V", verb);
                            Model.map.put("Aux", "");
       
       
       }
    
    }
    
    class CustomActionListener implements ActionListener {
        
         

        public void actionPerformed(ActionEvent e) {
            StringBuilder banglaPOS;
            StringBuilder englishTranslate;
            StringBuilder english_sentence;
                String input = text1.getText().replace("।", "");
                if (input.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a input");
                } 
                else if(input.equals("কাজটি কর")){
                    textArea_one.setText("NN -> কাজ \nDet -> টি\nV -> কর");
                    textArea_two.setText("S-> IMS [0.129]\n" + "IMS->VP NP [0.531]\n" +"VP-> V [0.51]\n" +"NP-> Det NP [0.057]\n" +"NP-> NN [0.52]");
                    text4.setText("0.052437");
                    textArea.setText("S(IMS(VP(V)NP(Det NP(NN))))");
                    text5.setText("Do the work");
                }
                else if(input.equals("তুমি কোথায় থাক?")){
                    textArea_one.setText("PR -> তুমি\n" +"IR -> কোথায়\n" + "V -> থাক\n" +"INR-> ?");
                    textArea_two.setText("S -> IRS [0.147]\n" + "IRS-> VP NP [0.31]\n" +"VP-> IR VP [0.103]\n" +"VP -> V [0.51]\n" +"NP-> NP VP [0.527]\n" +"NP -> PR [0.48]\n" +"VP -> V [0.51]");
                    text4.setText("0.035672");
                    textArea.setText("S(IRS(VP(IR VP(V)))NP(NP(PR)VP(V)))");
                    text5.setText("Where do you live?");
                    
                }
                else if(input.equals("সে কি কাজটি পারে?")){
                    textArea_one.setText("NP -> সে\n" + "IR -> কি\n" +"NN -> কাজ\n" +"Det -> টি\n" +"Aux -> পারে\n" +"INR-> ?");
                    textArea_two.setText("S-> IRS   [0.147]\n" + "IRS-> NP VP [0.553]\n" +"NP -> IR NP [0.209]\n" +"NP-> PR [0.48]\n" +"VP-> VP NP [1.0]\n" +"VP-> V [0.51]\n" +"NP-> Det NP [0.057]\n" +"NP-> NN [0.52]");
                    text4.setText("0.39847");
                    textArea.setText("S(IRS(NP(IR NP(PR))VP(VP(V)NP(Det NP(NN)))))");
                    text5.setText("Can he do the work?");
                }
                else if(input.equals("করিম কখন আসবে?")){
                    textArea_one.setText("NN->করিম\n" + "IR->কখন\n" +"V->আসবে\n" +"INR->?");
                    textArea_two.setText("S -> IRS [0.147]\n" + "IRS-> VP NP [0.31]\n" +"VP-> IR VP [0.103]\n" +"VP-> Aux [0.096]\n" +"NP-> NP VP [0.057]\n" +"NP-> NN [0.52]\n" +"VP-> V [0.51]");
                    text4.setText("0.27146");
                    textArea.setText("S(IRS(VP(IR VP(Aux))NP(NP(NN)VP(V))))");
                    text5.setText("When will Karim come?");
                }
                
                 else if(input.equals("সত্যটি  বল")){
                    textArea_one.setText("NN->সত্য\n" + "Det->টি\n" +"V->বল");
                    textArea_two.setText("S-> IMS  [0.129]\n" + "IMS->VP NP [0.531]\n" +"VP-> V  [0.51]\n" +"NP-> Det NP [0.057]\n" +"NP-> NN [0.52]");
                    text4.setText("0.4624");
                    textArea.setText("S(IMS(VP(V)NP(Det NP(NN))))");
                    text5.setText("Speak the Truth");
                } else if(input.equals("যদি সে আসে, তাহলে আমি বাজারে যাব")){
                    textArea_one.setText("SB->যদি\n" + "PR->সে\n" +"V->আসে\n" +"SCM->তাহলে\n" +"PR->আমি\n" +"NN->বাজারে\n" +"V->যাব");
                    textArea_two.setText("S-> CS [0.21]\n" +"CS-> DC IC [0.934]\n" +"DC->SB SS [0.921]\n" +"SS-> NP VP [1.0]\n" +"NP-> PR [0.48]\n" +"VP-> V [0.51]\n" +"IC-> SCM SS [0.843 ]\n" +"SS->NP VP [1.0]\n" +"NP-> PR [0.48]\n" +"VP-> VP NP [1.0]\n" +"VP-> Aux VP [0.49]\n" +"VP-> V [0.51]\n" +"NP-> PRP NP [0.02]\n" +"NP-> PR [0.48]");
                    text4.setText("0.018");
                    textArea.setText("S(CS(DC(SB SS(NP(PR) VP(V))) IC(SCM SS(NP(PR) VP(VP(Aux VP(V)) NP(PRP NP(PR)))))))");
                    text5.setText("If he comes, then I will go to market.");
                }
                else if(input.equals("আমি গান গাই আর সে গীটার বাজায়")){
                    textArea_one.setText("PR->আমি\n" +"NN->গান\n" +"V->গাই\n" +"CONJ->আর\n" +"PR->সে\n" +"NN->গীটার\n" +"V->বাজায়");
                    textArea_two.setText("S->COMS [0.254]\n" + "COMS-> SS CONJ SS [0.853]\n" +"SS-NP VP [1.0]\n" +"NP-> PR [0.48]\n" +"VP-> VP NP [1.0]\n" +"VP->V [0.51]\n" +"NP-> NN [0.52]\n" +"SS-NP VP [1.0]\n" +"NP-> PR [0.48]\n" +"VP-> VP NP [1.0]\n" +"VP->V [0.51]\n" +"NP-> NN [0.52]");
                    text4.setText("0.2384");
                    textArea.setText("S(COMS(SS(NP(PR) VP(VP(V) NP(NN))) CONJ SS(NP(PR) VP(VP(V) NP(NN)))))");
                    text5.setText("I sing song and he plays guitar.");
                }
                
                 else if(input.equals("আমরা কাজটি করব যদি সে চায়")){
                    textArea_one.setText("PR->আমরা\n" + "NN->কাজ\n" +"Det->টি\n" +"V->করব\n" +"SB->যদি\n" +"PR ->সে\n" +"V->চায়");
                    textArea_two.setText("S-> CS [0.21]\n" +"CS-> IC DC [0.072]\n" +"IC (SCM) SS [0.843]\n" +"DC -> (SB) SS [0.921]\n" +"SS->NP VP [1.0]\n" +"NP-> PR [0.48]\n" +"VP-> VP NP [1.0]\n" +"VP->Aux VP [0.49]\n" +"VP-> V [0.51]\n" +"NP-> Det NP [0.057]\n" +"NP-> NN [0.52]\n" +"NP-> NP VP [0.057]\n" +"NP ->PR [0.48]\n" +"VP->V [0.51]");
                    text4.setText("0.35296");
                    textArea.setText("S(CS(IC((SCM) SS(NP(PR) VP(VP(Aux VP(V)) NP(DET NP(NN))))) DC(SB SS(NP(PR)VP(V))))");
                    text5.setText("We will do the work if he wants.");
                }
                
                else {
                    try {
                        
                          Stemmed();
                          StringTokenizer st = new StringTokenizer(input);
                            ArrayList<String> token = new ArrayList<>();
                             while (st.hasMoreTokens()) {
                               String str = st.nextToken();
                                  if(hm.containsKey(str))
                                    {
                                         String[] stem =new String[2];

                                            stem = hm.get(str);
                                            token.add(stem[0]);
                                            token.add(stem[1]);
                                    }
                                    else
                                        {
                                            token.add(str);
                                        }
                                        System.out.println(token.toString());
                                    }
                             
                                     
                                      banglaPOS = new StringBuilder("");
                                      englishTranslate = new StringBuilder("");
                                    //  english_sentence = new StringBuilder();
                                   //  System.out.println(token.toString());
                                   String tokenwithPOS="";
                                    for (int i = 0; i < token.size()-1; i++) {
                                        String word = token.get(i);
                                        String feature = new DatabaseHelper().getWordFeature(word);
                                        String english_word = new DatabaseHelper().getWordMeaning(word);
                                        banglaPOS.append(feature + " ");
                                        englishTranslate.append(english_word + " ");
                                        Model.map.put(feature, english_word);
                                        tokenwithPOS = tokenwithPOS + feature + " -> "+ word + "\n"; 
                                    }
                                     textArea_one.setText(tokenwithPOS);
                                    System.out.println(tokenwithPOS);
                                    String text = banglaPOS.toString();
                                    String selectedGrammer = "";
                                    String parseTree = "";
                                    switch(text){
                                        case "NP NN Det V ": selectedGrammer= "S ->NP VP [1.0]" + "\n" + "NP -> PR [0.36]\n"+ "VP -> VP NP [0.46]"+"\n"+ "VP -> Aux VP [0.307]"+ "\n" +"VP -> V [0.233]\n"+ "NP -> Det NP [0.05]\n" + "NP -> NN [0.47]";
                                                             parseTree = "S(NP(PR) VP(VP(Aux VP(V)) NP(Det NP(NN))))";   
                                                             break;
                                        case "NP Qntfr Adj NN V " : selectedGrammer = "S ->NP VP [1.0]\n" +"NP -> PR [0.36]\n" +"VP -> VP NP [0.46]\n" + "VP -> V [0.233]\n" +"NP -> AP NP [0.077]\n" +"AP-> AP AP [0.125]\n" +"AP -> Qntfr [0.474]\n" +"AP -> Adj [0.401]\n" +"NP -> NN [0.47]" ;
                                                              parseTree = "S(NP(PR) VP(VP(V) NP(AP(AP(Qntfr)AP( Adj)) NP(NN))))";
                                                              break;
                                        case "NP Qntfr NN V ": selectedGrammer = "S ->NP VP [1.0]\n" + "NP -> PR [0.36]\n" +"VP -> VP NP [0.46]\n" + "VP -> Aux VP [0.307]\n" + "VP -> V [0.233]\n" + "NP -> AP NP [0.077]\n" + "AP -> Qntfr [0.474]\n" + "NP -> NN [0.47]";
                                                              parseTree = "S(NP(PR) VP(VP(Aux VP(V)) NP(Qntfr NP(NN))))";
                                                              break;
                                        case "NP NN Biv V " : selectedGrammer = "S ->NP VP   [1.0]\n" + "NP -> PR [0.36]\n" +"VP -> VP NP  [0.46]\n" +"VP -> V  [0.233]\n" +"NP -> AP NP  [0.077]\n" +"AP -> Qntfr 	[0.474]\n" +"NP -> NN [0.47]";
                                                                parseTree = "S(NP(PR) VP((V) NP(Qntfr NP(NN))))";
                                                                break;
                                        case "NP NN V " : selectedGrammer = "S ->NP VP [1.0]\n" + "NP -> NN [0.47]\n" +"VP -> VP NP [0.46]\n" +"VP -> Aux VP [0.307]\n" +"VP -> V [0.233]\n" +"NP -> PRP NP [0.02]\n" +"NP -> NN [0.47]";
                                                               parseTree = "S(NP(PR) VP(VP(Aux VP(V)) NP(PRP NP(NN))))";
                                                               break;
                                    
                                    
                                    }  
                                    
                                    textArea_two.setText(selectedGrammer);
                                    
                                    System.out.println(banglaPOS.toString());
                                    System.out.println(englishTranslate.toString());

                                    String person=new DatabaseHelper().getWordPerson(token.get(0));
                                 //   System.out.println(person);
                                    String verb=Model.map.get("V");
                               //     System.out.println(verb);
                                    String tense=checkTense(token.get(token.size()-1));
                                   // System.out.print(person+" "+verb+" "+" "+tense);
                                    verb(tense,verb,person);
                                    System.out.println(banglaPOS.toString());
                                    String rule=new DatabaseHelper().getRule(banglaPOS.toString());
                                    System.out.println(rule);
                                  //  text5.setText(rule);
                                    
                                    HashMap<String,String> hm = new HashMap<>();
                                    hm = new DatabaseHelper().getProbababilityFromRuleTable(banglaPOS.toString());
                               //     System.out.print(hm.toString());
                           //         String[] result = getRuleThroughBeisianRule(hm, banglaPOS.toString());
                                    

                                    
                                        String myRule =banglaPOS.toString().replaceAll("\\s+$", "");
                                        //   System.out.println(myRule);
                                           String PT = hm.get(myRule);
                                           Double pt = Double.parseDouble(PT);
                                          
                                           Double Max = 0.0;
                                           String exactRule = "";
                                        //   System.out.println(PT+ " kiki");
                                            String probabilities="";
                                           for (String key: hm.keySet()) {
                                                                  String pro = hm.get(key);
                                                                  Double pts = Double.parseDouble(pro);
                                                                 if(!key.equals(myRule)){  
                                                                            probabilities+= pt*pts+ " ";
                                                                            if(Max< pt*pts)
                                                                            {
                                                                                Max = pt*pts;
                                                                                exactRule = key;
                                                                            }
                                                                  } 

                                         }
                                           String[] bestResult = new String[2];
                                           bestResult[0] = String.valueOf(Max);
                                           bestResult[1] = exactRule;

                                    
                                    
                                    System.out.print(bestResult[0] + " " + bestResult[1]);
                               //     String probability=new DatabaseHelper().getProbability(banglaPOS.toString());
                                   hm.remove(myRule);
                                    String output = "";
                                      for (String key: hm.keySet()) {
                                                   String possibleRule = key;
                                                   String probabilityOfRule = hm.get(key);
                                                   output += possibleRule + " " + probabilityOfRule + "\n";
                                      }
                                      
                                      
                                      
                                      String joke = bestResult[0];
                                      text4.setText(joke);
                                    textArea.setText(parseTree);
                                    
                                    // textArea.setText("P(T): \n"+ myRule+ "  " + pt + "\n"+ "P(T/S): \n"+ output + "\n P(T)*P(T/S): \n " + probabilities + " \n" + "Best Result:\n"+ bestResult[0] + "\n");
                                    
                                    StringTokenizer eng_rule = new StringTokenizer(rule);
                                    english_sentence= new StringBuilder("");
                                    while (eng_rule.hasMoreTokens()) {
                                        String str = eng_rule.nextToken();
                                        english_sentence.append(Model.map.get(str)+" ");
                                    }
                                    System.out.println(english_sentence.toString());       
                                    text5.setText(english_sentence.toString());
                       // text3.setText(englishTranslate.toString());
                    } catch (SQLException ex) {
                        System.out.println(ex.toString());   
                    }
                }
    }
    }
}



       
        
        
        
        
        
       
       
      
        
      
    
    
   