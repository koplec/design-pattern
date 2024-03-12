package pagemaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database(){

    }

    public static Properties getProperties(String dbname){
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        }catch(FileNotFoundException e){
            System.out.println("Warning: " + filename + " is not found: "+e);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return prop;
    }
}