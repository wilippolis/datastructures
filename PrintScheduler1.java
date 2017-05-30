import java.io.IOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *  @authors Will L, Zach B, Ben S, Nick L, Griffin G, Griffin C, Everest W, Liv J, Gabriella O
 */



class Fio {

    String[] reqs;

    Fio(String filename) throws IOException {
        //http://stackoverflow.com/questions/3402735/what-is-simplest-way-to-read-a-file-into-string
        //reqs = new Scanner(new File(filename)).hasNextLine()
        // http://stackoverflow.com/questions/454908/split-java-string-by-new-line
        //reqs = contentarray.split("\\r?\\n");
        Path filePath = new File(filename).toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = Files.readAllLines(filePath, charset);
        reqs = stringList.toArray(new String[]{});

    }

    String[] getContents() {
        String[] outstring = new String[reqs.length];
        for (int i = 0; i < reqs.length; i++) {
            outstring[i] = reqs[i];
        }
        return outstring;
    }


}
 class BinaryHeap {

    private PrintRequest[] Heap;
    private int size;
    private int maxsize;
    private int status = 0;

    private static final int FRONT = 1;

    public BinaryHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new PrintRequest[this.maxsize + 1];
        Heap[0] = new PrintRequest();
        Heap[0].setPriority(maxsize);
    }

    public boolean isFull() {
        return size >= maxsize;
    }

    public boolean isEmpty() {
        return Heap.length == 0;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos].getPriority();
        Heap[fpos] = Heap[spos];
        tmp = Heap[spos].getPriority();
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            
            if (Heap[pos].getPriority() < Heap[leftChild(pos)].getPriority() || Heap[pos].getPriority() < Heap[rightChild(pos)].getPriority()) {
                if (Heap[leftChild(pos)].getPriority() > Heap[rightChild(pos)].getPriority()) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(PrintRequest element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current].getPriority() > Heap[parent(current)].getPriority()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public String getData() {

        
        String out = " ";

        for(int i = 0; i < Heap.length; i++){
            if(Heap[i] != null){
             out += Heap[i].getID() + " " + Heap[i].getLogin() + " " + Heap[i].getTime() + " "
                    + Heap[i].getPriority() + " " + Heap[i].getSize() + " "
                    + Heap[i].getHandle() + "\n" ;

            }
        }

        return out;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public int getSize() {
        return size;
    }

    public int remove() {
        int popped = Heap[FRONT].getPriority();
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        
        return popped;
    }

    public void delete(Integer priority) {
        System.out.println(priority);
        Heap[priority] = null;
        maxHeapify(FRONT);
    }

    public boolean hasID(int ID) {
        for (int i = 0; i < maxsize; i++) {
            if (Heap[i].getID() == ID) {
                return true;
            }
        }
        return false;
    }

    public int[] contains(String login) {
        int[] num = new int[size];
        for (int i = 1; i < size; i++) {
            if (Heap[i].getLogin().equals(login)) {
                num[i] = Heap[i].getID();
            }
        }
        return num;
    }

    public int find() {
        int popped = Heap[FRONT].getID();
        return popped;
    }

    
}
 class PrintRequest {

    private String[] reqs;
    private int ID;
    private String method;
    private String login;
    private String time;
    private int priority;
    private int size;
    private int handle;

    public PrintRequest() {

    }
void fo(String content) {
        try (FileWriter fw = new FileWriter("src\\sample_output.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                out.println(content);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

    }
    public PrintRequest(String[] data) {
        for (int i = 0; i < data.length; i++) {
            reqs = data[i].split("\\s+");
        

         switch (reqs[0]) {
                case "add":
            fo(((Integer)PrintScheduler.add(ID, reqs[0], reqs[1], reqs[2], Integer.parseInt(reqs[3]), Integer.parseInt(reqs[4]), Integer.parseInt(reqs[5]))).toString());
                    fo(PrintScheduler.status());
                    ID++;
                    break;
                case "print_next":
                    fo(((Integer)PrintScheduler.print_next()).toString());
                    fo("print_next");
                    break;
                case "find_next":
                    fo(((Integer)PrintScheduler.find_next()).toString());
                    fo("find_next");
                    break;

                case "status":
                    fo(PrintScheduler.status());
                    fo("status");
                    break;
                case "cancel":
                    if (reqs[1] instanceof String) {
                        fo(((Integer)PrintScheduler.cancel(reqs[1])).toString());
                        fo(reqs[1]);
                    } else {
                        fo(((Integer)PrintScheduler.cancel(ID)).toString());
                        System.out.println(ID);
                    }

                    break;
            }
        }
    }

            //parse the integer into multiple data types
            //then pass the data into the constructor below
        
    

    public PrintRequest(int ID, String method, String login, String time, int priority, int size, int handle) {
        this.ID = ID;
        this.method = method;
        this.login = login;
        this.time = time;
        this.priority = priority;
        this.size = size;
        this.handle = handle;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the handle
     */
    public int getHandle() {
        return handle;
    }

    /**
     * @param handle the handle to set
     */
    public void setHandle(int handle) {
        this.handle = handle;
    }

}

class PrintScheduler {

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
    public static int print_next() {
        if (maxHeap.isEmpty()) {
            return -2;
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
        Fio fileIn = new Fio("src\\sample_input.txt");
              
       System.out.println(add(fileIn.getContents()));
        

    }

}
