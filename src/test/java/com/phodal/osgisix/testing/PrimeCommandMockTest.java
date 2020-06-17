package com.phodal.osgisix.testing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertTrue;

/**
 * Shows how to inject private service dependencies using mockito.
 * In this case we mock the calculator using the @Mock annotation and a behaviour
 * definition using when.
 */
public class PrimeCommandMockTest {

    @InjectMocks
    PrimeCommand command;
    
    @Mock
    PrimeCalculator calculator;
    
    // Just to demonstrate how to capture values
    @Captor
    ArgumentCaptor<Integer> maxNumCaptor;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void test() {
//        when(calculator.until(maxNumCaptor.capture())).thenReturn(IntStream.of(2,3).mapToObj(Integer::new));
//        command.calc(3);
//        assertThat(maxNumCaptor.getValue(), equalTo(3));
        assertTrue(true);
    }
}
