import java.util.ArrayList;

/**
 * This class represents a TaskList, which is the list of tasks that Duke refers to to carry out commands provided
 * to him.
 */

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    /**
     * Adds an item to the TaskList.
     * This method is for Level-3, and is not longer used w.e.f Level-4
     *
     * @param input the item to be added to the TaskList
     */
    public void add(String input) {
        Task task = new Task(input);
        this.list.add(task);
        System.out.println("    " + "added: " + input);
    }

    /**
     * Adds an Event to the TaskList.
     *
     * @param event event to be added to the TaskList
     */
    public void add(Event event, boolean print) {
        this.list.add(event);
        if (print) {
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + event);
            System.out.printf("     Now you have %d tasks in the list.%n", list.size());
        }
    }


    /**
     * Adds a deadline to the TaskList.
     *
     * @param deadline deadline to be added to the TaskList
     */
    public void add(Deadline deadline, boolean print) {
        this.list.add(deadline);
        if (print) {
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + deadline);
            System.out.printf("     Now you have %d tasks in the list.%n", list.size());
        }
    }

    /**
     * Adds a toDo to the TaskList.
     *
     * @param toDo deadline to be added to the TaskList
     */
    public void add(ToDo toDo, boolean print) {
        this.list.add(toDo);
        if (print) {
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + toDo);
            System.out.printf("     Now you have %d tasks in the list.%n", list.size());
        }
    }

    /**
     * Finishes a task at a given index.
     *
     * @param index index from 1 (i.e lowest index is 1, so subtract 1 to get real index)
     */
    public void finishTask(int index) {
        Task task = this.list.get(index - 1);
        task.doneTask(true);
    }

    /**
     * Lists out the current items in the TaskList.
     */
    public void listOut() {
        if (this.list.size() == 0) {
            System.out.println("     You have no tasks in your list!");
            System.out.println("     Try adding some tasks with todo, event or deadline");
        } else {
            System.out.println("     Here are the tasks in your list:");
            for (int i = 0; i < this.list.size(); i++) {
                System.out.println("     " + (i + 1) + "." + this.list.get(i));
            }
        }
    }

    /**
     * This method is to be used when quitting and saving the file.
     *
     * @return the resulting string containing save-friendly information
     */
    public String save() {
        String output = "";
        for (Task task: list) {
            output += task.type() + " | " + (task.getState() ? "1 | " : "0 | ") + task.getSaveInfo() + "\n";
        }
        return output;
    }

    /**
     * Deletes a task at a certain index
     *
     * @param index index from 1 (i.e lowest index is 1, so subtract 1 to get real index)
     */
    public void deleteTask(int index) {
        Task item = this.list.remove(index - 1);
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + item);
        System.out.printf("     Now you have %d tasks in the list.%n", list.size());
    }
}
