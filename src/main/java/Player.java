import org.json.JSONObject;

public class Player {
    int id;
    String name;
    int winCount;

    public JSONObject toJSON(){
        JSONObject player = new JSONObject();
        player.put("id", this.id);
        player.put("name", this.name);
        player.put("winCount", this.winCount);
        return player;
    }
}
