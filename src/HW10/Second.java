package HW10;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

class User{
    String name;
    int age;
    public User(String name, int age){
        this.age = age;
        this.name = name;
    }
}
 class Second {
     public static void main(String[] args) throws IOException {
         File file = new File("nameAgeToWrite.txt"); // файл з іменами та віком
         BufferedReader reader = new BufferedReader(new FileReader(file));
          // рахуємо кількість рядків
         int lines  = 0;
         while(reader.readLine()!=null){
             lines++;
         }
         System.out.println("Lines amount is "+lines);
         User[] users = new User[lines-1]; // перший рядок не несе інформації і не входитиме в число юзерів
         String line = "";
         int i = 0;
         while((line = reader.readLine()) != null) {
             if (i != 0) {
                 String[] params = line.split(" ",2);
                 String name = params[0];
                 int age = Integer.parseInt(params[1]);
                 users[i-1] = new User(name, age); // тому що вже і = 1, але ми хочемо записати тільки першого Юзера
                 lines--;
                 i++;


             } else i++;//пропускаємо перший рядок в файлі
         }

       // User users = new User("Billy", 4); так все працює
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         OutputStream out = new FileOutputStream("nameAge.json");
         String string = gson.toJson(users);
         out.write(string.getBytes(StandardCharsets.UTF_8));
         out.flush();
         out.close();
         System.out.println(string);
     }

    public Second() throws FileNotFoundException {
    }
}
