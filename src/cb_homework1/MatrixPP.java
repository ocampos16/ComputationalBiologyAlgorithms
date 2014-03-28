/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb_homework1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Otto
 */
public class MatrixPP {
    
    //Variables
    String[] sequence1;
    String[] sequence2;
    int[][] matrix;
    int gapPenalty = 0;
    int misMatch = 1;
    ArrayList<String> finalAlignment1;
    ArrayList<String> finalAlignment2;
    ArrayList<String> finalAlignmentConnect;
            
    public MatrixPP(){
        
        //Determine finalAlignment1 length
        
        
    }//End public MatrixPP()

    public MatrixPP(String seq1, String seq2){

        seq1 = seq1.toLowerCase();
        this.sequence1 = seq1.split(",");        
        seq2 = seq2.toLowerCase();
        this.sequence2 = seq2.split(",");
                
        //Initialize finalAlignment1
        this.finalAlignment1 = new ArrayList<>();
        //Initialize finalAlignmentConnect
        this.finalAlignmentConnect = new ArrayList<>();
        //Initialize finalAlignment2
        this.finalAlignment2 = new ArrayList<>();
        
        this.matrix = new int[seq2.length()+1][seq1.length()+1];
                
        this.fillMatrixWithCeros();
        
        this.calculateMaximum();
        this.traceBackSequence();        
        
    }//End public MatrixPP(String seq1, String seq2)
        
    private void fillMatrixWithCeros(){
    
        for (int i = 0; i < this.sequence2.length+1; i++) {
            for (int j = 0; j < this.sequence1.length+1; j++) {
                this.matrix[i][j] = 0;
            }//End for (int j = 0; j < this.sequence2.length+1; j++)
        }//End for (int i = 0; i < this.sequence1.length+1; i++)        
    
    }//End private void fillMatrixWithCeros()
    
    @Override
    public String toString(){
    
        String string = "";
        
        //We print the matrix
        for (int i = 0; i < this.sequence2.length+1; i++) {
            for (int j = 0; j < this.sequence1.length+1; j++) {
                string += "["+i+"]"+"["+j+"] = "+this.matrix[i][j] + " ";
            }//End for (int j = 0; j < this.sequence2.length+1; j++)
            string += "\n";
        }//End for (int i = 0; i < this.sequence1.length+1; i++)                        
    
        //We print the final alignment
        string += "\n";
        string += "---------------";
        string += "Final Alignment";
        string += "---------------";
        
        Collections.reverse(this.finalAlignment1);
        Collections.reverse(this.finalAlignmentConnect);
        Collections.reverse(this.finalAlignment2);
        
        string += "\n";
        
        //Print sequence1 alignment
        for (String str : this.finalAlignment1) {
            string += " " + str + " ";
        }//End for (String str : this.finalAlignment1)
        
        string += "\n";

        //Print Connections alignment
        for (String str : this.finalAlignmentConnect) {
            string += " " + str + " ";
        }//End for (String str : this.finalAlignmentConnect)
        
        string += "\n";

        //Print Connections alignment
        for (String str : this.finalAlignment2) {
            string += " " + str + " ";
        }//End for (String str : this.finalAlignment2)
        
        return string;
        
    }//End public String toString()
    
    private void calculateMaximum(){
    
        for (int i = 1; i <= this.sequence2.length; i++) {
            for (int j = 1; j <= this.sequence1.length; j++) {
                
                    int num1 = this.matrix[i-1][j-1];
                    int sMatch;
                    
                    if ( this.sequence1[j-1].equals(this.sequence2[i-1]) )
                        sMatch = 1;
                    else
                        sMatch = 0;
                
                    num1 = num1 + sMatch;
                    
                    int num2 = this.matrix[i][j-1] + this.gapPenalty;
                    int num3 = this.matrix[i-1][j] + this.gapPenalty;                
                
                    int maximum  = Math.max(num1, num2);
                    maximum = Math.max(maximum, num3);
                    
                    //We assign the maximum
                    this.matrix[i][j] = maximum;
                    
            }//End for (int j = 0; j < this.sequence2.length+1; j++)
            
        }//End for (int i = 0; i < this.sequence1.length+1; i++)    
    
    }//End private void calculateMaximum()
        
    public void traceBackSequence(){
        
        //We position ourselves on the last cell of the array
        int tempI = this.sequence1.length;
        int tempJ = this.sequence2.length;

        //Counter for the sequences
        int counterS1 = this.sequence1.length - 1;
        int counterS2 = this.sequence2.length - 1;
        
        int tempMatchMis;                
                
        while ( (tempI > 0 ) && (tempJ > 0 )){
                                           
            System.out.println("TempI = " + tempI);
            System.out.println("TempJ = " + tempJ);
            
            int tempAnsI, tempAnsJ;
            
            //Left and Right        
//            if ( (this.matrix[tempI][tempJ - 1] + this.gapPenalty) >= 
//                 (this.matrix[tempI - 1][tempJ] + this.gapPenalty) ){
//            
//                tempAnsI = tempI;
//                tempAnsJ = tempJ - 1;
//                
//            }else {
//            
//                tempAnsI = tempI - 1;
//                tempAnsJ = tempJ;            
//            
//            }//End else
                
            if ( (this.matrix[tempI - 1][tempJ] + this.gapPenalty) >= 
                 (this.matrix[tempI][tempJ - 1] + this.gapPenalty) ){            
                
                tempAnsI = tempI - 1;
                tempAnsJ = tempJ;
                
            }else {
            
                tempAnsI = tempI;
                tempAnsJ = tempJ - 1;          
            
            }//End else            
            
            //Diagonal
            
            System.out.println("Sequence 1 = " + this.sequence1[tempI-1]);
            System.out.println("Sequence 2 = " + this.sequence2[tempJ-1]);            
                       
            
            if( this.sequence1[tempI-1].equals(this.sequence2[tempJ-1]) ){
                tempMatchMis = this.misMatch;
                System.out.println("Iguales");
            }
            else{
                tempMatchMis = 0;
                System.out.println("Non Iguales");
            }
            
            System.out.println("this.matrix[tempI - 1][tempJ - 1] = "+this.matrix[tempI - 1][tempJ - 1]);
            System.out.println("tempMatchMis = "+tempMatchMis);
            System.out.println("this.matrix[tempAnsI][tempAnsJ] = "+this.matrix[tempAnsI][tempAnsJ]);
            System.out.println("this.matrix[tempI - 1][tempJ - 1] + tempMatchMis = " + (this.matrix[tempI - 1][tempJ - 1] + tempMatchMis));
            System.out.println("this.matrix[tempAnsI][tempAnsJ] + this.gapPenalty = " + (this.matrix[tempAnsI][tempAnsJ] + this.gapPenalty));
            
            if ( (this.matrix[tempI - 1][tempJ - 1] + tempMatchMis) >= 
                 (this.matrix[tempAnsI][tempAnsJ] + this.gapPenalty) ){
                
                //We start writing our sequence
                this.finalAlignment1.add(this.sequence1[counterS1]);
                this.finalAlignmentConnect.add("|");
                this.finalAlignment2.add(this.sequence2[counterS2]);
                
                counterS1--;
                counterS2--;              
                
                tempI = tempI - 1;
                tempJ = tempJ - 1;
                
                System.out.println("Diagonal");
                
            }else {

                //Top
                if (tempAnsI != tempI ){
                
                    //We start writing our sequence
                    this.finalAlignment1.add(this.sequence1[counterS1]);
                    this.finalAlignmentConnect.add(" ");
                    this.finalAlignment2.add("_");
                    
                    counterS1--;
                    
                    tempI = tempAnsI;
                    
                    System.out.println("Top");
                
                //Bottom
                }else{

                    //We start writing our sequence
                    this.finalAlignment1.add("_");
                    this.finalAlignmentConnect.add(" ");
                    this.finalAlignment2.add(this.sequence2[counterS2]);                    
                    
                    counterS2--;
                    
                    tempJ = tempAnsJ;
                    
                    System.out.println("Bottom");
                    
                }//End else
            
                
                
            }//End else            
                                                
            System.out.println("");
            
        }//End while ( (tempI >= 0 ) && (tempJ >= 0 ))
            
    }//End public void traceBack()       
    
}//End public class MatrixPP
