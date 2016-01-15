/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hartchallenge3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//import org.apache.common.io;

import hart.ModuleA;
import hart.ModuleB;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *
 * @author Osburn
 */
public class HartChallenge3 {

    //GLOBAL CONSTANTS
    private static final long DEFAULT_DELAY_MS = 60000; //60,000ms = 60s = 1 minute
    private static final int MAX_LOOPS = 10; //10 minutes
    
    private static final String RT_API_SPOOF_IP = "10.6.184.14";
    
    private static final String FILE_RESULTS_DIRECTORY = "C:\\HART\\ModuleA_Results\\";
    private static final String EXPECTED_RESULTS_DIRECTORY_GOOD_TEST_ONE = "C:\\HART\\ExpectedResults\\GOOD_TEST_ONE\\";
    private static final String EXPECTED_RESULTS_DIRECTORY_BAD_TEST_ONE = "C:\\HART\\ExpectedResults\\BAD_TEST_ONE\\";

    //GLOBAL VARIABLES
    private static int count;
    private static boolean pass;
    private static String name;
    private static File file;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        log(FILE_RESULTS_DIRECTORY);
        
        for (SpoofMode mode : SpoofMode.values())
        {
            runBasicTestSequence(mode);
        }
    }
    
    private static void runBasicTestSequence(SpoofMode mode)
    {
        log("Beginning Basic Test Sequence, mode: " + mode.toString());
        count = 0;
        pass = true;
        
        // *** SERVER_SPOOF_TO_DO ***
        //Here we would have to talk to / initialize our HTTP Spoof to respond to the various API queries with the expected
        //inputs and ouputs for this GOOD TEST 1
        initializeRottenSpoof(mode);

        //Initialize Module A using our spoof IP
        ModuleA ma = new ModuleA(RT_API_SPOOF_IP);
        ModuleB mb = new ModuleB(RT_API_SPOOF_IP);
        
        //A does the first action and B is just waiting on A, so B should be initialized first
        mb.start(); 
        ma.start();
        
        //Assuming here that we have a ModuleA.finished() that returns a boolean that is only set to true after the final files have all been created and moduleA is done running.
        while (!ma.finished() && count < MAX_LOOPS)
        {
            count++;
            try
            {
                Thread.sleep(DEFAULT_DELAY_MS);
            }
            catch (InterruptedException e)
            {
                log(" FAILURE! : Unexpected InterruptedException when trying to sleep for " + DEFAULT_DELAY_MS + "ms!: " + e.getMessage());
                pass = false;
            }
        }
        
        if (count == MAX_LOOPS && !ma.finished())
        {
            log(" FAILURE! : We waited the maximum amount of time allowed and Module A still reports as unfinished!");
            pass = false;
        }
        else
        {
            assert ma.finished();
            
            //For each file in results folder, verify that the file is exactly the same as the corresponding file in the expected results folder
            File expectedDir = new File(EXPECTED_RESULTS_DIRECTORY_GOOD_TEST_ONE);
            File[] expectedFiles = expectedDir.listFiles();
            
            for (File expectedFile : expectedFiles) {
                name = expectedFile.getName(); //example: ToyStory.txt
                log("Validating Expected File: " + expectedFile.getPath());
                
                log(  "...Checking for file in actual results directory...");
                
                String path = FILE_RESULTS_DIRECTORY + name;
                file = new File(path);
                if (file.exists() && !file.isDirectory()) {
                    try {
                        validateSame(expectedFile, file);
                        log(" PASS: Actual file is same as expected.");
                    }catch (IOException e)
                    {
                        log(" FAILURE: Unexpected IOException caugh when trying to validate file contents!:" + e.getMessage());
                        pass = false;
                    }
                } 
                else {
                    log(" FAILURE: Actual file missing!:" + name);
                    pass = false;
                }
            }
            
        }
        
        if (pass)
        {
            log(" PASS! : There were no failures in GOOD_TEST_ONE!");
        }
        else
        {
            log(" FAIL! : There were at least one failure in GOOD_TEST_ONE!");
        }
        
    }
    
    private static boolean validateSame(File expected, File actual) throws IOException
    {
        //Note: Future improvement could be to use .readAllLines() as it is probably 
        //      more appropriate for our files here. This would also allow us look through them
        //      line by line and, when not equal, allow for better debug output in the logging.

        //Note: Might need getAbsolutePath() instead here
        Path p1 = Paths.get(expected.getPath()); 
        Path p2 = Paths.get(actual.getPath());

        return Arrays.equals(Files.readAllBytes(p1), Files.readAllBytes(p2));
    }
    
    private static String getExpectedDirPathForMode(SpoofMode mode)
    {
        switch (mode)
        {
            case GOOD_TEST_ONE:
                return EXPECTED_RESULTS_DIRECTORY_GOOD_TEST_ONE;
            case BAD_TEST_ONE:
                return EXPECTED_RESULTS_DIRECTORY_BAD_TEST_ONE;
            default:
                log(" TEST FAILURE: Unexpected SpoofMode encountered!: " + mode.toString());
                return "";
        }
    }
    
    private static void initializeRottenSpoof(SpoofMode mode)
    {
        //TO DO
    }
    
    private enum SpoofMode
    {
       /**
        * GOOD TEST ONE
        * 
        * SPOOF IP setup to return list of three movies: Toy Story, Toy Story 2, Toy Story 3
        * SPOOF IP setup to return full cast list for those three movies, as taken from RT
        * 
        * Make sure all three final expected files are correct.
        */
        GOOD_TEST_ONE,
        
        /**
        * BAD TEST ONE
        * 
        * SPOOF IP setup to return list of four movies: Toy Story, Toy Story 2, Toy Story 3, The Matrix,
        * SPOOF IP setup to return full cast list for those three movies, as taken from RT, but invalid full cast for The Matrix 
        * 
        * Make sure all three final expected Toy Story files are correct.
        * Make sure the final Matrix file exists and properly says "BAD_RT_RESPONSE" in the full cast section as described in the test plan document.
        * 
        */
        BAD_TEST_ONE
    }
    
    private static void log(String s)
    {
        System.out.println(s + "\n");
    }
    
}

