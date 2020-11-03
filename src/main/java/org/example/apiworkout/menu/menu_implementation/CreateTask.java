package org.example.apiworkout.menu.menu_implementation;

import lombok.AllArgsConstructor;
import org.example.apiworkout.WorkApi;
import org.example.apiworkout.menu.menu_action.MenuAction;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


@AllArgsConstructor
public class CreateTask implements MenuAction {

    private Scanner scanner;
    private PrintStream out;
    private WorkApi workApi;

    @Override
    public String getActionName() {
        return " Создать задачу.";
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        out.println(" Введите название задачи");
        String firstArg = scanner.nextLine();
        out.println(" Введите описание задачи");
        String secondArg = scanner.nextLine();
        workApi.createTask(firstArg, secondArg);
    }

    @Override
    public boolean exitMethod() {
        return false;
    }
}
