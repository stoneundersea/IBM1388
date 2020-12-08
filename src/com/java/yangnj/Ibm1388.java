package com.java.yangnj;

import sun.nio.cs.HistoricallyNamedCharset;
import sun.nio.cs.ext.ExtendedCharsets;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author YangNJ
 * @program: IBM1388
 * @description:
 *   This project is to Initializes a new charset(EBCDIC for Simplified Chinese),
 *   It based from OpenJDK IBM935 Charset,
 *   reference to https://blog.csdn.net/kakarot5/article/details/105341148
 *      Java NIO by Ron Hitchens, http://www.javanio.info/
 *   The convert matrix   IBM z/OS unicode service
 *      SYS1.SCUNTBL(CUNRDXPG)  SBCS   SYS1.SCUNTBL(CUNRDYPG)  DBCS
 *
 * @date 2020-11-30 09:27:38
 */
public class Ibm1388 extends Charset implements HistoricallyNamedCharset {
    public Ibm1388() {
        super("x-IBM1388", ExtendedCharsets.aliasesFor("x-IBM1388"));
    }
    @Override
    public String historicalName() {
        return "x-IBM1388";
    }
    @Override
    public boolean contains(Charset cs) {
        return cs instanceof Ibm1388;
    }
    @Override
    public CharsetDecoder newDecoder() {
        return new Ibm1388Decoder(this);
    }
    @Override
    public CharsetEncoder newEncoder() {
        return new Ibm1388Encoder(this);
    }


}
