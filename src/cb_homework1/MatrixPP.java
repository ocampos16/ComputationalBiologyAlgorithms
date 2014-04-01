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
    int gapPenalty = -2;
    int misMatchGood = 2;
    int misMatchBad = -1;
    
    //Final Alignment
    ArrayList<Alignment> finalAlignment;
            
    public MatrixPP(){
        
        //Determine finalAlignment1 length
        
        
    }//End public MatrixPP()

    public MatrixPP(String seq1, String seq2){

        seq1 = seq1.toLowerCase();
        this.sequence1 = seq1.split(",");        
        seq2 = seq2.toLowerCase();
        this.sequence2 = seq2.split(",");
        
        //We initialize the matrix
        this.matrix = new int[seq2.length()+1][seq1.length()+1];
                
        this.fillMatrixWithCeros();
        
        this.calculateMaximum();                
        
        System.out.println();
        //System.out.println(mpp.toString());
        this.printMatrix();
        
        this.traceBack();
        
        this.printFinalAlignment();
        
    }//End public MatrixPP(String seq1, String seq2)
        
    private void fillMatrixWithCeros(){
    
        for (int i = 0; i < this.sequence2.length+1; i++) {
            for (int j = 0; j < this.sequence1.length+1; j++) {
                this.matrix[i][j] = 0;
            }//End for (int j = 0; j < this.sequence2.length+1; j++)
        }//End for (int i = 0; i < this.sequence1.length+1; i++)        
    
    }//End private void fillMatrixWithCeros()
          
    private void calculateMaximum(){
    
        for (int i = 1; i <= this.sequence2.length; i++) {
            for (int j = 1; j <= this.sequence1.length; j++) {
                
                    int num1 = this.matrix[i-1][j-1];
                    int sMatch;
                    
                    if ( this.sequence1[j-1].equals(this.sequence2[i-1]) )
                        sMatch = this.misMatchGood;
                    else
                        sMatch = this.misMatchBad;
                
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
        
    private void traceBack(){
    
        //We reverse the sequences
        //Initialize finalAlignment1        
        ArrayList<String> alignment1;
        alignment1 = new ArrayList();
        for (int i = this.sequence1.length - 1; i >= 0; i--) {
            alignment1.add(this.sequence1[i]);
        }//End for (int i = this.sequence1.length - 1; i >= 0; i--)

        //Initialize finalAlignment2
        ArrayList<String> alignment2;
        alignment2 = new ArrayList();
        for (int i = this.sequence2.length - 1; i >= 0; i--) {
            alignment2.add(this.sequence2[i]);
        }//End for (int i = this.sequence1.length - 1; i >= 0; i--)           
                                     
        //1 Dimension Array that will keep track of the current cell [i,j]
        //We will initialize it with the cell of the bottom right corner
        int i = this.sequence2.length; 
        int j = this.sequence1.length;
        int[] tempCell = {i, j};
    
        //We initialize the arraylist that will contain the final alignments
        finalAlignment  = new ArrayList();
        
        while( (!alignment1.isEmpty()) || (!alignment2.isEmpty()) ){
        
            int tempValueDiagonal;
            int tempValueTop;
            int tempValueLeft;
            
            //Diagonal
            int tempIDiagonal = tempCell[0] - 1;
            int tempJDiagonal = tempCell[1] - 1;
            //We determine the value of the diagonal
            if ( alignment1.get(0).equals(alignment2.get(0))){
                tempValueDiagonal = this.matrix[tempIDiagonal][tempJDiagonal] + this.misMatchGood;
            }//End if ( alignment1.get(0).equals(alignment2.get(0)))
            else {            
                tempValueDiagonal = this.matrix[tempIDiagonal][tempJDiagonal];
            }//End else
        
            //Top
            int tempITop = tempCell[0] - 1;
            int tempJTop = tempCell[1];
            //We determine the value of the diagonal
            tempValueTop = this.matrix[tempITop][tempJTop] + this.gapPenalty;
            
            //Left
            int tempILeft = tempCell[0];
            int tempJLeft = tempCell[1] - 1;
            //We determine the value of the diagonal
            tempValueLeft = this.matrix[tempILeft][tempJLeft] + this.gapPenalty;                                    
            
            //We add the alignment to the final alignment set "Answer"
            Alignment alig = (getMaxAlignment(tempValueDiagonal, tempValueLeft, tempValueTop, alignment1, alignment2));
            
            //We now determine where to position our tempCell
            switch(alig.getDescription()){
            
                case "Diagonal":
                    tempCell[0] = tempIDiagonal;
                    tempCell[1] = tempJDiagonal;
                    break;
                    
                case "Left":
                    tempCell[0] = tempILeft;
                    tempCell[1] = tempJLeft;
                    break;

                case "Top":
                    tempCell[0] = tempITop;
                    tempCell[1] = tempJTop;                    
                    break;

                default:
                    break;
                    
            }//End switch(alig.getDescription())
            
            //Now we add alig to the final answer finalalignment
            this.finalAlignment.add(alig);
            
        }//End ( (!alignment1.isEmpty()) || (!alignment2.isEmpty()) )
                
        Collections.reverse(this.finalAlignment);
        
    }//End traceBack()
    
    public Alignment getMaxAlignment(int tempValueDiagonal, int tempValueLeft, int tempValueTop, ArrayList<String> alignment1, ArrayList<String> alignment2){
    
            //We initialize an alignment
            Alignment alig = new Alignment();
            //We determine the largest of them, if equal we priorize diagonal, left and top in that order
            if ( (tempValueDiagonal >= tempValueLeft) && (tempValueDiagonal >= tempValueTop) ){
            
                //We add the values to the alignment
                alig.setSequence1Char(alignment1.remove(0));
                alig.setAlignmentType("|");
                alig.setSequence2Char(alignment2.remove(0));
                alig.setDescription("Diagonal");
                
                return alig;
            
            }//End if ( tempValueDiagonal >= tempValueLeft )
            //Left
            if ((tempValueLeft >= tempValueTop) || (tempValueLeft >= tempValueDiagonal)){
            
                //We add the values to the alignment
                alig.setSequence1Char(alignment1.remove(0));
                alig.setAlignmentType(" ");
                alig.setSequence2Char("_");
                alig.setDescription("Left");
                
                return alig;            
                
            }//End else if (tempValueLeft >= tempValueTop)
            //Top
            if ((tempValueTop >= tempValueLeft) || (tempValueTop >= tempValueDiagonal)) {
            
                alig.setSequence1Char("_");
                alig.setAlignmentType(" ");
                alig.setSequence2Char(alignment2.remove(0));
                alig.setDescription("Top");
                
                return alig;              
                                
            }//End else        
    
            return null;
            
    }//End public Alignment getMaxAlignment(int tempValueDiagonal, int tempValueLeft, int tempValueTop, ArrayList<String> alignment1, ArrayList<String> alignment2)
    
    private void printMatrix(){
    
        String string = "";
        
        System.out.println("------");
        System.out.println("Matrix");
        System.out.println("------");
        
        //We print the matrix
        for (int i = 0; i < this.sequence2.length+1; i++) {
            for (int j = 0; j < this.sequence1.length+1; j++) {
                //string += "["+i+"]"+"["+j+"] = "+this.matrix[i][j] + " ";
                string += this.matrix[i][j] + " ";
            }//End for (int j = 0; j < this.sequence2.length+1; j++)
            string += "\n";
        }//End for (int i = 0; i < this.sequence1.length+1; i++)              
            
        System.out.println(string);
        
    }//End public void printMatrix()
    
    private void printFinalAlignment(){
    
        String string = "";
        
        //We print the final alignment
        string += "\n";
        string += "---------------";
        string += "Final Alignment";
        string += "---------------";
        string += "\n";
        
        for (Alignment al : this.finalAlignment) {

            string += al.getSequence1Char() + " ";

        }//End  for (Alignment al : this.finalAlignment)        
        
        string += "\n";
        
        for (Alignment al : this.finalAlignment) {

            string += al.getAlignmentType()+ " ";

        }//End  for (Alignment al : this.finalAlignment)        
        
        string += "\n"; 

        for (Alignment al : this.finalAlignment) {

            string += al.getSequence2Char()+ " ";

        }//End  for (Alignment al : this.finalAlignment)        
        
        string += "\n";
        
        System.out.println(string);
    
    }//End public void printFinalAlignment()       
    
}//End public class MatrixPP
