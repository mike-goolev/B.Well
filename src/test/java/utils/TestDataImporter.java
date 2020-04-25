package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestDataImporter {
    private static JSONObject testData;

    public static JSONObject get(String testSuite, String testMethod) {

        JSONParser parser = new JSONParser();

        try {
            /* Sets path to test data */
            JSONObject testSuiteData = (JSONObject) parser.parse(new FileReader(String.format(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "testData" + File.separator + "%s.json", testSuite)));
            TestDataImporter.testData = (JSONObject) testSuiteData.get(testMethod);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("An error occurred while parsing the json file.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return TestDataImporter.testData;
    }
}
