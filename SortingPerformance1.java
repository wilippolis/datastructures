import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilip
 */
//* Source: http://quiz.geeksforgeeks.org/insertion-sort/
 
 class InsertionSort {
    
    


    /*Function to sort array using insertion sort*/
    static void sort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
 
    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
 
    // Driver method
   
} /* This code is contributed by Rajat Mishra. */

//Source: http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html

 class MergeSort {
        private static int[] numbers;
        private static int[] helper;

        private static int number;

        public static void sort(int[] values) {
                numbers = values;
                number = values.length;
                MergeSort.helper = new int[number];
                mergesort(0, number - 1);
        }

        private static void mergesort(int low, int high) {
                // check if low is smaller than high, if not then the array is sorted
                if (low < high) {
                        // Get the index of the element which is in the middle
                        int middle = low + (high - low) / 2;
                        // Sort the left side of the array
                        mergesort(low, middle);
                        // Sort the right side of the array
                        mergesort(middle + 1, high);
                        // Combine them both
                        merge(low, middle, high);
                }
        }

        private static void merge(int low, int middle, int high) {

                // Copy both parts into the helper array
                for (int i = low; i <= high; i++) {
                        helper[i] = numbers[i];
                }

                int i = low;
                int j = middle + 1;
                int k = low;
                // Copy the smallest values from either the left or the right side back
                // to the original array
                while (i <= middle && j <= high) {
                        if (helper[i] <= helper[j]) {
                                numbers[k] = helper[i];
                                i++;
                        } else {
                                numbers[k] = helper[j];
                                j++;
                        }
                        k++;
                }
                // Copy the rest of the left side of the array into the target array
                while (i <= middle) {
                        numbers[k] = helper[i];
                        k++;
                        i++;
                }

        }
}
//http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 
 class QuickSort  {
        private static int[] numbers;
        private static int number;

        public static void sort(int[] values) {
                // check for empty or null array
                if (values ==null || values.length==0){
                        return;
                }
                QuickSort.numbers = values;
                number = values.length;
                quicksort(0, number - 1);
        }

        private static void quicksort(int low, int high) {
                int i = low, j = high;
                // Get the pivot element from the middle of the list
                int pivot = numbers[low + (high-low)/2];

                // Divide into two lists
                while (i <= j) {
                        // If the current value from the left list is smaller than the pivot
                        // element then get the next element from the left list
                        while (numbers[i] < pivot) {
                                i++;
                        }
                        // If the current value from the right list is larger than the pivot
                        // element then get the next element from the right list
                        while (numbers[j] > pivot) {
                                j--;
                        }

                        // If we have found a value in the left list which is larger than
                        // the pivot element and if we have found a value in the right list
                        // which is smaller than the pivot element then we exchange the
                        // values.
                        // As we are done we can increase i and j
                        if (i <= j) {
                                exchange(i, j);
                                i++;
                                j--;
                        }
                }
                // Recursion
                if (low < j)
                        quicksort(low, j);
                if (i < high)
                        quicksort(i, high);
        }

        private static void exchange(int i, int j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
        }
}

//http://www.geekviewpoint.com/java/sorting/radixsort
 

 class RadixSort {

public static void sort(int[] input) {
  final int RADIX = 10;
  // declare and initialize bucket[]
  List<Integer>[] bucket = new ArrayList[RADIX];
  for (int i = 0; i < bucket.length; i++) {
    bucket[i] = new ArrayList<Integer>();
  }

 
  // sort
  boolean maxLength = false;
  int tmp = -1, placement = 1;
  while (!maxLength) {
    maxLength = true;
    // split input between lists
   
 for (Integer i : input) {
      tmp = i / placement;
      bucket[tmp % RADIX].add(i);
      if (maxLength && tmp > 0) {
        maxLength = false;
      }
    }
    // empty lists into input array
    int a = 0;
   
 for (int b = 0; b < RADIX; b++) {
      for (Integer i : bucket[b]) {
        input[a++] = i;
      }
      bucket[b].clear();
    }
    // move to next digit
    placement *= RADIX;
  }
}
}
  class SortingPerformance{

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

