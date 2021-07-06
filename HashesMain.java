//Name: Mario Luja
// "We're in the endgame now." - Stephen Strange, M.D., Ph.D.
// https://pics.me.me/were-in-the-endgame-now-when-the-power-point-goes-38463881.png

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class HashesMain {
    public static final int ARR_LENGTH = 25;

    public static void main(String[] args) throws NoSuchAlgorithmException{
	// setup the hash map here
        
    	HashMap <String,String> hashedNamesHM = new HashMap<>();  
        
        Hashes hashes = new Hashes();

        String filename = "names.txt";
        String[] namesArr;
        namesArr = readNames(filename);
        

        //print out every element in the array
        for(int i = 0; i < namesArr.length; i++)
        {
        	System.out.println(namesArr[i]);
            hashes.makeHash(namesArr[i]);
            hashedNamesHM.put(namesArr[i], hashes.getHashedStr(namesArr[i]));
        }

        System.out.println();
        System.out.println(hashedNamesHM.toString());
        System.out.println();

        // find your main man
        if (hashedNamesHM.containsKey("Mega Man")) 
        {
            System.out.println("Mega Man" + " = " + hashedNamesHM.get("Mega Man"));
        } 
        else 
        {
            System.out.println("The HashMap does not contain ." + "Mega Man");
        }

        // find your leading lady
        if (hashedNamesHM.containsKey("Lucina")) 
        {
            System.out.println("Lucina" + " = " + hashedNamesHM.get("Lucina"));
        }
        else 
        {
            System.out.println("The HashMap does not contain .");
        }
    }
    

    // read the names from names.txt and put them into an array
    public static String[] readNames(String filename)
    {
        String[] names = new String[ARR_LENGTH];

        try 
        {	
        	Scanner readFile = new Scanner(new File(filename));
        	 while(readFile.hasNext())
             {
             	for(int i =0; i < names.length; i++)
             	{
             		names[i] = readFile.nextLine();
             	}
             }
        	 readFile.close();
        	 System.out.println("The list of names has been read.");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println(new File(filename).getAbsolutePath());
        }

        return names;
    }
}
