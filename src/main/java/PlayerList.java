import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import org.json.*;

public class PlayerList {
    private final Path fileName;
    private final JSONArray jsonArr;
    public PlayerList() throws IOException {
        this.fileName = Path.of("./src/main/players.json");
        if(Files.readString(fileName).isEmpty()){
            this.jsonArr = new JSONArray("[]");
        }
        else{
            this.jsonArr = new JSONArray(Files.readString(fileName));
        }
    }

    public void updateList(JSONObject playerObject){
        JSONObject object;
        for (int i = 0; i < this.jsonArr.length(); i++) {
            object = this.jsonArr.getJSONObject(i);
            if (object.get("name").equals(playerObject.getString("name"))){
                jsonArr.put(i, playerObject);
                return;
            }
        }
        jsonArr.put(playerObject);
    }

    public void storeList() throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(fileName)){
            writer.write(jsonArr.toString(2));
        }
    }

    public Player getPlayerInfo(String name){
        for (int i = 0; i < this.jsonArr.length(); i++) {
            JSONObject object = this.jsonArr.getJSONObject(i);
            if (object.get("name").equals(name)){
                System.out.printf("Loaded player %s\n", name);
                return new Player(object);
            }
        }
        System.out.printf("No player found, created new player %s\n", name);
        return new Player(new JSONObject().put("name", name).put("winCount", 0).put("lossCount", 0));
    }

    public JSONArray getArray(){
        return jsonArr;
    }
}
