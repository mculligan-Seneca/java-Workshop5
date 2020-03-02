/*
name: Mitchell Culligan
id: 161293170
email: mculligan@myseneca.ca
Professor : Mahboob Ali
date : Feb 21st 2020
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class Task1 {
        private static final char[][] KEYPAD = {{'A','B','C'},
                                                {'D','E','F'},
                                                {'G','H','I'},
                                                {'J','K','L'},
                                                {'M','N','O'},
                                                {'P','R','S'},
                                                {'T','U','V'},
                                                {'W','X','Y'} };




    public static void main(String[] args) {
        String number;
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[7];
        //BufferedOutputStream os = null;

        System.out.print("Enter the phone number: ");
        while(!input.hasNext("[2-9]{3}-?[2-9]{4}$")){
            input.nextLine();
            System.out.print("Invalid phone Number\nEnter the phone number: ");
        }
        number = input.nextLine().trim().replaceAll("-","");

        for(int i=0;i<numbers.length;i++){
            numbers[i]= Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        try( BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("PhoneNumberWords.txt"))){
            writeCombos(new StringBuilder(),os,numbers,0);
        }catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
    public static void writeCombos(StringBuilder sb,BufferedOutputStream os, int[] numbers, int index)throws IOException {
            int key = numbers[index]-2;

            for(int i=0; i<KEYPAD[key].length;i++){
                sb.append(KEYPAD[key][i]);
                if(index==numbers.length-1){
                    os.write(sb.toString().getBytes());
                    os.write(System.getProperty("line.separator").getBytes());
                }
                else writeCombos(sb, os, numbers, index + 1);

                sb.deleteCharAt(index);

            }
            


    }
}
