package actions;

import input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}