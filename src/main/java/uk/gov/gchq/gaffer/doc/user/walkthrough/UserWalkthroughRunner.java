/*
 * Copyright 2016-2018 Crown Copyright
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
package uk.gov.gchq.gaffer.doc.user.walkthrough;

import uk.gov.gchq.gaffer.doc.walkthrough.AbstractWalkthrough;
import uk.gov.gchq.gaffer.doc.walkthrough.AbstractWalkthroughRunner;

import java.util.Arrays;
import java.util.List;

public class UserWalkthroughRunner extends AbstractWalkthroughRunner {
    private static final List<AbstractWalkthrough> EXAMPLES = Arrays.asList(
            new TheBasics(),
            new MultipleEdges(),
            new Filtering(),
            new Transforms(),
            new OperationChains(),
            new Aggregation(),
            new Cardinalities(),
            new Views(),
            new Subgraphs(),
            new Traversing(),
            new FullExample()
    );

    public UserWalkthroughRunner() {
        super("User Guide", EXAMPLES, null, "user");
    }

    public static void main(final String[] args) throws Exception {
        new UserWalkthroughRunner().generate();
    }
}
