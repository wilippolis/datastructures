
import java.io.IOException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilip
 */
public class PrintScheduler {

    private static BinaryHeap maxHeap = new BinaryHeap(15);

    //int add(string login, string time, int priority, int size, int handle)
    // add a new request to a queue; return a sequential ID# if successful, or FULL if the total file size of all pending
    //requests exceeds the maximum spool size of 50MB. The input argument handle is not
    //used in this exercise, so set it to NULL. The ID cycles in the range of 1 - 1024
//    public String[] parseInput(String input){
//        
//    }
    
   
    public static int add(String[] file){
         if (maxHeap.isFull()) {
            return -1;
        } else {
            PrintRequest req = new PrintRequest(file);
            
            maxHeap.insert(req);
            return req.getID();
        
        }
        
    }
    public static int add(int ID, String method, String login, String time, int priority, int size, int handle) {

        if (maxHeap.isFull()) {
            return -1;
        } 
        else {
            PrintRequest req = new PrintRequest(ID,method, login, time, priority, size, handle);
            maxHeap.insert(req);
            return req.getID();
        }

    }

    //int print_next()
    // return EMPTY if the queue is empty, or return the ID of the pending
    //highest-priority request and delete it from the queue
    public static PrintRequest print_next() {
        if (maxHeap.isEmpty()) {
            return maxHeap.getPR(0);
        } else {
            return maxHeap.remove();
        }

    }

    //int find_next()
    // return EMPTY if the queue is empty, or return the ID of the pending
    //highest-priority request
    public static int find_next() {
        if (maxHeap.isEmpty()) {
            return -2;
        } else {
            return maxHeap.find();
        }

    }

    //int cancel(string login)
    // delete all the requests made by the login user; return the number
    //of deleted requests if successful, or return NONE if not found
    public static int cancel(String login) {
        for (int i = 0; i < maxHeap.getSize(); i++) {
            if (maxHeap.contains(login).length == 0) {
                return -3;
            } else {
                for (int j = 0; j < maxHeap.contains(login).length; j++) {

                    maxHeap.delete(maxHeap.contains(login)[j]);

                }
            }
        }
        return 3;
    }

    //int cancel(int ID)
    // delete the request with the ID; return 0 if successful, or return NONE if
    //not found
    public static int cancel(Integer ID) {
        if (maxHeap.hasID(ID)) {
            maxHeap.delete(ID);
            return 0;
        } else {
            return -3;
        }

    }
    //String status()
    // return a string containing information about all pending requests' ID,
    //login, creation time, priority, file size, and file handle; return “EMPTY” if there's no
    //pending request. The order of the print requests returned does not matter

    public static String status() {
        if (maxHeap.isEmpty()) {
            return "-1";
        } else {
            
            return maxHeap.getData();
    
        
        }
       
    }
    
    
    
    //error codes: -1 for FULL, -2 for EMPTY, -3 for NONE
    public static void main(String[] args) throws IOException {
        Fio fileIn = new Fio("C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\sample_input.txt");
              
       System.out.println(add(fileIn.getContents()));
        

    }

}
