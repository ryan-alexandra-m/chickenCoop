package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;

public class FileCreate {
    //The local date that allows us to get todays date, as well as name- which is the name of the file as a String
    LocalDate today;
    String name;

    //Our constructor for creatign a file, with the date, as well as the name of the File
    public FileCreate(LocalDate today, String name) {
        this.today = today;
        this.name = name;
    }

    //This allows us to  create a file, and since name comes into the constructor, we can take it from there. This function
    //allows us to access and edit this file later in the code.
    public void createFile() throws IOException {
        String fileName = name + ".txt";
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File created.");
        } else {
            System.out.println("File already exists.");
        }
    }

    //This is a write to file function, but with the array list conditions, whihc is a serpperate way of writing to the file
    public void addConditions(String a, ArrayList arrayList, String fileName, int line){
        try{
            FileWriter myWrite= new FileWriter(fileName + ".txt");
            BufferedWriter buf= new BufferedWriter(myWrite);
            LineNumberReader lnr = new LineNumberReader(new FileReader(fileName + ".txt"));
            lnr.setLineNumber(line);
            for(int i=1;i<lnr.getLineNumber();i++){
                buf.newLine();
            }
            buf.write("health conditions "+ String.valueOf(arrayList)+ "\n"+ a);
            buf.newLine();
            buf.close();
            System.out.println("Wrote to file");
        }catch (IOException e){
            System.out.println("an error occured.");
            e.printStackTrace();
        }}

    //This read file function- 1) reads what is currently in the file, 2) makes that into a string to be able to be accessed later
    public static String readFile(String message) throws IOException {
        Path path= Paths.get(message);
        byte[] b= {};
        try{
            b=Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String contents= new String(b);
        return contents;}

    //The variable already is where we will put the read file, mes is the message we will put into the file, and fileName is the name, and line is where we want to
    //put it using lineNumberReader.
    public void finalWrite(String already, String mes, String fileName, int line){
        try{
            FileWriter myWrite= new FileWriter(fileName + ".txt");
            BufferedWriter buf= new BufferedWriter(myWrite);
            LineNumberReader lnr = new LineNumberReader(new FileReader(fileName + ".txt"));
            lnr.setLineNumber(line);
            for(int i=1;i<lnr.getLineNumber();i++){
                buf.newLine();
            }
            buf.write(already+ "\n" +mes);
            buf.newLine();
            buf.close();
            System.out.println("Wrote to file");
        }catch (IOException e){
            System.out.println("an error occured.");
            e.printStackTrace();
        }}
}
