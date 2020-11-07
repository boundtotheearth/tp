//@@author claracheong4
package seedu.momentum.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.momentum.commons.core.DateTimeWrapper;
import seedu.momentum.commons.core.DateWrapper;
import seedu.momentum.commons.core.UniqueItemList;
import seedu.momentum.commons.exceptions.IllegalValueException;
import seedu.momentum.model.project.CompletionStatus;
import seedu.momentum.model.project.Deadline;
import seedu.momentum.model.project.Description;
import seedu.momentum.model.project.Name;
import seedu.momentum.model.project.TrackedItem;
import seedu.momentum.model.reminder.Reminder;
import seedu.momentum.model.tag.Tag;
import seedu.momentum.model.timer.TimerWrapper;
import seedu.momentum.model.timer.WorkDuration;

/**
 * Contains methods that converts a json field to a model field.
 */
public class JsonToModel {

    /**
     * Convert json description to model description.
     *
     * @param description The description.
     * @return The model description.
     */
    protected static Description getModelDescription(String description) {
        return new Description(description);
    }

    /**
     * Convert json name to model name.
     *
     * @param name      The name.
     * @param exception The exception message.
     * @return The model name.
     * @throws IllegalValueException If the name is invalid.
     */
    protected static Name getModelName(String name, String exception) throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(exception, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(name);
    }

    /**
     * Convert json completion status to model completion status.
     *
     * @param completionStatus The completion status.
     * @return The model completion status.
     */
    protected static CompletionStatus getModelCompletionStatus(boolean completionStatus) {
        if (completionStatus) {
            return new CompletionStatus().reverse();
        }
        return new CompletionStatus();
    }

    /**
     * Convert json created date to model created date.
     *
     * @param createdDate The created date.
     * @return The model created date.
     * @throws IllegalValueException If the created date is invalid.
     */
    protected static DateWrapper getModelCreatedDate(String createdDate) throws IllegalValueException {
        if (!DateWrapper.isValid(createdDate)) {
            throw new IllegalValueException(DateWrapper.MESSAGE_CONSTRAINTS);
        }
        return new DateWrapper(createdDate);
    }

    /**
     * Convert json deadline to model deadline.
     *
     * @param deadline                The deadline.
     * @param modelCreatedDateWrapper The model created date wrapper.
     * @return The model deadline.
     * @throws IllegalValueException If the deadline is invalid.
     */
    protected static Deadline getModelDeadline(JsonAdaptedDeadline deadline, DateWrapper modelCreatedDateWrapper)
            throws IllegalValueException {
        return deadline == null
                ? new Deadline()
                : deadline.toModelType(modelCreatedDateWrapper);
    }

    /**
     * Convert json reminder to model reminder.
     *
     * @param reminder The reminder.
     * @return The model reminder.
     * @throws IllegalValueException If the reminder is invalid.
     */
    protected static Reminder getModelReminder(String reminder) throws IllegalValueException {
        return Reminder.recreateReminder(reminder);
    }

    /**
     * Convert json tags to model tags.
     *
     * @param tagged The tagged.
     * @return The model tags.
     * @throws IllegalValueException If the tag list is invalid.
     */
    protected static Set<Tag> getModelTags(List<JsonAdaptedTag> tagged) throws IllegalValueException {
        final List<Tag> trackedItemTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            trackedItemTags.add(tag.toModelType());
        }
        return new HashSet<>(trackedItemTags);
    }

    /**
     * Convert json timer to model timer.
     *
     * @param timer The timer.
     * @return The model timer wrapper.
     * @throws IllegalValueException If the timer is invalid.
     */
    protected static TimerWrapper getModelTimerWrapper(JsonAdaptedTimer timer) throws IllegalValueException {
        return timer == null ? new TimerWrapper() : timer.toModelType();
    }

    //@@author boundtotheearth
    /**
     * Convert json datetime to model datetime.
     *
     * @param time Time to convert.
     * @param errorMessage Error message to show if the timer is invalid.
     * @throws IllegalValueException If the time is invalid.
     */
    protected static DateTimeWrapper getModelDateTimeWrapper(String time, String errorMessage)
        throws IllegalValueException {
        if (time == null) {
            throw new IllegalValueException(String.format(errorMessage,
                DateTimeWrapper.class.getSimpleName()));
        }

        if (!DateTimeWrapper.isValid(time)) {
            throw new IllegalValueException(DateTimeWrapper.MESSAGE_CONSTRAINTS);
        }

        return new DateTimeWrapper(time);
    }

    /**
     * Convert json durations to model durations.
     *
     * @param durations The durations.
     * @return The model durations.
     * @throws IllegalValueException If the duration list is invalid.
     */
    protected static UniqueItemList<WorkDuration> getModelDurations(List<JsonAdaptedWorkDuration> durations)
            throws IllegalValueException {
        final List<WorkDuration> projectDurations = new ArrayList<>();
        for (JsonAdaptedWorkDuration duration : durations) {
            projectDurations.add(duration.toModelType());
        }

        UniqueItemList<WorkDuration> modelDurations = new UniqueItemList<>();
        modelDurations.setItems(projectDurations);
        return modelDurations;
    }

    /**
     * Convert json tasks to model tasks.
     *
     * @param taskList The task list.
     * @return The model tasks.
     * @throws IllegalValueException If the task list is invalid.
     */
    protected static UniqueItemList<TrackedItem> getModelTasks(List<JsonAdaptedTask> taskList)
            throws IllegalValueException {
        final List<TrackedItem> projectTasks = new ArrayList<>();
        for (JsonAdaptedTask task : taskList) {
            projectTasks.add(task.toModelType());
        }
        UniqueItemList<TrackedItem> modelTasks = new UniqueItemList<>();
        modelTasks.setItems(projectTasks);
        return modelTasks;
    }
}
