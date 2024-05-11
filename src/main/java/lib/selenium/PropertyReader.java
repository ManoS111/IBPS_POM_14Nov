package lib.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

    public static final PropertyReader PROPERTYREADER = new PropertyReader();

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        return PROPERTYREADER;
    }

    public Map<String, String> getConfigAsMap(String propName) {
        if (propName == null || propName.isEmpty()) {
            return new HashMap<String, String>();
        }
        Properties property = new Properties();
        InputStream input = null;
        Map<String, String> propMap = new HashMap<String, String>();

        try {
            input = getClass().getClassLoader().getResourceAsStream(propName);
            property.load(input);
            Enumeration<Object> propKeys = property.keys();
            while (propKeys.hasMoreElements()) {
                String s = (String) propKeys.nextElement();
                propMap.put(s, property.getProperty(s));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return propMap;
    }
}
