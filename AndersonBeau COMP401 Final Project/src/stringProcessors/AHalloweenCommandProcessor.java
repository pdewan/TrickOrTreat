package stringProcessors;

import graphics.HalloweenSimulation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import util.annotations.MaxValue;
import util.annotations.MinValue;
import util.annotations.StepValue;
import util.annotations.Position;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
import util.trace.bean.AddedPropertyChangeListener;
import util.trace.bean.NotifiedPropertyChangeEvent;
import util.trace.bean.SetProperty;
import util.trace.trickOrTreat.CommandSubmitted;
import veto.PropertyChangeVetoer;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AHalloweenCommandProcessor implements HalloweenCommandProcessor, Serializable
{
	public static final boolean RESET_COMMAND = false;

	transient HalloweenSimulation MyHalloweenSim;
	transient Undoer undoer = new AHistoryUndoer();
	transient int commands;
	transient int placeholderCommands;
	String inputString = "";
//	IteratorEnabledScanner stringProcessor = new AnIteratorEnabledScanner();
	transient IteratorEnabledScanner stringProcessor;
	transient IteratorEnabledScanner placeholderProcessor;
	 String errorMessages = "";
//	boolean isAvatarConnected;
//	int houseConnectedToAvatar;
	 transient TokenInterface commandToken;
	transient TokenInterface placeholderToken;
//	boolean justAssignedMacro = false;
	transient boolean stillNeedToTestCurrentToken = false;
		int totalWordCount = 0;
		int totalCommandCount = 0;
		String macro1 = "";
		String macroBuildString = "";
	transient TokenInterface macro1Token = new InvalidWord("macro1");
	boolean animationOn = false;
	boolean statsOn = false;
	int numberOfSteps = 20;
	int pauseTime = 100;
	boolean smoothAnimation = false;
	int simWorldSize;
	String SimErrorMessages = "";
	transient Vector<PropertyChangeListener> listeners = new Vector<PropertyChangeListener>();
	transient Vector<PropertyChangeVetoer> vetoers = new Vector<PropertyChangeVetoer>();
	boolean connectedToSimulation = true;
//	List<String> commandHistory = new ArrayList();
	
	

	public AHalloweenCommandProcessor(HalloweenSimulation inputSim)
	{
		init(inputSim);
//		MyHalloweenSim = inputSim;
//		simWorldSize = MyHalloweenSim.getWorldSize();
////		isAvatarConnected = MyHalloweenSim.getIsAvatarConnected();
////		houseConnectedToAvatar = MyHalloweenSim.getAvatarConnectedHouseNumber();
//		MyHalloweenSim.addCommandLineListener(this);
//		MyHalloweenSim.toggleAnimation(animationOn, numberOfSteps, pauseTime);
	}
	
	public AHalloweenCommandProcessor()
	{

	}
	boolean replayInputString = false;
	void replay() {
		replay = true;
		if( replayInputString && !inputString.equals(""))
			processCommand(inputString);

		replay = false;
	}
	
	public void init (HalloweenSimulation inputSim) {
		MyHalloweenSim = inputSim;
		simWorldSize = MyHalloweenSim.getWorldSize();
		replay();
//		isAvatarConnected = MyHalloweenSim.getIsAvatarConnected();
//		houseConnectedToAvatar = MyHalloweenSim.getAvatarConnectedHouseNumber();
		MyHalloweenSim.addCommandLineListener(this);
		MyHalloweenSim.toggleAnimation(animationOn, numberOfSteps, pauseTime);
	}
	
	
	@Override
	@Position (0)
	@util.annotations.ComponentWidth(900)
//	@util.annotations.ComponentWidth(200)

	public String getInputString()
	{
		return inputString;
	}

	@Override
	@Position (1)
	@util.annotations.ComponentWidth(900)
//	@util.annotations.ComponentWidth(200)

	public String getErrorMessages()
	{
		return errorMessages;
	}

	@Override
	@Position (2)
	@util.annotations.ComponentWidth(900)
	public String getSimFeedback()
	{
		if (MyHalloweenSim != null)
		return MyHalloweenSim.getErrorMessages();
		else
			return "";
//		return SimErrorMessages;
	}

//	@Override
//	@Position (4)
//	public boolean getIsAvatarConnected()
//	{
//		return isAvatarConnected;
//	}
	
	@Override
	@Position (3)
	public boolean getAnimationActivated()
	{
		return animationOn;
	}
	
	@Override
	public boolean preGetNumberOfSteps()
	{
		return animationOn;
	}
	
	@Override
	@Position (4)
	@util.annotations.PreferredWidgetClass(javax.swing.JSpinner.class)
	@MinValue(1)
	@MaxValue(500)
	@StepValue(1)
//	@util.annotations.Direction(AttributeNames.HORIZONTAL)
	public int getNumberOfSteps()
	{
		assert (preGetNumberOfSteps());
		return numberOfSteps;
	}
	
	@Override
	public void setNumberOfSteps(int nSteps)
	{
		numberOfSteps = nSteps;
		if (animationOn == true)
		{
			if (MyHalloweenSim != null)

			MyHalloweenSim.toggleAnimation(animationOn, numberOfSteps, pauseTime);
		}
	}
	
	@Override
	public boolean preGetPauseTime()
	{
		return animationOn;
	}

	@Override
	@Position (5)
	@util.annotations.PreferredWidgetClass(javax.swing.JSpinner.class)
	@util.annotations.MinValue(10)
	@util.annotations.MaxValue(2000)
	@util.annotations.StepValue(10)
//	@util.annotations.Direction(AttributeNames.HORIZONTAL)
	public int getPauseTime()
	{
		assert (preGetPauseTime());
		return pauseTime;
	}
	
	@Override
	public void setPauseTime(int pTime)
	{
		pauseTime = pTime;
		if (animationOn == true)
		{
			if (MyHalloweenSim != null)

			MyHalloweenSim.toggleAnimation(animationOn, numberOfSteps, pauseTime);
		}
	}

	@Override
	@Position (6)
	public boolean getStatisticsActivated()
	{
		return statsOn;
	}

	@Override
	public void setStatisticsActivated(boolean toggle)
	{
		statsOn = toggle;
		notifyAllListeners(preconditionEvent);
	}

	@Override
	public boolean preGetStoredMacro()
	{
		return statsOn;
	}
	
	@Override
	@Position (7)
	@util.annotations.ComponentWidth(500)
	public String getStoredMacro()
	{
		assert (preGetStoredMacro());
		if (macro1.length() == 0)
		{
			return "Macro is empty.";
		}
		else
		{
			return ("Macro [" + macro1 + "] stored as Token: " + macro1Token.getUserInputString());
		}
	}
	
	@Override
	public boolean preGetWordCount()
	{
		return statsOn;
	}

	@Override
	@Position (8)
	public int getWordCount()
	{
		assert (preGetWordCount());
		return totalWordCount;
	}

	@Override
	public boolean preGetCommandCount()
	{
		return statsOn;
	}
	
	@Override
	@Position (9)
	public int getCommandCount()
	{
		assert (preGetCommandCount());
		return totalCommandCount;
	}
	
	@Override
	public boolean preGetDistanceMoved()
	{
		return statsOn;
	}
	
	@Override
	@Position (10)
	public int getDistanceMoved()
	{
		assert (preGetDistanceMoved());
		if (MyHalloweenSim != null)
		return MyHalloweenSim.getDistanceMoved();
		else
			return 0;
	}

	@Override
	public boolean preGetHousesAdded()
	{
		return statsOn;
	}
	
	@Override
	@Position (11)
	public int getHousesAdded()
	{
		assert (preGetHousesAdded());
		if (MyHalloweenSim != null)

		return MyHalloweenSim.getHousesAdded();
		else return 0;
	}

	@Override
	public boolean preGetHousesRemoved()
	{
		return statsOn;
	}
	
	@Override
	@Position (12)
	public int getHousesRemoved()
	{
		assert (preGetHousesRemoved());
		if (MyHalloweenSim != null)

		return MyHalloweenSim.getHousesRemoved();
		else return 0;
	}

	@Override
	public boolean preGetCupcakesEaten()
	{
		return statsOn;
	}
	
	@Override
	@Position (13)
	public int getCupcakesEaten()
	{
		assert (preGetCupcakesEaten());
		if (MyHalloweenSim != null)
		return MyHalloweenSim.getCupcakesEaten();
		else return 0;
	}

	@Override
	public boolean preGetHousePreset1()
	{
		return statsOn;
	}
	
	@Override
	@Position (14)
	public boolean getHousePreset1()
	{
		assert (preGetHousePreset1());
		if (MyHalloweenSim != null)

		return MyHalloweenSim.getPreset1();
		else return false;
	}

	@Override
	public boolean preGetHousePreset2()
	{
		return statsOn;
	}
	
	@Override
	@Position (15)
	public boolean getHousePreset2()
	{
		assert (preGetHousePreset2());
		if (MyHalloweenSim != null)

		return MyHalloweenSim.getPreset2();
		else return false;
	}

	@Override
	public boolean preGetHousePreset3()
	{
		return statsOn;
	}
	
	@Override
	@Position (16)
	public boolean getHousePreset3()
	{
		assert (preGetHousePreset3());
		if (MyHalloweenSim != null)

		return MyHalloweenSim.getPreset3();
		else return false;
	}

	@Override
	public boolean preGetHousePreset4()
	{
		return statsOn;
	}
	
	@Override
	@Position (17)
	public boolean getHousePreset4()
	{

		assert (preGetHousePreset4());
		if (MyHalloweenSim != null)

		return MyHalloweenSim.getPreset4();
		return false;
	}
	
	@Override
	public boolean preGetWorldSize()
	{
		return statsOn;
	}

	@Override
	@Position (18)
	public int getWorldSize()
	{
		return simWorldSize;
	}
	
//	@Override
//	@Position (3)
//	public String getHouseAvatarIsConnectedTo()
//	{
//		if (houseConnectedToAvatar > 0)
//		{
//			return ("Connected to house" + houseConnectedToAvatar);
//		}
//		else
//		{
//			return "";
//		}
//	}

	@Visible(false)
	@Override
	public void simulationListener(String simInput)
	{
		@SuppressWarnings("unused")
		String OldMessage = SimErrorMessages;
		SimErrorMessages = simInput;
//		System.out.println("Message Received: " + simInput);
//		if (animationOn == true)
//		{
//			notifyAllListeners(new PropertyChangeEvent(this, "ErrorMessage2", OldMessage, SimErrorMessages));
//		}
	}

	@SuppressWarnings("unused")
	public void notifyAllListeners(PropertyChangeEvent event)
	{
	    for(int i = 0; i < listeners.size(); i++)
	    {
	        listeners.get(i).propertyChange(event);
	    }
	}
	
	private boolean checkWithAllVetoers(PropertyChangeEvent event)
	{
		boolean retVal = true;
	    for(int i = 0; i < vetoers.size(); i++)
	    {
	        retVal &= vetoers.get(i).allowPropertyChange(event);
	        if (!retVal) return false;
	    }
	    return true;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener newListener)
	{
		AddedPropertyChangeListener.newCase(this, newListener);
		listeners.add(newListener);
	}
	
	@Override
	public void addPropertyChangeVetoer(PropertyChangeVetoer newVetoer)
	{
		vetoers.add(newVetoer);
	}
	PropertyChangeEvent preconditionEvent = new PropertyChangeEvent(this, "this", null, this);

	@Override
	public void setAnimationActivated(boolean toggle)
	{
		boolean oldVal = animationOn;
		animationOn = toggle;
		if (MyHalloweenSim != null)

		MyHalloweenSim.toggleAnimation(animationOn, numberOfSteps, pauseTime);
		PropertyChangeEvent inputEvent = new PropertyChangeEvent(this, "AnimationActivated", oldVal, animationOn);

		notifyAllListeners(inputEvent);
		notifyAllListeners(preconditionEvent);



	}
	PropertyChangeListener[] emptyPropertyChangeListenerArray = {};
	@Override
	public void setInputString(String newVal)
	{
		SetProperty.newCase(this, "InputString", newVal);
		String oldInputString = inputString;		
		String newInputString = newVal;
		PropertyChangeEvent inputEvent = new PropertyChangeEvent(this, "InputString", oldInputString, newInputString);

		if (checkWithAllVetoers(inputEvent)) {
			if (isConnectedToSimulation()) {
				processCommand(newVal);
			}
			NotifiedPropertyChangeEvent.newCase(this, inputEvent, listeners.toArray(emptyPropertyChangeListenerArray));
			notifyAllListeners(inputEvent);
		} else {
			System.out.println ("Property cnange vetoed");
		}
//		else { // shoud probably reject the set
//			inputString = newVal;
//		}
////		PropertyChangeEvent inputEvent = new PropertyChangeEvent(this, "InputString", oldInputString, newInputString);
//		NotifiedPropertyChangeEvent.newCase(this, inputEvent, listeners.toArray(emptyPropertyChangeListenerArray));
//		notifyAllListeners(inputEvent);
	}
	
	boolean replay;
	@Override
	public void processCommand(String newInputString)
	{
		CommandSubmitted.newCase(this, newInputString);
		inputString = newInputString;
		if (MyHalloweenSim == null)
			return;
		String oldErrorMessages = errorMessages;

		errorMessages = "";
		if (MyHalloweenSim != null)
		MyHalloweenSim.clearErrorMessages();
		// Load the input string into the iterator enabled scanner
//		stringProcessor.setInputString(inputString);
		stringProcessor = new AnIteratorEnabledScanner(inputString);
		stillNeedToTestCurrentToken = false;	
//		if (!replay) {
//		commandHistory.add(inputString);
		if (RESET_COMMAND)
		inputString = "";
//		}
		// Now, we check if hasNext is true and if so we get the next token and process it
		commands = 0; // Keep track of valid commands
		int loopCounter = 0;
		while (stringProcessor.hasNext() == true)
		{
			// Get the next token if ready to do so
			if (stillNeedToTestCurrentToken == false || loopCounter > 1)
			{
				stillNeedToTestCurrentToken = false;
				loopCounter = 0;
				try
				{
					commandToken = stringProcessor.next();
				}
				catch (AScannerException scannerE)
				{
					errorMessages += scannerE.getMessage();
					commandToken = scannerE.getThrownToken();
				}
				totalWordCount++;
			}
			// Test it for validity
			if (commandToken instanceof Move)
			{
				try
				{
					moveAvatar();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
//				if only processing 1 command per sentence than need to break after a recognized command
//				break;
			}
			
			if (commandToken instanceof addHouse)
			{
				try
				{
					addHouse();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}
			
			if (commandToken instanceof removeHouse)
			{
				try
				{
					removeHouse();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}

			if (commandToken instanceof Give)
			{
				try
				{
					giveCandy();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}

			if (commandToken instanceof Take)
			{
				try
				{
					takeCandy();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}

			if (commandToken instanceof Animate)
			{
				animateSimulation();
			}

			if (commandToken instanceof Undo)
			{
				undoCommand();
			}

			if (commandToken instanceof Redo)
			{
				redoCommand();
			}
			
			if (commandToken instanceof Preset)
			{
				try
				{
					storeHousePreset();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
			}

			if (commandToken instanceof Eat)
			{
				try
				{
					eatCommand();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}
			
			if (commandToken instanceof Statistics)
			{
				toggleStatistics();
			}

			if (commandToken instanceof Assign)
			{
				try
				{
					assignMacroCommand();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
			}

			if (commandToken instanceof Word && commandToken.getUserInputString().equals(macro1Token.getUserInputString()))
			{
				processMacro();
				commands++;
			}
			loopCounter++;
		}

		try
		{
			if (commands==0)
			{
				System.out.println(" >>>> No valid commands entered.");
				throw new AParserException(" >>>> No valid commands entered.");
			}
		}
		catch (AParserException parserE)
		{
			errorMessages += parserE.getMessage();
		}

		//Reset Variables for new input
		macroBuildString = "";
		totalCommandCount += commands;
		PropertyChangeEvent errorEvent = new PropertyChangeEvent(this, "ErrorMessages", oldErrorMessages, errorMessages);
		notifyAllListeners(errorEvent);


		// Update fields for status of avatar on CLI
//		isAvatarConnected = MyHalloweenSim.getIsAvatarConnected();
//		houseConnectedToAvatar = MyHalloweenSim.getAvatarConnectedHouseNumber();
	}
		
	void moveAvatar() throws AParserException
	{
		if (MyHalloweenSim == null)
			return;
		if (stringProcessor.hasNext() == true)
		{
			try
			{
				placeholderToken = stringProcessor.next();
			}
			catch (AScannerException scannerE)
			{
				errorMessages += scannerE.getMessage();
				placeholderToken = scannerE.getThrownToken();
			}
			totalWordCount++;
			if (placeholderToken instanceof Number)
			{
				int parameter1 = ((Number) placeholderToken).convertToInt();
				if (stringProcessor.hasNext() == true)
				{
					try
					{
						placeholderToken = stringProcessor.next();
					}
					catch (AScannerException scannerE)
					{
						errorMessages += scannerE.getMessage();
						placeholderToken = scannerE.getThrownToken();
					}
					totalWordCount++;
					if (placeholderToken instanceof Number)
					{
						int parameter2 = ((Number) placeholderToken).convertToInt();
						
						undoer.execute(new MoveCommand(MyHalloweenSim, parameter1, parameter2));
						macroBuildString += ("move " + parameter1 + " " + parameter2 +" ");
						commands++;
					}
					else
					{
						commandToken = placeholderToken;
						stillNeedToTestCurrentToken = true;
						throw new AParserException("Y is not an integer! Correct Syntax is:  move x y ");
					}
				}
				else
				{
					throw new AParserException("Move Command Missing Y Value! Correct Syntax is: move x y ");
				}
			}
			else
			{
				commandToken = placeholderToken;
				stillNeedToTestCurrentToken = true;
				throw new AParserException("X is not an integer! Move Command must be followed by positive/negative integers for x and y.");
			}
		}
		else
		{
			throw new AParserException("Move Missing Parameters! Move Command must be followed by positive/negative integers for x and y.");
		}
	}
	
	void addHouse() throws AParserException, ASemanticException
	{
		if (MyHalloweenSim.preAddHouse()==false)
		{
			throw new ASemanticException("Cannot AddHouse, the neighborhood is full!");
		}
		if (stringProcessor.hasNext() == true)
		{
			try
			{
				placeholderToken = stringProcessor.next();
			}
			catch (AScannerException scannerE)
			{
				errorMessages += scannerE.getMessage();
				placeholderToken = scannerE.getThrownToken();
			}
			totalWordCount++;
			if (placeholderToken instanceof Number)
			{
				int parameter1 = ((Number) placeholderToken).convertToInt();
				if (parameter1 > 0 && parameter1 < 5)
				{
					undoer.execute(new addHouseCommand(MyHalloweenSim, parameter1));
					macroBuildString += ("addhouse " + parameter1 + " ");
					commands++;
				}
				else
				{
					undoer.execute(new addHouseCommand(MyHalloweenSim));
					macroBuildString += "addhouse ";
					commands++;
					throw new AParserException(" Macro Parameter must be between 1 and 4 - Parameter Discarded / Random House Added.");
				}
			}
			else
			{
				commandToken = placeholderToken;
				stillNeedToTestCurrentToken = true;
				undoer.execute(new addHouseCommand(MyHalloweenSim));
				macroBuildString += "addhouse ";
				commands++;
			}
		}
		else
		{
			undoer.execute(new addHouseCommand(MyHalloweenSim));
			macroBuildString += "addhouse ";
			commands++;
		}
	}
	
	void removeHouse() throws ASemanticException
	{
		if (MyHalloweenSim.preRemoveHouse()==false)
		{
			throw new ASemanticException("Cannot RemoveHouse, the neighborhood is empty!");
		}
		undoer.execute(new removeHouseCommand(MyHalloweenSim));
		macroBuildString += "removeHouse ";
		commands++;
	}
	
	void giveCandy() throws AParserException, ASemanticException
	{
		if (MyHalloweenSim.preGiveCandy()==false)
		{
			throw new ASemanticException("Cannot Give Cupcakes, Your feet are not on the path of a house!");
		}
		if (stringProcessor.hasNext() == true)
		{
			try
			{
				placeholderToken = stringProcessor.next();
			}
			catch (AScannerException scannerE)
			{
				errorMessages += scannerE.getMessage();
				placeholderToken = scannerE.getThrownToken();
			}
			totalWordCount++;
			if (placeholderToken instanceof Number)
			{
				int parameter1 = ((Number) placeholderToken).convertToInt();
				undoer.execute(new GiveCommand(MyHalloweenSim, parameter1));
				macroBuildString += ("give " + parameter1 + " ");
				commands++;
			}
			else if (placeholderToken instanceof Minus)
			{
				throw new AParserException("If you want to give a negative amount, just use the Take Command!");
			}
			else
			{
				commandToken = placeholderToken;
				stillNeedToTestCurrentToken = true;
				throw new AParserException("Give Command must be followed by positive integer.");
			}
		}
		else
		{
			throw new AParserException(errorMessages += "Missing Parameter! Give Command must be followed by positive integer.");
		}
	}
	
	void takeCandy() throws AParserException, ASemanticException
	{
		if (MyHalloweenSim.preTakeCandy()==false)
		{
			throw new ASemanticException("Cannot Take Cupcakes, Your feet are not on the path of a house!");
		}
		if (stringProcessor.hasNext() == true)
		{
			try
			{
				placeholderToken = stringProcessor.next();
			}
			catch (AScannerException scannerE)
			{
				errorMessages += scannerE.getMessage();
				placeholderToken = scannerE.getThrownToken();
			}
			totalWordCount++;
			if (placeholderToken instanceof Number)
			{
				int parameter1 = ((Number) placeholderToken).convertToInt();
				undoer.execute(new TakeCommand(MyHalloweenSim, parameter1));
				macroBuildString += ("take " + parameter1 + " ");
				commands++;
			}
			else if (placeholderToken instanceof Minus)
			{
				throw new AParserException("If you want to take a negative amount, just use the Give Command!");
			}
			else
			{
				commandToken = placeholderToken;
				stillNeedToTestCurrentToken = true;
				throw new AParserException("Take Command must be followed by positive integer.");
			}
		}
		else
		{
			throw new AParserException("Missing Parameter! Take Command must be followed by positive integer.");
		}
	}

	void storeHousePreset() throws AParserException
	{
		if (stringProcessor.hasNext() == true)
		{
			try
			{
				placeholderToken = stringProcessor.next();
			}
			catch (AScannerException scannerE)
			{
				errorMessages += scannerE.getMessage();
				placeholderToken = scannerE.getThrownToken();
			}
			totalWordCount++;
			if (placeholderToken instanceof Number)
			{
				int parameter1 = ((Number) placeholderToken).convertToInt();
				if (parameter1 < 1 || parameter1 > simWorldSize)
				{
					throw new AParserException("Preset Not Stored! 1st Argument must be between 1-" + simWorldSize);
				}
				if (stringProcessor.hasNext() == true)
				{
					try
					{
						placeholderToken = stringProcessor.next();
					}
					catch (AScannerException scannerE)
					{
						errorMessages += scannerE.getMessage();
						placeholderToken = scannerE.getThrownToken();
					}
					totalWordCount++;
					if (placeholderToken instanceof Number)
					{
						int parameter2 = ((Number) placeholderToken).convertToInt();
						if (parameter2 < 1 || parameter2 > 4)
						{
							throw new AParserException("Preset Not Stored! 2nd Argument must be between 1-4");
						}
						undoer.execute(new PresetCommand(MyHalloweenSim, parameter1, parameter2));
						commands++;
					}
					else
					{
						commandToken = placeholderToken;
						stillNeedToTestCurrentToken = true;
						throw new AParserException("Preset Not Stored! Correct Syntax is: preset (1-" + simWorldSize + ") (1-4)");
					}
				}
				else
				{
					throw new AParserException("Preset Not Stored! Correct Syntax is: preset house# preset#");
				}
			}
			else
			{
				commandToken = placeholderToken;
				stillNeedToTestCurrentToken = true;
				throw new AParserException("Preset 1st & 2nd Parameters must be integers. # of house to copy (1-" + simWorldSize + "), # of preset to save (1-4).");
			}
		}
		else
		{
			throw new AParserException("Preset Command Missing Parameters! Preset must be followed by house # to copy, and Preset # to save into.");
		}
	}
	
	void animateSimulation()
	{
		if (animationOn == false)
		{
			setAnimationActivated(true);
			errorMessages += " Animation set to ON.";
		}
		else
		{
			setAnimationActivated(false);
			errorMessages += " Animation set to OFF.";
		}
		commands++;
	}
	
	void toggleStatistics()
	{
		if (statsOn == false)
		{
			setStatisticsActivated(true);
			errorMessages += " Statistics set to DISPLAYED.";
		}
		else
		{
			setStatisticsActivated(false);
			errorMessages += " Statistics set to HIDDEN.";
		}
		commands++;
	}

	@Override
	public boolean preUndoCommand()
	{
		return undoer.getCanUndo();
	}
	
	@Override
	public void undoCommand()
	{
		undoer.undo();
		macroBuildString += "undo ";
		commands++;
	}

	@Override
	public boolean preRedoCommand()
	{
		return undoer.getCanRedo();
	}
	
	@Override
	public void redoCommand()
	{
		undoer.redo();
		macroBuildString += "redo ";
		commands++;
	}

	void eatCommand() throws ASemanticException
	{
		if (MyHalloweenSim.preEatCandy()==false)
		{
			throw new ASemanticException("You have no cupcakes to eat!  Better go do some trick-or-treating...");
		}
		undoer.execute(new EatCommand(MyHalloweenSim));
		macroBuildString += "eat ";
		commands++;
	}

	void assignMacroCommand() throws AParserException
	{
		if (macroBuildString.length() > 0)
		{
			if (stringProcessor.hasNext() == true)
			{
				try
				{
					placeholderToken = stringProcessor.next();
				}
				catch (AScannerException scannerE)
				{
					errorMessages += scannerE.getMessage();
					placeholderToken = scannerE.getThrownToken();
				}
				totalWordCount++;
				if (placeholderToken instanceof Word)
				{
					macro1Token = placeholderToken;
					macro1 = macroBuildString;
					commands++;
					throw new AParserException((" Assigned macro called [" + macro1Token + "] that contains [" + macro1 + "]"));
				}
				else
				{
					commandToken = placeholderToken;
					stillNeedToTestCurrentToken = true;
					throw new AParserException(" Assign Command must be followed by a valid word.");
				}
			}
			else
			{
				throw new AParserException(" No Parameter! Assign Command must be followed by a valid word.");
			}
		}
		else
		{
			throw new AParserException(" Cannot assign 0 commands to a macro!");
		}
	}

	void processMacro()
	{
		try
		{
			throw new AParserException(("Processing Macro [" + macro1Token + "] which is: " + macro1));
		}
		catch (AParserException parserE)
		{
			errorMessages += parserE.getMessage();
		}
		// Here goes nothing!
		// Recursively scan the history for new (valid) commands starting at the point in the history where the input string was added.
		// Had to duplicate setInputString because otherwise I got all kinds of weird recursion issues
		// It seemed like java was just losing it's place - not sure why, I don't understand enough about Java Order of Execution
		// Load the input string into the iterator enabled macro scanner
		placeholderProcessor = stringProcessor;
		stringProcessor = new AnIteratorEnabledScanner(macro1);
		// Now, we check if hasNext is true and if so we get the next token and process it
		placeholderCommands = commands;
		commands = 0; // Keep track of valid commands
		int loopCounter = 0;
		while (stringProcessor.hasNext() == true)
		{
			// Get the next token if ready to do so
			if (stillNeedToTestCurrentToken == false || loopCounter > 1)
			{
				stillNeedToTestCurrentToken = false;
				loopCounter = 0;
				try
				{
					commandToken = stringProcessor.next();
				}
				catch (AScannerException scannerE)
				{
					errorMessages += scannerE.getMessage();
					commandToken = scannerE.getThrownToken();
				}
				totalWordCount++;
			}
			// Test it for validity
			if (commandToken instanceof Move)
			{
				try
				{
					moveAvatar();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
			}
			
			if (commandToken instanceof addHouse)
			{
				try
				{
					addHouse();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}
			
			if (commandToken instanceof removeHouse)
			{
				try
				{
					removeHouse();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}

			if (commandToken instanceof Give)
			{
				try
				{
					giveCandy();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}

			if (commandToken instanceof Take)
			{
				try
				{
					takeCandy();
				}
				catch (AParserException parserE)
				{
					errorMessages += parserE.getMessage();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}

			if (commandToken instanceof Animate)
			{
				animateSimulation();
			}

			if (commandToken instanceof Undo)
			{
				undoCommand();
			}

			if (commandToken instanceof Redo)
			{
				redoCommand();
			}

			if (commandToken instanceof Eat)
			{
				try
				{
					eatCommand();
				}
				catch (ASemanticException semanticE)
				{
					errorMessages += semanticE.getMessage();
				}
			}

			loopCounter++;
		}

		try
		{
			if (commands==0)
			{
				throw new AParserException(" >>>> No valid commands entered.");
			}
		}
		catch (AParserException parserE)
		{
			errorMessages += parserE.getMessage();
		}

		//Reset Variables for new input
		stringProcessor = placeholderProcessor;
		commands += placeholderCommands;

		// Update fields for status of avatar on CLI
//		isAvatarConnected = MyHalloweenSim.getIsAvatarConnected();
//		houseConnectedToAvatar = MyHalloweenSim.getAvatarConnectedHouseNumber();
	}
	public void setAnimateCars(boolean newVal) {
		if (MyHalloweenSim != null)
		MyHalloweenSim.setAnimateCars(newVal);
		else {
			System.out.println("AHalloweenCommandProcessor: Halloweeen Simulation Not Initialized - Ignoring setAnimateCars call");
		}
		
	}
	@Visible(false)
	public boolean getAnimateCars() {
		if (MyHalloweenSim != null)
		return MyHalloweenSim.getAnimateCars();
		else return false;
	}
	
	public void initSerializedObject () {
		 listeners = new Vector<PropertyChangeListener>();
		 vetoers = new Vector<PropertyChangeVetoer>();
		  undoer = new AHistoryUndoer();
		  macro1Token = new InvalidWord("macro1");


	}
	@Override
	public boolean isConnectedToSimulation() {
		return connectedToSimulation;
	}
    @Override
	public void setConnectedToSimulation(boolean newVal) {
    	if (newVal == connectedToSimulation)
    		return;
		this.connectedToSimulation = newVal;
    	notifyAllListeners(new PropertyChangeEvent(this, "ConnectedToSimulation", null, newVal));

	}
}