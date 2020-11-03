package org.example.apiworkout.menu.menu_implementation;

import lombok.AllArgsConstructor;
import org.example.apiworkout.menu.menu_action.MenuAction;
import java.io.PrintStream;


@AllArgsConstructor
public class ExitMenu implements MenuAction {

    private PrintStream out;

    @Override
    public String getActionName() {
        return " Выход.";
    }

    @Override
    public void execute() {
        out.println(" Всего доброго");
    }

    @Override
    public boolean exitMethod() {
        return true;
    }
}
