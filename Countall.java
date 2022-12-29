import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Countall extends Sortfile{

    static String nameFile = "C:/Users/Artyom/IdeaProjects/IDZ_2/test_IDZ";
    static String NO_FILE = "NO_FILE";
    ArrayList<File> allFile = everything();


    String content;
    String newpath = "";

    public boolean check_str() {
        for (File value : allFile) {
            if (value.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<File> everything_str() {
        File file = new File(nameFile);
        File[] arr = file.listFiles();
        if (arr != null) {
            return new ArrayList<>(Arrays.asList(arr));
        } else {
            throw new NullPointerException(NO_FILE + file);
        }
    }

    public void openfull_str() {
        int endSize = allFile.size();
        for (int value = 0; value < endSize; value++) {
            if (allFile.get(value).isDirectory()) {
                nameFile = String.valueOf(allFile.get(value));
                ArrayList<File> allFile2 = everything_str();
                allFile.addAll(allFile2);
                allFile.remove(allFile.get(value));
            }
        }
        if (check_str()) {
            openfull_str();
        }
    }

    public void reczavis_str() {
        openfull_str();
        Collections.sort(allFile);
        for (File nameFile : allFile) {
            try {
                List<String> lines = Files.readAllLines(Path.of(nameFile.toURI()));
                content = String.join(System.lineSeparator(), lines);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            newpath += content;
        }
    }
    public void monitor_str() {
        System.out.println(newpath);
    }
}
