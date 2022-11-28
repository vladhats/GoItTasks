package HW11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

