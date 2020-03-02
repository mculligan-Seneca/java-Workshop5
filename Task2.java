/*
name: Mitchell Culligan
id: 161293170
email: mculligan@myseneca.ca
Professor : Mahboob Ali
date : Feb 21st 2020
 */

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;


public class Task2 {

    public static void main(String[] args){
        String fileName;
        File file ;
        Scanner input = new Scanner(System.in);
        int numBytesRead;
        Integer l;
        char[] buff = new char[8192];//default buffer size ~8192
        HashMap<Character,Integer> alpha= new HashMap<>();

        for(int i=0;i<26;i++)
                alpha.put(Character.valueOf((char) ('A' + i)), 0);
        for(int i=0;i<26;i++)
                alpha.put(Character.valueOf((char)('a'+i)),0);

        System.out.print("Enter the name of the file: ");
        fileName = input.nextLine();//REMEMBER to add src in intellij
        file = new File(fileName.trim());
        if(file.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(file))){

                long startTime = System.nanoTime();
                while((numBytesRead=br.read(buff))!=-1) {
                    for (int i = 0; i < numBytesRead; i++) {
                       l = alpha.get(buff[i]);
                       if(l!=null) {
                           l += 1;
                           alpha.replace(buff[i], l);
                       }
                    }

                }
                alpha.forEach((k,v)-> System.out.printf("%c found %d times\n",k,v));
                long endTime = System.nanoTime();
                System.out.printf("Time in ms: %f", (endTime-startTime)/1000000.0);
            } catch (IOException ioe) {
                ioe.printStackTrace();

            }
        }else
            System.out.println("Bad file Does't exist!");


    }


}
