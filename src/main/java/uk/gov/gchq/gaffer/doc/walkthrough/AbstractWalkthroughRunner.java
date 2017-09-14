/*
 * Copyright 2016 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.gov.gchq.gaffer.doc.walkthrough;

import org.apache.commons.io.IOUtils;

import uk.gov.gchq.gaffer.cache.CacheServiceLoader;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.commonutil.CommonConstants;
import uk.gov.gchq.gaffer.commonutil.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

public class AbstractWalkthroughRunner {
    public static final String EXAMPLE_DIVIDER = "\n\n";

    private final String title;
    private final List<AbstractWalkthrough> examples;
    protected final String modulePath;
    protected final String resourcePrefix;

    public AbstractWalkthroughRunner(final String title, final List<AbstractWalkthrough> examples, final String modulePath, final String resourcePrefix) {
        this.title = title;
        this.examples = examples;
        this.modulePath = modulePath;
        this.resourcePrefix = resourcePrefix;
    }

    public void run() throws Exception {
        System.out.println("# " + title);
        printTableOfContents();
        printIntro();
        printWalkthroughTitle();
        for (final AbstractWalkthrough example : examples) {
            // Clear the caches so the output is not dependent on what's been run before
            try {
                if (CacheServiceLoader.getService() != null) {
                    CacheServiceLoader.getService().clearCache("NamedOperation");
                    CacheServiceLoader.getService().clearCache("JobTracker");
                }
            } catch (final CacheOperationException e) {
                throw new RuntimeException(e);
            }

            System.out.println(example.walkthrough());
            System.out.println(EXAMPLE_DIVIDER);
        }
    }

    protected void printIntro() {
        printFile("Intro.md");
    }

    protected void printRunningTheExamples() {
        printFile("RunningTheExamples.md");
    }

    protected void printFile(final String filename) {
        final String intro;
        try (final InputStream stream = StreamUtil.openStream(getClass(), resourcePrefix + "/walkthrough/" + filename)) {
            intro = new String(IOUtils.toByteArray(stream), CommonConstants.UTF_8);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(WalkthroughStrSubstitutor.substitute(intro, modulePath));
    }

    private void printTableOfContents() throws InstantiationException, IllegalAccessException {
        int index = 1;
        System.out.println(index + ". [Introduction](#introduction)");
        index++;
        System.out.println(index + ". [Walkthroughs](#walkthroughs)");

        index = 1;
        for (final AbstractWalkthrough example : examples) {
            final String header = example.getHeader();
            System.out.println("   " + index + ". [" + header + "](#" + header.toLowerCase(Locale.getDefault()).replace(" ", "-") + ")");
            index++;
        }
        System.out.println("\n");
    }

    protected void printWalkthroughTitle() {
        System.out.println("## Walkthroughs");
    }
}
