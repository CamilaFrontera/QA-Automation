package Utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static String getProperty(String data){
        try{
            InputStream input = new FileInputStream(projectPath + "/src/main/resources/data.properties");
            prop.load(input);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return prop.getProperty(data);
    }
    }

