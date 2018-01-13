package stringProcessors;

public interface IteratorEnabledScanner
{
	public boolean hasNext();
	public TokenInterface next() throws AScannerException;
}
