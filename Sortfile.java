import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sortfile {
    static String nameFile = "C:/Users/Artyom/IdeaProjects/IDZ_2/test_IDZ";
    static String NO_FILE = "NO_FILE";
    ArrayList<File> allFile = everything();
    ArrayList<String> sortByPos = new ArrayList<>();

    public ArrayList<File> everything() {
        File file = new File(nameFile);
        File[] arr = file.listFiles();
        if (arr != null) {
            return new ArrayList<>(Arrays.asList(arr));
        } else {
            throw new NullPointerException(NO_FILE + file);
        }
    }

    public void monitor() {
        for (File value : allFile) {
            System.out.println(value);
        }
    }

    public void monitor_abc() {
        Collections.sort(allFile);
        for (File value : allFile) {
            System.out.println(value);
        }
    }

    public boolean check() {
        for (File value : allFile) {
            if (value.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    public void openfull() {
        int endSize = allFile.size();
        for (int value = 0; value < endSize; value++) {
            if (allFile.get(value).isDirectory()) {
                nameFile = String.valueOf(allFile.get(value));
                ArrayList<File> allFile2 = everything();
                allFile.addAll(allFile2);
                allFile.remove(allFile.get(value));
            }
        }
        if (check()) {
            openfull();
        }
    }

    String content;
    String newpath = null;

    public String schet = null;

    public void printall() {
        int endSize = allFile.size();
        for (File file : allFile) {
            nameFile = String.valueOf(file);
            if (!(sortByPos.contains(String.valueOf(file)))) {
                reczavis();
            }
        }
    }

    ArrayList<String> moreContent = new ArrayList<>();

    public void reczavis() {
        String schet = nameFile;
        try {
             List<String> lines = Files.readAllLines(Path.of(nameFile));
             for (int i = 0; i < lines.size(); i++){
                 content = lines.get(i);
             }
             // content = String.join(System.lineSeparator(), lines);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (content.contains("require '")) {
            int i = content.indexOf("require '");
            i += 9;
            newpath = String.valueOf(content.charAt(i));
            i += 1;
            while (content.charAt(i) != '\'') {
                newpath += content.charAt(i);
                i += 1;
            }

            if (content.contains("require '")) {
                nameFile = newpath;
                reczavis();
                sortByPos.add(schet);
            }
        }
        else if (!(sortByPos.contains(String.valueOf(nameFile)))) {
            sortByPos.add(0, nameFile);
            reczavis();
        }
    }


    public void sorteq() {
        // Collections.reverse(sortByPos);
        for (int i = 0; i < sortByPos.size(); i++){
            System.out.println(sortByPos.get(i));
        }
    }
}
