package eastone.common.test;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ObjectTest extends TestCase {
  /**
   * Create the test case.
   * @param testName name of the test case
   */
  public ObjectTest(final String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(ObjectTest.class);
  }

  /**
   * 测试日志功能是否正常.
   * @throws IOException 异常
   */
  public void testLogger() throws IOException {
    /*
     * PipedOutputStream pipedout = null; PipedInputStream pipedin = null;
     * InputStreamReader ir = null; BufferedReader br = null; PrintStream out =
     * null; PrintStream ori_out = null; String print_str = null; final String
     * msg = "Hello World"; try { pipedout = new PipedOutputStream(); pipedin =
     * new PipedInputStream(pipedout); ir = new InputStreamReader(pipedin); br =
     * new BufferedReader(ir); out = new PrintStream(pipedout, true); ori_out =
     * System.out;// save the output stream //change the console's output stream
     * f //or reading the log text to validate the function. System.setOut(out);
     * new eastone.common.Object() { { logger.info(msg); } }; //read from piped
     * input stream //which receive the log text from console. print_str =
     * br.readLine();// //validate the log text
     * assertEquals(print_str.indexOf(msg) >= 0, true); } finally { br.close();
     * ir.close(); pipedin.close(); pipedout.close(); System.setOut(ori_out);//
     * restore the output stream as console }
     */
  }
}
