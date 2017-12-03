package Interface;

/**
 * Created by Guy on 15/10/2016.
 */
public interface Menu<T> extends Animation {
    void addSelection(String key, String message, T returnVal);
    T getStatus();
}