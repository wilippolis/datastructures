/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilip
 */
public class MergeOperation {
    private static int[] input = new int[10];
    
    
    static void makeArray(){
    for (int i = 0; i < 10; i++){
    input[i] = i ;
    }
    }
    
    static void sortIt(){
        MergeSort.sort(input);
        
    }
    
    public static void main(String[] args){
        makeArray();
        sortIt();
        
    }
    
}
    
    
    
    

