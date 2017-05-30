
/*

@wilip 
Worked with: Zach B & Ben S

 */
public class Probing {

    private static int linearProbes;
    private static int quadProbes;
    private static int doubleProbes;
    private static int linearNPrime;
    private static int wow = 0;

    public static void main(String[] args) {
        int[] keys = randValues(99999, 1000);
        int[] doublekeys = randValues(99999, 1009);

        System.out.println("Linear Insertion");
        LinearProbe linp = new LinearProbe(1009, keys);
        linp.linearInsertion(keys);
        
        wow = 1;
        
        System.out.println("Linear Instertion (NP)");
        LinearProbe linearNP = new LinearProbe(1000,keys);
        linearNP.linearInsertion(keys);
        
        
        System.out.println("Quadratic Insertion");
        QuadraticProbe qp = new QuadraticProbe(1000, keys);
        qp.quadraticInsertion(keys);

        System.out.println("Double Hashing");
        DoubleHash dp = new DoubleHash(1009, doublekeys);
        dp.doublehashInsertion(keys);
        System.out.println("");
        System.out.println("Quadratic probes: " + quadProbes + ", Linear Probes (Prime): "
                + linearProbes + ", Linear Probes (NP): " + linearNPrime + ", Double Hashing Probes: " + doubleProbes);

    }

    public static int[] randValues(int end, int numVals) {
        int[] ary = new int[numVals];
        for (int i = 0; i < numVals; i++) {
            ary[i] = (int) (Math.random() * end);
        }
        return ary;
    }

    public static class LinearProbe {

        private int tblLength;
        private int[] keys;

        LinearProbe(int tblLength, int[] keys) {
            this.tblLength = tblLength;
            this.keys = new int[tblLength];
            for (int i = 0; i < keys.length; i++) {
                this.keys[i] = -1;
            }
        }

        public void linearInsertion(int[] randkeys) {
            for (int i = 0; i < randkeys.length; i++) {
                LProbe(randkeys[i]);
            }
        }

        public void LProbe(int key) {
            int index = (key % this.tblLength);
            int probes = 1;
            if (keys[index] != -1) {
                LProbe(((index + 1) % this.tblLength), key, probes + 1);
            } else {
                this.keys[index] = key;
                System.out.println(probes + ",");
                if(wow == 0){
                linearProbes++;
                }
                else{
                    linearNPrime++;
                }
            }
        }

        public void LProbe(int index, int key, int probes) {
            if (keys[index] != -1) {
                LProbe(((index + 1) % (this.tblLength)), key, probes + 1);
            } else {
                this.keys[index] = key;
                System.out.print(probes + ",");
            }
        }

    }

    public static class QuadraticProbe {

        //private long[] array = {};
        private int tblLength;
        private int[] keys;

        QuadraticProbe(int tblLength, int[] keys) {
            this.tblLength = tblLength;
            this.keys = new int[tblLength];
            for (int i = 0; i < keys.length; i++) {
                this.keys[i] = -1;
            }
        }

        public void quadraticInsertion(int[] randkeys) {

            for (int i = 0; i < randkeys.length; i++) {
                QProbe(randkeys[i]);
            }
        }

        public void QProbe(int key) {
            int index = (key % this.tblLength);
            int probes = 1;
            if (keys[index] != -1) {
                QProbe((int) ((index + Math.pow(probes, 2) + 1) % this.tblLength), key, probes + 1);
            } else {
                this.keys[index] = key;
                System.out.println(probes + ",");
                quadProbes++;
            }
        }

        public void QProbe(int index, int key, int probes) {
            if (keys[index] != -1) {
                QProbe((int) ((index + Math.pow(probes, 2) + 1) % this.tblLength), key, probes + 1);
            } else {
                this.keys[index] = key;
                System.out.print(probes + ",");
            }
        }

    }

    public static class DoubleHash {

        private int tblLength;
        private int[] keys;

        DoubleHash(int tblLength, int[] keys) {
            this.tblLength = tblLength;
            this.keys = new int[tblLength];
            for (int i = 0; i < keys.length; i++) {
                this.keys[i] = -1;
            }
        }

        public void doublehashInsertion(int[] randkeys) {
            for (int i = 0; i < randkeys.length; i++) {
                DProbe(randkeys[i]);
            }
        }

        int h(int i, int k) {
            return (k % (this.tblLength) + i * (k % 97 + 1)) % (this.tblLength);
        }

        public void DProbe(int key) {
            int index = key % this.tblLength;
            int probes = 1;
            if (keys[index] != -1) {
                DProbe(((key % this.tblLength) + probes * ((key % 97) + 1)) % this.tblLength, key, probes + 1);
            } else {
                this.keys[index] = key;
                System.out.println(probes + ",");
                doubleProbes++;

            }
        }

        public void DProbe(int index, int key, int probes) {
            if (keys[index] != -1) {
                DProbe(((key % this.tblLength) + probes * ((key % 97) + 1)) % this.tblLength, key, probes + 1);
            } else {
                this.keys[index] = key;
                System.out.print(probes + ",");
            }
        }

    }

}
