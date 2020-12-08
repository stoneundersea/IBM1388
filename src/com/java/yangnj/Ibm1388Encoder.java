package com.java.yangnj;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
/**
 * This program is update from OpenJDK IBM935,
 * Convert matrix is based IBM z/OS
 * SBCS is based from SYS1.SCUNTBL(CUNRDXPG)
 * DBCS is based from SYS1.SCUNTBL(CUNRDYPG)
 * @author ynj
 * Date 2020-11-10
 */
public class Ibm1388Encoder extends CharsetEncoder {
    /**
     * UTF-16 Character not in IBM1388,replace with 0x6F(ibm388 ？)
     */
    private static final byte REPLACE_BYTE=0x6F;
    private byte b1;
    private byte b2;
    /**
     * SBCS and DBCS convert matrix(From UTF-16 to EBCDIC),Sub-Character is 0x006F
     *  The convert array subscript is between 0x0000-0xFFE5(exclude 0xA000-0xDFFF)
     */
    //0x0000-0x1fff
    private static final char[] convertIndex1 = UtfToEbcdicMatrix01.initialize();
    //0x2000-0x3fff
    private static final char[] convertIndex2 = UtfToEbcdicMatrix02.initialize();
    //0x4000-0x5fff
    private static final char[] convertIndex3 = UtfToEbcdicMatrix03.initialize();
    //0x6000-0x7fff
    private static final char[] convertIndex4 = UtfToEbcdicMatrix04.initialize();
    //0x8000-0x9fff
    private static final char[] convertIndex5 = UtfToEbcdicMatrix05.initialize();
    //0xe000-0xffe5
    private static final char[] convertIndex6 = UtfToEbcdicMatrix06.initialize();


    private static final int SBCS = 0;
    private static final int DBCS = 1;
    private static final byte SO = 0x0e;
    private static final byte SI = 0x0f;

    private int  currentState;

    //private final Surrogate.Parser sgp = new Surrogate.Parser();
    /*  将父类的 encoder's replacement value设置为0X6f(EBCDIC ?)                       */
    protected Ibm1388Encoder(Charset cs) {
        super(cs, 4.0f, 5.0f, new byte[] {REPLACE_BYTE});
    }

    @Override
    protected void implReset() {
        currentState = SBCS;
    }
    /*The default implementation of this method does nothing, and always returns CoderResult.UNDERFLOW.
     This method should be overridden by encoders that may need to write final bytes to the
     output buffer once the entire input sequence has been read.
      为DBCS的结束加上0X0F
     */
    @Override
    protected CoderResult implFlush(ByteBuffer out) {
        if (currentState == DBCS) {
            if (out.remaining() < 1) {
                return CoderResult.OVERFLOW;
            }
            out.put(SI);
        }
        implReset();
        return CoderResult.UNDERFLOW;
    }

    /**
     * Returns true if the given character can be converted to the target character encoding.
     */
    @Override
    public boolean canEncode(char ch) {
        //int  index;
        int  theBytes;
        //char ch与0xFFE0(0B 1111 1111 1110 0000)进行位与运算，再将结果二进制右移5位，最高位是0，左边补齐0;最高为是1，左边补齐1
        // char ch与0x001F(0B 0000 0000 0001 1111)进行位与运算
        // 这样的处理是为了避免出现负数？？？
        /*
        index = index1[((ch & mask1) >> shift)] + (ch & mask2);
        if (index  < 15000){
            theBytes = (int)(index2.charAt(index));
        }else{
            theBytes = (int)(index2a.charAt(index-15000));
        }

         */

        if((ch > 0XFFE5)||(ch > 0x9FFF && ch < 0xE000)){
            return false;
        }
        theBytes = (int) convertByIndex(ch);
        return (0XFFFD!= theBytes);

    }

    private char convertByIndex(char c){
        if(c <= 0x1FFF){
            return convertIndex1[c];
        }
        if(c <= 0x3FFF){
            return convertIndex2[c-0x2000];
        }
        if(c <= 0x5FFF){
            return convertIndex3[c-0x4000];
        }
        if(c <= 0x7FFF){
            return convertIndex4[c-0x6000];
        }
        if(c <= 0x9FFF){
            return convertIndex5[c-0x8000];
        }
        return convertIndex6[c-0xE000];
    }

    private CoderResult encodeArrayLoop(CharBuffer src, ByteBuffer dst) {
        char[] sa = src.array();
        int sp = src.arrayOffset() + src.position();
        int sl = src.arrayOffset() + src.limit();
        byte[] da = dst.array();
        int dp = dst.arrayOffset() + dst.position();
        int dl = dst.arrayOffset() + dst.limit();
        int outputSize = 0;             // size of output
        int spaceNeeded;


        try {
            while (sp < sl) {
                int index;
                int theBytes;
                char c = sa[sp];

                //判断是否为辅助平面(UCS-4)的高位或低位字符  即在D800-DFFF之间
                //U+D800–U+DBFF, called High Surrogates,  U+DC00–U+DFFF, called Low Surrogates,
                //如果是辅助平面范围字符(UCS-4)，检查高位和低位是否配套存在
                /*
                if (Surrogate.is(c)) {
                    if (sgp.parse(c, sa, sp, sl) < 0){
                        return sgp.error();
                    }
                    return sgp.unmappableResult();
                }
                */
                /** If char is High Surrogate, add next char,translate to 0x6F(EBCDIC ?)
                 *  If char not in translate matrix，translate to 0x6F.
                 */
                if(Character.isHighSurrogate(c)){
                    /**
                    * Add judgement is avoid IllegalArgumentException in "src.position(sp - src.arrayOffset())"
                    */
                    if(sp > sl-1){
                        sp++;
                    }
                    theBytes=REPLACE_BYTE;
                }else if((c > 0XFFE5)||(c > 0x9FFF && c < 0xE000)){
                    theBytes = REPLACE_BYTE;
                }else{
                    theBytes =  (int) convertByIndex(c);
                }

                b1= (byte)((theBytes & 0x0000ff00)>>8);
                b2 = (byte)(theBytes & 0x000000ff);
                /*
                if (b1 == 0x00 && b2 == 0x00 && c != '\u0000') {
                    return CoderResult.unmappableForLength(1);
                }
                 */

                if (currentState == DBCS && b1 == 0x00) {
                    if (dl - dp < 1) {
                        return CoderResult.OVERFLOW;
                    }
                    currentState = SBCS;
                    da[dp++] = SI;
                } else if (currentState == SBCS && b1 != 0x00) {
                    if (dl - dp < 1) {
                        return CoderResult.OVERFLOW;
                    }
                    currentState = DBCS;
                    da[dp++] = SO;
                }
                if (currentState == DBCS) {
                    spaceNeeded = 2;
                }else {
                    spaceNeeded = 1;
                }
                if (dl - dp < spaceNeeded) {
                    return CoderResult.OVERFLOW;
                }
                if (currentState == SBCS) {
                    da[dp++] = b2;
                }else {
                    da[dp++] = b1;
                    da[dp++] = b2;
                }
                sp++;
            }
            return CoderResult.UNDERFLOW;
        } finally {
            src.position(sp - src.arrayOffset());
            dst.position(dp - dst.arrayOffset());
        }
    }


    private CoderResult encodeBufferLoop(CharBuffer src, ByteBuffer dst) {
        int mark = src.position();
        int outputSize = 0;             // size of output
        int spaceNeeded;

        try {
            while (src.hasRemaining()) {
                int index;
                int theBytes;
                char c = src.get();
                /*
                if (Surrogate.is(c)) {
                    if (sgp.parse(c, src) < 0) {
                        return sgp.error();
                    }
                    return sgp.unmappableResult();
                }
                if (c >= '\uFFFE') {
                    return CoderResult.unmappableForLength(1);
                }
                */

                if(Character.isHighSurrogate(c)){
                    if(src.hasRemaining()){
                        src.get();
                    }
                    theBytes=REPLACE_BYTE;
                }else if((c > 0XFFE5)||(c > 0x9FFF && c < 0xE000)){
                    theBytes = REPLACE_BYTE;
                }else{
                    theBytes =  (int) convertByIndex(c);
                }
                //???????
               /*
                index = index1[((c & mask1) >> shift)]  + (c & mask2);
                if (index < 15000) {
                    theBytes = (int) (index2.charAt(index));
                }else {
                    theBytes = (int) (index2a.charAt(index - 15000));
                }
                */
                /*  Check Unicode scope.                                         */

                b1 = (byte)((theBytes & 0x0000ff00)>>8);
                b2 = (byte)(theBytes & 0x000000ff);
                /*
                if (b1== 0x00 && b2 == 0x00 && c != '\u0000') {
                    return CoderResult.unmappableForLength(1);
                }
                */

                if (currentState == DBCS && b1 == 0x00) {
                    if (dst.remaining() < 1) {
                        return CoderResult.OVERFLOW;
                    }
                    currentState = SBCS;
                    dst.put(SI);
                } else if (currentState == SBCS && b1 != 0x00) {
                    if (dst.remaining() < 1) {
                        return CoderResult.OVERFLOW;
                    }
                    currentState = DBCS;
                    dst.put(SO);
                }

                if (currentState == DBCS) {
                    spaceNeeded = 2;
                }else {
                    spaceNeeded = 1;
                }

                if (dst.remaining() < spaceNeeded) {
                    return CoderResult.OVERFLOW;
                }

                if (currentState == SBCS) {
                    dst.put(b2);
                }else {
                    dst.put(b1);
                    dst.put(b2);
                }
                mark++;
            }
            return CoderResult.UNDERFLOW;
        } finally {
            src.position(mark);
        }
    }

    @Override
    protected CoderResult encodeLoop(CharBuffer src, ByteBuffer dst) {
        //for heap buffers
        return src.hasArray() && dst.hasArray() ? encodeArrayLoop(src, dst) : encodeBufferLoop(src, dst);

    }
}




