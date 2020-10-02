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

import uk.gov.gchq.koryphe.impl.function.StringRegexReplace;

public class StringRegexReplaceExample extends FunctionExample {

    public StringRegexReplaceExample() {
        super(StringRegexReplace.class);
    }

    public static void main(final String[] args) {
        new StringRegexReplaceExample().runAndPrint();
    }

    @Override
    protected void runExamples() {
        replaceStrings();
    }

    private void replaceStrings() {
        // ---------------------------------------------------------
        final StringRegexReplace function = new StringRegexReplace("[tT]ea", "cake");
        // ---------------------------------------------------------

        runExample(function, null, "tea", "Tea", "TEA", "brainteaser", null, "coffee", 5L);
    }
}
