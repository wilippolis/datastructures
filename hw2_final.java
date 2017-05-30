/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilip
 */
public class hw2_final {
    int x = 0;
    int y = x;
    public int pow(int x, int n){
        for(int i =0; i < n; n++)
            y *= x;
        
        return y;
    }
    
}
