
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.Stack;

/**
 *
 * @author wilip
 */
public class PrefixEval_Alt {


    /**
     *
     * @author williamlippolis
     */
    public static int evaluate() throws FileNotFoundException, IOException {

        FileInputStream fstream = new FileInputStream("C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\input.txt");

        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine = br.readLine();
        
        Stack<Integer> list = new Stack<>();
        
        int result = 0;

        // Stack<Integer> list = new Stack<>();
        int number1;     //result of 1st popping
        int number2;     // result of 2nd popping

        for (int i = 0; i < strLine.length(); i++) {

            char ch = strLine.charAt(i);

            if (ch == ' ') {

            } else if (Character.isDigit(ch)) {
                list.push(Integer.parseInt(ch + ""));
                //System.out.println(ch);
                //          list.printS();

            } else {
                number1 = (int) list.pop();
                number2 = (int) list.pop();

                if (ch == '+') {
                    list.push(number1 + number2);

                } else if (ch == '-') {
                    list.push(number2 - number1);

                } else if (ch == '*') {

                    list.push(number1 * number2);

                } else if (ch == '/') {
                    list.push(number2 / number1);
                }

                // change this into else if handling all four operations TODO
            }
        }

        return list.pop();
    }

    public static void main(String[] args) throws IOException {
        evaluate();

    }

}

//    public int prefixEval(String expr){
//        
//        
//    Stack<Character> stack = new Stack<>();
//    
//    for(int i = 0; i < expr.length(); i++){
//    if((expr.charAt(i) >= '0') && (expr.charAt(i) <= '9')){
//        stack.push(expr.charAt(0));
//        
//        while (())
//    }
//}
//    return;
//    }

