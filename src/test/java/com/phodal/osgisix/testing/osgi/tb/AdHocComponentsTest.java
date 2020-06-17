package com.phodal.osgisix.testing.osgi.tb;

import com.phodal.osgisix.testing.IntStreamProcessing;
import com.phodal.osgisix.testing.PrimeCalculator;
import com.phodal.osgisix.testing.osgi.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.tinybundles.core.TinyBundles;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

/**
 * Sometimes you want to create some DS components just for the test.
 * This is easy as TinyBundles now allows to create bundles with DS components on the fly.
 */
@RunWith(PaxExam.class)
public class AdHocComponentsTest extends BaseTest {
    @Inject
    PrimeCalculator calculator;
    
    @Inject
    IntStreamProcessing doubler;

    @Configuration
    public Option[] configuration() {
        return new Option[] { 
                baseConfiguration(),
                
                // Create bundle with DS component on the fly
                BndDSOptions.dsBundle("doubling", 
                        TinyBundles.bundle().add(DoublingComponent.class)
                        )
                };
    }

    @Test
    public void test() {
        assertTrue(true);
    }
}
