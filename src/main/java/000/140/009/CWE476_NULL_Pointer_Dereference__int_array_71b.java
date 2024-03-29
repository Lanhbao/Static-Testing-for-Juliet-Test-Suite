/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__int_array_71b.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-71b.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */





public class CWE476_NULL_Pointer_Dereference__int_array_71b
{
    public void badSink(Object dataObject ) throws Throwable
    {
        int [] data = (int [])dataObject;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(Object dataObject ) throws Throwable
    {
        int [] data = (int [])dataObject;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(Object dataObject ) throws Throwable
    {
        int [] data = (int [])dataObject;

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
