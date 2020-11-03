package org.example.apiworkout;

import com.google.gson.Gson;
import org.example.apiworkout.menu.Menu;
import org.example.apiworkout.menu.menu_action.MenuAction;
import org.example.apiworkout.menu.menu_implementation.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        HttpClient client = HttpClient.newBuilder().build();
        WorkApi workApi = new WorkApi(gson, client);
        Scanner scanner = new Scanner(System.in);
        List<MenuAction> list = new ArrayList<>();
        list.add(new CreateTask(scanner, System.out, workApi));
        list.add(new RemoveTask(scanner, System.out, workApi));
        list.add(new ShowTask(System.out, workApi));
        list.add(new ShowDescription(workApi,scanner,System.out));
        list.add(new ExitMenu(System.out));
        Menu menu = new Menu(list, System.out, scanner);
        menu.run();
    }
}
