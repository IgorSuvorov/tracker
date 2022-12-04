package model;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item one, Item two) {
        return one.getName().compareTo(two.getName());
    }
}