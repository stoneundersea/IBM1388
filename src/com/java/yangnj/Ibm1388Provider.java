package com.java.yangnj;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.HashSet;
import java.util.Iterator;

public class Ibm1388Provider extends CharsetProvider {
    private static final String CHARSET_NAME = "x-IBM1388";
    private Charset charsetIBM1388 = null;
    /*Constructor, instantiate a Charset object and save the reference. */
    public Ibm1388Provider() {
        this.charsetIBM1388 = new Ibm1388();
    }

    /**
     * Called by Charset static methods to find a particular named Charset. If
     * it's the name of this charset (we don't have any aliases) then return the
     * Rot13 Charset, else return null.
     */
    @Override
    public Charset charsetForName(String charsetName) {
        if (charsetName.equalsIgnoreCase(CHARSET_NAME)) {
            return (this.charsetIBM1388);
        }
        return (null);
    }

    /**
     * Return an Iterator over the set of Charset objects we provide.
     *
     * @return An Iterator object containing references to all the Charset
     *         objects provided by this class.
     */
    @Override
    public Iterator<Charset> charsets() {
        HashSet<Charset> set = new HashSet<>(1);
        set.add(this.charsetIBM1388);
        return (set.iterator());
    }
}

