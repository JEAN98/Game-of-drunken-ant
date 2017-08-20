package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameSettingsModel {

    private String nickName;
    private boolean antInformation;
    private int large;
    private int width;
    private int obstacleQuantity;
    private int stepsQuantityMade;
    private int betterScore;
    private ArrayList<Integer> rowHistory;
    private ArrayList<Integer> columnHistory;

    public GameSettingsModel(String nickName, int large, int width, int obstacleQuantity) {
        this.nickName = nickName;
        this.large = large;
        this.width = width;
        this.obstacleQuantity = obstacleQuantity;
        this.stepsQuantityMade = 0;
        this.betterScore = 0;
        this.rowHistory = new ArrayList<>();
        this.columnHistory = new ArrayList<>();
    }

    public boolean getAntInformation() {
        return antInformation; //use the current matrix
    }

    public void setGetAntInformation(boolean getAntInformation) {
        this.antInformation = getAntInformation;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getObstacleQuantity() {
        return obstacleQuantity;
    }

    public void setObstacleQuantity(int obstacleQuantity) {
        this.obstacleQuantity = obstacleQuantity;
    }

    public int getStepsQuantityMade() {
        return stepsQuantityMade;
    }

    public void setStepsQuantityMade(int stepsQuantityMade) {
        this.stepsQuantityMade = stepsQuantityMade;
    }

 
    public int getBetterScore() {
        return betterScore;
    }

    public void setBetterScore(int betterScore) {
        this.betterScore = betterScore;
    }

  
    public ArrayList<Integer> getRowHistory() {
        return rowHistory;
    }

    public void setRowHistory(int rowHistory) {
        this.rowHistory.add(rowHistory);
    }

    public ArrayList<Integer> getColumnHistory() {
        return columnHistory;
    }

    public void setColumnHistory(int columnHistory) {
        this.columnHistory.add(columnHistory);
    }


}
