

public class StartUI {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Added item: " + item);
    }

    public static void findAllItems(Input input, Tracker tracker) {
        System.out.println("=== Showing all items ===" + System.lineSeparator());
        tracker.findAll();
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are no items in the storage yet");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit an item ===" + System.lineSeparator());
        int id = input.askInt("Enter id: ");
        System.out.println();
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            System.out.println("Item was deleted successfully.");
        } else {
            System.out.println("Error.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete an item ===" + System.lineSeparator());
        int id = input.askInt("Enter id: ");
        tracker.delete(id);
        if (tracker.delete(id)) {
            System.out.println("Item was deleted successfully.");
        } else {
            System.out.println("Error.");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        System.out.println("=== Find an item by ID ===" + System.lineSeparator());
        int id = input.askInt("Enter id: ");
        tracker.findById(id);
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item(s) with this id: " + id + " was not found.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find an item by Name ===" + System.lineSeparator());
        String name = input.askStr("Enter name: ");
        tracker.findByName(name);
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Item(s) with this name: " + name + " was not found.");
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(input, tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemByID(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                System.out.println("Goodbye!");
                run = false;
            }
        }
    }
}
