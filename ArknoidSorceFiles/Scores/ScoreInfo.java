package Scores;

/**
 * Created by Guy on 14/10/2016.
 */
public class ScoreInfo implements Comparable<ScoreInfo>{
    private String name;
    private int score;

    public ScoreInfo() {
    }

    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(ScoreInfo o) {
        return o.score - this.score;
    }

}
