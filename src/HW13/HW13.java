package HW13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HW13 {
        public static void main(String[] args) {
            Map<String, Object> test = new HashMap<>() {
            };


            User user = new User(11, "Test user", "Test username", "fsdfds@mail.com");

            File file = new File("src/UsersOutput/UserGet.txt");

           Methods methods = new Methods();
            String url = "https://jsonplaceholder.typicode.com/users";


            //Task 1


            methods.getAllUserInfo(url);


            ArrayList<Object> userArrayList = null;
            try {
                userArrayList = methods.jsonToObjectArray(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            methods.postUser(user, url);


            methods.putUser(userArrayList, 4, url);


            methods.deleteUser(userArrayList, 4, url);


            methods.getUserInfoWithID(3, url);


            methods.getUserInfoWithUserName("Samantha", url);


            // Task 2

            methods.getCommentsToLastPost(2);


            // Task 3

            methods.completion(1);


        }
    }

