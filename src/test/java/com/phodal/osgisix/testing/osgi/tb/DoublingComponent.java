package com.phodal.osgisix.testing.osgi.tb;

import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;

import com.phodal.osgisix.testing.IntStreamProcessing;

/**
 * DS Component that doubles a stream of Integers to demonstrate how to create dummy / test
 * compomnents on the fly
 */
@Component
public class DoublingComponent implements IntStreamProcessing {

    @Override
    public Stream<Integer> process(Stream<Integer> stream) {
        return stream.map(num -> num * 2);
    }
}
