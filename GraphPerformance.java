
/**
 *
 * @author wilip
 */



public class GraphPerformance {

    public static void addEdges(String type, int size) {
        if (type.equals("list")) {
            AdjacencyList list = new AdjacencyList(size);
            long start = System.nanoTime();
            
            for (int i = 0; i < size - 1; i++) {
                list.addEdge(i, i + 1, 1);
            }
            
            long end = System.nanoTime();
            long time = end - start;
            System.out.println(time);
        }
        
        else {
        
            long start = System.nanoTime();
            AdjacencyMatrix matrix = new AdjacencyMatrix(size);
            for (int i = 0; i < size -1 ; i++) {
                
                matrix.addEdge(i, i + 1);
            }
            long end = System.nanoTime();
            long time = end - start;
            System.out.println(time);
        }
    }
    public static void main(String[] args) {

        ///NOTE: IN ORDER FOR THIS TO EXECUTE PROPERLY
        ///ADJUST VM OPTIONS TO -Xmx8096m or higher
        
        System.out.println("List Times:");
        addEdges("list",10000);
        addEdges("list",100000);
        addEdges("list",1000000);
        addEdges("list",10000000);
        
        System.out.println("Matrix Times:");
        addEdges("matrix",10000);
        addEdges("matrix",100000);
        addEdges("matrix",1000000);
        addEdges("matrix",10000000);
        
    }

}
