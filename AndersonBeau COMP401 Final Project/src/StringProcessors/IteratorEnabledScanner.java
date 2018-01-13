package StringProcessors;

public interface IteratorEnabledScanner
{
	public boolean hasNext();
	public TokenInterface next() throws AScannerException;
}
