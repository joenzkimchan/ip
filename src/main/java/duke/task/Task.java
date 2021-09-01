package duke.task;

import duke.Ui;

/**
 * This class represents a task to be done in the TaskList.
 */
public class Task {
    private String taskName;
    private boolean isDone;

    /**
     * Constructor for a task, which takes in a task name.
     *
     * @param taskName name of task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    /**
     * Gives the type of the Task (i.e Event, ToDo, Deadline). To be overriden.
     *
     * @return empty string
     */
    public String getType() {
        return "";
    }

    /**
     * Gives the description of the task.
     *
     * @return description of the task
     */
    public String getTaskName() {
        return this.taskName;
    }

    /**
     * Shows the state of the task.
     *
     * @return the state of the task
     */
    public boolean getDone() {
        return this.isDone;
    }

    /**
     * Gives a save-file friendly version of the task. To be overriden in child classes.
     *
     * @return save information
     */
    public String getSaveInfo() {
        return this.taskName;
    }

    /**
     * Marks the task as done.
     *
     * @param shouldPrint determines if the task being marked as done should be printed.
     */
    public String doneTask(boolean shouldPrint) {
        this.isDone = true;
        String output = null;
        if (shouldPrint) {
            output = Ui.finishTask(this);
        }
        return output;
    }

    /**
     * Returns whether the name contains the keyword. Note this matches the keyword with anything infront
     * and behind it. (e.g. four in fourteen will return true)
     *
     * @param keyword to be searched in the task name.
     * @return true if the task name contains the keyword, false if not.
     */
    public boolean doesNameContain(String keyword) {
        return taskName.matches("(.*)" + keyword + "(.*)");
    }

    /**
     * Overriden toString method.
     *
     * @return string representation of the task.
     */
    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + this.taskName;
    }
}
