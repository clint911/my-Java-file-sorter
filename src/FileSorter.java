import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
public  class FileSorter {

    public static void myRecursivePrinter(File[] arr, int index, int level) {
        //terminate condition
        if  (index == arr.length)    {
            return;
        }
        //tabs for internal levels
        for     (int i = 0; i < level; i++)     {
            System.out.println("\t");
        }
        //for files
        if (arr[index].isFile())    {
            System.out.println(arr[index].getName());
        }
        //for subdirectories
        else if(arr[index].isDirectory()) {
            System.out.println("[" + arr[index].getName() + "]");
            //recursion for sub-directories
            //Note is something says null then it is from around here
            myRecursivePrinter(arr[index].listFiles(), 0, level + 1);
        }
        //performing recursion for the main directory
        myRecursivePrinter(arr, ++index, level);

    }

    //We use our main method as our driver method
    public static void main(String[] args) {
        //Here we provide full path(change accordingly)
        String maindirpath = "./clintonNewFolder";
        File maindir = new File(maindirpath);
            //array for files and subdirectories of directory pointed by maindir
            File arr[] = maindir.listFiles();
            System.out.println("**************************************************************");
            System.out.println("Files from main directory: " + maindir);
            System.out.println("***************************************************************");

            //calling our recursive Method
            myRecursivePrinter(arr, 0, 0);
        }


}