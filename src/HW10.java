import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;

public class HW10 {
    public static void main(String[] args) throws IOException {
        first();
    }

    public static void first() throws IOException {
        File file = new File("phoneNumbers.txt");
        FileWriter fos = new FileWriter(new File("validOnes.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Pattern p1 = Pattern.compile("(\\d){3}-(\\d){3}-(\\d){4}");
            Pattern p2 = Pattern.compile("\\(\\d\\d\\d\\)\\s(\\d){3}-(\\d){4}");
            while ((line = br.readLine()) != null) {
                Matcher m1 = p1.matcher(line);
                Matcher m2 = p2.matcher(line);
                if (m1.matches() | m2.matches()) {
                    System.out.println(line);
                    fos.write(line + "\n");
                    ;


                }
            }
            fos.flush();
        }

    }

    public void second() throws IOException {
        File file = new File("nameAgeToWrite.txt"); // файл з іменами та віко
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // рахуємо кількість рядків
        int lines = 0;
        while (true) {
            try {
                if (!(reader.readLine() != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            lines++;
        }
        System.out.println("Lines amount is " + lines);
        List<User> users = new ArrayList<>(); // перший рядок не несе інформації і не входитиме в число юзерів
        String line = "";
        int i = 0;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (i != 0) {
                String[] params = line.split(" ", 2);
                String name = params[0];
                int age = Integer.parseInt(params[1]);
                users.add(new User(name,age)); // тому що вже і = 1, але ми хочемо записати тільки першого Юзера
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

    public static void third ()throws FileNotFoundException {

        String name = "countWords.txt";
        InputStream i = new FileInputStream(name);
        Scanner scanner = new Scanner(i);
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> unique = new HashMap<>();
        while(scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        String line = sb.toString();
        String[] words = line.split(" ");
        for ( String word: words) {
            if(!unique.containsKey(word)){
                unique.put(word, 1);
            } else {
                Integer current = unique.get(word);
                unique.put(word, current+1);
            }

        }
//            for(String//            }
        Comparator comparator = new Comparator() {
            Map<String, Integer> local = unique;
            @Override
            public int compare(Object o1, Object o2) {
                return local.get(o1)< local.get(o2) ? 1: -1;
            }
        };
        Map<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(unique);
        System.out.println(treeMap);

    }

    class User {
        String name;
        int age;

        public User(String name, int age) {
            this.age = age;
            this.name = name;
        }
    }
}

