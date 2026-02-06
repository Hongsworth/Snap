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
}
