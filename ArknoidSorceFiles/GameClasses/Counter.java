package GameClasses;

/**
 * Created by Guy on 25/09/2016.
 */
public class Counter {
    private int num;

    public Counter(int num) {
        this.num = num;
    }

    // add number to current count.
    public void increase(int number) {
        this.num += number;
    }
    // subtract number from current count.
    public void decrease(int number) {
        this.num -= number;
    }
    // get current count.
    public int getValue() {
        return this.num;
    }
}
