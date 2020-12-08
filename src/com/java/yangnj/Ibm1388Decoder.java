package com.java.yangnj;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
/**
 * @author YangNJ
 * @program: Ibm1388Decoder
 * @description:
 *   An engine that can transform a sequence of bytes(IBM1388) in a specific charset into a sequence of
 *      sixteen-bit Unicode characters.
 *   The convert matrix   IBM z/OS unicode service
 *      SYS1.SCUNTBL(CUNRDXPG)  SBCS   SYS1.SCUNTBL(CUNRDYPG)  DBCS
 *
 * @date 2020-11-30 09:27:38
 */
public class Ibm1388Decoder extends CharsetDecoder {
    private static final char REPLACE_CHAR='\uFFFD';
    /**
     *  SBCS and DBCS convert matrix(From EBCDIC to UTF-16),Sub-Character is 0xFFFD
     *  The convert array subscript is between 0x0000-0x7FFD.
     *   Java source program has 64K limited,
     *   So split many class for static constants definition.
     */
    /**
     * 0x0000-0x1fff
     */
    private static final char[] CONVERT_INDEX1 = EbcdicToUtfMatrix01.initialize();
    private static final int INDEX1_BASE = 0;
    private static final int INDEX1_LIMIT = 0x1FFF;
    /**
     * 0x2000-0x3fff
     */
    private static final char[] CONVERT_INDEX2 = EbcdicToUtfMatrix02.initialize();
    private static final int INDEX2_BASE = 0x2000;
    private static final int INDEX2_LIMIT = 0x3FFF;
    /**
     * 0x4000-0x5fff
     */
    private static final char[] CONVERT_INDEX3 = EbcdicToUtfMatrix03.initialize();
    private static final int INDEX3_BASE = 0x4000;
    private static final int INDEX3_LIMIT = 0x5FFF;
    /**
     * 0x6000-0x7ffd
     */
    private static final char[] CONVERT_INDEX4 = EbcdicToUtfMatrix04.initialize();
    private static final int INDEX4_BASE = 0x6000;
    private static final int INDEX4_LIMIT = 0x7FFD;

    private static final int SBCS = 0;
    private static final int DBCS = 1;

    private static final int SO = 0x0e;
    private static final int SI = 0x0f;
    private int  currentState;

    protected Ibm1388Decoder(Charset cs) {
        super(cs, 0.5f, 1.0f);
    }

    @Override
    protected void implReset() {
        currentState = SBCS;
    }

    private char convertByIndex(int i){
        if(i <= INDEX1_LIMIT){
            return CONVERT_INDEX1[i-INDEX1_BASE];
        }
        if(i <= INDEX2_LIMIT){
            return CONVERT_INDEX2[i-INDEX2_BASE];
        }
        if(i <=INDEX3_LIMIT){
            return CONVERT_INDEX3[i-INDEX3_BASE];
        }
        return CONVERT_INDEX4[i-INDEX4_BASE];
    }

    private CoderResult decodeArrayLoop(ByteBuffer src, CharBuffer dst) {
        byte[] sa = src.array();
        int sp = src.arrayOffset() + src.position();
        int sl = src.arrayOffset() + src.limit();
        assert (sp <= sl);
        sp = (sp <= sl ? sp : sl);
        char[] da = dst.array();
        int dp = dst.arrayOffset() + dst.position();
        int dl = dst.arrayOffset() + dst.limit();
        assert (dp <= dl);
        dp = (dp <= dl ? dp : dl);

        try {
            while (sp < sl) {
                int b1, b2;
                b1 = sa[sp];
                int inputSize = 1;
                int v = 0;
                char outputChar = REPLACE_CHAR;
                if (b1 < 0) {
                    b1 += 256;
                }
                if (b1 == SO) {
                    /**
                     * Shift out, For SO characters- simply validate the state and if OK
                     * update the state and go to the next byte
                     */
                    if (currentState != SBCS) {
                        /**
                         * Return a CoderResult object indicating a malformed-input error.
                         */
                        return CoderResult.malformedForLength(1);
                    }else {
                        currentState = DBCS;
                    }
                } else if (b1 == SI) {
                    // For SI characters - simply validate the state and if OK
                    //    update the state and go to the next byte

                    if (currentState != DBCS) {
                        return CoderResult.malformedForLength(1);
                    } else {
                        currentState = SBCS;
                    }
                } else {
                    if (currentState == SBCS) {
                        outputChar = convertByIndex(b1);
                    } else {
                        if (sl - sp < 2) {
                            return CoderResult.UNDERFLOW;
                        }
                        b2 = sa[sp + 1];
                        if (b2 < 0) {
                            b2 += 256;
                        }

                        inputSize++;

                        // Check validity of dbcs ebcdic byte pair values
                        /*
                        if ((b1 != 0x40 || b2 != 0x40) &&
                                (b2 < 0x41 || b2 > 0xfe)) {
                            return CoderResult.malformedForLength(2);
                        }*/

                        // Lookup in the two level index
                        v = b1 * 256 + b2;
                        //Check ebcdic charset scope*/
                        if(v > 0X7ffd){
                            return CoderResult.malformedForLength(2);
                        }
                        outputChar = convertByIndex(v);
                    }
                    if (outputChar == '\uFFFD') {
                        return CoderResult.unmappableForLength(inputSize);
                    }

                    if (dl - dp < 1) {
                        return CoderResult.OVERFLOW;
                    }
                    da[dp++] = outputChar;
                }
                sp += inputSize;
            }
            return CoderResult.UNDERFLOW;
        } finally {
            src.position(sp - src.arrayOffset());
            dst.position(dp - dst.arrayOffset());
        }
    }

    private CoderResult decodeBufferLoop(ByteBuffer src, CharBuffer dst) {
        int mark = src.position();

        try {
            while (src.hasRemaining()) {
                int b1, b2;
                int v = 0;
                b1 = src.get();
                int inputSize = 1;
                char outputChar = REPLACE_CHAR;

                if (b1 < 0) {
                    b1 += 256;
                }
                if (b1 == SO) {  // Shift out
                    // For SO characters - simply validate the state and if OK
                    //    update the state and go to the next byte

                    if (currentState != SBCS) {
                        return CoderResult.malformedForLength(1);
                    }else{
                        currentState = DBCS;
                    }
                } else if (b1 == SI) {
                    // For SI characters - simply validate the state and if OK
                    //    update the state and go to the next byte

                    if (currentState != DBCS) {
                        return CoderResult.malformedForLength(1);
                    } else {
                        currentState = SBCS;
                    }
                } else {
                    if (currentState == SBCS) {
                        outputChar = convertByIndex(b1);
                    } else {
                        if (src.remaining() < 1) {
                            return CoderResult.UNDERFLOW;
                        }
                        b2 = src.get();
                        if (b2 < 0) {
                            b2 += 256;
                        }
                        inputSize++;

                        // Check validity of dbcs ebcdic byte pair values
                        /*
                        if ((b1 != 0x40 || b2 != 0x40) &&
                                (b2 < 0x41 || b2 > 0xfe)) {
                            return CoderResult.malformedForLength(2);
                        }

                         */

                        // Lookup in the two level index
                        v = b1 * 256 + b2;
                        if(v > 0X7ffd){
                            return CoderResult.malformedForLength(2);
                        }
                        outputChar = convertByIndex(v);
                    }
                    if (outputChar == REPLACE_CHAR) {
                        return CoderResult.unmappableForLength(inputSize);
                    }
                    if (!dst.hasRemaining()) {
                        return CoderResult.OVERFLOW;
                    }
                    dst.put(outputChar);
                }
                mark += inputSize;
            }
            return CoderResult.UNDERFLOW;
        } finally {
            src.position(mark);
        }
    }

    @Override
    protected CoderResult decodeLoop(ByteBuffer src, CharBuffer dst) {
        /**
         *  Is HeapBuffer?
         */
        return src.hasArray() && dst.hasArray() ?  decodeArrayLoop(src, dst) : decodeBufferLoop(src, dst);
    }

}
