package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    protected static String[] NodeUrls() {
        Properties properties = new Properties();
        InputStream input = null;
        String userDirectory = System.getProperty("user.dir");
        String Node1Url, Node2Url; 

		try {
			input = new FileInputStream(userDirectory + "/base.properties");
			properties.load(input);
			Node1Url = properties.getProperty("node1.url");
			Node2Url = properties.getProperty("node2.url");			
        } 
        catch (IOException ex) {
            ex.printStackTrace();
            Node1Url = null;
            Node2Url = null;
        } 
        finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        }
        return new String[] {Node1Url, Node2Url};
    }


}