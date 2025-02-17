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
package org.eolang.parser;

import com.yegor256.xsline.Shift;
import com.yegor256.xsline.TrDefault;
import com.yegor256.xsline.TrEnvelope;
import com.yegor256.xsline.TrFast;
import com.yegor256.xsline.TrLambda;
import com.yegor256.xsline.TrLogged;
import com.yegor256.xsline.Train;
import java.util.logging.Level;

/**
 * Train full of logging and checking.
 * @since 0.51
 */
public final class TrFull extends TrEnvelope {
    /**
     * Ctor.
     */
    public TrFull() {
        this(new TrDefault<>());
    }

    /**
     * Ctor.
     * @param train Original
     */
    public TrFull(final Train<Shift> train) {
        super(
            new TrStepped(
                new TrFast(
                    new TrLambda(
                        new TrLogged(
                            train,
                            TrFull.class,
                            Level.FINEST
                        ),
                        StEoLogged::new
                    ),
                    TrFull.class,
                    500L
                )
            )
        );
    }
}
