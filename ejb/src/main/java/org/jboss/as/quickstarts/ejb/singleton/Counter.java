/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.ejb.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * This singleton stores stores two counters which are only reset when the application is restarted.
 *
 * @author Serge Pagop (spagop@redhat.com)
 *
 */
@Singleton
@Named
@Startup
public class Counter {
    private static Logger LOGGER = Logger.getLogger(Counter.class.getName());
    private int a = 1;
    private int b = 1;

    @PostConstruct
    public void init(){
        LOGGER.info("started...");
    }

    public void incrementA() {
        a++;
    }

    public void incrementB() {
        b++;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
