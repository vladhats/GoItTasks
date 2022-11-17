package HW10;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;

public class HW10 {
    public HW10() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
//        first();
        second();
//        third();
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

    public static void second() throws IOException {
        File file = new File("nameAgeToWrite.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<User> users = new ArrayList<>();
        String line = "";
        while((line=reader.readLine()) !=null){
                if (!((line = reader.readLine()) != null)) break;
                String[] params = line.split(" ", 2);
                String name = params[0];
                int age = Integer.parseInt(params[1]);
                //User user =
                users.add(new User(name, age));
        }
        users.remove(0);
        // User users = new User("Billy", 4); так все працює
        OutputStream out = new FileOutputStream("nameAge.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String string = gson.toJson(users);
        out.write(string.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
        System.out.println(string);//for checking
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

    static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.age = age;
            this.name = name;
        }
    }
}

