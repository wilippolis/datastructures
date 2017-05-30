/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilip
 */
public class hw2_logn_fact {
    
    static long powfunc(long x, int n){
    if ( n == 0){
        return 1;
    }
    if (n ==1 ){
        return 1;
    }
    if (n%2 == 0){
        return powfunc(x*x, n/2);
    }
    else {
        return powfunc(x*x, n/2) * x;
    }
    
    }
    
    static int powersumfunc(int a, int x, int n){
        int powerSum = 0;
        for(int N = 0; N <= n; N++){
            powerSum +=(powfunc(x,N));
        }
        powerSum *= a;
        return powerSum;
    }
    
    static double test(int a, int x, int n){
        long average_time = 0;
        int iters = 10;
for(int i = 0; i<=iters; i++){
    long begin = System.nanoTime();
    int ps = powersumfunc(10,2,n);
    long end = System.nanoTime();
    long elapsed_time = (end - begin) / 1000;
    if (i ==0){
        continue;
    }
    average_time += elapsed_time;
}        return average_time;
    }
    
    public static void main(String[] args){
        System.out.println(test(10,2,100));
        for(int i = 1000; i <= 10000000; i *= 10){
            System.out.println(test(10,2,i));
        } 
    }
}
//    public static void answer() {
//		int x = 2;
//		int N = 0;
//		int a = 10;
//		int total_sum = 0;
//		int new_sum = 0;
//		int count = 0;
//		int average = 0;
//		int total_time = 0;
//		int y = 0;
//		for (int z = 2; z <= 6; z++) {
//			N = (int) Math.pow(10, z);
//			for (count = 0; count <= 10; count++) {
//				long begin = System.nanoTime();
//				for (int i = 0; i <= N; i++) {
//					int term = 0;
//					for( int j = 0; j<=i; j++){
//						if (N == 0)
//                                                    return 1;
//                                                if ( N == 1)
//                                                    return 1;
//                                                if ( N % )
//					}
//
//					new_sum = term*a;
//					total_sum += new_sum;
//				}
//				long end = System.nanoTime();
//				long elapsed_time = (end - begin) / 1000;
//				if (count > 0) {
//					total_time += elapsed_time;
//				}
//
//				System.out.println(count + " Elapsed Time:" + elapsed_time);
//				// System.out.println(count + " Total Time:" + total_time);
//
//			}
//
//			average = total_time / 10;
//			total_time = 0;
//			System.out.println("Average for: N = " + N + " is " + average + " microseconds");
//
//		}
//
//	}
//        
//        public static void main(String[] args) {
//		answer();
//	}
//
//}
//
//// } 
//
