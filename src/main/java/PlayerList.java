import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import org.json.*;

public class PlayerList {
    Path filename;
    String content;
    JSONArray jsonArr;
    public PlayerList() throws IOException {
        this.filename = Path.of("./src/main/players.json");
        this.content = Files.readString(filename);
        this.jsonArr = new JSONArray(content);
    }

    public void readList() {
    }

    public void storeList(){
    }
}
