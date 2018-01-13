//Header
/*
Beau Anderson
COMP 401
AnIteratorEnabledScanner.java - Class that parses a sentence into words and numbers, following the Iterator Convention.
*/

package stringProcessors;

public class AnIteratorEnabledScanner implements IteratorEnabledScanner
{
	String inputString = "";
	String stringToProcess = "";
	TokenInterface currentToken;
	String errorMessage = "";
	int intValueOfNumberString;
	int wordCount = 0;
	int pointer = 0;
	
	public AnIteratorEnabledScanner(String newInputString)
	{
		stringToProcess = newInputString;
		pointer = 0;
	}
	
//	@Override
//	public void setInputString(String newInputString)
//	{
//		stringToProcess = newInputString;
//		pointer = 0;
//	}
	
//	@Override
	TokenInterface WANProcessor(String inputSentence)
	{
		boolean validWord = false;
		boolean validNum = false;
		boolean plusSign = false;
		boolean minusSign = false;
		boolean invalidString = false;
		boolean invalidMath = false;
		int sentenceLength = inputSentence.length();
		int spaces = 0;
		int invalidWords = 0;
		boolean wordBuild = false;
		boolean testForMath = false;
		String word = "";
		TokenInterface currentToken = null;
		errorMessage = "";

		int i = 0;						// This is our counter for counting through the String, and also our character position
		int j = 0;						// This is the position of the next character to be tested

		for(i=pointer;i<sentenceLength;i++)
		{
			j = i + 1;

			// Checks for the ending of a word as defined by a space and the condition of Invalid Math
			if (inputSentence.charAt(i) == ' ' && invalidMath == true)
			{
				wordBuild = false;
				spaces++;
				if (word.length() != 0)
				{
					currentToken = convertWordStringToToken(word, validWord, validNum, plusSign, minusSign, invalidString, invalidMath);		// Call the printOut method to print whatever it found
					while (i < sentenceLength && inputSentence.charAt(i) == ' ')
					{
						i++;
					}
					pointer = i;
					return currentToken; // returns token and is ready to be called for next token.
				}
			}
			// Checks for beginning or ending of a word or number but if the + or - flag is set it discards the next spaces
			else if (inputSentence.charAt(i) == ' ' && (plusSign == true || minusSign == true) && validNum == false)
			{
				spaces++;
				testForMath = true;
			}
			// Checks for a space to signify the start of a word or number
			else if (inputSentence.charAt(i) == ' ')
			{
				wordBuild = false;
				spaces++;
				if (word.length() != 0)
				{
					currentToken = convertWordStringToToken(word, validWord, validNum, plusSign, minusSign, invalidString, invalidMath);		// Call the printOut method to print whatever it found
					while (i < sentenceLength && inputSentence.charAt(i) == ' ')
					{
						i++;
					}
					pointer = i;
					return currentToken;
				}
			}
			else
			{
				if (wordBuild == false)
				{
					if (Character.isLetter(inputSentence.charAt(i)) && invalidString == false && validNum == false && testForMath == false)
					{
						validWord = true;
						wordBuild = true;
						wordCount++;
					}
					else if (Character.isDigit(inputSentence.charAt(i)) && invalidString == false && validWord == false)
					{
						validNum = true;
						wordBuild = true;
						wordCount++;
					}
					else if (inputSentence.charAt(i) == '+' && testForMath == false)
					{
						plusSign = true;
						testForMath = true;
					}
					else if (inputSentence.charAt(i) == '-' && testForMath == false)
					{
						minusSign = true;
						testForMath = true;
					}
					else if (testForMath == true && Character.isDigit(inputSentence.charAt(i)) == false)
					{
						invalidMath = true;
						wordBuild = true;
					}
					else
					{
						validWord = false;
						validNum = false;
						plusSign = false;
						minusSign = false;
						invalidString = true;
						wordBuild = true;
						wordCount++;
						invalidWords++;
					}
					word = word + inputSentence.substring(i,j);
				}
				else if (wordBuild == true)
				{
					if (Character.isLetter(inputSentence.charAt(i)) && invalidString == false && validNum == false && plusSign == false && minusSign == false)
					{
						validWord = true;
					}
					else if (Character.isDigit(inputSentence.charAt(i)) && invalidString == false && validWord == false)
					{
						validNum = true;
					}
					else if (invalidString == false)
					{
						validWord = false;
						validNum = false;
						invalidString = true;
						if (testForMath == true)
						{
							invalidMath = true;
						}
						invalidWords++;
					}
					else
					{
						validWord = false;
						validNum = false;
						invalidString = true;						
						if (testForMath == true)
						{
							invalidMath = true;
						}
					}
					word = word + inputSentence.substring(i,j);
				}				
			}
		}

		if (wordBuild == true || (wordBuild == false && (plusSign == true || minusSign == true)))
		{
			currentToken = convertWordStringToToken(word, validWord, validNum, plusSign, minusSign, invalidString, invalidMath);		// Call the printOut method to print the final word
			if(invalidString == true)
			{
				invalidWords++;
			}
//			wordCount++;
			word = "";
			wordBuild = false;
		}
		
		if (wordCount == invalidWords)
		{
			word = "";
			errorMessage = "No valid words or numbers found in input!";
		}

//		System.out.println("Ran the ENTIRE Method!");
		pointer = inputSentence.length();
		return currentToken;
	}
	
//	@Override
	TokenInterface convertWordStringToToken(String word, boolean validWord, boolean validNum, boolean plusSign, boolean minusSign, boolean invalidString, boolean invalidMath)
	{
		TokenInterface currentToken;
		if (validWord == true)
		{
			String lowerCase = word.toLowerCase();
			if (lowerCase.equals("addhouse") || lowerCase.equals("addh"))
			{
				currentToken = new addHouse(word);
			}
			else if (lowerCase.equals("animate") || lowerCase.equals("anim") || lowerCase.equals("ani"))
			{
				currentToken = new Animate(word);
			}
			else if (lowerCase.equals("give") || lowerCase.equals("giv") || lowerCase.equals("gv"))
			{
				currentToken = new Give(word);
			}
			else if (lowerCase.equals("move") || lowerCase.equals("mov") || lowerCase.equals("mv"))
			{
				currentToken = new Move(word);
			}
			else if (lowerCase.equals("redo") || lowerCase.equals("red") || lowerCase.equals("rdo") || lowerCase.equals("rd"))
			{
				currentToken = new Redo(word);
			}
			else if (lowerCase.equals("removehouse") || lowerCase.equals("removeh") || lowerCase.equals("remh"))
			{
				currentToken = new removeHouse(word);
			}
			else if (lowerCase.equals("take") || lowerCase.equals("tak") || lowerCase.equals("tk"))
			{
				currentToken = new Take(word);
			}
			else if (lowerCase.equals("undo") || lowerCase.equals("und") || lowerCase.equals("udo") || lowerCase.equals("ud"))
			{
				currentToken = new Undo(word);
			}
			else if (lowerCase.equals("eat"))
			{
				currentToken = new Eat(word);
			}
			else if (lowerCase.equals("assign"))
			{
				currentToken = new Assign(word);
			}
			else if (lowerCase.equals("stat") || lowerCase.equals("stats") || lowerCase.equals("statistics"))
			{
				currentToken = new Statistics(word);
			}
			else if (lowerCase.equals("pre") || lowerCase.equals("preset"))
			{
				currentToken = new Preset(word);
			}
			else
			{
				if (word.charAt(0)=='a') {errorMessage += "Commands Starting With A: addhouse, addh, animate, anim, ani, assign | ";}
				if (word.charAt(0)=='e') {errorMessage += "Commands Starting With E: eat | ";}
				if (word.charAt(0)=='g') {errorMessage += "Commands Starting With G: give, giv, gv | ";}
				if (word.charAt(0)=='m') {errorMessage += "Commands Starting With M: move, mov, mv | ";}
				if (word.charAt(0)=='p') {errorMessage += "Commands Starting With P: preset, pre | ";}
				if (word.charAt(0)=='r') {errorMessage += "Commands Starting With R: redo, red, rdo, rd, removehouse, remh | ";}
				if (word.charAt(0)=='s') {errorMessage += "Commands Starting With S: statistics, stats, stat | ";}
				if (word.charAt(0)=='t') {errorMessage += "Commands Starting With T: take, tak, tk | ";}
				if (word.charAt(0)=='u') {errorMessage += "Commands Starting With U: undo, und, udo, ud | ";}
				currentToken = new Word(word);
			}
		}
		else if (validNum == true && plusSign == false && minusSign == false && invalidMath == false)
		{
			NumberInterface numberToken = new Number(word);
			intValueOfNumberString = numberToken.convertToInt();
			currentToken = numberToken;
		}
		else if (validNum == true && plusSign == true && minusSign == false && invalidMath == false)
		{
			NumberInterface plusToken = new Plus(word);
			intValueOfNumberString = plusToken.convertToInt();
			currentToken = plusToken;
		}
		else if (validNum == true && minusSign == true && plusSign == false && invalidMath == false)
		{
			NumberInterface minusToken = new Minus(word);
			intValueOfNumberString = minusToken.convertToInt();
			currentToken = minusToken;
		}
		else if (plusSign == true && invalidMath == true)
		{
			currentToken = new InvalidPlus(word);
		}
		else if (minusSign == true && invalidMath == true)
		{
			currentToken = new InvalidMinus(word);
		}
		else
		{
			currentToken = new InvalidWord(word);
		}
		return currentToken;
	}
	
//	@Override
//	public int getWordCount()
//	{
//		return wordCount;
//	}
	
//	@Override
//	public void clearWordCount()
//	{
//		wordCount = 0;
//	}

	@Override
	public boolean hasNext()
	{
		if(pointer < stringToProcess.length())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public TokenInterface next() throws AScannerException
	{
		currentToken = WANProcessor(stringToProcess);
//		if (pointer == stringToProcess.length())
		if (errorMessage.length() > 0)
		{
			if (currentToken == null)
			{
				throw new AScannerException("User Entered No Input!");
			}
			else
			{
				throw new AScannerException(errorMessage, currentToken);
			}
		}
		return currentToken;
	}
}