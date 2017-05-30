
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilip
 */
public class SortingPerformance {

    private static final String r_100 = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\r_100.out";
    private static final String r_1k = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\r_1k.out";
    private static final String r_10k = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\r_10k.out";
    private static final String r_100k = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\r_100k.out";
    private static final String r_1m = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\r_1m.out";

    public static String[] getFile(String file) throws FileNotFoundException, IOException {
        String[] strings = new Scanner(new File(file)).useDelimiter("\\Z").next().split("\n");

        return strings;
    }

     public static int[] converter(String[] filename) throws FileNotFoundException {
//       String[] r100str = new Scanner(new File(filename)).useDelimiter("\\Z").next().split("\n");
        int[] r100 = new int[100];
        for (int i = 0; i < 100; i++) {
            r100[i] = Integer.valueOf(filename[i].replaceAll("\\p{Cntrl}", ""));
        }
        return r100;
    }

    public static void main(String[] args) throws IOException {

        //////////////////1 HUNDRED
        long total_time = 0;

        System.out.println("For r_100.out");

        long elapsed_time = 0;
        for (int i = 0; i < 11; i++) {
            long begin = System.nanoTime();
            RadixSort.sort(converter(getFile(r_100)));

            long interval = System.nanoTime();
            long temp = interval - begin;
            if (i > 0) {
                elapsed_time += temp;
            }
            System.out.println(interval - begin);
        }

        //long end = System.nanoTime();
        long avg_time = elapsed_time / 10;
        total_time += elapsed_time;
        System.out.println("Average Radix Sort Runtime: " + avg_time);

        /////////////////////////////////////////////2
        long elapsed_time2 = 0;

        for (int i = 0; i < 11; i++) {
            long begin2 = System.nanoTime();
            InsertionSort.sort(converter(getFile(r_100)));

            long interval2 = System.nanoTime();
            long temp2 = interval2 - begin2;
            if (i > 0) {
                elapsed_time2 += temp2;
            }
            System.out.println(interval2 - begin2);
        }

        long end2 = System.nanoTime();
        long avg_time2 = elapsed_time2 / 10;
        total_time += elapsed_time2;
        System.out.println("Average Insertion Sort Runtime: " + avg_time);

        ////////////////////////////////////////////////////////////3
        long elapsed_time3 = 0;
        for (int i = 0; i < 11; i++) {
            long begin3 = System.nanoTime();

            MergeSort.sort(converter(getFile(r_100)));

            long interval3 = System.nanoTime();
            long temp3 = interval3 - begin3;

            if (i > 0) {
                elapsed_time3 += temp3;
            }
            System.out.println(interval3 - begin3);
        }

        long end3 = System.nanoTime();
        long avg_time3 = elapsed_time3 / 10;
        total_time += elapsed_time3;
        System.out.println("Average Merge Sort Runtime: " + avg_time3);

        ////////////////////////////////////////////////////////4
        long elapsed_time4 = 0;
        for (int i = 0; i < 11; i++) {
            long begin4 = System.nanoTime();

            QuickSort.sort(converter(getFile(r_100)));

            long interval4 = System.nanoTime();
            long temp4 = interval4 - begin4;
            if (i > 0) {
                elapsed_time4 += temp4;
            }
            System.out.println(interval4 - begin4);
        }

        long end4 = System.nanoTime();
        long avg_time4 = elapsed_time4 / 10;
        total_time += elapsed_time4;

        System.out.println("Average Quick Sort Runtime: " + avg_time4);
        System.out.println("Total Time: " + total_time);
        System.out.println(" ");

        //////////////////////////////////1 THOUSAND
        System.out.println("For r_1k.out");

        long elapsed_time_1k_1 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1k_1 = System.nanoTime();

            RadixSort.sort(converter(getFile(r_1k)));

            long interval_1k_1 = System.nanoTime();
            long temp_1k_1 = interval_1k_1 - begin_1k_1;

            if (i > 0) {
                elapsed_time_1k_1 += temp_1k_1;
            }
            System.out.println(interval_1k_1 - begin_1k_1);
        }

        long end_1k_1 = System.nanoTime();
        long avg_time_1k_1 = elapsed_time_1k_1 / 10;
        total_time += elapsed_time_1k_1;
        System.out.println("Average Radix Sort Runtime: " + avg_time_1k_1);

        long elapsed_time_1k_2 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1k_2 = System.nanoTime();

            InsertionSort.sort(converter(getFile(r_1k)));

            long interval_1k_2 = System.nanoTime();
            long temp_1k_2 = interval_1k_2 - begin_1k_2;

            if (i > 0) {
                elapsed_time_1k_2 += temp_1k_2;
            }
            System.out.println(interval_1k_2 - begin_1k_2);
        }

        long avg_time_1k_2 = elapsed_time_1k_2 / 10;
        total_time += elapsed_time_1k_2;
        System.out.println("Average Insertion Sort Runtime: " + avg_time_1k_2);

        ////////////////////////////////////////////////3
        long elapsed_time_1k_3 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1k_3 = System.nanoTime();

            MergeSort.sort(converter(getFile(r_1k)));

            long interval_1k_3 = System.nanoTime();
            long temp_1k_3 = interval_1k_3 - begin_1k_3;

            if (i > 0) {
                elapsed_time_1k_3 += temp_1k_3;
            }
            System.out.println(interval_1k_3 - begin_1k_3);
        }

        long avg_time_1k_3 = elapsed_time_1k_3 / 10;
        total_time += elapsed_time_1k_3;
        System.out.println("Average Merge Sort Runtime: " + avg_time_1k_3);

        long elapsed_time_1k_4 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1k_4 = System.nanoTime();
            QuickSort.sort(converter(getFile(r_1k)));
            long interval_1k_4 = System.nanoTime();
            long temp_1k_4 = interval_1k_4 - begin_1k_4;
            if (i > 0) {
                elapsed_time_1k_4 += temp_1k_4;
            }
            System.out.println(interval_1k_4 - begin_1k_4);
        }

        long avg_time_1k_4 = elapsed_time_1k_4 / 10;
        total_time += elapsed_time_1k_4;
        System.out.println("Average Quick Sort Runtime: " + avg_time_1k_4);
        System.out.println("Total Time: " + total_time);
        System.out.println("");

        ///////////////////////////////////TEN THOUSAND
        long elapsed_time_10k_1 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_10k_1 = System.nanoTime();

            RadixSort.sort(converter(getFile(r_10k)));

            long interval_10k_1 = System.nanoTime();
            long temp_10k_1 = interval_10k_1 - begin_10k_1;

            if (i > 0) {
                elapsed_time_10k_1 += temp_10k_1;
            }
            System.out.println(interval_10k_1 - begin_10k_1);
        }

        long avg_time_10k_1 = elapsed_time_10k_1 / 10;
        total_time += elapsed_time_10k_1;
        System.out.println("Average Radix Sort Runtime: " + avg_time_10k_1);

        long elapsed_time_10k_2 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_10k_2 = System.nanoTime();

            InsertionSort.sort(converter(getFile(r_10k)));

            long interval_10k_2 = System.nanoTime();
            long temp_10k_2 = interval_10k_2 - begin_10k_2;

            if (i > 0) {
                elapsed_time_10k_2 += temp_10k_2;
            }
            System.out.println(interval_10k_2 - begin_10k_2);
        }

        long avg_time_10k_2 = elapsed_time_10k_2 / 10;
        total_time += elapsed_time_10k_2;
        System.out.println("Average Insertion Sort Runtime: " + avg_time_10k_2);

        long elapsed_time_10k_3 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_10k_3 = System.nanoTime();

            RadixSort.sort(converter(getFile(r_10k)));

            long interval_10k_3 = System.nanoTime();
            long temp_10k_3 = interval_10k_3 - begin_10k_3;

            if (i > 0) {
                elapsed_time_10k_3 += temp_10k_3;
            }
            System.out.println(interval_10k_3 - begin_10k_3);
        }

        long avg_time_10k_3 = elapsed_time_10k_3 / 10;
        total_time += elapsed_time_10k_3;
        System.out.println("Average Merge Sort Runtime: " + avg_time_10k_3);

        long elapsed_time_10k_4 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_10k_4 = System.nanoTime();

            RadixSort.sort(converter(getFile(r_10k)));

            long interval_10k_4 = System.nanoTime();
            long temp_10k_4 = interval_10k_4 - begin_10k_4;

            if (i > 0) {
                elapsed_time_10k_4 += temp_10k_4;
            }
            System.out.println(interval_10k_4 - begin_10k_4);
        }

        long avg_time_10k_4 = elapsed_time_10k_4 / 10;
        total_time += elapsed_time_10k_1;
        System.out.println("Average Quick Sort Runtime: " + avg_time_10k_4);
        System.out.println("Total Time: " + total_time);
        System.out.println("");

        ////////////////////////////////////////100 THOUSAND
        System.out.println("For r_100k.out");

        long elapsed_time_100k_1 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_100k_1 = System.nanoTime();

            RadixSort.sort(converter(getFile(r_100k)));

            long interval_100k_1 = System.nanoTime();
            long temp_100k_1 = interval_100k_1 - begin_100k_1;

            if (i > 0) {
                elapsed_time_100k_1 += temp_100k_1;
            }
            System.out.println(interval_100k_1 - begin_100k_1);
        }

        long avg_time_100k_1 = elapsed_time_100k_1 / 10;
        total_time += elapsed_time_100k_1;
        System.out.println("Average Radix Sort Runtime: " + avg_time_100k_1);

        long elapsed_time_100k_2 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_100k_2 = System.nanoTime();

            InsertionSort.sort(converter(getFile(r_100k)));

            long interval_100k_2 = System.nanoTime();
            long temp_100k_2 = interval_100k_2 - begin_100k_2;

            if (i > 0) {
                elapsed_time_100k_2 += temp_100k_2;
            }
            System.out.println(interval_100k_2 - begin_100k_2);
        }

        long avg_time_100k_2 = elapsed_time_100k_2 / 10;
        total_time += elapsed_time_100k_2;
        System.out.println("Average Insertion Sort Runtime: " + avg_time_100k_2);

        ///////////////OPTIMIZED TO HERE
        long elapsed_time_100k_3 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_100k_3 = System.nanoTime();

            MergeSort.sort(converter(getFile(r_100k)));

            long interval_100k_3 = System.nanoTime();
            long temp_100k_3 = interval_100k_3 - begin_100k_3;

            if (i > 0) {
                elapsed_time_100k_3 += temp_100k_3;
            }
            System.out.println(interval_100k_3 - begin_100k_3);
        }

        long avg_time_100k_3 = elapsed_time_100k_3 / 10;
        total_time += elapsed_time_100k_3;
        System.out.println("Average Merge Sort Runtime: " + avg_time_100k_3);

        long elapsed_time_100k_4 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_100k_4 = System.nanoTime();

            QuickSort.sort(converter(getFile(r_100k)));

            long interval_100k_4 = System.nanoTime();
            long temp_100k_4 = interval_100k_4 - begin_100k_4;

            if (i > 0) {
                elapsed_time_100k_4 += temp_100k_4;
            }
            System.out.println(interval_100k_4 - begin_100k_4);
        }

        long avg_time_100k_4 = elapsed_time_100k_4 / 10;
        total_time += elapsed_time_100k_4;
        System.out.println("Average Quick Sort Runtime: " + avg_time_100k_4);

        System.out.println("Total Time: " + total_time);
        System.out.println("");

        /////////////////////////////////////////// 1 MILLION
        long elapsed_time_1m_1 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1m_1 = System.nanoTime();

            RadixSort.sort(converter(getFile(r_100k)));

            long interval_1m_1 = System.nanoTime();
            long temp_1m_1 = interval_1m_1 - begin_1m_1;

            if (i > 0) {
                elapsed_time_1m_1 += temp_1m_1;
            }
            System.out.println(interval_1m_1 - begin_1m_1);
        }

        long avg_time_1m_1 = elapsed_time_1m_1 / 10;
        total_time += elapsed_time_1m_1;
        System.out.println("Average Radix Sort Runtime: " + avg_time_1m_1);

        
        long elapsed_time_1m_2 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1m_2 = System.nanoTime();

            InsertionSort.sort(converter(getFile(r_1m)));

            long interval_1m_2 = System.nanoTime();
            long temp_1m_2 = interval_1m_2 - begin_1m_2;

            if (i > 0) {
                elapsed_time_1m_2 += temp_1m_2;
            }
            System.out.println(interval_1m_2 - begin_1m_2);
        }

        long avg_time_1m_2 = elapsed_time_1m_2 / 10;
        total_time += elapsed_time_1m_2;
        System.out.println("Average Insertion Sort Runtime: " + avg_time_1m_2);

        long elapsed_time_1m_3 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1m_3 = System.nanoTime();

            MergeSort.sort(converter(getFile(r_1m)));

            long interval_1m_3 = System.nanoTime();
            long temp_1m_3 = interval_1m_3 - begin_1m_3;

            if (i > 0) {
                elapsed_time_1m_3 += temp_1m_3;
            }
            System.out.println(interval_1m_3 - begin_1m_3);
        }

        long avg_time_1m_3 = elapsed_time_1m_3 / 10;
        total_time += elapsed_time_1m_3;
        System.out.println("Average Merge Sort Runtime: " + avg_time_1m_3);

        long elapsed_time_1m_4 = 0;
        for (int i = 0; i < 11; i++) {
            long begin_1m_4 = System.nanoTime();

            QuickSort.sort(converter(getFile(r_1m)));

            long interval_1m_4 = System.nanoTime();
            long temp_1m_4 = interval_1m_4 - begin_1m_4;

            if (i > 0) {
                elapsed_time_1m_4 += temp_1m_4;
            }
            System.out.println(interval_1m_4 - begin_1m_4);
        }

        long avg_time_1m_4 = elapsed_time_1m_4 / 10;
        total_time += elapsed_time_1m_4;
        System.out.println("Average Quick Sort Runtime: " + avg_time_1m_4);
        System.out.println("Total Time: " + total_time);
        System.out.println(" ");

        System.out.println("Average Runtime Table");
        System.out.println("input ----- radix ----- insertion ----- merge ----- quick");
        System.out.println("r_100.out: " + elapsed_time + ", " + elapsed_time2 + ", " + elapsed_time3 + ", " + elapsed_time4);
        System.out.println("r_1k.out: " + elapsed_time_1k_1 + ", " + elapsed_time_1k_2 + ", " + elapsed_time_1k_3 + ", " + elapsed_time_1k_4);
        System.out.println("r_10k.out: " + elapsed_time_10k_1 + ", " + elapsed_time_10k_2 + ", " + elapsed_time_10k_3 + ", " + elapsed_time_10k_4);
        System.out.println("r_100k.out: " + elapsed_time_100k_1 + ", " + elapsed_time_100k_2 + ", " + elapsed_time_100k_3 + ", " + elapsed_time_100k_4);
        System.out.println("r_1m.out: " + elapsed_time_1m_1 + ", " + elapsed_time_1m_2 + ", " + elapsed_time_1m_3 + ", " + elapsed_time_1m_4);

    }
    
   
    
    

}

