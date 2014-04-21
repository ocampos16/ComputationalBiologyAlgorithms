/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb_homework2;

/**
 *
 * @author Otto
 */

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractListModel;

public class ListModelSequence extends AbstractListModel{

    ArrayList<Sequence> _sequence;
    
    public ListModelSequence(){    
    
    }//End public ListModelSequence()  
    
    public ListModelSequence(ArrayList<Sequence> array){
    
        this._sequence = array;
    
    }//End public ListModelSequence(ArrayList<Sequence> array)
    
    @Override
    public int getSize() {
        
        return this._sequence.size();
        
    }//End public int getSize()

    @Override
    public Object getElementAt(int i) {
        
        return (Sequence)this._sequence.get(i);
        
    }//End public Object getElementAt(int i)
    
    public ArrayList<Sequence> getSequenceList(){
        
        return this._sequence;
        
    }//End public ArrayList<Sequence> getSequenceList()
    
    public void setList(ArrayList<Sequence> array){
        
        this._sequence = array;
        
    }//End  public void setList(ArrayList<Song> array)
    
    public void getSortedList(ArrayList<Sequence> array){
        
            Collections.sort(array);
            this._sequence = array;
            
    }//End public void getSortedList(ArrayList<Sequence> array)
    
    public void sort(){
        
        Collections.sort(this._sequence);
        fireContentsChanged(this, 0, this._sequence.size());
    
    }//End public void sort()
    
}//End public class ListModelSequence
