package profplan.testutil;

import static profplan.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static profplan.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static profplan.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static profplan.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static profplan.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static profplan.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static profplan.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static profplan.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static profplan.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static profplan.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import profplan.model.ProfPlan;
import profplan.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task ALICE = new TaskBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends").withDueDate("01-01-2000").build();
    public static final Task BENSON = new TaskBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends").withDueDate("01-01-2000").build();
    public static final Task CARL = new TaskBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street")
            .withDueDate("01-01-2000").build();
    public static final Task DANIEL = new TaskBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street")
            .withTags("friends").withDueDate("01-01-2000").build();
    public static final Task ELLE = new TaskBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave")
            .withDueDate("01-01-2000").build();
    public static final Task FIONA = new TaskBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo")
            .withDueDate("01-01-2000").build();
    public static final Task GEORGE = new TaskBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").withDueDate("01-01-2000").build();

    // Manually added
    public static final Task HOON = new TaskBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india")
            .withDueDate("01-01-2000").build();
    public static final Task IDA = new TaskBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave")
            .withDueDate("01-01-2000").build();

    // Manually added - Task's details found in {@code CommandTestUtil}
    public static final Task AMY = new TaskBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
            .withTags(VALID_TAG_FRIEND).withDueDate("01-01-2000").build();
    public static final Task BOB = new TaskBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withDueDate("01-01-2000").build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical tasks.
     */
    public static ProfPlan getTypicalProfPlan() {
        ProfPlan ab = new ProfPlan();
        for (Task task : getTypicalTasks()) {
            ab.addTask(task);
        }
        return ab;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}