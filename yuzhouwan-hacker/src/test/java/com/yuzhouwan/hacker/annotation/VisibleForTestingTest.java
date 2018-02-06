package com.yuzhouwan.hacker.annotation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Copyright @ 2018 yuzhouwan.com
 * All right reserved.
 * Function：VisibleForTesting Test
 *
 * @author Benedict Jin
 * @since 2018/2/6
 */
public class VisibleForTestingTest {

    @Test
    public void testVisibleForTesting() {
        assertEquals(true, new VisibleForTestingExample().visibleForTesting());
    }
}
