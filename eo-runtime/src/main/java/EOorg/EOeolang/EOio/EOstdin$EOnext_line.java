/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2022 Yegor Bugayenko
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

package EOorg.EOeolang.EOio;

import EOorg.EOeolang.EOerror;
import java.util.Scanner;
import org.eolang.AtComposite;
import org.eolang.Data;
import org.eolang.PhDefault;
import org.eolang.PhWith;
import org.eolang.Phi;

/**
 * Standard Input. Consumes only one line.
 *
 * @since 0.23
 */
public class EOstdin$EOnext_line extends PhDefault {

    /**
     * Ctor.
     * @param parent Sigma
     */
    public EOstdin$EOnext_line(final Phi parent) {
        super(parent);
        this.add("φ", new AtComposite(this, rho -> {
            try (Scanner sc = new Scanner(System.in)) {
                if (!sc.hasNextLine()) {
                    return new PhWith(
                        new EOerror(Phi.Φ), "msg",
                        new Data.ToPhi("There is no line in the standard input stream to consume")
                    );
                }
                return new Data.ToPhi(sc.nextLine());
            }
        }));
    }
}