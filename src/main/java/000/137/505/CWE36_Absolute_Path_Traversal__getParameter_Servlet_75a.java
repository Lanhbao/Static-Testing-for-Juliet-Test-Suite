/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__getParameter_Servlet_75a.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-75a.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: getParameter_Servlet Read data from a querystring using getParameter()
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */




import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import java.io.*;
import javax.servlet.http.*;


public class CWE36_Absolute_Path_Traversal__getParameter_Servlet_75a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Read data from a querystring using getParameter */
        data = request.getParameter("name");

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            (new CWE36_Absolute_Path_Traversal__getParameter_Servlet_75b()).badSink(dataSerialized , request, response );
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
            }
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            (new CWE36_Absolute_Path_Traversal__getParameter_Servlet_75b()).goodG2BSink(dataSerialized , request, response );
        }
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
            }
        }
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}