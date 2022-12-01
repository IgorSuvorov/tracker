package actions;

import input.Input;
import output.Output;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete an item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete an item ===" + System.lineSeparator());
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("model.Item was deleted successfully.");
        } else {
            out.println("Error.");
        }
        return true;
    }
}
