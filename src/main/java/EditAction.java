public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
