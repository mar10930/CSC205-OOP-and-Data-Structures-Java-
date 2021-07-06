//Name: Mario Luja
//Date: July 8 2020

import java.math.BigInteger;
public class InfiniteInt extends DLList<Integer>implements Comparable
{
	private String str;
	
	public InfiniteInt(String str)
	{
		int ind =0;
		int num = 0;
		int divisible = 0;
		this.str = str;
		
		//Check if the string contains any non integer characters
		for(int i =0; i < str.length(); i++)
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				throw new IllegalArgumentException("The string must "
						+ "only contain numbers.");
			}
		}
		
		//If number of integers is not divisible by 3
		divisible = str.length() % 3;
		
		if(divisible != 0)
		{
			divisible = 3 - divisible;
			
			for(int i = 0; i < divisible; i++)
			{
				str = "0" + str;
			}
		}
		
		//Check if the string is divisible into groups of 3
		while(ind < str.length())
		{
			//Continually shifts string to every 3rd and converts to an int
			num = Integer.parseInt(str.substring(ind, ind+3));
			addLast(num);
			ind += 3;
		}
		
	}
	
	public InfiniteInt()
	{
		
		addFirst(0);
	}
	
	public String toString()
	{
		
		//Data
		String ogNum = super.toString();
		int ogLength = ogNum.length()-1;
		char [] ch = ogNum.toCharArray();
		String num = "";
		String appendOne = "";
		String appendTwo = "";
		
		//Remove all the "[" "]" and spaces
		for(int i = 0; i < ogLength; i++)
		{
			char letter = ch[i];
			if(letter != '['&& letter != ']' && letter != ' ')
			{
				num += letter;
			}
		}

		
		//append extra zero
		if(this.getLast() < 100 && this.size() > 1 && 
		this.getLast() > 9 )
		{
			appendOne = num.substring(0,num.length()-2) + "0" + 
						num.substring(num.length()-2); 
			return appendOne;
		}
		
		//append 2 zeros
		else if(this.getLast() < 10 && this.size() > 1 )
		{
			appendTwo = num.substring(0,num.length()-1) + "00" + 
						num.charAt(num.length()-1);	
			return appendTwo;
		}
		
		return num;

	}
	
	public static InfiniteInt add(InfiniteInt num1, InfiniteInt num2)
	{
		//Data
		int num1Int = 0;
		int num2Int = 0;
		String sumString = "";
		String str1 = "";
		String str2 = "";

		
		//traverse through the linked list and append to a string
		while(!num1.isEmpty() )
		{
			num1Int = num1.removeFirst();
			str1 +=  Integer.toString(num1Int);
		}

		while(!num2.isEmpty())
		{
			num2Int = num2.removeFirst();
			str2 +=  Integer.toString(num2Int);
		}
		
		//Convert the strings into integers
		BigInteger numb1 = new BigInteger(str1);  
		BigInteger numb2 = new BigInteger(str2) ;
		 
		
		//Convert sum to a string
		
		sumString = numb1.add(numb2).toString();
		
		//return the sum InfiniteInt
		InfiniteInt sumLink = new InfiniteInt(sumString);
		return sumLink;
		
	}
	public int compareTo(Object o)
	{
		//Data
		String firstLink = "" ;
		String secondLink = "";
		String str1 = this.toString();;
		String str2 = o.toString();;
		
		//remove the commas to compare numbers
		firstLink = str1.replaceAll(",", "");
		secondLink = str2.replaceAll(",", "");
		
		//Convert String to BigInteger to be able to compare large values
		BigInteger one = new BigInteger(firstLink);
		BigInteger two = new BigInteger(secondLink);
		
		//Checks if the object passed is not InfiniteInt
		if(!(o instanceof InfiniteInt) ||!(this instanceof InfiniteInt) )
		{
			//throw ClassCastException
			throw new ClassCastException();
		}
		
		//Compare the value of the numbers
		else if(one.compareTo(two) > 0)
		{
			return 1;
		}
		
		else if(one.compareTo(two) < 0)
		{
			return -1;
		}
		   
		else 
		{
			return 0;
		}

	}
	
	public String revAndRemoveToString()
	{
		//Data
		String str = this.toString();
		String rev = "";
		String revRem = "";
		char[] ch = str.toCharArray();
		char temp;
		int start = 0;
		int end = ch.length-1;
		
		//reverse the string
		while(end > start)
		{
			temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
		
		//removes all the commas
		rev = new String(ch);
		revRem = rev.replaceAll(",", "");
		
		return revRem;
	}
	
	public String replaceCommasWithHyphens()
	{
		//Data
		String str = this.toString();
		String replace = "";
		
		//replaces commas with hyphens
		replace = str.replaceAll(",","-");
		return replace;
	}
	
	public String getGraderHash()
	{
		return "8ade5dbef6e08858f9cb061c841222f9";
	}
}
