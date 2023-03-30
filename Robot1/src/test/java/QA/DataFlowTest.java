package QA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import input.InputReader;
import main.Main;

@RunWith(DataProviderRunner.class) 
public class DataFlowTest {


    @DataProvider
    public static Object[][] sumTestData() {
        return new Object[][]{
                {"I 3", true},
                {"I_4", false},
                {"I 3 I 3", false},
                {"Q 4", true},
                {"Z 2", false},
                {"I", false},
                {"I 101", false},
                {"I I",false},
                {"m", false},
                {"m 0", false},
                {"m m", false}
        };
    }

    @Test
    @UseDataProvider("sumTestData")
    public void dataFlowTest(String input, boolean expected){
        boolean actual = InputReader.validateCommand(input);
        assertEquals(expected, actual);
    }


}
