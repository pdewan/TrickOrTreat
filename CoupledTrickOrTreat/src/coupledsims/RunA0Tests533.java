package coupledsims;

import gradingTools.comp533s22.assignment0.S22Assignment0Suite;
import gradingTools.comp533s22.assignment2.S22Assignment2Suite;
import gradingTools.comp533s22.assignment3.S22Assignment3Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunA0Tests533 {

	public static void main(String[] args) {
		Tracer.showInfo(true);
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
//		S21Assignment0Suite.setProcessTimeOut(45);
		S22Assignment3Suite.main(args);
	}

}
