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
        switch (language) {
            case "english":
            {
                try {
                    bufferedReader = new BufferedReader(new FileReader(Helper.getcurrentDir()+"src/test/java/resources/en_GB.json"));
                    lineBuffer = new StringBuffer();
                    while ((lines = bufferedReader.readLine())!=null){
                        lineBuffer.append(lines);
                    }
                     text = JsonPath.read(lineBuffer.toString(), key);

                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            break;
            case  "Arabic":
            {
                try {
                    bufferedReader = new BufferedReader(new FileReader(Helper.getcurrentDir()+"src/test/java/resources/ar.json"));
                    lineBuffer = new StringBuffer();
                    while ((lines = bufferedReader.readLine())!=null){
                        lineBuffer.append(lines);
                    }
                    //System.out.println(lineBuffer.toString());
                    text = JsonPath.read(lineBuffer.toString(), key);

                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            break;
            case  "Kurdish - Badini":
            {
                try {
                    bufferedReader = new BufferedReader(new FileReader(Helper.getcurrentDir()+"src/test/java/resources/ku_BA.json"));
                    lineBuffer = new StringBuffer();
                    while ((lines = bufferedReader.readLine())!=null){
                        lineBuffer.append(lines);
                    }
                    //System.out.println(lineBuffer.toString());
                    text = JsonPath.read(lineBuffer.toString(), key);

                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            break;
            case  "Kurdish - Sorani":
            {
                try {
                    bufferedReader = new BufferedReader(new FileReader(Helper.getcurrentDir()+"src/test/java/resources/ku_CKB.json"));
                    lineBuffer = new StringBuffer();
                    while ((lines = bufferedReader.readLine())!=null){
                        lineBuffer.append(lines);
                    }
                    //System.out.println(lineBuffer.toString());
                    text = JsonPath.read(lineBuffer.toString(), key);

                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            break;
            default:
                System.out.println("default");
        }
        return text;
    }


}


