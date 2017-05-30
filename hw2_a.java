/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilip
 */
public class hw2_a {
  
	

	public static void summationfunc() {
		int x = 2;
		int N = 0;
		int a = 10;
		int total_sum = 0;
		int new_sum = 0;
		int count = 0;
		int avg_time = 0;
		int total_time = 0;
		
                
		for (int z = 2; z <= 6; z++) {
			N = (int) Math.pow(10, z);
			for (count = 0; count <= 10; count++) {
				long begin = System.nanoTime();
				for (int i = 0; i <= N; i++) {
					int k = 0;
					for( int j = 0; j<=i; j++){
						k *=x;
					}

					new_sum = k*a;
					total_sum += new_sum;
				}
				long end = System.nanoTime();
				long elapsed_time = (end - begin) / 1000;
				if (count > 0) {
					total_time += elapsed_time;
				}
			}
			avg_time = total_time / 10;
			System.out.println(count + " Elapsed Time = " + avg_time);
                        total_time = 0;
		}

	}
        public static void main(String[] args) {
		summationfunc();
	}

}



