// Programmer: Mario Luja
// Date: June 8, 2020
// The Saurian class has the ability to translate English to Saurian
//  and Saurian to English

// Disclaimer:
// The given assignment description, project files, code files and/or solution files
// should not be made available in a public form via methods such as online hosting
// in code repositories, educational resource hosting websites, etc. These projects
// and related files can be hosted in private repositories for situations such as
// showing example work at job interviews, personal reference for future class
// projects, etc.


public class Saurian
{
	// data
	private String saurianForm;
	private String englishForm;

	// constants used for translating
	// note M = M and m = m so M and m are not needed
	public static final char[] ENGLISHARR = {'A','B','C','D','E','F','G','H','I','J','K','L','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static final char[] SAURIANARR = {'U','R','S','T','O','V','W','X','A','Z','B','C','D','E','F','G','H','J','K','I','L','N','P','O','Q','u','r','s','t','o','v','w','x','a','z','b','c','d','e','f','g','h','j','k','i','l','n','p','o','q'};
	public static final int ARRLENGTH = ENGLISHARR.length;	// should be the same length for ENGLISHARR and SAURIANARR

	public Saurian()
	{
		saurianForm = "";
		englishForm = "";
	}
	

	//Overloaded constructor
	public Saurian(String phrase,boolean language)
	{
		if(language == true)
		{
			englishForm = phrase;
		}
		else
		{
			saurianForm = phrase; 
		}
	}
	
	public String getSaurian()
	{
		translateEngToSaur(englishForm);
		return saurianForm;
	}
	
	public String getEnglish()
	{
		translateSaurToEng(saurianForm);
		return englishForm;
	}
	
	//Setter methods
	
	public void setEnglish(String englishString)
	{
		englishForm = englishString;
	}
	
	public void setSaurian(String saurianString)
	{
		saurianForm = saurianString;
	}
	
	//Translate methods
	
	//Saurian to English
	public void translateSaurToEng(String saurianToEnglish)
	{
		//Data
		englishForm = "";
		char saurLetter;
		boolean saurLetterPassed;
			
		//Goes through chars in Saurian phrase
		for(int i = 0; i < saurianToEnglish.length(); i++)
		{
			saurLetter = saurianToEnglish.charAt(i);
			
			//Check if the character is a letter
			if(Character.isLetter(saurLetter) == true)	
			{
				//If the following letter has already been translated
				saurLetterPassed = false;
				for(int j = 0; j < ARRLENGTH; j++)
				{
					if(SAURIANARR[j] == saurLetter && saurLetterPassed == 
					false)
					{
						englishForm += ENGLISHARR[j];
						saurLetterPassed = true;		
					}
				}
			}
			//Adds special characters to the phrase (! , ? etc...)
			else
			{
				englishForm += saurLetter;
			}
		}
	}
	
	//English to Saurian translation
	public void translateEngToSaur(String englishToSaur)
	{
		boolean engLetterPassed;
		saurianForm = "";
		char engLetter;
		
		//Runs through every character of the English phrase
		for(int i = 0; i< englishToSaur.length(); i++)
		{
			engLetter = englishToSaur.charAt(i);
			
			//Check if the character is a letter
			if(Character.isLetter(engLetter) == true)	
			{
				engLetterPassed = false;
				for(int j = 0; j < ARRLENGTH; j++)
				{
					if(ENGLISHARR[j] == engLetter)
					{
						saurianForm += SAURIANARR[j];
						
						//letter has already been translated
						engLetterPassed = true;
					}
					
				}
			}
			
			//Adds special characters to the phrase (! , ? etc...)
			else
			{
				saurianForm += engLetter;
			}
			
		}
		
	}
	
	//toString method
	public String toString()
	{
		String disp = "English translation: \n" + englishForm +
		"\n" + "Saurian translation: \n" + saurianForm;
		return disp;
	}
	
}

