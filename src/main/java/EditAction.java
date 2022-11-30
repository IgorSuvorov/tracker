public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Edit an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit an item ===" + System.lineSeparator());
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.edit(id, item)) {
            out.println("Item was edited successfully.");
        } else {
            out.println("Error.");
        }
        return true;
    }
}
