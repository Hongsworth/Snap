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

    public void updateList(JSONObject object){
        jsonArr.put(object);
    }

    public void storeList() throws IOException {
        System.out.println(content);
        try(BufferedWriter writer = Files.newBufferedWriter(fileName)){
            writer.write(jsonArr.toString(2));
        }
    }

    public boolean checkName(String name){
        for (int i = 0; i < this.jsonArr.length(); i++) {
            JSONObject object = this.jsonArr.getJSONObject(i);
//            System.out.println(object.get("name"));
            if (object.get("name").equals(name)){
                return true;
            }
        }
        return false;
    }

    public JSONArray getArray(){
        return jsonArr;
    }
}
