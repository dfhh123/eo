/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2025 Objectionary.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/*
 * @checkstyle PackageNameCheck (10 lines)
 * @checkstyle TrailingCommentCheck (3 lines)
 */
package EOorg.EOeolang; // NOPMD

import org.eolang.AtCompositeTest;
import org.eolang.Data;
import org.eolang.Phi;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Test case for {@link EOnumber}.
 *
 * @since 0.39
 * @checkstyle TypeNameCheck (4 lines)
 */
@SuppressWarnings("JTCOP.RuleAllTestsHaveProductionClass")
final class EOnumberTest {

    @Test
    void hasDifferentHashes() {
        final Phi left = new Data.ToPhi(42L);
        final Phi right = new Data.ToPhi(42L);
        MatcherAssert.assertThat(
            AtCompositeTest.TO_ADD_MESSAGE,
            left.hashCode(),
            Matchers.not(Matchers.equalTo(right.hashCode()))
        );
    }

    @Test
    void hasHashEvenWithoutData() {
        final Phi phi = new EOnumber();
        MatcherAssert.assertThat(
            AtCompositeTest.TO_ADD_MESSAGE,
            phi.hashCode(),
            Matchers.greaterThan(0)
        );
    }

    @Test
    void hasDifferentHash() {
        final Phi raw = new EOnumber();
        final Phi initialized = new Data.ToPhi(0L);
        MatcherAssert.assertThat(
            AtCompositeTest.TO_ADD_MESSAGE,
            raw.hashCode(),
            Matchers.not(initialized.hashCode())
        );
    }
}
