package HW10;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Third{
        public static void main(String[]args) throws FileNotFoundException {

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
    }


