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
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        String strSequence1 = "g,a,a,t,t,c,a,g,t,t,a";
        String strSequence2 = "g,g,a,t,c,g,a";
//        String strSequence1 = "g,a,a,t,t,c,a,g,t,t,a,c,g,t,a,t,a,c,a,g,a";
//        String strSequence2 = "g,g,a,t,c,g,a,c,c,a,t,t,c,g,c,a,c,g,t,t,a";        
        
        
//        String strSequence1 = "";
//        String strSequence2 = "";        
        
//        //The user inserts the first sequence
//        System.out.println("Enter sequence 1");
//        //We get the first sequence
//        strSequence1 = input.next();
//        
//        //The user inserts the second sequence
//        System.out.println("Enter sequence 2");
//        //We get the first sequence
//        strSequence2 = input.next();

        //We print both sequences
        System.out.println();
        System.out.println("Sequences");
        System.out.println("---------");        
        System.out.println("Sequence 1: " + strSequence1);
        System.out.println("Sequence 2: " + strSequence2);        
        
        //We create the matrix
        MatrixPP mpp = new MatrixPP(strSequence1, strSequence2);
        
    }//End public static void main(String[] args)
}//End public class CB_Homework1
