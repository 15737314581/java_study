package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void init(){
        System.out.println("init....");
    }

    @After
    public void close(){
        System.out.println("close...");
    }


    @Test
    public void testAdd(){
        System.out.println("testadd...");
        Calculator cal = new Calculator();
        int result = cal.add(1, 2);
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        System.out.println("testsub...");
        Calculator cal = new Calculator();
        int result = cal.sub(1, 2);
        Assert.assertEquals(-1,result);
    }
}
