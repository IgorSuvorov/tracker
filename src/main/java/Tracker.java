import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        return indexOf(id) != -1 ? items[indexOf(id)] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                rsl[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    public boolean replace(int id, Item item) {
        boolean valid = indexOf(id) != -1;
        if (valid) {
            item.setId(id);
            items[indexOf(id)] = item;
        }
        return valid;
    }

    public boolean delete(int id) {
        boolean valid = indexOf(id) != -1;
        if (valid) {
            System.arraycopy(items, indexOf(id) + 1, items, indexOf(id),  size - indexOf(id) - 1);
            items[size - 1] = null;
            size--;
        }
        return valid;
    }
}