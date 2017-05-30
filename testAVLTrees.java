
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author wilip
 */
public class testAVLTrees {

    private static AvlTree tree = new AvlTree();
    private static Integer[] nums;
    private static String[] strings;
    private static final String INC_FILE = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\INC.txt";
    private static final String RAND_FILE = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\RAND.txt";

    public static void getFile(String file) throws FileNotFoundException, IOException {
        strings = new Scanner(new File(file)).useDelimiter("\\Z").next().split(" ");
        
        
    }
    
    public static Integer[] converter(String[] array){
        nums = new Integer[100000];
        
        for(int i = 0; i < strings.length;i++){
            nums[i] = Integer.parseInt(strings[i]);
        }
        
        return nums;
    }

    //PART ONE
    public static void insertData(String[] strings) {
        long total_time = 0;
        long begin = System.nanoTime();

        for (int i = 0; i < strings.length; i++) {
            //System.out.print(strings[i]);
            tree.insert(nums[i]);

            if (i == 20000 || i == 30000 || i == 40000 || i == 50000 || i == 60000
                    || i == 70000 || i == 80000 || i == 90000 || i == 100000) {

                long end = System.nanoTime();
                long elapsed_time = end - begin;

                total_time += elapsed_time;

                System.out.println("Run time for " + i + " insertions: " + total_time);

            }

        }
        System.out.println("Cumulitive time: " + total_time);

    }

    //PART TWO
 public static void searchTree(Integer j) {
        System.out.println("Searching...");
        long begin2 = System.nanoTime();
        long total = 0;

        if (j > 1) {
            for (int x = 0; x < j; x++) {
                for (int i = 0; i < 500; i++) {
                    
                    tree.contains(nums[i]);

                    if (x == 20000 || x == 30000 || x == 40000 || x == 50000 || x == 60000
                            || x == 70000 || x == 80000 || x == 90000 || x == 100000) {
                        long end2 = System.nanoTime();
                        long elapsed = end2 - begin2;
                        
                        if (i != 10000) {
                            total += elapsed;
                        }
                        System.out.println("Run time for " + i + " searches: " + total);
                    }
                }
            }
        }
                for (int i = 0; i < strings.length; i++) {
                    tree.contains(nums[i]);

                    if (i == 20000 || i == 30000 || i == 40000 || i == 50000 || i == 60000
                            || i == 70000 || i == 80000 || i == 90000 || i == 100000) {
                        long end2 = System.nanoTime();
                        long elapsed = end2 - begin2;

                        total += elapsed;
                        
                        System.out.println("Run time for " + i + " searches: " + total);
                    }
                }
     
           System.out.println("Cumulitive time: " + total);
        }
 
    public static void main(String[] args) throws IOException {
        System.out.println("AVL Tree");
        System.out.println("Incremental Input: ");
        getFile(INC_FILE);
        converter(strings);
        insertData(strings);

        tree.makeEmpty();

        System.out.println("Random Input: ");
        getFile(RAND_FILE);
        insertData(strings);
        searchTree(1);
        searchTree(201);

    }

}
