import org.json.JSONObject;

public class Player {
    String name;
    int winCount;
    int lossCount;

    public JSONObject toJSON(){
        JSONObject player = new JSONObject();
        player.put("name", this.name);
        player.put("winCount", this.winCount);
        player.put("lossCount", this.lossCount);
        return player;
    }
}
