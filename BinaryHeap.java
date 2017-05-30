
/*
 * @author William Lippolis
 *
 */
public class BinaryHeap {

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
        return size == maxsize;
    }

    public boolean isEmpty() {
        return size == 0;
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

        for (int i = 0; i < Heap.length; i++) {
            if (Heap[i] != null) {
                out += Heap[i].getID() + " " + Heap[i].getLogin() + " " + Heap[i].getTime() + " "
                        + Heap[i].getPriority() + " " + Heap[i].getSize() + " "
                        + Heap[i].getHandle() + "\n";

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

    public PrintRequest remove(){
        
                            // (assumes non-empty list)
      PrintRequest root = Heap[FRONT];
      Heap[0] = Heap[--size];
      maxHeapify(FRONT);
      return root;
      } 
    
    public PrintRequest getPR(int i)
    {
        return Heap[i];
    }
//    public int remove() {
//        int popped = Heap[FRONT].getID();
//        Heap[FRONT] = Heap[size--];
//        maxHeapify(FRONT);
//
//        return popped;
//    }

    public void delete(Integer priority) {
        System.out.println(priority);
        Heap[priority] = Heap[size--];
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

    public static void main(String... arg) {
//        System.out.println("The Max Heap is ");
        //BinaryHeap maxHeap = new BinaryHeap(15);
//        maxHeap.insert(new PrintRequest(1, "add", "Will", "12", 2, 5, 0));
//        maxHeap.insert(new PrintRequest(2, "add", "Will", "16", 6, 8, 0));
//        maxHeap.insert(new PrintRequest(3, "add", "Will", "14", 8, 3, 0));
//        maxHeap.insert(new PrintRequest(4, "add", "Will", "14", 8, 3, 0));
//        maxHeap.insert(new PrintRequest(5, "add", "Will", "14", 8, 3, 0));
//        maxHeap.insert(new PrintRequest(6, "add", "Will", "14", 8, 3, 0));
//        maxHeap.insert(new PrintRequest(7, "add", "Will", "14", 8, 3, 0));
//        maxHeap.insert(new PrintRequest(8, "add", "Will", "14", 8, 3, 0));
//        maxHeap.insert(new PrintRequest(9, "add", "Will", "14", 8, 3, 0));
//        maxHeap.maxHeap();
//
//        maxHeap.print();
//        System.out.println(maxHeap.rightChild(3));
//        System.out.println("The max val is " + maxHeap.remove());
    }

}
