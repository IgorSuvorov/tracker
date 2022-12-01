package actions;

import input.Input;
import output.Output;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit the application";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit the application ===");
        return false;
    }
}
