package start;

import actions.Tracker;
import model.Item;

public class SingleTracker {
    private static SingleTracker instance = null;

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    private SingleTracker() {
    }

    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public boolean edit(int id, Item item) {
        return tracker.edit(id, item);
    }
}
