package HW13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Methods<T> {


    public void getAllUserInfo(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/UsersOutput/UserGet.txt")));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void postUser(User user, String url) {
        // Post user works: response.statusCode() = 201
//        response.body() = {
//                "id": 11
//}
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(user)))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response.statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<T> jsonToObjectArray(File file) throws FileNotFoundException { // Works Fine
        return new Gson().fromJson(new JsonReader(new FileReader(file)), new TypeToken<List<T>>() {
        }
                .getType());
    }


    public void putUser(ArrayList<User> user, int id, String url) {

        String uri = url + "/" + (id);
        String userWithId = String.valueOf(user.get(id));


        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .version(HttpClient.Version.HTTP_1_1)
                .timeout(Duration.ofMinutes(1))
                .PUT(HttpRequest.BodyPublishers.ofString(userWithId))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response_PUT_statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void deleteUser(ArrayList<User> user, int id, String url) {

        String uri = url + "/" + (id);
        String userWithId = String.valueOf(user.get(id));

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .version(HttpClient.Version.HTTP_1_1)
                .timeout(Duration.ofMinutes(1))
                .method("DELETE", HttpRequest.BodyPublishers.ofString(userWithId))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response_Delete_statusCode() = " + response.statusCode());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void getUserInfoWithID(int id, String url) {
        String uri = url + "/" + id;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/UsersOutput/Get$" + id + "$User.txt")));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void getUserInfoWithUserName(String name, String url) {

        String uri = url + "?username=" + name;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/UsersOutput/Get$" + name + "$User.txt")));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getLastPost(int userId) {
        URI url = null;
        try {
            url = new URI("https://jsonplaceholder.typicode.com/users/" + userId + "/posts");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        List<UserMake> posts = new Gson().fromJson(response.body(), new TypeToken<List<UserMake>>() {
        }
                .getType());
        return getLastPostId(posts);
    }

    public void getCommentsToLastPost(int userId) {
        int lastPostId = getLastPost(userId);
        URI uri = null;
        try {
            uri = new URI("https://jsonplaceholder.typicode.com/posts/" + userId + "/comments");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        List<Commentary> comments = new Gson().fromJson(response.body(), new TypeToken<List<Commentary>>() {
        }
                .getType());
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("src/UsersOutput/user-" + userId +
                "-post-" + lastPostId + "-comments.txt")) {
            gson.toJson(comments, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getAllCommentsToPost(comments));

    }

    public void completion(int id) {
        URI uri = null;
        try {
            uri = new URI("https://jsonplaceholder.typicode.com/users/" + id + "/todos");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();


        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        List<UserSetters> toDo = new Gson().fromJson(response.body(), new TypeToken<List<UserSetters>>() {
        }
                .getType());

        System.out.println("\nTo do list:\n" + findNotDoneTasks(toDo));

    }


    private int getLastPostId(List<UserMake> post) {
        Integer lastId = 0;
        for (int i = 0; i < post.size(); i++) {
            UserMake o = post.get(i);
            if (o.getId() > lastId) {
                lastId = o.getId();
            }
        }
        return lastId;
    }

    private StringBuilder getAllCommentsToPost(List<Commentary> comments) {
        StringBuilder sb = new StringBuilder("Comments:\n");
        for (int i = 0; i < comments.size(); i++) {
            Commentary o = comments.get(i);
            sb.append(o.toString());
        }
        return sb;
    }

    private StringBuilder findNotDoneTasks(List<UserSetters> toDoSTasks) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toDoSTasks.size(); i++) {
            UserSetters o = toDoSTasks.get(i);
            if (!o.isCompleted()) {
                sb.append(o);
            }
        }
        return sb;
    }
}
