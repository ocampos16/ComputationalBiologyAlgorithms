/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb_homework1;

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
    
    public MatrixPP(){
                            
    }//End public MatrixPP()

    public MatrixPP(String seq1, String seq2){

        seq1 = seq1.toLowerCase();
        this.sequence1 = seq1.split(",");        
        seq2 = seq2.toLowerCase();
        this.sequence2 = seq2.split(",");
        
        this.matrix = new int[seq2.length()+1][seq1.length()+1];
                
        this.fillMatrixWithCeros();
        
        this.calculateMaximum();
        
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
        
        for (int i = 0; i < this.sequence2.length+1; i++) {
            for (int j = 0; j < this.sequence1.length+1; j++) {
                string += this.matrix[i][j] + " ";
            }//End for (int j = 0; j < this.sequence2.length+1; j++)
            string += "\n";
        }//End for (int i = 0; i < this.sequence1.length+1; i++)                        
    
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
        
}//End public class MatrixPP
