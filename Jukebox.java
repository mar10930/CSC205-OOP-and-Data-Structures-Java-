//Name: Mario Luja
//Date: June 23 2020
import java.util.ArrayList;
import java.util.Random;

public class Jukebox implements JukeInterface
{
	
	ArrayList <Record> records;
	public Jukebox()
	{
		  records = new ArrayList<> ();
	}
	
	public void insert(Record aRecord)
	{
		records.add(aRecord);
	}

	public void insert(int slot, Record aRecord)
	{
		records.add(slot, aRecord);
	}
	
	public boolean remove(Record aRecord)
	{	
		if(records.contains(aRecord))
		{
			records.remove(aRecord);
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	public boolean contains(Record aRecord)
	{
		if(records.contains(aRecord))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//
	public int findSlot(Record aRecord)
	{
		int slot;
		
		if(records.contains(aRecord))
		{
			slot = records.indexOf(aRecord);
			return slot;
		}
		
		else
		{
			return -1;
		}
	}
	
	//Random method to select a random record
	public Record random()
	{
		int randomRec;
		
		randomRec = (int) (Math.random() *records.size()-1);

		return records.get(randomRec);
	}
	
	//To string method to print out the arraylist
	public String toString()
	{
		return records.toString();
	}

}
