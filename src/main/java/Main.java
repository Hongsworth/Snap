import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main() throws IOException {
//        Snap snap = new Snap();
//        snap.runGame();
        PlayerList players = new PlayerList();
        players.updateList(new JSONObject().put("id", 3).put("name", "player3").put("winCount", 0));
        players.storeList();
    }
}
