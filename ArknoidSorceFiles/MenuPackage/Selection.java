package MenuPackage;

import Interface.Task;

/**
 * Created by Guy on 15/10/2016.
 */
public class Selection {
    private String key;
    private String message;
    private Task task;

    public Selection(String key, Task task, String message) {
        this.key = key;
        this.message = message;
        this.task = task;
    }

    public String getKey() {
        return key;
    }

    public Task getTask() {
        return task;
    }

    public String getMessage() {
        return message;
    }
}
