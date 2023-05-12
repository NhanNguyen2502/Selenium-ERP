package erp.common.helpers;

import com.jayway.jsonpath.JsonPath;
import org.python.antlr.ast.Str;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TranslationHelpers {
    private static BufferedReader bufferedReader;
    private static String lines;
    private static StringBuffer lineBuffer;
    private static String linkFile;

    public static String setFile(String language, String key) {
        String text = null;
        String fileUrl = Helper.getcurrentDir()+"src/test/java/resources/en_GB.json";
        switch (language) {
            case "english" -> {
                fileUrl = Helper.getcurrentDir()+"src/test/java/resources/en_GB.json";
            }
            case "Arabic" -> {
                fileUrl = Helper.getcurrentDir()+"src/test/java/resources/ar.json";

            }
            case "Kurdish - Badini" -> {
                fileUrl = Helper.getcurrentDir()+"src/test/java/resources/ku_BA.json";
            }
            case "Kurdish - Sorani" -> {
                fileUrl = Helper.getcurrentDir()+"src/test/java/resources/ku_CKB.json";
            }
            default ->   fileUrl = Helper.getcurrentDir()+"src/test/java/resources/en_GB.json";
        }

        try {
            bufferedReader = new BufferedReader(new FileReader(fileUrl));
            lineBuffer = new StringBuffer();
            while ((lines = bufferedReader.readLine()) != null) {
                lineBuffer.append(lines);
            }
            text = JsonPath.read(lineBuffer.toString(), key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


}


