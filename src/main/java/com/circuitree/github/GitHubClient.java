package com.circuitree.github;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GitHubClient {
    private static final OkHttpClient httpClient = new OkHttpClient();

    public static List<JsonElement> getSortedRepos(String username) {
        Request request = new Request.Builder()
                .url("https://api.github.com/users/" + username + "/repos?per_page=100")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.body() == null) return List.of();

            JsonArray repos = JsonParser.parseString(response.body().string()).getAsJsonArray();

            List<JsonElement> repoList = new ArrayList<>();
            repos.forEach(repoList::add);

            repoList.sort(Comparator.comparing(
                    e -> e.getAsJsonObject().get("pushed_at").getAsString(),
                    Comparator.reverseOrder()
            ));

            return repoList;
        } catch (IOException e) {
            System.err.println("Request failed: " + e.getMessage());
            return List.of();
        }
    }
}