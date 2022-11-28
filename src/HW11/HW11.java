package HW11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static HW11.Fourth.zip;

public class HW11 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Аскольд");
        names.add("Дір");
        names.add("Ігор");
        names.add("Ольга");
        names.add("Святослав");
        names.add("Володимир");
        names.add("Ярослав");
        names.add("Ярополк");
        names.add("Святополк");
        names.add("Андрій");
        names.add("Степан");

        String[] array = new String[]{"1, 2, 0", "4, 5"};

        System.out.println(first(names));
        System.out.println(second(names));

        Stream<Integer> stream1 =  Stream.of(1,2,3,4,5,6,7,8);
        Stream<Integer> stream2 =  Stream.of(9,10,11,12,13);

        System.out.println(third(array));

 Stream.iterate(1, x -> x < x+1 , x -> x+1).forEach(x -> new Fourth(x).rand());

        System.out.println(zip(stream1, stream2));
    }



        public static  String first(List list){
            StringBuilder sb = new StringBuilder();
            for(Object o:list){
                if(list.indexOf(o)%2 != 0){
                    sb.append(list.indexOf(o));
                    sb.append(". ");
                    sb.append(o);
                    if(list.size()-1 > list.indexOf(o) && list.size()-2 > list.indexOf(o)){
                        sb.append(", ");
                    }
                }
            }
            return sb.toString().trim();
        }
    public static List second(List list){
        List list1 = (List) list.stream()
                .sorted()
                .map(object -> object.toString().toUpperCase())
                .collect(Collectors.toList());

        return list1 ;
    }
    public static String third(String[] array){
        String result = Stream.of(array).map(s -> {
            ArrayList<Integer> tempInt = new ArrayList<>();
            String[] splited;
            for (int i = 0; i < array.length; i++) {
                splited = array[i].split(", ",0);
                for (int j = 0; j < splited.length; j++) {
                    tempInt.add(Integer.parseInt(splited[j]));
                }
            }
            return tempInt;
        }).map(s -> {  StringBuilder sb = new StringBuilder("\"");
            Collections.sort(s);
            for(Integer i:s){
                sb.append(i);
                if(s.indexOf(i) != s.size()-1){
                    sb.append(", ");
                }
            }
            sb.append("\"");
            return sb.toString();}).collect(Collectors.toSet()).toString();
        return result;
    }}


