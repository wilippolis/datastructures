/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilip
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class PrefixEval {

    private static int count = 0;
    private static Stack<Integer> stk = new Stack<>();
    private static ArrayList<Integer> outList = new ArrayList<>();
    private static File file;

    public static void main(String[] args) throws IOException {
        createFile();
        for (int i = 0; i < 3; i++) {
            System.out.println(Evaluate(getString()));

        }
        write();

    }

    //gets the input file
    public static String getString() throws IOException, FileNotFoundException {

        //Source: http://stackoverflow.com/questions/5819772/java-parsing-text-file
        //I used stackoverflow to figure out how to open files.
        FileInputStream fstream = new FileInputStream("C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\input.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        //Create three different strings for each input line
//        String strLine = "+ + 5 * 6 7 * + * 8 9 10 11";
        String strLine = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        //conditional input 
        if (count == 1) {
            count++;
            return str2;
        }
        if (count == 2) {
            count++;
            return str3;
        }

        count++;
        return strLine;

    }

    //parses and evaluates the input string in prefix
    public static int Evaluate(String strLine) throws IOException {

        System.out.println(strLine);

        String[] stringParsed = strLine.split(" ");

        strLine = " ";
        for (int i = 0; i < stringParsed.length; ++i) {
            strLine += stringParsed[stringParsed.length - i - 1];
            strLine += " ";
        }
        strLine = strLine.substring(0, strLine.length() - 1);;

        for (int i = 0; i < strLine.length(); i++) {
            if ((strLine.charAt(i) >= '0') && (strLine.charAt(i) <= '9')) {

                stk.push(0);
                while ((strLine.charAt(i) >= '0') && (strLine.charAt(i) <= '9')) {
                    stk.push(10 * stk.pop() + (strLine.charAt(i) - '0'));
                    i++;
                }
            }
            if (strLine.charAt(i) == '+') {
                stk.push(stk.pop() + stk.pop());
            }
            if (strLine.charAt(i) == '-') {
                stk.push((stk.pop() - stk.pop()));
            }
            if (strLine.charAt(i) == '*') {
                stk.push(stk.pop() * stk.pop());
            }
            if (strLine.charAt(i) == '/') {
                stk.push(stk.pop() / stk.pop());
            }

        }

        //add the first item in the stack to the arraylist
        outList.add(stk.get(0));
        //write();
        System.out.println(outList.toString());

        return stk.pop();

    }

    //create the output file
    public static void createFile() throws IOException {
        file = new File("output.txt");
        file.createNewFile();

    }

    //write to the output file 
    public static void write() throws IOException {

        
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        for(int i = 0; i < outList.size();i++){
            writer.println(outList.get(i));
                    //.toString().replace("[", "").replace("]", ""));
        }
        writer.close();

    }
}
