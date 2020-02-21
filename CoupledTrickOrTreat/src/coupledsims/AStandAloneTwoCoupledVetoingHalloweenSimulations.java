package coupledsims;

import assignments.util.inputParameters.AnAbstractSimulationParametersBean;
import assignments.util.mainArgs.ClientArgsProcessor;
import main.BeauAndersonFinalProject;
import stringProcessors.HalloweenCommandProcessor;
import util.interactiveMethodInvocation.SimulationParametersControllerFactory;
import util.trace.Tracer;
import util.trace.bean.BeanTraceUtility;
import util.trace.factories.FactoryTraceUtility;
import util.trace.port.nio.NIOTraceUtility;

public class AStandAloneTwoCoupledVetoingHalloweenSimulations extends AStandAloneTwoCoupledHalloweenSimulations {
	@Override
	protected void init (String[] args) {
		super.init(args);
		new AVetoingSimulationCoupler(commandProcessor1, commandProcessor2);
		new AVetoingSimulationCoupler(commandProcessor2, commandProcessor1);
	}
	
}
