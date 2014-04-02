/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb_homework1;

import java.util.Scanner;

/**
 *
 * @author Otto
 */
public class CB_Homework1 {

    /**
     * @param args the command line arguments
     */
    static MatrixPP mpp;
    static Scanner input;
    
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        input = new Scanner(System.in);
        
        String strSequence1 = "g,a,a,t,t,c,a,g,t,t,a";
        String strSequence2 = "g,g,a,t,c,g,a";       
        
//        String strSequence1 = "";
//        String strSequence2 = "";        
        
        System.out.println("-------------------------------------");
        System.out.println("Welcome to Needleman/Wunsch Technique");
        System.out.println("-------------------------------------");
        
        //We create an instance to matrix
        mpp = new MatrixPP();
        
        //We display the main menu
        mainMenu();
                    
    }//End public static void main(String[] args)
    
    private static void mainMenu(){
    
        int option = 0;
        
        int m = 0, mis = 0, p = 0;
        String temp, sq1, sq2;
        
        while ( option != 5 ){
        
            System.out.println("---------");
            System.out.println("Main Menu");
            System.out.println("---------");

            System.out.println("");

            System.out.println("----------");
            System.out.println("Properties");
            System.out.println("----------");
            System.out.println("Match Value = "+mpp.getMisMatchGood());
            System.out.println("MisMatch Value = "+mpp.getMisMatchBad());
            System.out.println("Gap Penalty = "+mpp.getGapPenalty());

            System.out.println("");

            System.out.println("--------");
            System.out.println("Options:");
            System.out.println("--------");
            System.out.println("1. Modify Match Value.");
            System.out.println("2. Modify MisMatch Value.");
            System.out.println("3. Modify Gap Penalty.");
            System.out.println("4. Execute Algorithm.");
            System.out.println("5. Exit");            
            
            System.out.print("Enter an option: ");
            temp = input.next();
            try {

                option = Integer.parseInt(temp);

            } catch(Exception ex){

                System.out.print("ERROR: Please enter an integer.");

            }//End catch(Exception ex)
            
            switch (option){
            
                case 1:
                    System.out.print("Please enter match value (integer): ");                                       
                    temp = input.next();                  
                    
                    try {
                    
                        m = Integer.parseInt(temp);
                        mpp.setMisMatchGood(m);
                        
                    } catch(Exception ex){
                    
                        System.out.print("ERROR: Please enter an integer.");
                        
                    }//End catch(Exception ex)                    
                    break;

                case 2:
                    System.out.print("Please enter mismatch value (integer): ");                                       
                    temp = input.next();                     
                    
                    try {
                    
                        mis = Integer.parseInt(temp);
                        mpp.setMisMatchBad(mis);
                        
                    } catch(Exception ex){
                    
                        System.out.print("ERROR: Please enter an integer.");
                        
                    }//End catch(Exception ex)                         
                    break;
                    
                case 3:
                    System.out.print("Please enter a gap penalty (integer): ");                                       
                    temp = input.next();                     
                    
                    try {
                    
                        p = Integer.parseInt(temp);
                        mpp.setGapPenalty(p);
                        
                    } catch(Exception ex){
                    
                        System.out.print("ERROR: Please enter an integer.");
                        
                    }//End catch(Exception ex)                      
                    break;

                case 4:
                    
//                    System.out.print("Please enter the first sequence (EX: g,c,c,g,a,t,t,c): ");                                       
//                    sq1 = input.next();         
//                    System.out.print("Please enter the second sequence (EX: g,c,c,g,a,t,t,c): ");                                       
//                    sq2 = input.next(); 
                    
        String strSequence1 = "g,a,a,t,t,c,a,g,t,t,a";
        String strSequence2 = "g,g,a,t,c,g,a";                      
                    
                    //We execute the algorithm
                    mpp.execute(strSequence1, strSequence2);                                                           
                    
                    //We print both sequences
                    System.out.println();
                    System.out.println("---------");
                    System.out.println("Sequences");
                    System.out.println("---------");      
                    String s = "";
                    //Sequence 1
                    for (String str : mpp.sequence1) {
                        s += "," + str;
                    }//End for (String str : mpp.sequence1)
                    s = s.replaceFirst(",", "");                    
                    
                    System.out.println("Sequence 1: " + s);  

                    //Sequence 2
                    s = "";
                    for (String str : mpp.sequence2) {
                        s += "," + str;
                    }//End for (String str : mpp.sequence1)
                    s = s.replaceFirst(",", "");                    
                    
                    System.out.println("Sequence 2: " + s);                    
                    
                    break;
                    
                case 5:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Please Enter a valid option.");
                    break;
                    
            }//End switch (option)
            
        
        }//End while ( option != 5 )
        
//        //The user inserts the first sequence
//        System.out.println("Enter sequence 1");
//        //We get the first sequence
//        strSequence1 = input.next();
//        
//        //The user inserts the second sequence
//        System.out.println("Enter sequence 2");
//        //We get the first sequence
//        strSequence2 = input.next();
        
        
    }//End private static mainMenu()
    
}//End public class CB_Homework1
