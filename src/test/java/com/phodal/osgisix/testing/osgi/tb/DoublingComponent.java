package com.phodal.osgisix.testing.osgi.tb;

import com.phodal.osgisix.testing.IntStreamProcessing;
import org.osgi.service.component.annotations.Component;

/**
 * DS Component that doubles a stream of Integers to demonstrate how to create dummy / test
 * compomnents on the fly
 */
@Component
public class DoublingComponent implements IntStreamProcessing {

    @Override
    public Integer process(Integer stream) {
        return stream;
    }
}
