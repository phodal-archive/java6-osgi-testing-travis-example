/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.phodal.osgisix.testing.osgi.before;

import static java.util.Arrays.asList;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.ops4j.pax.exam.junit.PaxExam;

/**
 * Shows how to extend the PaxExam runner to implement hooks that are executed outside of OSGi in the parent
 * junit process 
 */
public class ExtPaxExam extends PaxExam {

    private Optional<Method> before;
    private Optional<Method> after;

    public ExtPaxExam(Class<?> klass) throws InitializationError {
        super(klass);
        this.before = getStaticMethodWith(klass, BeforeOsgi.class);
        this.after = getStaticMethodWith(klass, AfterOsgi.class);
    }

    @Override
    public void run(RunNotifier notifier) {
        Consumer<Method> consumer = new Consumer<Method>() {
            @Override
            public void accept(Method method) {
                try {
                    method.invoke(null);
                } catch (Exception e) {
                    throw new RuntimeException("Error calling method " + method, e);
                }
            }
        };
        this.before.ifPresent(consumer);
        super.run(notifier);
        this.after.ifPresent(consumer);
    }
    
    private Optional<Method> getStaticMethodWith(Class<?> klass, Class<? extends Annotation> annotation) {
        final Class<? extends Annotation> annotation1 = annotation;
        Predicate<Method> methodPredicate = new Predicate<Method>() {
            @Override
            public boolean test(Method method) {
                return method.getAnnotation(annotation1) != null;
            }
        };
        Optional<Method> foundMethod = Arrays.stream(klass.getMethods())
            .filter(methodPredicate)
            .findFirst();
        if (foundMethod.isPresent()) {
            Method m = foundMethod.get();
            if (!Modifier.isStatic(m.getModifiers())) {
                throw new IllegalStateException("Method " + m.getName() + " must be static to be used as " + annotation.getName());
            }
        }
        return foundMethod;
    }

    private void invoke(Method method) {
        try {
            method.invoke(null);
        } catch (Exception e) {
            throw new RuntimeException("Error calling method " + method, e);
        }
    }
}
