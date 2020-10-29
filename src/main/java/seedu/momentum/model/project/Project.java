package seedu.momentum.model.project;

import static java.util.Objects.requireNonNull;
import static seedu.momentum.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Set;

import javafx.collections.ObservableList;
import seedu.momentum.commons.core.DateWrapper;
import seedu.momentum.model.reminder.Reminder;
import seedu.momentum.model.reminder.ReminderManager;
import seedu.momentum.model.tag.Tag;
import seedu.momentum.model.timer.TimerWrapper;
import seedu.momentum.model.timer.UniqueDurationList;
import seedu.momentum.model.timer.WorkDuration;

/**
 * Represents a Project in the project book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Project extends TrackedItem {

    private UniqueTrackedItemList taskList;
    private SortType sortType = SortType.ALPHA;
    private boolean isAscending = true;
    private boolean isSortedByCompletionStatus = true;

    /**
     * Constructs a {@code Project}.
     *
     * @param name               A valid name.
     * @param description        A description of the project.
     * @param completionStatus   A completion status of the project.
     * @param createdDateWrapper A dateWrapper associated with the creation of the project.
     * @param deadline           A deadline associated with the project.
     * @param reminder           A reminder associated with the tracked item.
     * @param tags               A set of tags associated to the project.
     * @param durations          A list of {@code WorkDuration} associated with the project.
     * @param timerWrapper       A timerWrapper associated with the project.
     * @param taskList           UniqueTrackedListList associated with the project.
     */
    public Project(Name name, Description description, CompletionStatus completionStatus,
                   DateWrapper createdDateWrapper, Deadline deadline, Reminder reminder, Set<Tag> tags,
                   UniqueDurationList durations, TimerWrapper timerWrapper, UniqueTrackedItemList taskList) {
        super(name, description, completionStatus, createdDateWrapper, deadline, reminder, tags, durations,
                timerWrapper);
        this.taskList = taskList;
    }

    /**
     * Constructs a {@code Project}.
     *
     * @param name                       A valid name.
     * @param description                A description of the project.
     * @param completionStatus           A completion status of the project.
     * @param createdDateWrapper         A dateWrapper associated with the creation of the project.
     * @param deadline                   A deadline associated with the project.
     * @param reminder                   A reminder associated with the tracked item.
     * @param tags                       A set of tags associated to the project.
     * @param durations                  A list of {@code WorkDuration} associated with the project.
     * @param timerWrapper               A timerWrapper associated with the project.
     * @param taskList                   UniqueTrackedListList associated with the project.
     * @param sortType                  A boolean to check the type of order of the sort.
     * @param isAscending                A boolean to check if the list is sorted in ascending order.
     * @param isSortedByCompletionStatus A boolean to check if the list is sorted by completion status.
     */
    public Project(Name name, Description description, CompletionStatus completionStatus,
                   DateWrapper createdDateWrapper, Deadline deadline, Reminder reminder, Set<Tag> tags,
                   UniqueDurationList durations, TimerWrapper timerWrapper, UniqueTrackedItemList taskList,
                   SortType sortType, boolean isAscending, boolean isSortedByCompletionStatus) {
        super(name, description, completionStatus, createdDateWrapper, deadline, reminder, tags, durations,
                timerWrapper);
        this.taskList = taskList;
        this.sortType = sortType;
        this.isAscending = isAscending;
        this.isSortedByCompletionStatus = isSortedByCompletionStatus;
        taskList.setOrder(sortType, isAscending, isSortedByCompletionStatus);
    }

    /**
     * Constructs a {@code Project}.
     *
     * @param name               A valid name.
     * @param description        A description of the project.
     * @param completionStatus   A completion status of the project.
     * @param createdDateWrapper A dateWrapper associated with the creation of the project.
     * @param deadline           A deadline associated with the project.
     * @param reminder           A reminder associated with the tracked item.
     * @param tags               A set of tags associated to the project.
     * @param durations          A list of {@code WorkDuration} associated with the project.
     * @param timerWrapper       A timerWrapper associated with the project.
     */
    public Project(Name name, Description description, CompletionStatus completionStatus,
                   DateWrapper createdDateWrapper, Deadline deadline, Reminder reminder, Set<Tag> tags,
                   UniqueDurationList durations, TimerWrapper timerWrapper) {
        super(name, description, completionStatus, createdDateWrapper, deadline, reminder, tags, durations,
                timerWrapper);
        taskList = new UniqueTrackedItemList();
    }

    /**
     * Constructs a new {@code Project}
     *
     * @param name               A valid name.
     * @param completionStatus   A completion status of the project.
     * @param createdDateWrapper A dateWrapper associated with the creation of the project
     * @param deadline           A deadline associated with the project.
     * @param reminder           A reminder associated with the tracked item.
     * @param description        A description of the project.
     * @param tags               A set of tags associated to the project.
     */
    public Project(Name name, Description description, CompletionStatus completionStatus,
                   DateWrapper createdDateWrapper, Deadline deadline, Reminder reminder, Set<Tag> tags) {
        super(name, description, completionStatus, createdDateWrapper, deadline, reminder, tags);
        taskList = new UniqueTrackedItemList();
    }

    /**
     * Returns a copy of this project with its timerWrapper started.
     *
     * @return A copy of this project, but with its timerWrapper started
     */
    @Override
    public Project startTimer() {
        TimerWrapper newTimerWrapper = timerWrapper.start();
        return new Project(name, description, completionStatus, createdDateWrapper, deadline, reminder, tags, durations,
                newTimerWrapper, taskList);
    }

    /**
     * Returns a copy of this project with its timerWrapper stopped, then adds the timed duration into
     * the list.
     *
     * @return A copy of this project, but with its timerWrapper stopped
     */
    @Override
    public Project stopTimer() {
        TimerWrapper newTimerWrapper = timerWrapper.stop();
        WorkDuration duration = new WorkDuration(newTimerWrapper.getStartTime(), newTimerWrapper.getStopTime());
        UniqueDurationList newDurations = new UniqueDurationList();
        newDurations.setDurations(durations);
        newDurations.add(duration);
        return new Project(name, description, completionStatus, createdDateWrapper, deadline, reminder, tags,
                newDurations, newTimerWrapper, taskList);
    }

    /**
     * Adds a task in the {@code Project}'s {@code UniqueTrackedItemList}.
     *
     * @param task task to be added.
     * @return A copy of this project, but with task added.
     */
    public Project addTask(TrackedItem task) {
        requireNonNull(task);
        UniqueTrackedItemList newList = this.taskList.addTask(task);
        return new Project(name, description, completionStatus, createdDateWrapper, deadline, reminder,
                tags, durations, timerWrapper, newList, sortType, isAscending, isSortedByCompletionStatus);
    }

    /**
     * Checks whether a task is in the {@code Project}'s {@code UniqueTrackedItemList}.
     *
     * @param task task that needs to be checked.
     */
    public boolean hasTask(TrackedItem task) {
        requireNonNull(task);
        return taskList.contains(task);
    }

    /**
     * Deletes a task in the {@code Project}'s {@code UniqueTrackedItemList}.
     *
     * @param task task to be deleted.
     * @return A copy of this project, but with task removed.
     */
    public Project deleteTask(TrackedItem task) {
        requireNonNull(task);
        UniqueTrackedItemList newList = taskList.removeTask(task);
        return new Project(name, description, completionStatus, createdDateWrapper, deadline, reminder,
                tags, durations, timerWrapper, newList);
    }

    /**
     * Edits a task is in the {@code Project}'s {@code UniqueTrackedItemList} and returns new Project.
     *
     * @param target     task to be replaced.
     * @param editedTask task to replace the original task with.
     */
    public Project setTask(TrackedItem target, TrackedItem editedTask) {
        requireAllNonNull(target, editedTask);
        taskList.setTrackedItem(target, editedTask);
        return new Project(name, description, completionStatus, createdDateWrapper, deadline, reminder,
                tags, durations, timerWrapper, taskList);
    }

    /**
     * Removes all tasks belonging to this project.
     */
    public void clearTasks() {
        taskList = new UniqueTrackedItemList();
    }


    /**
     * Orders the list of tasks in a way given by the {@code sortType}.
     *
     * @param orderType                  A boolean to check the type of order of the sort.
     * @param isAscending                A boolean to check if the list is sorted in ascending order.
     * @param isSortedByCompletionStatus A boolean to check if the list is sorted by completion status.
     */
    public Project orderTaskList(SortType orderType, boolean isAscending, boolean isSortedByCompletionStatus) {
        requireAllNonNull(orderType, isAscending, isSortedByCompletionStatus);

        UniqueTrackedItemList newList = taskList.copy();

        return new Project(name, description, completionStatus, createdDateWrapper, deadline, reminder,
                tags, durations, timerWrapper, newList, orderType, isAscending, isSortedByCompletionStatus);
    }

    public ObservableList<TrackedItem> getTaskList() {
        return taskList.asUnmodifiableObservableList();
    }

    /**
     * Returns true if both tracked item of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two projects.
     */
    @Override
    public boolean isSameTrackedItem(TrackedItem otherTrackedItem) {
        if (!(otherTrackedItem instanceof Project)) {
            return false;
        }

        return super.isSameTrackedItem(otherTrackedItem);
    }

    /**
     * Reschedule all reminders in the task list.
     */
    public void rescheduleReminder(ReminderManager reminderManager) {
        for (TrackedItem task : taskList) {
            reminderManager.rescheduleReminder(this, (Task) task);
        }
    }

    /**
     * Remove the reminder of a project.
     */
    public Project removeReminder() {
        Reminder newReminder = this.reminder.remove();
        return new Project(name, description, completionStatus, createdDateWrapper, deadline, newReminder, tags,
                durations, timerWrapper, taskList);
    }

    /**
     * Remove the reminder of a trackedItem.
     */
    public Project removeReminder(Task task) {
        Task newTask = task.removeReminder();
        taskList.setTrackedItem(task, newTask);
        return new Project(name, description, completionStatus, createdDateWrapper, deadline, reminder, tags, durations,
                timerWrapper, taskList);
    }

    /**
     * Returns true if the instance is a Task. Returns false otherwise.
     */
    @Override
    public boolean isTask() {
        return false;
    }

    /**
     * Returns true if both tracked items have the same identity and data fields.
     * This defines a stronger notion of equality between two tracked items.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Project)) {
            return false;
        }

        return super.equals(other)
                && this.getTaskList().equals(((Project) other).getTaskList());
    }
}
