package coupledsims;

import stringProcessors.HalloweenCommandProcessor;
import main.BeauAndersonFinalProject;

public class TwoCoupledHalloweenSimulations {
	
	public static HalloweenCommandProcessor createSimulation1(String aPrefix) {
		return 	BeauAndersonFinalProject.createSimulation(
					aPrefix,
					Simulation1.SIMULATION1_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET, 
					Simulation.SIMULATION_WIDTH, 
					Simulation.SIMULATION_HEIGHT, 
					Simulation1.SIMULATION1_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET);
	}
	public static HalloweenCommandProcessor createSimulation2(String aPrefix) {
		return 	BeauAndersonFinalProject.createSimulation(
					aPrefix, 
					Simulation2.SIMULATION2_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET, 
					Simulation.SIMULATION_WIDTH, 
					Simulation.SIMULATION_HEIGHT, 
					Simulation2.SIMULATION2_X_OFFSET, 
					Simulation.SIMULATION_Y_OFFSET);
	}
	public static void main (String[] args) {
		//Ideally the prefixes should be main args
		HalloweenCommandProcessor commandProcessor1 = createSimulation1(Simulation1.SIMULATION1_PREFIX);				 
		HalloweenCommandProcessor commandProcessor2 = createSimulation2(Simulation2.SIMULATION2_PREFIX);
		new ASimulationCoupler(commandProcessor1, commandProcessor2);
		new ASimulationCoupler(commandProcessor2, commandProcessor1);
	}

}
