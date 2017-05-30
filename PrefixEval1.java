
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilip
 */
public class PrefixEval1 {


   
   public static void main(String[] args) throws IOException {
       System.out.println(PrefixEval());
   }

   public static int PrefixEval() throws IOException {
       FileInputStream fstream = new FileInputStream("C:\\Users\\wilip\\Desktop\\UVM Sophomore Year\\cs124\\cs124\\src\\input.txt");
       DataInputStream in = new DataInputStream(fstream);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
      
       String strLine = br.readLine() + br.readLine() + br.readLine();
      
       
       System.out.println(strLine);
       
       String[] stringParsed = strLine.split(" ");
       
       strLine = " ";
       for(int i = 0; i < stringParsed.length; ++i){            
           strLine += stringParsed[stringParsed.length - i-1];
           strLine += " ";
       }        
       strLine = strLine.substring(0, strLine.length() - 1);;
       
       System.out.println(strLine);
           
       Stack<Integer> stk = new Stack<Integer>();
       for (int i = 0; i < strLine.length(); i++) {
           if ((strLine.charAt(i) >= '0') && (strLine.charAt(i) <= '9')) {
               // Parse an integer number and push it into the stack.
               stk.push(0);
               while ((strLine.charAt(i) >= '0') && (strLine.charAt(i) <= '9')) {
                   stk.push(10*stk.pop() + (strLine.charAt(i) - '0'));
                   i++;
               }
           }
           if (strLine.charAt(i) == '+') stk.push(stk.pop() + stk.pop());
           if (strLine.charAt(i) == '-') stk.push((stk.pop() - stk.pop()));
           if (strLine.charAt(i) == '*') stk.push(stk.pop() * stk.pop());
           if (strLine.charAt(i) == '/') stk.push(stk.pop() / stk.pop());
       }
       return stk.pop();
   }
}


