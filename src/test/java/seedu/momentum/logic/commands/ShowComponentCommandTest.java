package seedu.momentum.logic.commands;

import static seedu.momentum.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.momentum.testutil.Assert.assertThrows;
import static seedu.momentum.testutil.TypicalProjects.getTypicalProjectBook;

import org.junit.jupiter.api.Test;

import seedu.momentum.logic.parser.ShowComponentCommandParser;
import seedu.momentum.model.Model;
import seedu.momentum.model.ModelManager;
import seedu.momentum.model.UserPrefs;

public class ShowComponentCommandTest {
    @Test
    public void constructor_nullProject_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ShowComponentCommand(null));
    }

    @Test
    public void execute_showComponent_throwsCommandException() {
        Model model = new ModelManager(getTypicalProjectBook(), new UserPrefs());
        ShowComponentCommand showComponentCommand =
                new ShowComponentCommand(ShowComponentCommandParser.ComponentType.REMINDER);
        assertCommandFailure(showComponentCommand, model, ShowComponentCommand.MESSAGE_FAILURE);
    }
}
