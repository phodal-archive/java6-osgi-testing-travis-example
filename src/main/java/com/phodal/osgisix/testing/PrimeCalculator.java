package com.phodal.osgisix.testing;

import org.osgi.service.component.annotations.Component;

/**
 * Calculate prime numbers
 */
@Component(
        service = PrimeCalculator.class
        )
public class PrimeCalculator {
    
    public Integer until(int max) {
//        return rangeClosed(2, max)
//                .filter(this::isPrime)
//                .mapToObj(Integer::new);
         return 1;
    }
    
    public boolean isPrime(Integer number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
