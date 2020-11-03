package org.example.apiworkout.menu;

import lombok.AllArgsConstructor;
import org.example.apiworkout.menu.menu_action.MenuAction;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class Menu {
    private List<MenuAction> menuActions;
    private PrintStream out;
    private Scanner scanner;

    private void showMenu() {
        for (int i = 0; i < menuActions.size(); i++) {
            out.println((i + 1) + " )" + menuActions.get(i).getActionName());
        }
    }

    private int getUserChoice() {
        out.println(" Введите пункт меню :");
        return Integer.parseInt(scanner.nextLine()) - 1;
    }

    public void run() throws IOException, InterruptedException {

        while (true){
            showMenu();
            int index = getUserChoice();
            if (index < 0 || index >= menuActions.size()){
                throw new IndexOutOfBoundsException();
            }
            menuActions.get(index).execute();
            if (menuActions.get(index).exitMethod()) break;
        }


    }
}
