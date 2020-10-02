/*
 * Copyright 2020 Crown Copyright
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

import uk.gov.gchq.koryphe.impl.function.StringSplit;

public class StringSplitExample extends FunctionExample {

    public StringSplitExample() {
        super(StringSplit.class);
    }

    public static void main(final String[] args) {
        new StringSplitExample().runAndPrint();
    }

    @Override
    protected void runExamples() {
        splitStringsWithRegex();
    }

    private void splitStringsWithRegex() {
        // ---------------------------------------------------------
        final StringSplit function = new StringSplit(" ");
        // ---------------------------------------------------------

        runExample(function, null,
                "no-delimiters-in-this-string",
                "string  with  two  spaces",
                "string with one space",
                "tab\tdelimited\tstring",
                "",
                null);
    }
}
