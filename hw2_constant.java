/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.Math;

/**
 *
 * @author wilip
 */
public class hw2_constant {

    public static int sum() {
        int x = 2;
        long N = 10;
        int a = 10;
        int total_sum = 0;
        int new_sum = 0;

        
        for (int k = 0; k < 5; k++) {
            long begin = System.nanoTime();
            for (int i = 0; i <= 11; i++) {

                for (int j = 0; j <= N; j++) {
                    new_sum = a * (int) Math.pow(x, j);
                    if (i != 0) {
                        total_sum += new_sum;
                    }

                }
                //System.out.println("We've run" + i + "times!");
            } N *= 10;
        
        long end = System.nanoTime();
        long elapsed_time = ((end - begin) / 10) / 1000;
        System.out.println("Elapsed time for " + N +": " + elapsed_time);
     
        
        }return total_sum;
    }

    public static void main(String[] args) {
        sum();
    }

}
