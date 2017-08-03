package gameofant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameSettingsModel {

    private String nickName;
    private int large;
    private int width;
    private int life;
    private int obstacleQuantity;
    private int stepsQuantityMade;
    private int betterScore;
    private int alcoholismLevel;
    private int sugarLevel;
    private int currentRow;
    private int currentColumn;
    private int passRow;
    private int passColumn;
    private ArrayList<Integer> rowHistory;
    private ArrayList<Integer> columnHistory;

    public GameSettingsModel(String nickName, int large, int width, int obstacleQuantity) {
        this.nickName = nickName;
        this.large = large;
        this.width = width;
        this.life = 100;
        this.obstacleQuantity = obstacleQuantity;
        this.stepsQuantityMade = 0;
        this.betterScore = 0;
        this.alcoholismLevel = 0;
        this.sugarLevel = 0;
        this.currentColumn = 0;
        this.currentRow = 0;
        this.passRow = -100;
        this.passColumn = -100;
        this.rowHistory = new ArrayList<>();
        this.columnHistory = new ArrayList<>();
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
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

    public int getAlcoholismLevel() {
        return alcoholismLevel;
    }

    public void setAlcoholismLevel(int alcoholismLevel) {
        this.alcoholismLevel = alcoholismLevel;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public int getPassRow() {
        return passRow;
    }

    public void setPassRow(int passRow) {
        this.passRow = passRow;
    }

    public int getPassColumn() {
        return passColumn;
    }

    public void setPassColumn(int passColumn) {
        this.passColumn = passColumn;
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
