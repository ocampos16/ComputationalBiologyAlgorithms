/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb_homework2;

/**
 *
 * @author Otto
 */
public class Sequence {
    
    private String name;
    private String sequence;

    Sequence(String name, String sequence) {
        
        this.name = name;
        this.sequence = sequence;
        
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
    
        return this.name;
    
    }//End public String toString()
    
}//End public class Sequence
