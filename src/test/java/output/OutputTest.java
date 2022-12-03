package output;

import actions.*;
import input.Input;
import input.StubInput;
import model.Item;
import org.junit.jupiter.api.Test;
import start.StartUI;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    @Test
    public void whenEditItemTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit an item" + ln
                        + "1. Exit the application" + ln
                        + "=== Edit an item ===" + ln + ln
                        + "Item was edited successfully." + ln
                        + "Menu:" + ln
                        + "0. Edit an item" + ln
                        + "1. Exit the application" + ln
                        + "=== Exit the application ===" + ln
        );
    }

    @Test
    public void whenFindAllTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        List<UserAction> actions = List.of(
                new FindAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find all items" + ln
                        + "1. Exit the application" + ln
                        + "=== Showing all items ===" + ln + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Find all items" + ln
                        + "1. Exit the application" + ln
                        + "=== Exit the application ===" + ln
        );
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find an item by id" + ln
                        + "1. Exit the application" + ln
                        + "=== Find an item by ID ===" + ln + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find an item by id" + ln
                        + "1. Exit the application" + ln
                        + "=== Exit the application ===" + ln
        );
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "test1", "1"}
        );
        Item one = tracker.add(new Item("test1"));
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find an item by name" + ln
                        + "1. Exit the application" + ln
                        + "=== Find an item by name ===" + ln + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find an item by name" + ln
                        + "1. Exit the application" + ln
                        + "=== Exit the application ===" + ln
        );
    }
}
