import org.json.JSONObject;

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
}
