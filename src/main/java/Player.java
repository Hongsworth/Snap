import org.json.JSONObject;

import java.sql.SQLOutput;

public class Player {
    String name;
    int winCount;
    int lossCount;

    public Player(JSONObject player){
        this.name = player.getString("name");
        this.winCount = player.getInt("winCount");
        this.lossCount = player.getInt("lossCount");
    }

    public JSONObject toJSON(){
        JSONObject player = new JSONObject();
        player.put("name", this.name);
        player.put("winCount", this.winCount);
        player.put("lossCount", this.lossCount);
        return player;
    }

    public void addWin(){
        this.winCount += 1;
    }

    public void addLoss(){
        this.lossCount += 1;
    }

    public void printRecord(){
        System.out.printf("%s's record\n", this.name);
        System.out.printf("Number of wins: %d\n", this.winCount);
        System.out.printf("Number of Losses: %d\n \n", this.lossCount);
    }
}
