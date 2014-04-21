/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb_homework2;

import java.util.ArrayList;

/**
 *
 * @author Otto
 */
public class Sequence implements Comparable<Sequence>{
    
    private String name;
    private String sequence;
    private ArrayList<Alignment> alignment;
    private int score;

    Sequence(String name, String sequence) {
        
        this.name = name;
        this.sequence = sequence;
        this.alignment = new ArrayList();
        this.score = 0;
        
    }//End Sequence(String name, String sequence)

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sequence
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
                
    @Override
    public String toString(){
    
        return this.name + "Score = " + this.score;
    
    }//End public String toString()

    /**
     * @return the alignment
     */
    public ArrayList<Alignment> getAlignment() {
        return alignment;
    }

    /**
     * @param alignment the alignment to set
     */
    public void setAlignment(ArrayList<Alignment> alignment) {
        this.alignment = alignment;
    }

    @Override
    public int compareTo(Sequence t) {
        
        return Integer.compare(this.score, t.getScore());
                
    }//End public int compareTo(Sequence t)

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    public void calculateScore(){
    
        int totalScore;
        totalScore = 0;
        
        for (Alignment alig : this.alignment) {
            
            totalScore += alig.getScore();
            
        }//End for (Alignment alig : this.alignment)
        
        this.score = totalScore;
        
    }//End public int calculateScore()
    
    
}//End public class Sequence
