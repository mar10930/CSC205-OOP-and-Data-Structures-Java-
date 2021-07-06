//Name: Mario Luja
//Date: June 30,2020
// "Let's get together and hash it out." - Tony Stark

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Hashes {
    private String name;

    public void makeHash(String hashName) throws NoSuchAlgorithmException 
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] byteArr = md.digest(hashName.getBytes(StandardCharsets.UTF_8));

        StringBuilder buildStr = new StringBuilder();

        for (byte b : byteArr)
        {
            buildStr.append(String.format("%02x", b));
        }

         name = buildStr.toString();
    }

    public String getHashedStr(String hashedName)throws NoSuchAlgorithmException  {
        
    	makeHash(name);
    	
    	return name;

    }

}
