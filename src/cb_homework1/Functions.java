/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cb_homework1;

/**
 *
 * @author Otto
 */
public class Functions {
 
    
    public int PermutationNonRepeat(int n, int r){
    
        int discardedNumbers = n - r;
        int ans =  n;
        
        for (int i = n-1; i > discardedNumbers; i--) {
            
            ans = ans * i;
            
        }//End for (int i = n; i >= discardedNumbers; i--)
        
        return ans;
    
    }//End public int Permutation(int n, int r)
    
    public double PermutationRepeat(int n, int r){   
        
        double ans = Math.pow(n, r);
        return ans;
    
    }//End public int Permutation(int n)    
    
}//End public class Functions
