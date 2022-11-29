public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "Delete an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete an item ===" + System.lineSeparator());
        int id = input.askInt("Enter id: ");
        tracker.delete(id);
        if (tracker.delete(id)) {
            System.out.println("Item was deleted successfully.");
        } else {
            System.out.println("Error.");
        }
        return true;
    }
}
