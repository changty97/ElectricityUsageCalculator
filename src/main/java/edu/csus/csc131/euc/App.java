package edu.csus.csc131.euc;
import java.util.Arrays;
import javax.swing.JFrame;

/**
 * Hello world!
 *
 */

public class App
{
    // constants
    private static final int RATES_ARRAY_SIZE = 24;
    private static final float RATES_DEFAULT_OFFPEAK_SUMMER = (float)0.1209;
    private static final float RATES_DEFAULT_OFFPEAK_NONSUMMER = (float)0.1006;
    private static final float RATES_DEFAULT_MIDPEAK_SUMMER = (float)0.1671;
    private static final float RATES_DEFAULT_PEAK_SUMMER = (float)0.2941;
    private static final float RATES_DEFAULT_PEAK_NONSUMMER = (float)0.1388;

    // helper method for setting default rates
    private static float[] setDefaultRates(boolean isSummer){
        float temp[] = new float[RATES_ARRAY_SIZE];
        if(isSummer){
            Arrays.fill(temp, 0, 11, RATES_DEFAULT_OFFPEAK_SUMMER);
            Arrays.fill(temp, 12, 16, RATES_DEFAULT_MIDPEAK_SUMMER);
            Arrays.fill(temp, 17, 19, RATES_DEFAULT_PEAK_SUMMER);
            Arrays.fill(temp, 20, 23, RATES_DEFAULT_MIDPEAK_SUMMER);
        }else{
            Arrays.fill(temp, 0, 15, RATES_DEFAULT_OFFPEAK_NONSUMMER);
            Arrays.fill(temp, 16, 19, RATES_DEFAULT_PEAK_NONSUMMER);
            Arrays.fill(temp, 20, 23, RATES_DEFAULT_OFFPEAK_NONSUMMER);
        }
        return temp;
    }

    public static void main( String[] args )
    {
        // input default rates
        float rates[] = setDefaultRates(true); //just for test. Boolean determines if summer or non summer
        System.out.println(rates);
        // make instance of the window
        //UIwindow window1 = new UIwindow("Main Window", 800, 800);
        // window1.initializeGUI();
        MainWindow mainWindow = new MainWindow();
        mainWindow.toString();
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(450, 300);
        frame.add(mainWindow);
    }
}
