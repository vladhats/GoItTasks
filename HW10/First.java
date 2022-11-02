package HW10;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class First {
    public static void main(String[] args) throws IOException {
        filter();
    }

    public static void filter() throws IOException {
        File file = new File("phoneNumbers.txt");
        FileWriter fos = new FileWriter(new File("validOnes.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Pattern p1 = Pattern.compile("(\\d){3}-(\\d){3}-(\\d){4}");
            Pattern p2 = Pattern.compile("\\(\\d\\d\\d\\)\\s(\\d){3}-(\\d){4}");
            while ((line = br.readLine()) != null) {
                Matcher m1 = p1.matcher(line);
                Matcher m2 = p2.matcher(line);
                if(m1.matches()| m2.matches()){
                    System.out.println(line);
                     fos.write(line+"\n");
                    ;


                }
            }
            fos.flush();
        }

    }
}
