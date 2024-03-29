/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__int_array_72b.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-72b.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 72 Data flow: data passed in a Vector from one method to another in different source files in the same package
 *
 * */




import java.util.Vector;

public class CWE476_NULL_Pointer_Dereference__int_array_72b
{
    public void badSink(Vector<int []> dataVector ) throws Throwable
    {
        int [] data = dataVector.remove(2);

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(Vector<int []> dataVector ) throws Throwable
    {
        int [] data = dataVector.remove(2);

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(Vector<int []> dataVector ) throws Throwable
    {
        int [] data = dataVector.remove(2);

        /* FIX: validate that data is non-null */
        if (data != null)
        {
            IO.writeLine("" + data.length);
        }
        else
        {
            IO.writeLine("data is null");
        }

    }
}
