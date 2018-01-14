//Header
/*
Beau Anderson
COMP 401
Final Project
1/09/2011
BeauAndersonFinalProject.java - Added Spinners to the animation section.
							  - Implemented Variable world size from 3 - 14 Houses.
							  - Optimized code further by adding more collections
							  - (Roads and Borders) and arrays (Houses and Empty Plots).
*/

package main;

import stringProcessors.*;
import util.trace.TraceableWarning;
import util.trace.bean.BeanTraceUtility;
import util.trace.trickOrTreat.TrickOrTreatTraceUility;
import util.trace.uigen.ImageYLessThanZero;
import graphics.*;
import bus.uigen.CompleteOEFrame;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.uiFrame;

public class BeauAndersonFinalProject
{
	public static void main(String[] args)
	{
		createSimulation("", 0, 0, 1200, 765, 100, 100);
	}
//	public static HalloweenCommandProcessor createSimulation(String titlePrefix, 
//				int simulationX, 
//				int simulationY, 
//				int simulationWidth,
//				int simulationHeight,
//				int commandX,
//				int commandY)
//	{
//		// The simulation requires 7 arguments, if you imagine that the window is a bounded
//		// box restricting avatar movement, then the first 4 arguments are the top (x,y)
//		// coordinate of the window, and the corresponding width and height.  This will not
//		// necessarily be the size of the actual window, in fact I have made this window 40
//		// pixels smaller so that the simulation border is visible.  Arguments 5 and 6 are
//		// an (x,y) offset which is basically the point on the simulation "world map" that
//		// is to be displayed at 0,0 - The last argument is an into from 1 to 14 for world size
//		HalloweenSimulation aNewHalloweenSim = new AHalloweenSimulation(40, 40, 1144, 720, 100, 50, 8);
////		OEFrame simulationFrame = ObjectEditor.edit(aNewHalloweenSim);
//		uiFrame simulationFrame = ObjectEditor.edit(aNewHalloweenSim);
//		simulationFrame.hideMainPanel();
//		simulationFrame.setTitle(titlePrefix + "Beau Anderson's Halloween Simulation - Version 13.5");
//		simulationFrame.setSize(simulationWidth, simulationHeight); // sets the width and height of window	
//		simulationFrame.setLocation(simulationX, simulationY);
//		// Display my Halloween Command Line Interface
//		// This extended subclass overrides the token detection routine to add support for new commands
//		HalloweenCommandProcessor commandLine = new AHalloweenCommandProcessor(aNewHalloweenSim);
////		OEFrame commandFrame = ObjectEditor.edit(commandLine);
//		uiFrame commandFrame = ObjectEditor.edit(commandLine);
//		commandFrame.setLocation(commandX, commandY);
//		commandFrame.setTitle(titlePrefix + "Halloween Simulation Command Line Interface - Version 13.5");
////		commandFrame.setSize(1100, 210); // sets the width and height of window
//		commandFrame.setSize(400, 210); // sets the width and height of window
//		return commandLine;
//	}
	public static HalloweenCommandProcessor createSimulation(String titlePrefix, 
			int simulationX, 
			int simulationY, 
			int simulationWidth,
			int simulationHeight,
			int commandX,
			int commandY)
{
	
	HalloweenSimulation aNewHalloweenSim = createAndDisplaySimulationWithoutCommandProcessor(simulationX, simulationY, simulationWidth, simulationHeight, titlePrefix);
////	OEFrame simulationFrame = ObjectEditor.edit(aNewHalloweenSim);
//	uiFrame simulationFrame = ObjectEditor.edit(aNewHalloweenSim);
//	simulationFrame.hideMainPanel();
//	simulationFrame.setTitle(titlePrefix + "Beau Anderson's Halloween Simulation - Version 13.5");
//	simulationFrame.setSize(simulationWidth, simulationHeight); // sets the width and height of window	
//	simulationFrame.setLocation(simulationX, simulationY);
//	// Display my Halloween Command Line Interface
//	// This extended subclass overrides the token detection routine to add support for new commands
	HalloweenCommandProcessor commandLine = new AHalloweenCommandProcessor();
	bindAndDisplayCommandProcessor(aNewHalloweenSim, commandLine, titlePrefix, commandX, commandY);
	return commandLine;
}
	public static HalloweenSimulation createAndDisplaySimulationWithoutCommandProcessor( 
			int simulationX, 
			int simulationY, 
			int simulationWidth,
			int simulationHeight,
			String titlePrefix
			)
{
	// The simulation requires 7 arguments, if you imagine that the window is a bounded
	// box restricting avatar movement, then the first 4 arguments are the top (x,y)
	// coordinate of the window, and the corresponding width and height.  This will not
	// necessarily be the size of the actual window, in fact I have made this window 40
	// pixels smaller so that the simulation border is visible.  Arguments 5 and 6 are
	// an (x,y) offset which is basically the point on the simulation "world map" that
	// is to be displayed at 0,0 - The last argument is an into from 1 to 14 for world size
	HalloweenSimulation aNewHalloweenSim = new AHalloweenSimulation(40, 40, 1144, 720, 100, 50, 8);
//	OEFrame simulationFrame = ObjectEditor.edit(aNewHalloweenSim);
	// some images will be < 0
	TraceableWarning.doNotWarn(ImageYLessThanZero.class);
	BeanTraceUtility.setTracing();
	TrickOrTreatTraceUility.setTracing();
	CompleteOEFrame simulationFrame = ObjectEditor.edit(aNewHalloweenSim);
	simulationFrame.hideMainPanel();
	simulationFrame.setTitle(titlePrefix + "Beau Anderson's Halloween Simulation - Version 13.5");
	simulationFrame.setSize(simulationWidth, simulationHeight); // sets the width and height of window	
	simulationFrame.setLocation(simulationX, simulationY);
	// Display my Halloween Command Line Interface
	// This extended subclass overrides the token detection routine to add support for new commands
//	HalloweenCommandProcessor commandLine = new AHalloweenCommandProcessor(aNewHalloweenSim);
////	OEFrame commandFrame = ObjectEditor.edit(commandLine);
//	uiFrame commandFrame = ObjectEditor.edit(commandLine);
//	commandFrame.setLocation(commandX, commandY);
//	commandFrame.setTitle(titlePrefix + "Halloween Simulation Command Line Interface - Version 13.5");
////	commandFrame.setSize(1100, 210); // sets the width and height of window
//	commandFrame.setSize(400, 210); // sets the width and height of window
//	return commandLine;
	return aNewHalloweenSim;
}
	public static void bindAndDisplayCommandProcessor(HalloweenSimulation aSimulation, 
			HalloweenCommandProcessor commandLine, String titlePrefix, int commandX,
			int commandY) {
//		HalloweenCommandProcessor commandLine = new AHalloweenCommandProcessor(aNewHalloweenSim);
		commandLine.init(aSimulation);
//		OEFrame commandFrame = ObjectEditor.edit(commandLine);
		CompleteOEFrame commandFrame = ObjectEditor.edit(commandLine);
		commandFrame.setLocation(commandX, commandY);
		commandFrame.setTitle(titlePrefix + "Halloween Simulation Command Line Interface - Version 13.5");
//		commandFrame.setSize(1100, 210); // sets the width and height of window
		commandFrame.setSize(400, 210); // sets the width and height of window
		
	}
}