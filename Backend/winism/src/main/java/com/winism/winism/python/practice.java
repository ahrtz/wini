package com.winism.winism.python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.python.util.PythonInterpreter;

public class practice {

    private static PythonInterpreter interpreter;
    public static void main(String[] args){

        try{
            Process process = Runtime.getRuntime().exec("python C:\\Users\\git\\ssafy_project3\\s03p31a208\\Backend\\winism\\test2.py TheLittlePrince 50");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            // BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(),"MS949"));

            ArrayList<String> arr = new ArrayList<String>();
            
            String s = "";
            while((s= stdInput.readLine()) != null) {
           	    System.out.println(s);
                arr.add(s);
            }
           

            System.out.println(arr);

            stdInput.close();


        }
        catch(Exception e){
            System.out.println(e);
        }

        
        // interpreter = new PythonInterpreter();
        // int a = 7;
        // int b = 8;
        // try{
            
        //     interpreter.execfile("test.py");
        //     interpreter.exec("print(readcsv())");
        // }
        // catch(Exception e){
            
        // }
    }

}
