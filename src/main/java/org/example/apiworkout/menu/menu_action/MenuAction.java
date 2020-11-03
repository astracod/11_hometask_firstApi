package org.example.apiworkout.menu.menu_action;

import java.io.IOException;

public interface MenuAction {

        String getActionName();
        void execute() throws IOException, InterruptedException;
        boolean exitMethod();

}
