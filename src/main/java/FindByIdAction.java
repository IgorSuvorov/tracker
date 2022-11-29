public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find an item by ID ===" + System.lineSeparator());
        int id = input.askInt("Enter id: ");
        tracker.findById(id);
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item(s) with this id: " + id + " was not found.");
        }
        return true;
    }
}
