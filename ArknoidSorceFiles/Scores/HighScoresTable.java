package Scores;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Guy on 14/10/2016.
 */
public class HighScoresTable {
    private List<ScoreInfo> scoreInfos;
    private int sizeOfList;

    public HighScoresTable() {
    }

    public List<ScoreInfo> getScoreInfos() {
        return scoreInfos;
    }

    public void setScoreInfos(List<ScoreInfo> scoreInfos) {
        this.scoreInfos = scoreInfos;
    }

    public int getSizeOfList() {
        return sizeOfList;
    }

    public void setSizeOfList(int sizeOfList) {
        this.sizeOfList = sizeOfList;
    }

    //sizeOfList is the maximum high score we save in the table
    public HighScoresTable(int size)
    {
        this.scoreInfos = new ArrayList<>();
        this.sizeOfList = size;
    }

    public void add(ScoreInfo score) {
        this.scoreInfos.add(score);
    }

    // Return table size.
    public int sizeTable() { return sizeOfList; }

    // Return the current high scores as the high scores first
    public List<ScoreInfo> getHighScores()
    {
        Collections.sort(this.scoreInfos);
        return this.scoreInfos;
    }

    //if we add this score what rank it will be
    public int getRank(int score) {
        ArrayList<ScoreInfo> arrayList = new ArrayList<>(this.scoreInfos);
        ScoreInfo scoreInfo = new ScoreInfo("David", score);
        arrayList.add(scoreInfo);
        Collections.sort(arrayList);
        return arrayList.indexOf(scoreInfo);
    }

    // Clears the table
    public void clear()
    {
        this.scoreInfos.clear();
    }

    public void load(File filename) {
        this.scoreInfos = new ArrayList<>();
        Gson gson = new Gson();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            HighScoresTable highScoresTable =  gson.fromJson(bufferedReader, HighScoresTable.class);
            this.scoreInfos = highScoresTable.scoreInfos;
            this.setSizeOfList(highScoresTable.sizeTable());
        } catch (FileNotFoundException e) { }

    }

    public void save(File filename) {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        } catch (Exception e) { }

    }

    public static HighScoresTable loadFromFile(File filename, int size) {
        HighScoresTable highScoresTable = new HighScoresTable(size);
        highScoresTable.load(filename);
        return highScoresTable;
    }
}
