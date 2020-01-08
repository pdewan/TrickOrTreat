package coupledsims;

import gradingTools.comp533s19.assignment1.Assignment1Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunA1Tests {

	public static void main(String[] args) {
		Tracer.showInfo(true);
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
		Assignment1Suite.setProcessTimeOut(45);
	Assignment1Suite.main(args);
	}

}
