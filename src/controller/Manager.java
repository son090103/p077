/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.ListandSearch;
import view.Menu;

/**
 *
 * @author son
 */
public class Manager extends Menu{
     private static final Scanner sc = new Scanner(System.in);

    ListandSearch list = new ListandSearch();
    public Manager(String title, String[] s){
        super(title, s);
    }

    @Override
    public void execute(int n) {
        switch (n) {

            case 1:
               list.countWordInFile();
                break;
            case 2:
                list.searchFilesContainingWord();
               break;
            case 3:
                System.exit(0);        
        }
    }
}
