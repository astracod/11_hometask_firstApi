package org.example.apiworkout.menu.menu_implementation;


import lombok.AllArgsConstructor;
import org.example.apiworkout.WorkApi;
import org.example.apiworkout.menu.menu_action.MenuAction;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


@AllArgsConstructor
public class RemoveTask implements MenuAction {

    private Scanner scanner;
    private PrintStream out;
    private WorkApi workApi;

    @Override
    public String getActionName() {
        return " Удалить задачу.";
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        out.println(" Введите номер задачи");
        Long number = Long.parseLong(scanner.nextLine());
        workApi.removeTask(number);
    }

    @Override
    public boolean exitMethod() {
        return false;
    }
}
