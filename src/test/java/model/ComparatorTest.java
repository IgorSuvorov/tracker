package model;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {
    @Test
    public void ascOrderSort() {
        List<Item> items = Arrays.asList(
                new Item("C"),
                new Item("A"),
                new Item("D"),
                new Item("B"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C"),
                new Item("D"));
        assertEquals(items, expected);
    }

    @Test
    public void descOrderSort() {
        List<Item> items = Arrays.asList(
                new Item("C"),
                new Item("A"),
                new Item("D"),
                new Item("B"));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("D"),
                new Item("C"),
                new Item("B"),
                new Item("A"));
        assertEquals(items, expected);
    }
}
