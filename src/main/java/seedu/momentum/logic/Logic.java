package seedu.momentum.logic;

import java.nio.file.Path;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.momentum.commons.core.GuiSettings;
import seedu.momentum.logic.commands.CommandResult;
import seedu.momentum.logic.commands.exceptions.CommandException;
import seedu.momentum.logic.parser.exceptions.ParseException;
import seedu.momentum.logic.statistic.StatisticGenerator;
import seedu.momentum.model.ReadOnlyProjectBook;
import seedu.momentum.model.project.TrackedItem;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     *
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException   If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns true if the reminder is empty, false otherwise.
     *
     * @return the boolean.
     */
    BooleanProperty isReminderEmpty();

    /**
     * Returns the string representation of the reminder.
     *
     * @return the reminder.
     */
    StringProperty getReminder();

    /**
     * Returns the ProjectBook.
     *
     * @see seedu.momentum.model.Model#getProjectBook()
     */
    ReadOnlyProjectBook getProjectBook();

    /**
     * Returns an unmodifiable view of the filtered list of tracked items.
     */
    ObjectProperty<FilteredList<TrackedItem>> getObservableFilteredTrackedItemList();

    /**
     * Returns a list of projects whose timers are running.
     */
    ObservableList<TrackedItem> getRunningTimers();

    /**
     * Returns the user prefs' project book file path.
     */
    Path getProjectBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    StatisticGenerator getStatistic();
}
