package HW11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        //fourth
//        Stream.iterate(1, x -> x < x+1 , x -> x+1).forEach(x -> new Fourth(x).rand());

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
    }

        public class Fourth {
            private int x;
            private long a;
            private int c;
            private int m;


            public Fourth(int x, long a, int c, int m) {
                this.x = Math.abs(x);
                this.a = a;
                this.c = c;
                this.m = m;
            }

            public Fourth(int x) {
                this.x = x;
                this.a = 25214903917L;
                this.c = 11;
                this.m = (int) Math.pow(2, 48);
            }

            public long rand() {
                x = (int) ((a * x + c) % m);
                return x;
            }


        }

            public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
                List<T> firstList = first.collect(Collectors.toList());
                List<T> secondList = second.collect(Collectors.toList());
                List<T> result = new ArrayList<>();
                int minListLength = 0;
                int list1Index = 0;
                int list2Index = 0;
                if (firstList.size() > secondList.size()) {
                    minListLength = secondList.size();
                } else {
                    minListLength = firstList.size();
                }

                for (int i = 0; i < minListLength*2; i++) {
                    if (i % 2 == 0) {
                        result.add(firstList.get(list1Index));
                        list1Index++;
                    } else {
                        result.add(secondList.get(list2Index));
                        list2Index++;
                    }
                }

                return result.stream();
            }
        }

