/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.tools.ant.taskdefs.optional;

import org.apache.tools.ant.BuildFileTest;

/**
 * Tests the {@link XSLTProcess} task.
 * TODO merge with {@link StyleTest}?
 * @since Ant 1.5
 */
public class XsltTest extends BuildFileTest {

    /**
     * where tasks run
     */
    private final static String TASKDEFS_DIR = "src/etc/testcases/taskdefs/optional/";


    /**
     * Constructor
     *
     * @param name testname
     */
    public XsltTest(String name) {
        super(name);
    }


    /**
     * The JUnit setup method
     */
    public void setUp() {
        configureProject(TASKDEFS_DIR + "xslt.xml");
    }



    /**
     * A unit test for JUnit
     */
    public void testCatchNoDtd() throws Exception {
        expectBuildExceptionContaining("testCatchNoDtd",
                                       "expected failure",
                                       /* actually: "chemical" */null);
    }

    /**
     * A unit test for JUnit
     */
    public void testCatalog() throws Exception {
         executeTarget("testCatalog");
    }

    public void testOutputProperty() throws Exception {
      executeTarget("testOutputProperty");
    }

    public void testXMLWithEntitiesInNonAsciiPath() throws Exception {
        executeTarget("testXMLWithEntitiesInNonAsciiPath");
    }

    /**
     * check that the system id gets set properly on stylesheets.
     * @throws Exception if something goes wrong.
     */
    public void testStyleSheetWithInclude() throws Exception {
        executeTarget("testStyleSheetWithInclude");
        if (getLog().indexOf("java.io.FileNotFoundException") != -1) {
            fail("xsl:include was not found");
        }
    }
}

