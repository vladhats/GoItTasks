package HW10;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class Third{
        public static void main(String[]args) throws FileNotFoundException {
            String name = "text.txt";
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
            System.out.println(unique);
        }
    }


