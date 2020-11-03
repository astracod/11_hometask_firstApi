package org.example.apiworkout.menu.menu_implementation;

import lombok.AllArgsConstructor;
import org.example.apiworkout.WorkApi;
import org.example.apiworkout.dto.ResponseTaskTwo;
import org.example.apiworkout.menu.menu_action.MenuAction;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@AllArgsConstructor
public class ShowDescription implements MenuAction {

    private WorkApi workApi;
    private Scanner scanner;
    private PrintStream out;

    @Override
    public String getActionName() {
        return " Посмотреть описание задачи.";
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        out.println(" Какую задачу Вы хотите просмотреть?");
        long id = Long.parseLong(scanner.nextLine());
        for (ResponseTaskTwo task : workApi.getTasks()) {
            if (task.getId() == id) out.println(task.getDescription());
        }
    }

    @Override
    public boolean exitMethod() {
        return false;
    }
}
