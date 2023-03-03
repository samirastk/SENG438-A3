package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private static Range exampleRange, largeRange;

    @BeforeClass
    public static void setUpBeforeClass() {
        exampleRange = new Range(-1, 1);
        largeRange = new Range(-99995.875, 139995.875);

    }

    @Test
    public void getCentralValueTestZero() {
        assertEquals(0, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void getCentralValueTestLargeRange() {
        assertEquals(20000, largeRange.getCentralValue(), .000000001d);
    }

    //length
    @Test
    public void getLengthTestTwo() {
        assertEquals(2, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void getLengthTestLargeRange() {
        assertEquals(239991.75, largeRange.getLength(), .000000001d);
    }

    //lowerBound
    @Test
    public void getLowerBoundTestNegOne() {
        assertEquals(-1, exampleRange.getLowerBound(), .000000001d);
    }

    @Test
    public void getLowerBoundTestLargeRange() {
        assertEquals(-99995.875, largeRange.getLowerBound(), .000000001d);
    }

    //upperBound
    @Test
    public void getUpperBoundTestOne() {
        assertEquals(1, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getUpperBoundTestLargeRange() {
        assertEquals(139995.875, largeRange.getUpperBound(), .000000001d);
    }

    //contains
    @Test
    public void containsTestOneInRange() {
        boolean actual = exampleRange.contains(1);
        assertEquals(true, actual);
    }

    @Test
    public void containsTestNegOneInRange() {
        boolean actual = exampleRange.contains(-1);
        assertEquals(true, actual);
    }

    @Test
    public void containsTestZeroInRange() {
        boolean actual = largeRange.contains(0);
        assertEquals(true, actual);
    }

    @Test
    public void containsTestTwoOutOfRange() {
        boolean actual = exampleRange.contains(2);
        assertEquals(false, actual);
    }

    @Test
    public void containsTestLargeNegOutOfRange() {
        boolean actual = largeRange.contains(-99999);
        assertEquals(false, actual);
    }

    @Test
    public void containsTestLargePosOutOfRange() {
        boolean actual = largeRange.contains(140000);
        assertEquals(false, actual);
    }

    //intersect
    @Test
    public void intersectsTestInRange() {
        boolean actual = exampleRange.intersects(-1, 2);
        assertEquals(true, actual);
    }

    @Test
    public void intersectsTestOutOfRangeAbove() {
        boolean actual = largeRange.intersects(139995.876, 149995.875);
        assertEquals(false, actual);
    }

    @Test
    public void intersectsTestOutOfRangeBelow() {
        boolean actual = largeRange.intersects(-1099995, -99995.876);
        assertEquals(false, actual);
    }
}