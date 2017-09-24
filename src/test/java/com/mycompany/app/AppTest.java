package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.*;

public class AppTest extends TestCase
{
 
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public static void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new App().search(array, 4));
      }

      public static void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 5));
      }

      public static void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        assertFalse(new App().search(array, 1));
      }

      public static void testNull() {
        assertFalse(new App().search(null, 1));
      }

}


