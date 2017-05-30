
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author wilip
 */
public class TreePerformance {

    //Declare fields
    private static BinarySearchTree BSTree = new BinarySearchTree();
    private static AvlTree AVLTree = new AvlTree();
    private static SplayTree SplayTree = new SplayTree();
    private static final String INC_FILE = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\INC.txt";
    private static final String RAND_FILE = "C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\RAND.txt";

    //read specified file into String array
    public static String[] getFile(String file) throws FileNotFoundException, IOException {
        String[] strings = new Scanner(new File(file)).useDelimiter("\\Z").next().split(" ");

        return strings;
    }

    //Convert string array into integer array
    public static Integer[] converter(String[] strings) {
        Integer[] nums = new Integer[100000];

        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        return nums;
    }

    //PART ONE - Insert specified data set into specified data structure
    public static void insertData(Object tree, Integer[] nums) {
        long total_time = 0;
        long begin = System.nanoTime();

        //Determines which tree to use
        for (int i = 0; i < nums.length; i++) {
            if (tree instanceof AvlTree) {
                AVLTree.insert(nums[i]);
            } else if (tree instanceof BinarySearchTree) {
                BSTree.insert(nums[i]);
            } else {
                SplayTree.insert(nums[i]);
            }

            if (i == 10000 || i == 20000 || i == 30000 || i == 40000 || i == 50000 || i == 60000
                    || i == 70000 || i == 80000 || i == 90000 || i == 100000) {

                long end = System.nanoTime();
                long elapsed_time = end - begin;

                total_time += elapsed_time;

                System.out.println("Run time for " + i + " insertions: " + total_time);

            }

        }
        System.out.println("Average time: " + total_time / 8);
    }

    //PART TWO - Seach specified tree for specified keys 
    public static void searchTree(Object tree, Integer[] nums, Integer j) {
        System.out.println("Searching...");

        //Get the system time
        long begin2 = System.nanoTime();

        //Create a total time counter
        long total = 0;

        //if statement determines which search pattern will be executes
        if (j > 1) {
            // 200 keys by 500 iterations 
            for (int x = 0; x < j; x++) {
                for (int i = 0; i < 500; i++) {
                    
                    //Determines which tree to use
                    if (tree instanceof AvlTree) {
                        AVLTree.contains(nums[i]);
                    } else if (tree instanceof BinarySearchTree) {
                        BSTree.contains(nums[i]);
                    } else {
                        SplayTree.contains(nums[i]);
                    }
                    if (i == 10000 || i == 20000 || i == 30000 || i == 40000 || i == 50000 || i == 60000
                            || i == 70000 || i == 80000 || i == 90000 || i == 100000) {
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

        //100,000 searches 
        for (int i = 0; i < nums.length; i++) {
            
            //Determines which tree to use
            if (tree instanceof AvlTree) {
                AVLTree.contains(nums[i]);
            } else if (tree instanceof BinarySearchTree) {
                BSTree.contains(nums[i]);
            } else {
                SplayTree.contains(nums[i]);
            }

            if (i == 10000 || i == 20000 || i == 30000 || i == 40000 || i == 50000 || i == 60000
                    || i == 70000 || i == 80000 || i == 90000 || i == 100000) {
                long end2 = System.nanoTime();
                long elapsed = end2 - begin2;

                if (i != 10000) {
                    total += elapsed;
                }
                System.out.println("Run time for " + i + " searches: " + total);
            }
        }
        System.out.println("Average time: " + total / 8);

    }

    public static void main(String[] args) throws IOException {

        //////////////////Binary Search Tree/////////////////////////
        System.out.println("Binary Search Tree");
        System.out.println("Incremental Input: ");
        insertData(BSTree, converter(getFile(INC_FILE)));

        //Empty the tree to prepare for new inputs
        BSTree.makeEmpty();

        System.out.println("Random Input: ");
        insertData(BSTree, converter(getFile(RAND_FILE)));
        searchTree(BSTree, converter(getFile(RAND_FILE)), 1);
        searchTree(BSTree, converter(getFile(RAND_FILE)), 201);

        ///////////////////AVL Tree///////////////////////////////////
        System.out.println("AVL Tree");
        System.out.println("Incremental Input: ");
        insertData(AVLTree, converter(getFile(INC_FILE)));

        //Empty the tree to prepare for new inputs
        AVLTree.makeEmpty();

        System.out.println("Random Input: ");
        insertData(AVLTree, converter(getFile(RAND_FILE)));
        searchTree(AVLTree, converter(getFile(RAND_FILE)), 1);
        searchTree(AVLTree, converter(getFile(RAND_FILE)), 201);

        ///////////////////Splay Tree/////////////////////////////////
        System.out.println("Splay Tree");
        System.out.println("Incremental Input: ");
        insertData(SplayTree, converter(getFile(INC_FILE)));

        //Empty the tree to prepare for new inputs
        SplayTree.makeEmpty();

        System.out.println("Random Input: ");
        insertData(SplayTree, converter(getFile(RAND_FILE)));
        searchTree(SplayTree, converter(getFile(RAND_FILE)), 1);
        searchTree(SplayTree, converter(getFile(RAND_FILE)), 201);
    }

}
