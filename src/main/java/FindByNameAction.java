public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find an item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find an item by name ===" + System.lineSeparator());
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Item(s) with this name: " + name + " was not found.");
        }
        return true;
    }
}
