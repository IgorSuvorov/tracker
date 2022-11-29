public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Showing all items ===" + System.lineSeparator());
        tracker.findAll();
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("There are no items in the storage yet");
        }
        return true;
    }
}
