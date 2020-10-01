package chapter13;


import java.io.*;

import java.util.*;

public class ExceptionHandling {

    public static void main(String args[]){
        createNewFile();
        numbersExceptionHandling();
    }

    public static void createNewFile(){
        File file = new File("resources/nonexistent.txt");
        try{
            file.createNewFile();
        }catch (FileNotFoundException e){
            System.out.println("Directory does not exist.");
            e.printStackTrace();
        }
    }

    public static void createNewFileRethrow() throws IOException{
        File file = new File("resources/nonexistent.txt");
        file.createNewFile();
    }

    public static void numbersExceptionHandling(){
        File file = new File("resources/numbers.txt");
        Scanner fileReader = null;
        try{
            fileReader = new Scanner(file);
            while(fileReader.hasNext()){
                double num = fileReader.nextDouble();
                System.out.println(num);
            }
        }catch(FileNotFoundException e){
             throw InputMismatchException;
            e.printStackTrace();
        }finally{
            fileReader.close();
        }
    }


    public static void tryWithResources(){
        File file = new File("resources/numbers.txt");
        try(Scanner fileReader = new Scanner(file)){
            while(fileReader.hasNext()){
                double num = fileReader.nextDouble();
                System.out.println(num);
            }
        }catch(FileNotFoundException){
            throw InputMismatchException;
            e.printStackTrace();
        }
    }
}
