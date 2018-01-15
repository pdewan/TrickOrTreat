package coupledsims;

import stringProcessors.HalloweenCommandProcessor;
import main.BeauAndersonFinalProject;

public class TwoCoupledVetoingHalloweenSimulations extends TwoCoupledHalloweenSimulations{
	
	public static void main (String[] args) {
		//Ideally the prefixes should be main args
		HalloweenCommandProcessor commandProcessor1 = createSimulation1(Simulation1.SIMULATION1_PREFIX);				 
		HalloweenCommandProcessor commandProcessor2 = createSimulation2(Simulation2.SIMULATION2_PREFIX);
		new AVetoingSimulationCoupler(commandProcessor1, commandProcessor2);
		new AVetoingSimulationCoupler(commandProcessor2, commandProcessor1);
	}

}
