import com.battleship.*;

import java.io.*;

import org.junit.*;

import static org.junit.Assert.fail;

public class ScreenWriterTest {
    
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ScreenWriter screenWriter;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        screenWriter = new ScreenWriter();
    }

    @Test
    public void testMainMenuFormating() {
        screenWriter.printStartMenu();

        String expectedStartMenu =   "######     #    ####### ####### #       #######  #####  #     # ### ######  \r\n" +
                                    "#     #   # #      #       #    #       #       #     # #     #  #  #     # \r\n" +
                                    "#     #  #   #     #       #    #       #       #       #     #  #  #     # \r\n" +
                                    "######  #     #    #       #    #       #####    #####  #######  #  ######  \r\n" +
                                    "#     # #######    #       #    #       #             # #     #  #  #       \r\n" +
                                    "#     # #     #    #       #    #       #       #     # #     #  #  #       \r\n" +
                                    "######  #     #    #       #    ####### #######  #####  #     # ### #       \r\n" + 
                                    "\r\n" + 
                                    "Select number of players (1, 2)";

        Assert.assertEquals(expectedStartMenu, outputStreamCaptor.toString().trim());
    }
}