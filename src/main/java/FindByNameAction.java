public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find an item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
