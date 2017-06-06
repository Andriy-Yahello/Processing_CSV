package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.SocketHandler;

public class Main {

    public static void main(String[] args) throws IOException {
        //creating a stream
        FileInputStream stream = new FileInputStream("E:\\java program\\ProccessCSV\\FL_insurance_sample.csv");
        //finding length of the file
        int length = stream.available();
        //creating array with appropriate length
        byte [] data = new byte[length];
        //reading file
        stream.read(data);
        //converting to String
        String text = new String(data);


        //creating list of lines
        ArrayList<String[]> wordsInline = new ArrayList<>();
        //splitting by \n
        String [] lines = text.split("\n");

        for(String line: lines){
            //splitting by , each line
            String [] words = line.split(",");
            //adding to list
            wordsInline.add(words);
        }



        //HashMap<String, Integer> map = new HashMap<String, Integer>();
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();//sorted


        for(String[] words : wordsInline){
            //skipping first line with declarations
            if(words[15].equals("line"))
                continue;

            if(words[15].equals("Residential")){}
            //enumerating all records
            /*for(String word: words){
                System.out.print(word);
                //adding "|" after each word
                System.out.print("|");
            }*/

           //counting all lines with the same name
                    if(map.containsKey((words[15]))){
                        //if the record with the same name is found in map we increment k by 1
                        Integer k = map.get(words[15]);
                        k++;
                        map.put(words[15], k);
                    }else {
                        //if there is no records with such name we initialize k with 1
                        map.put(words[15], 1);
                    }




        }
        //we get the sum of records with name "Residential"
        //System.out.println(map.get("Residential"));

        //returns all keys
        for(String key : map.keySet()){
            System.out.println("Line: " + key + ", Quantity: " + map.get(key));
        };
    }
}
