package org.example.apiworkout;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import org.example.apiworkout.dto.CreateResponseTaskThree;
import org.example.apiworkout.dto.CreateTaskRequest;
import org.example.apiworkout.dto.ResponseTaskTwo;
import org.example.apiworkout.dto.StatusResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class WorkApi {

    private Gson gson ;
    private HttpClient client ;


    public StatusResponse createTask(String firstArg, String secondArg) throws IOException, InterruptedException {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest(firstArg, secondArg);
        String body = gson.toJson(createTaskRequest);
        HttpResponse<String> response = client.send(createRequestToCreateTask(body), HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), StatusResponse.class);
    }

    private HttpRequest createRequestToCreateTask(String body) {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://simple-api-mamedov.herokuapp.com/task/create"))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .build();
    }

    public List<ResponseTaskTwo> getTasks() throws IOException, InterruptedException {
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://simple-api-mamedov.herokuapp.com/tasks"))
                .build();
        HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        String body1 = response1.body();
        return gson.fromJson(body1, new TypeToken<ArrayList<ResponseTaskTwo>>() {
        }.getType());
    }

    public StatusResponse removeTask(Long numberTask) throws IOException, InterruptedException {
        CreateResponseTaskThree createResponseTaskThree = new CreateResponseTaskThree(numberTask);
        String body = gson.toJson(createResponseTaskThree);
        HttpResponse<String> response2 = client.send(createRequestToRemoveTask(body), HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response2.body(), StatusResponse.class);
    }

    private HttpRequest createRequestToRemoveTask(String body) {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://simple-api-mamedov.herokuapp.com/task/remove"))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .build();
    }

}
