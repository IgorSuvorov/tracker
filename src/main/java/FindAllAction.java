public class FindAllAction implements UserAction{
    @Override
    public String name() {
        return "Find all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
