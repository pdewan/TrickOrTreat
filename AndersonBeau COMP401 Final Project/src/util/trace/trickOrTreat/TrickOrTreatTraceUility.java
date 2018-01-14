package util.trace.trickOrTreat;

import util.trace.ImplicitKeywordKind;
import util.trace.TraceableInfo;
import util.trace.Tracer;
import util.trace.bean.NotifiedPropertyChangeEvent;
;

public class TrickOrTreatTraceUility {
	public static void setTracing() {
		Tracer.showInfo(true);
		Tracer.setDisplayThreadName(true); 
		TraceableInfo.setPrintTraceable(true);
		TraceableInfo.setPrintSource(true);
		Tracer.setImplicitPrintKeywordKind(ImplicitKeywordKind.OBJECT_CLASS_NAME);		
		Tracer.setKeywordPrintStatus(CommandSubmitted.class, true);
		
		
	}

}
