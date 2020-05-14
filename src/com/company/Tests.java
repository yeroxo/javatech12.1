package com.company;


import org.junit.Assert;
import org.junit.Test;



public class Tests {

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testStringWord(){
        Integer.decode("*8");
    }

    @Test(expected = NullPointerException.class)
    public void testNull(){
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testStartWithPlusAndSpace(){
        Integer.decode("+ 13");
    }

    @Test(expected = NumberFormatException.class)
    public void testStartWithMinusAndSpace(){
        Integer.decode("- 13");
    }

    @Test(expected = NumberFormatException.class)
    public void testDouble(){
        Integer.decode("12.3");
    }

    @Test(expected = NumberFormatException.class)
    public void testLong(){
        Integer.decode("12l");
    }

    @Test
    public void testZero(){
        Assert.assertEquals(0,Integer.decode("0").longValue());
    }

    @Test
    public void testStartWithPlus(){
        Assert.assertEquals(2, Integer.decode("+2").longValue());
    }

    @Test
    public void testDefaultInt(){
        Assert.assertEquals(1, Integer.decode("1").longValue());
    }

    @Test
    public void testHexStartWithSharp(){
        Assert.assertEquals(255, Integer.decode("#FF").longValue());
    }

    @Test
    public void testHexStartWithZeroX(){
        Assert.assertEquals(748, Integer.decode("0x2EC").longValue());
    }

    @Test
    public void testHexStartWithZero(){
        Assert.assertEquals(15, Integer.decode("0Xf").longValue());
    }

    @Test
    public void testOctalFormat(){
        Assert.assertEquals(30, Integer.decode("036").longValue());
    }
}