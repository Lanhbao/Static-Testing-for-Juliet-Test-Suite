/*
@description This abstract class is meant to be used by testcases that have a flaw
outside of good or bad function.  These flaws are part of the class.  For an 
example, see CWE 580.

*/

public abstract class AbstractTestCaseClassIssueBad extends AbstractTestCaseBase implements Cloneable 
{    
    public abstract void bad() throws Throwable;
    
    public void runTest(String className) 
    {
        IO.writeLine("Starting tests for Class " + className);

        try 
        {
            bad();
            
            IO.writeLine("Completed bad() for Class " + className);
        } 
        catch (Throwable throwableException) 
        {
            IO.writeLine("Caught a throwable from bad() for Class "  + className);

            IO.writeLine("Throwable's message = " + throwableException.getMessage());
            
            StackTraceElement stackTraceElements[] = throwableException.getStackTrace();

            IO.writeLine("Stack trace below");

            for (StackTraceElement stackTraceElement : stackTraceElements) 
            {
                IO.writeLine(stackTraceElement.toString());
            } 
        } 
    } /* runTest */
} /* class */
