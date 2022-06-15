/*
 * Copyright 2021 Crown Copyright
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
package uk.gov.gchq.gaffer.doc.function;

import uk.gov.gchq.gaffer.operation.function.ToTrailingWildcardPair;

public class ToTrailingWildcardPairExample extends FunctionExample {

    public static void main(final String[] args) {
        new ToTrailingWildcardPairExample().runAndPrint();
    }

    public ToTrailingWildcardPairExample() {
        super(ToTrailingWildcardPair.class);
        skipPython();
    }

    @Override
    protected void runExamples() {
        withDefaultEndOfRange();
    }

    private void withDefaultEndOfRange() {
        // ---------------------------------------------------------
        final ToTrailingWildcardPair function = new ToTrailingWildcardPair();
        // ---------------------------------------------------------

        runExample(function, null,  "value1", "value2", null);
    }
}

