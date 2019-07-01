package by.pvt.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alve
 */
public class MinMaxServiceImplTest {

    MinMaxServiceImpl objUnderTest;


    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("setUp()");
        objUnderTest = new MinMaxServiceImpl();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        objUnderTest = null;
    }

    @org.junit.Test
    public void findMin() {
        // given
        List<Integer> test1 = List.of(3, 1, 2);

        // when
        Integer result = objUnderTest.findMin(test1);

        // then
        assertEquals(Integer.valueOf(1), result);
    }

    @org.junit.Test(expected = Exception.class)
    public void findMinWithException() {
        // given
        List<Integer> test1 = List.of();

        // when
        objUnderTest.findMin(test1);
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void findMinWithNotEmptyList() {
        // given
        List<Integer> test1 = new ArrayList<>();
        test1.add(null);
        test1.add(null);

        // when
        objUnderTest.findMin(test1);
    }


    @org.junit.Test
    public void findMax() {
        // given

        // when
        //objUnderTest.

        // then
        //assertEquals(true, false);
    }


}