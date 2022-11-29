public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit the application";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Exit the application ===");
        return false;
    }
}
