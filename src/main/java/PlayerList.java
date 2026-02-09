import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import org.json.*;

public class PlayerList {
    Path fileName;
    String content;
    JSONArray jsonArr;
    BufferedWriter writer;
    public PlayerList() throws IOException {
        this.fileName = Path.of("./src/main/players.json");
        this.content = Files.readString(fileName);
        this.jsonArr = new JSONArray(content);
    }

    public void readList() {
    }

//    public void updateList(JSONObject playerObject){
//        for (int i = 0; i < this.jsonArr.length(); i++) {
//            JSONObject object = this.jsonArr.getJSONObject(i);
//            if (object.get("name").equals(playerObject.getString("name"))){
//                System.out.printf("Loaded player %s\n", name);
//            }
//        }
//        System.out.printf("No player found, created new player %s\n", name);
//
//        jsonArr.put(object);
//    }

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
