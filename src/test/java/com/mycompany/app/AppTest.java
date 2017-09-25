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
        ArrayList<String> array = new ArrayList<>(Arrays.asList("ycb", "ycb", "a", "asdf"));
        assertTrue(new App().search(array, "ycb",2));
      }

      public static void testNotFound() {
        ArrayList<String> array = new ArrayList<>(Arrays.asList("ycb", "ycb", "a", "asdf"));
        assertFalse(new App().search(array, "ycb",1));
      }

      public static void testEmptyArray() {
        ArrayList<String> array = new ArrayList<>();
        assertFalse(new App().search(array, "ycb",1));
      }

      public static void testNull() {
        assertFalse(new App().search(null, "ycb",1));
      }

      public static void testFoundSame() {
        ArrayList<String> array = new ArrayList<>(Arrays.asList("ycb", "ycb", "ycb", "ycb"));
        assertTrue(new App().search(array, "ycb",4));
      }

}


