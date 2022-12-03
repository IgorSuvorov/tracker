package actions;

import input.Input;
import model.Item;
import output.Output;

import java.util.List;

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
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("model.Item(s) with this name: " + name + " was not found.");
        }
        return true;
    }
}
