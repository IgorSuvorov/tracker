package lambda;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        List<String> list = List.of("two", "three", "four", "five", "six", "seven");

        for (int i = 1; i <= 7; i++) {
            biCon.accept(i, list.get(i - 1));
        }

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Consumer<String> con = (str) -> System.out.println(str);
        Function<String, String> func = (str) -> str.toUpperCase();
        for (String str : sup.get()) {
            con.accept(func.apply(str));
        }
    }
}