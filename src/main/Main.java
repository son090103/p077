
package main;

import controller.Manager;
import view.Menu;


public class Main {
    public static void main(String[] args) {
        String title = "============ Word Program =========";
        String[] s = new String[]{"Count Word In File", "Find File By Word", "Exit"};
        Menu<String> menu = new Manager(title, s);
        menu.run();
    }
}
