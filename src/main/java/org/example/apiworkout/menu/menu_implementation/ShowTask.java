package org.example.apiworkout.menu.menu_implementation;

import lombok.AllArgsConstructor;

import org.example.apiworkout.WorkApi;
import org.example.apiworkout.dto.ResponseTaskTwo;
import org.example.apiworkout.menu.menu_action.MenuAction;

import java.io.IOException;
import java.io.PrintStream;


@AllArgsConstructor
public class ShowTask implements MenuAction {


    private PrintStream out;
    private WorkApi workApi;

    @Override
    public String getActionName() {
        return " Показать задачи.";
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        for (ResponseTaskTwo task : workApi.getTasks()) {
            out.println(" Задача "+task.getId()+" )"+task.getName());
        }
    }

    @Override
    public boolean exitMethod() {
        return false;
    }
}
