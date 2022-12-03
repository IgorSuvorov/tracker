package start;

import actions.Tracker;
import model.Item;

import java.util.List;

public class SingleTracker {
    private static SingleTracker instance = null;

    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public boolean edit(int id, Item item) {
        return tracker.edit(id, item);
    }
}
