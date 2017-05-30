/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilip
 */
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author zacharybechhoefer
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

    public static void main(String... arg) throws IOException {
    
    }
}
