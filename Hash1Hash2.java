/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilip
 */
public class Hash1Hash2 {

    private static long start;
    private static long end;
    private static long total;

    static void startTimer() {
        start = System.nanoTime();

    }

    static long endTimer() {
        total = 0;
        end = System.nanoTime();
        long inc = end - start;
        total += inc;
        end = 0;
        
        return total;
    }

    static int hash1(String k, int M) {
        int h = 0;
        for (int i = 0; i < k.length(); i++) {
            h = (127 * h + (int) k.charAt(i));
           
        }
        // If the hash table address K is negative, add the hash table size M
     if(h%M < 0){
              return (h%M) + M;
            }
     else{
        return h % M;
     }
    }

    static int hash2(String k, int M) {
        int h = 0;
        for (int i = 0; i < k.length(); i++) {
            h = (127 * h + (int) k.charAt(i)) % M;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println("Hashing(Full String)...\n");
        startTimer();

        for (int i = 0; i < 5; i++) {
            System.out.println("Full String Hash " + i + ": " + hash1("Saddam Hussein", 1048573));
            endTimer();
        }
        System.out.println("Runtime: " + total / 5 +"\n");
        

        System.out.println("Hashing(Incremental)...\n");

        total = 0;
        
        start = 0;
        startTimer();
        
       

        for (int i = 0; i < 5; i++) {
            System.out.println("Incremental(linear) Hash " + i + ": " + hash2("Saddam Hussein", 1048573));
            endTimer();
        }
        System.out.println("Runtime: " + total / 5);
        System.out.println(total);

    }
}
