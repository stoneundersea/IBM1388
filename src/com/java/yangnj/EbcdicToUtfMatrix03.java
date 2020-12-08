package com.java.yangnj;

/**
 * @author ynj
 * @program: ibm1388
 * @description:
 * @date 2020-12-03 19:27:04
 */
public class EbcdicToUtfMatrix03 {
    //0x4000-0x5fff
    private static final char[] convertIndex = {
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4000-0X400f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4010-0X401f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4020-0X402f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4030-0X403f  */
            '\u3000', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4040-0X404f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4050-0X405f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4060-0X406f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4070-0X407f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4080-0X408f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4090-0X409f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X40a0-0X40af  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X40b0-0X40bf  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X40c0-0X40cf  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X40d0-0X40df  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X40e0-0X40ef  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X40f0-0X40ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4100-0X410f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4110-0X411f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4120-0X412f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4130-0X413f  */
            '\uFFFD', '\u03B1', '\u03B2', '\u03B3', '\u03B4', '\u03B5', '\u03B6', '\u03B7', '\u03B8', '\u03B9', '\u03BA', '\u03BB', '\u03BC', '\u03BD', '\u03BE', '\u03BF',   /* 0X4140-0X414f  */
            '\u03C0', '\u03C1', '\u03C3', '\u03C4', '\u03C5', '\u03C6', '\u03C7', '\u03C8', '\u03C9', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4150-0X415f  */
            '\uFFFD', '\u0391', '\u0392', '\u0393', '\u0394', '\u0395', '\u0396', '\u0397', '\u0398', '\u0399', '\u039A', '\u039B', '\u039C', '\u039D', '\u039E', '\u039F',   /* 0X4160-0X416f  */
            '\u03A0', '\u03A1', '\u03A3', '\u03A4', '\u03A5', '\u03A6', '\u03A7', '\u03A8', '\u03A9', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4170-0X417f  */
            '\u0430', '\u0431', '\u0432', '\u0433', '\u0434', '\u0435', '\u0451', '\u0436', '\u0437', '\u0438', '\u0439', '\u043A', '\u043B', '\u043C', '\u043D', '\u043E',   /* 0X4180-0X418f  */
            '\u043F', '\u0440', '\u0441', '\u0442', '\u0443', '\u0444', '\u0445', '\u0446', '\u0447', '\u0448', '\u0449', '\u044A', '\u044B', '\u044C', '\u044D', '\u044E',   /* 0X4190-0X419f  */
            '\u044F', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X41a0-0X41af  */
            '\uFFFD', '\u2170', '\u2171', '\u2172', '\u2173', '\u2174', '\u2175', '\u2176', '\u2177', '\u2178', '\u2179', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X41b0-0X41bf  */
            '\u0410', '\u0411', '\u0412', '\u0413', '\u0414', '\u0415', '\u0401', '\u0416', '\u0417', '\u0418', '\u0419', '\u041A', '\u041B', '\u041C', '\u041D', '\u041E',   /* 0X41c0-0X41cf  */
            '\u041F', '\u0420', '\u0421', '\u0422', '\u0423', '\u0424', '\u0425', '\u0426', '\u0427', '\u0428', '\u0429', '\u042A', '\u042B', '\u042C', '\u042D', '\u042E',   /* 0X41d0-0X41df  */
            '\u042F', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X41e0-0X41ef  */
            '\uFFFD', '\u2160', '\u2161', '\u2162', '\u2163', '\u2164', '\u2165', '\u2166', '\u2167', '\u2168', '\u2169', '\u216A', '\u216B', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X41f0-0X41ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4200-0X420f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4210-0X421f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4220-0X422f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4230-0X423f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFE1', '\uFF0E', '\uFF1C', '\uFF08', '\uFF0B', '\uFF5C',   /* 0X4240-0X424f  */
            '\uFF06', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFF01', '\uFFE5', '\uFF0A', '\uFF09', '\uFF1B', '\uFFE2',   /* 0X4250-0X425f  */
            '\uFF0D', '\uFF0F', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFE4', '\uFF0C', '\uFF05', '\uFF3F', '\uFF1E', '\uFF1F',   /* 0X4260-0X426f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFF40', '\uFF1A', '\uFF03', '\uFF20', '\uFF07', '\uFF1D', '\uFF02',   /* 0X4270-0X427f  */
            '\uFFFD', '\uFF41', '\uFF42', '\uFF43', '\uFF44', '\uFF45', '\uFF46', '\uFF47', '\uFF48', '\uFF49', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4280-0X428f  */
            '\uFFFD', '\uFF4A', '\uFF4B', '\uFF4C', '\uFF4D', '\uFF4E', '\uFF4F', '\uFF50', '\uFF51', '\uFF52', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4290-0X429f  */
            '\uFFFD', '\uFFE3', '\uFF53', '\uFF54', '\uFF55', '\uFF56', '\uFF57', '\uFF58', '\uFF59', '\uFF5A', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X42a0-0X42af  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X42b0-0X42bf  */
            '\uFF5B', '\uFF21', '\uFF22', '\uFF23', '\uFF24', '\uFF25', '\uFF26', '\uFF27', '\uFF28', '\uFF29', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X42c0-0X42cf  */
            '\uFF5D', '\uFF2A', '\uFF2B', '\uFF2C', '\uFF2D', '\uFF2E', '\uFF2F', '\uFF30', '\uFF31', '\uFF32', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X42d0-0X42df  */
            '\uFF04', '\uFFFD', '\uFF33', '\uFF34', '\uFF35', '\uFF36', '\uFF37', '\uFF38', '\uFF39', '\uFF3A', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X42e0-0X42ef  */
            '\uFF10', '\uFF11', '\uFF12', '\uFF13', '\uFF14', '\uFF15', '\uFF16', '\uFF17', '\uFF18', '\uFF19', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X42f0-0X42ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4300-0X430f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4310-0X431f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4320-0X432f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4330-0X433f  */
            '\uFFFD', '\u3002', '\u300C', '\u300D', '\u3001', '\u30FB', '\u30F2', '\u30A1', '\u30A3', '\u30A5', '\uFFE0', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4340-0X434f  */
            '\uFFFD', '\u30A7', '\u30A9', '\u30E3', '\u30E5', '\u30E7', '\u30C3', '\u30EE', '\u30FC', '\u30F5', '\u30F6', '\uF83D', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4350-0X435f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4360-0X436f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4370-0X437f  */
            '\uFFFD', '\u30A2', '\u30A4', '\u30A6', '\u30A8', '\u30AA', '\u30AB', '\u30AD', '\u30AF', '\u30B1', '\u30B3', '\uFFFD', '\u30B5', '\u30B7', '\u30B9', '\u30BB',   /* 0X4380-0X438f  */
            '\u30BD', '\u30BF', '\u30C1', '\u30C4', '\u30C6', '\u30C8', '\u30CA', '\u30CB', '\u30CC', '\u30CD', '\u30CE', '\uFFFD', '\uFFFD', '\u30CF', '\u30D2', '\u30D5',   /* 0X4390-0X439f  */
            '\uFFFD', '\uFF5E', '\u30D8', '\u30DB', '\u30DE', '\u30DF', '\u30E0', '\u30E1', '\u30E2', '\u30E4', '\u30E6', '\uFFFD', '\u30E8', '\u30E9', '\u30EA', '\u30EB',   /* 0X43a0-0X43af  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\u30EC', '\u30ED', '\u30EF', '\u30F3', '\u309B', '\u309C',   /* 0X43b0-0X43bf  */
            '\u30AC', '\u30AE', '\u30B0', '\u30B2', '\u30B4', '\u30B6', '\u30B8', '\u30BA', '\u30BC', '\u30BE', '\u30C0', '\u30C2', '\u30C5', '\u30C7', '\u30C9', '\u30D0',   /* 0X43c0-0X43cf  */
            '\u30D3', '\u30D6', '\u30D9', '\u30DC', '\u30F4', '\u30D1', '\u30D4', '\u30D7', '\u30DA', '\u30DD', '\u30F0', '\u30F1', '\u30FD', '\u30FE', '\uFFFD', '\uFFFD',   /* 0X43d0-0X43df  */
            '\uFF3C', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X43e0-0X43ef  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X43f0-0X43ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4400-0X440f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4410-0X441f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4420-0X442f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4430-0X443f  */
            '\uFFFD', '\uFFFD', '\u300E', '\u300F', '\uFF3B', '\uFF3D', '\u3092', '\u3041', '\u3043', '\u3045', '\u2015', '\u00B1', '\u2260', '\u221E', '\u2103', '\uFFFD',   /* 0X4440-0X444f  */
            '\u00B4', '\u3047', '\u3049', '\u3083', '\u3085', '\u3087', '\u3063', '\u308E', '\uFFFD', '\uFFFD', '\u2010', '\u3003', '\uF83E', '\u3005', '\u3006', '\u3007',   /* 0X4450-0X445f  */
            '\u00A8', '\u2018', '\u201C', '\u3014', '\u3008', '\u300A', '\u3010', '\u2264', '\u2234', '\u2642', '\u00A7', '\u203B', '\u3012', '\u3231', '\u2116', '\u2121',   /* 0X4460-0X446f  */
            '\uFF3E', '\u2019', '\u201D', '\u3015', '\u3009', '\u300B', '\u3011', '\u2265', '\u2235', '\u2640', '\u00D7', '\u00F7', '\u2016', '\u3013', '\u2025', '\u2026',   /* 0X4470-0X447f  */
            '\uFFFD', '\u3042', '\u3044', '\u3046', '\u3048', '\u304A', '\u304B', '\u304D', '\u304F', '\u3051', '\u3053', '\uFFFD', '\u3055', '\u3057', '\u3059', '\u305B',   /* 0X4480-0X448f  */
            '\u305D', '\u305F', '\u3061', '\u3064', '\u3066', '\u3068', '\u306A', '\u306B', '\u306C', '\u306D', '\u306E', '\uFFFD', '\uFFFD', '\u306F', '\u3072', '\u3075',   /* 0X4490-0X449f  */
            '\uFFFD', '\uFFFD', '\u3078', '\u307B', '\u307E', '\u307F', '\u3080', '\u3081', '\u3082', '\u3084', '\u3086', '\uFFFD', '\u3088', '\u3089', '\u308A', '\u308B',   /* 0X44a0-0X44af  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\u308C', '\u308D', '\u308F', '\u3093', '\uFFFD', '\uFFFD',   /* 0X44b0-0X44bf  */
            '\u304C', '\u304E', '\u3050', '\u3052', '\u3054', '\u3056', '\u3058', '\u305A', '\u305C', '\u305E', '\u3060', '\u3062', '\u3065', '\u3067', '\u3069', '\u3070',   /* 0X44c0-0X44cf  */
            '\u3073', '\u3076', '\u3079', '\u307C', '\uFFFD', '\u3071', '\u3074', '\u3077', '\u307A', '\u307D', '\u3090', '\u3091', '\u309D', '\u309E', '\uFFFD', '\uFFFD',   /* 0X44d0-0X44df  */
            '\u25CB', '\u25CF', '\u25B3', '\u25B2', '\u25CE', '\u2606', '\u2605', '\u25C7', '\u25C6', '\u25A1', '\u25A0', '\u25BD', '\u25BC', '\u00B0', '\u2032', '\u2033',   /* 0X44e0-0X44ef  */
            '\u2192', '\u2190', '\u2191', '\u2193', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X44f0-0X44ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4500-0X450f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4510-0X451f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4520-0X452f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4530-0X453f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\u02C9', '\u02C7', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4540-0X454f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\u3016', '\u3017', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4550-0X455f  */
            '\uFFFD', '\uFFFD', '\u2236', '\u2227', '\u2228', '\u2211', '\u220F', '\u222A', '\u2229', '\u2208', '\u2237', '\u221A', '\u22A5', '\u2225', '\u2220', '\u2312',   /* 0X4560-0X456f  */
            '\u2299', '\u222B', '\u222E', '\u2261', '\u224C', '\u2248', '\u223D', '\u221D', '\uFFFD', '\u226E', '\u226F', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4570-0X457f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\u00A4', '\uFFFD', '\uFFFD', '\u2030', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4580-0X458f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4590-0X459f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X45a0-0X45af  */
            '\uFFFD', '\u2488', '\u2489', '\u248A', '\u248B', '\u248C', '\u248D', '\u248E', '\u248F', '\u2490', '\u2491', '\u2492', '\u2493', '\u2494', '\u2495', '\u2496',   /* 0X45b0-0X45bf  */
            '\u2497', '\u2498', '\u2499', '\u249A', '\u249B', '\u2474', '\u2475', '\u2476', '\u2477', '\u2478', '\u2479', '\u247A', '\u247B', '\u247C', '\u247D', '\u247E',   /* 0X45c0-0X45cf  */
            '\u247F', '\u2480', '\u2481', '\u2482', '\u2483', '\u2484', '\u2485', '\u2486', '\u2487', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X45d0-0X45df  */
            '\uFFFD', '\u2460', '\u2461', '\u2462', '\u2463', '\u2464', '\u2465', '\u2466', '\u2467', '\u2468', '\u2469', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X45e0-0X45ef  */
            '\uFFFD', '\u3220', '\u3221', '\u3222', '\u3223', '\u3224', '\u3225', '\u3226', '\u3227', '\u3228', '\u3229', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X45f0-0X45ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4600-0X460f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4610-0X461f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4620-0X462f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4630-0X463f  */
            '\uFFFD', '\u0101', '\u00E1', '\u01CE', '\u00E0', '\u0113', '\u00E9', '\u011B', '\u00E8', '\u012B', '\u00ED', '\u01D0', '\u00EC', '\u014D', '\u00F3', '\u01D2',   /* 0X4640-0X464f  */
            '\u00F2', '\u016B', '\u00FA', '\u01D4', '\u00F9', '\u01D6', '\u01D8', '\u01DA', '\u01DC', '\u00FC', '\u00EA', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4650-0X465f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\u3105', '\u3106', '\u3107', '\u3108', '\u3109', '\u310A', '\u310B', '\u310C', '\u310D', '\u310E', '\u310F',   /* 0X4660-0X466f  */
            '\u3110', '\u3111', '\u3112', '\u3113', '\u3114', '\u3115', '\u3116', '\u3117', '\u3118', '\u3119', '\u311A', '\u311B', '\u311C', '\u311D', '\u311E', '\u311F',   /* 0X4670-0X467f  */
            '\u3120', '\u3121', '\u3122', '\u3123', '\u3124', '\u3125', '\u3126', '\u3127', '\u3128', '\u3129', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4680-0X468f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4690-0X469f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\u2500', '\u2501', '\u2502', '\u2503', '\u2504', '\u2505', '\u2506', '\u2507', '\u2508', '\u2509', '\u250A', '\u250B',   /* 0X46a0-0X46af  */
            '\u250C', '\u250D', '\u250E', '\u250F', '\u2510', '\u2511', '\u2512', '\u2513', '\u2514', '\u2515', '\u2516', '\u2517', '\u2518', '\u2519', '\u251A', '\u251B',   /* 0X46b0-0X46bf  */
            '\u251C', '\u251D', '\u251E', '\u251F', '\u2520', '\u2521', '\u2522', '\u2523', '\u2524', '\u2525', '\u2526', '\u2527', '\u2528', '\u2529', '\u252A', '\u252B',   /* 0X46c0-0X46cf  */
            '\u252C', '\u252D', '\u252E', '\u252F', '\u2530', '\u2531', '\u2532', '\u2533', '\u2534', '\u2535', '\u2536', '\u2537', '\u2538', '\u2539', '\u253A', '\u253B',   /* 0X46d0-0X46df  */
            '\u253C', '\u253D', '\u253E', '\u253F', '\u2540', '\u2541', '\u2542', '\u2543', '\u2544', '\u2545', '\u2546', '\u2547', '\u2548', '\u2549', '\u254A', '\u254B',   /* 0X46e0-0X46ef  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X46f0-0X46ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4700-0X470f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4710-0X471f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4720-0X472f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4730-0X473f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4740-0X474f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4750-0X475f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4760-0X476f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4770-0X477f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4780-0X478f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4790-0X479f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X47a0-0X47af  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X47b0-0X47bf  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X47c0-0X47cf  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X47d0-0X47df  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X47e0-0X47ef  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X47f0-0X47ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4800-0X480f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4810-0X481f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4820-0X482f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4830-0X483f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4840-0X484f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4850-0X485f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4860-0X486f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4870-0X487f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4880-0X488f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4890-0X489f  */
            '\u554A', '\u963F', '\u57C3', '\u6328', '\u54CE', '\u5509', '\u54C0', '\u7691', '\u764C', '\u853C', '\u77EE', '\u827E', '\u788D', '\u7231', '\u9698', '\u978D',   /* 0X48a0-0X48af  */
            '\u6C28', '\u5B89', '\u4FFA', '\u6309', '\u6697', '\u5CB8', '\u80FA', '\u6848', '\u80AE', '\u6602', '\u76CE', '\u51F9', '\u6556', '\u71AC', '\u7FF1', '\u8884',   /* 0X48b0-0X48bf  */
            '\u50B2', '\u5965', '\u61CA', '\u6FB3', '\u82AD', '\u634C', '\u6252', '\u53ED', '\u5427', '\u7B06', '\u516B', '\u75A4', '\u5DF4', '\u62D4', '\u8DCB', '\u9776',   /* 0X48c0-0X48cf  */
            '\u628A', '\u8019', '\u575D', '\u9738', '\u7F62', '\u7238', '\u767D', '\u67CF', '\u767E', '\u6446', '\u4F70', '\u8D25', '\u62DC', '\u7A17', '\u6591', '\u73ED',   /* 0X48d0-0X48df  */
            '\u642C', '\u6273', '\u822C', '\u9881', '\u677F', '\u7248', '\u626E', '\u62CC', '\u4F34', '\u74E3', '\u534A', '\u529E', '\u7ECA', '\u90A6', '\u5E2E', '\u6886',   /* 0X48e0-0X48ef  */
            '\u699C', '\u8180', '\u7ED1', '\u68D2', '\u78C5', '\u868C', '\u9551', '\u508D', '\u8C24', '\u82DE', '\u80DE', '\u5305', '\u8912', '\u5265', '\uFFFD', '\uFFFD',   /* 0X48f0-0X48ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4900-0X490f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4910-0X491f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4920-0X492f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4930-0X493f  */
            '\uFFFD', '\u8584', '\u96F9', '\u4FDD', '\u5821', '\u9971', '\u5B9D', '\u62B1', '\u62A5', '\u66B4', '\u8C79', '\u9C8D', '\u7206', '\u676F', '\u7891', '\u60B2',   /* 0X4940-0X494f  */
            '\u5351', '\u5317', '\u8F88', '\u80CC', '\u8D1D', '\u94A1', '\u500D', '\u72C8', '\u5907', '\u60EB', '\u7119', '\u88AB', '\u5954', '\u82EF', '\u672C', '\u7B28',   /* 0X4950-0X495f  */
            '\u5D29', '\u7EF7', '\u752D', '\u6CF5', '\u8E66', '\u8FF8', '\u903C', '\u9F3B', '\u6BD4', '\u9119', '\u7B14', '\u5F7C', '\u78A7', '\u84D6', '\u853D', '\u6BD5',   /* 0X4960-0X496f  */
            '\u6BD9', '\u6BD6', '\u5E01', '\u5E87', '\u75F9', '\u95ED', '\u655D', '\u5F0A', '\u5FC5', '\u8F9F', '\u58C1', '\u81C2', '\u907F', '\u965B', '\u97AD', '\u8FB9',   /* 0X4970-0X497f  */
            '\uFFFD', '\u7F16', '\u8D2C', '\u6241', '\u4FBF', '\u53D8', '\u535E', '\u8FA8', '\u8FA9', '\u8FAB', '\u904D', '\u6807', '\u5F6A', '\u8198', '\u8868', '\u9CD6',   /* 0X4980-0X498f  */
            '\u618B', '\u522B', '\u762A', '\u5F6C', '\u658C', '\u6FD2', '\u6EE8', '\u5BBE', '\u6448', '\u5175', '\u51B0', '\u67C4', '\u4E19', '\u79C9', '\u997C', '\u70B3',   /* 0X4990-0X499f  */
            '\u75C5', '\u5E76', '\u73BB', '\u83E0', '\u64AD', '\u62E8', '\u94B5', '\u6CE2', '\u535A', '\u52C3', '\u640F', '\u94C2', '\u7B94', '\u4F2F', '\u5E1B', '\u8236',   /* 0X49a0-0X49af  */
            '\u8116', '\u818A', '\u6E24', '\u6CCA', '\u9A73', '\u6355', '\u535C', '\u54FA', '\u8865', '\u57E0', '\u4E0D', '\u5E03', '\u6B65', '\u7C3F', '\u90E8', '\u6016',   /* 0X49b0-0X49bf  */
            '\u64E6', '\u731C', '\u88C1', '\u6750', '\u624D', '\u8D22', '\u776C', '\u8E29', '\u91C7', '\u5F69', '\u83DC', '\u8521', '\u9910', '\u53C2', '\u8695', '\u6B8B',   /* 0X49c0-0X49cf  */
            '\u60ED', '\u60E8', '\u707F', '\u82CD', '\u8231', '\u4ED3', '\u6CA7', '\u85CF', '\u64CD', '\u7CD9', '\u69FD', '\u66F9', '\u8349', '\u5395', '\u7B56', '\u4FA7',   /* 0X49d0-0X49df  */
            '\u518C', '\u6D4B', '\u5C42', '\u8E6D', '\u63D2', '\u53C9', '\u832C', '\u8336', '\u67E5', '\u78B4', '\u643D', '\u5BDF', '\u5C94', '\u5DEE', '\u8BE7', '\u62C6',   /* 0X49e0-0X49ef  */
            '\u67F4', '\u8C7A', '\u6400', '\u63BA', '\u8749', '\u998B', '\u8C17', '\u7F20', '\u94F2', '\u4EA7', '\u9610', '\u98A4', '\u660C', '\u7316', '\uFFFD', '\uFFFD',   /* 0X49f0-0X49ff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4a00-0X4a0f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4a10-0X4a1f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4a20-0X4a2f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4a30-0X4a3f  */
            '\uFFFD', '\u573A', '\u5C1D', '\u5E38', '\u957F', '\u507F', '\u80A0', '\u5382', '\u655E', '\u7545', '\u5531', '\u5021', '\u8D85', '\u6284', '\u949E', '\u671D',   /* 0X4a40-0X4a4f  */
            '\u5632', '\u6F6E', '\u5DE2', '\u5435', '\u7092', '\u8F66', '\u626F', '\u64A4', '\u63A3', '\u5F7B', '\u6F88', '\u90F4', '\u81E3', '\u8FB0', '\u5C18', '\u6668',   /* 0X4a50-0X4a5f  */
            '\u5FF1', '\u6C89', '\u9648', '\u8D81', '\u886C', '\u6491', '\u79F0', '\u57CE', '\u6A59', '\u6210', '\u5448', '\u4E58', '\u7A0B', '\u60E9', '\u6F84', '\u8BDA',   /* 0X4a60-0X4a6f  */
            '\u627F', '\u901E', '\u9A8B', '\u79E4', '\u5403', '\u75F4', '\u6301', '\u5319', '\u6C60', '\u8FDF', '\u5F1B', '\u9A70', '\u803B', '\u9F7F', '\u4F88', '\u5C3A',   /* 0X4a70-0X4a7f  */
            '\uFFFD', '\u8D64', '\u7FC5', '\u65A5', '\u70BD', '\u5145', '\u51B2', '\u866B', '\u5D07', '\u5BA0', '\u62BD', '\u916C', '\u7574', '\u8E0C', '\u7A20', '\u6101',   /* 0X4a80-0X4a8f  */
            '\u7B79', '\u4EC7', '\u7EF8', '\u7785', '\u4E11', '\u81ED', '\u521D', '\u51FA', '\u6A71', '\u53A8', '\u8E87', '\u9504', '\u96CF', '\u6EC1', '\u9664', '\u695A',   /* 0X4a90-0X4a9f  */
            '\u7840', '\u50A8', '\u77D7', '\u6410', '\u89E6', '\u5904', '\u63E3', '\u5DDD', '\u7A7F', '\u693D', '\u4F20', '\u8239', '\u5598', '\u4E32', '\u75AE', '\u7A97',   /* 0X4aa0-0X4aaf  */
            '\u5E62', '\u5E8A', '\u95EF', '\u521B', '\u5439', '\u708A', '\u6376', '\u9524', '\u5782', '\u6625', '\u693F', '\u9187', '\u5507', '\u6DF3', '\u7EAF', '\u8822',   /* 0X4ab0-0X4abf  */
            '\u6233', '\u7EF0', '\u75B5', '\u8328', '\u78C1', '\u96CC', '\u8F9E', '\u6148', '\u74F7', '\u8BCD', '\u6B64', '\u523A', '\u8D50', '\u6B21', '\u806A', '\u8471',   /* 0X4ac0-0X4acf  */
            '\u56F1', '\u5306', '\u4ECE', '\u4E1B', '\u51D1', '\u7C97', '\u918B', '\u7C07', '\u4FC3', '\u8E7F', '\u7BE1', '\u7A9C', '\u6467', '\u5D14', '\u50AC', '\u8106',   /* 0X4ad0-0X4adf  */
            '\u7601', '\u7CB9', '\u6DEC', '\u7FE0', '\u6751', '\u5B58', '\u5BF8', '\u78CB', '\u64AE', '\u6413', '\u63AA', '\u632B', '\u9519', '\u642D', '\u8FBE', '\u7B54',   /* 0X4ae0-0X4aef  */
            '\u7629', '\u6253', '\u5927', '\u5446', '\u6B79', '\u50A3', '\u6234', '\u5E26', '\u6B86', '\u4EE3', '\u8D37', '\u888B', '\u5F85', '\u902E', '\uFFFD', '\uFFFD',   /* 0X4af0-0X4aff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4b00-0X4b0f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4b10-0X4b1f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4b20-0X4b2f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4b30-0X4b3f  */
            '\uFFFD', '\u6020', '\u803D', '\u62C5', '\u4E39', '\u5355', '\u90F8', '\u63B8', '\u80C6', '\u65E6', '\u6C2E', '\u4F46', '\u60EE', '\u6DE1', '\u8BDE', '\u5F39',   /* 0X4b40-0X4b4f  */
            '\u86CB', '\u5F53', '\u6321', '\u515A', '\u8361', '\u6863', '\u5200', '\u6363', '\u8E48', '\u5012', '\u5C9B', '\u7977', '\u5BFC', '\u5230', '\u7A3B', '\u60BC',   /* 0X4b50-0X4b5f  */
            '\u9053', '\u76D7', '\u5FB7', '\u5F97', '\u7684', '\u8E6C', '\u706F', '\u767B', '\u7B49', '\u77AA', '\u51F3', '\u9093', '\u5824', '\u4F4E', '\u6EF4', '\u8FEA',   /* 0X4b60-0X4b6f  */
            '\u654C', '\u7B1B', '\u72C4', '\u6DA4', '\u7FDF', '\u5AE1', '\u62B5', '\u5E95', '\u5730', '\u8482', '\u7B2C', '\u5E1D', '\u5F1F', '\u9012', '\u7F14', '\u98A0',   /* 0X4b70-0X4b7f  */
            '\uFFFD', '\u6382', '\u6EC7', '\u7898', '\u70B9', '\u5178', '\u975B', '\u57AB', '\u7535', '\u4F43', '\u7538', '\u5E97', '\u60E6', '\u5960', '\u6DC0', '\u6BBF',   /* 0X4b80-0X4b8f  */
            '\u7889', '\u53FC', '\u96D5', '\u51CB', '\u5201', '\u6389', '\u540A', '\u9493', '\u8C03', '\u8DCC', '\u7239', '\u789F', '\u8776', '\u8FED', '\u8C0D', '\u53E0',   /* 0X4b90-0X4b9f  */
            '\u4E01', '\u76EF', '\u53EE', '\u9489', '\u9876', '\u9F0E', '\u952D', '\u5B9A', '\u8BA2', '\u4E22', '\u4E1C', '\u51AC', '\u8463', '\u61C2', '\u52A8', '\u680B',   /* 0X4ba0-0X4baf  */
            '\u4F97', '\u606B', '\u51BB', '\u6D1E', '\u515C', '\u6296', '\u6597', '\u9661', '\u8C46', '\u9017', '\u75D8', '\u90FD', '\u7763', '\u6BD2', '\u728A', '\u72EC',   /* 0X4bb0-0X4bbf  */
            '\u8BFB', '\u5835', '\u7779', '\u8D4C', '\u675C', '\u9540', '\u809A', '\u5EA6', '\u6E21', '\u5992', '\u7AEF', '\u77ED', '\u953B', '\u6BB5', '\u65AD', '\u7F0E',   /* 0X4bc0-0X4bcf  */
            '\u5806', '\u5151', '\u961F', '\u5BF9', '\u58A9', '\u5428', '\u8E72', '\u6566', '\u987F', '\u56E4', '\u949D', '\u76FE', '\u9041', '\u6387', '\u54C6', '\u591A',   /* 0X4bd0-0X4bdf  */
            '\u593A', '\u579B', '\u8EB2', '\u6735', '\u8DFA', '\u8235', '\u5241', '\u60F0', '\u5815', '\u86FE', '\u5CE8', '\u9E45', '\u4FC4', '\u989D', '\u8BB9', '\u5A25',   /* 0X4be0-0X4bef  */
            '\u6076', '\u5384', '\u627C', '\u904F', '\u9102', '\u997F', '\u6069', '\u800C', '\u513F', '\u8033', '\u5C14', '\u9975', '\u6D31', '\u4E8C', '\uFFFD', '\uFFFD',   /* 0X4bf0-0X4bff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4c00-0X4c0f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4c10-0X4c1f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4c20-0X4c2f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4c30-0X4c3f  */
            '\uFFFD', '\u8D30', '\u53D1', '\u7F5A', '\u7B4F', '\u4F10', '\u4E4F', '\u9600', '\u6CD5', '\u73D0', '\u85E9', '\u5E06', '\u756A', '\u7FFB', '\u6A0A', '\u77FE',   /* 0X4c40-0X4c4f  */
            '\u9492', '\u7E41', '\u51E1', '\u70E6', '\u53CD', '\u8FD4', '\u8303', '\u8D29', '\u72AF', '\u996D', '\u6CDB', '\u574A', '\u82B3', '\u65B9', '\u80AA', '\u623F',   /* 0X4c50-0X4c5f  */
            '\u9632', '\u59A8', '\u4EFF', '\u8BBF', '\u7EBA', '\u653E', '\u83F2', '\u975E', '\u5561', '\u98DE', '\u80A5', '\u532A', '\u8BFD', '\u5420', '\u80BA', '\u5E9F',   /* 0X4c60-0X4c6f  */
            '\u6CB8', '\u8D39', '\u82AC', '\u915A', '\u5429', '\u6C1B', '\u5206', '\u7EB7', '\u575F', '\u711A', '\u6C7E', '\u7C89', '\u594B', '\u4EFD', '\u5FFF', '\u6124',   /* 0X4c70-0X4c7f  */
            '\uFFFD', '\u7CAA', '\u4E30', '\u5C01', '\u67AB', '\u8702', '\u5CF0', '\u950B', '\u98CE', '\u75AF', '\u70FD', '\u9022', '\u51AF', '\u7F1D', '\u8BBD', '\u5949',   /* 0X4c80-0X4c8f  */
            '\u51E4', '\u4F5B', '\u5426', '\u592B', '\u6577', '\u80A4', '\u5B75', '\u6276', '\u62C2', '\u8F90', '\u5E45', '\u6C1F', '\u7B26', '\u4F0F', '\u4FD8', '\u670D',   /* 0X4c90-0X4c9f  */
            '\u6D6E', '\u6DAA', '\u798F', '\u88B1', '\u5F17', '\u752B', '\u629A', '\u8F85', '\u4FEF', '\u91DC', '\u65A7', '\u812F', '\u8151', '\u5E9C', '\u8150', '\u8D74',   /* 0X4ca0-0X4caf  */
            '\u526F', '\u8986', '\u8D4B', '\u590D', '\u5085', '\u4ED8', '\u961C', '\u7236', '\u8179', '\u8D1F', '\u5BCC', '\u8BA3', '\u9644', '\u5987', '\u7F1A', '\u5490',   /* 0X4cb0-0X4cbf  */
            '\u5676', '\u560E', '\u8BE5', '\u6539', '\u6982', '\u9499', '\u76D6', '\u6E89', '\u5E72', '\u7518', '\u6746', '\u67D1', '\u7AFF', '\u809D', '\u8D76', '\u611F',   /* 0X4cc0-0X4ccf  */
            '\u79C6', '\u6562', '\u8D63', '\u5188', '\u521A', '\u94A2', '\u7F38', '\u809B', '\u7EB2', '\u5C97', '\u6E2F', '\u6760', '\u7BD9', '\u768B', '\u9AD8', '\u818F',   /* 0X4cd0-0X4cdf  */
            '\u7F94', '\u7CD5', '\u641E', '\u9550', '\u7A3F', '\u544A', '\u54E5', '\u6B4C', '\u6401', '\u6208', '\u9E3D', '\u80F3', '\u7599', '\u5272', '\u9769', '\u845B',   /* 0X4ce0-0X4cef  */
            '\u683C', '\u86E4', '\u9601', '\u9694', '\u94EC', '\u4E2A', '\u5404', '\u7ED9', '\u6839', '\u8DDF', '\u8015', '\u66F4', '\u5E9A', '\u7FB9', '\uFFFD', '\uFFFD',   /* 0X4cf0-0X4cff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4d00-0X4d0f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4d10-0X4d1f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4d20-0X4d2f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4d30-0X4d3f  */
            '\uFFFD', '\u57C2', '\u803F', '\u6897', '\u5DE5', '\u653B', '\u529F', '\u606D', '\u9F9A', '\u4F9B', '\u8EAC', '\u516C', '\u5BAB', '\u5F13', '\u5DE9', '\u6C5E',   /* 0X4d40-0X4d4f  */
            '\u62F1', '\u8D21', '\u5171', '\u94A9', '\u52FE', '\u6C9F', '\u82DF', '\u72D7', '\u57A2', '\u6784', '\u8D2D', '\u591F', '\u8F9C', '\u83C7', '\u5495', '\u7B8D',   /* 0X4d50-0X4d5f  */
            '\u4F30', '\u6CBD', '\u5B64', '\u59D1', '\u9F13', '\u53E4', '\u86CA', '\u9AA8', '\u8C37', '\u80A1', '\u6545', '\u987E', '\u56FA', '\u96C7', '\u522E', '\u74DC',   /* 0X4d60-0X4d6f  */
            '\u5250', '\u5BE1', '\u6302', '\u8902', '\u4E56', '\u62D0', '\u602A', '\u68FA', '\u5173', '\u5B98', '\u51A0', '\u89C2', '\u7BA1', '\u9986', '\u7F50', '\u60EF',   /* 0X4d70-0X4d7f  */
            '\uFFFD', '\u704C', '\u8D2F', '\u5149', '\u5E7F', '\u901B', '\u7470', '\u89C4', '\u572D', '\u7845', '\u5F52', '\u9F9F', '\u95FA', '\u8F68', '\u9B3C', '\u8BE1',   /* 0X4d80-0X4d8f  */
            '\u7678', '\u6842', '\u67DC', '\u8DEA', '\u8D35', '\u523D', '\u8F8A', '\u6EDA', '\u68CD', '\u9505', '\u90ED', '\u56FD', '\u679C', '\u88F9', '\u8FC7', '\u54C8',   /* 0X4d90-0X4d9f  */
            '\u9AB8', '\u5B69', '\u6D77', '\u6C26', '\u4EA5', '\u5BB3', '\u9A87', '\u9163', '\u61A8', '\u90AF', '\u97E9', '\u542B', '\u6DB5', '\u5BD2', '\u51FD', '\u558A',   /* 0X4da0-0X4daf  */
            '\u7F55', '\u7FF0', '\u64BC', '\u634D', '\u65F1', '\u61BE', '\u608D', '\u710A', '\u6C57', '\u6C49', '\u592F', '\u676D', '\u822A', '\u58D5', '\u568E', '\u8C6A',   /* 0X4db0-0X4dbf  */
            '\u6BEB', '\u90DD', '\u597D', '\u8017', '\u53F7', '\u6D69', '\u5475', '\u559D', '\u8377', '\u83CF', '\u6838', '\u79BE', '\u548C', '\u4F55', '\u5408', '\u76D2',   /* 0X4dc0-0X4dcf  */
            '\u8C89', '\u9602', '\u6CB3', '\u6DB8', '\u8D6B', '\u8910', '\u9E64', '\u8D3A', '\u563F', '\u9ED1', '\u75D5', '\u5F88', '\u72E0', '\u6068', '\u54FC', '\u4EA8',   /* 0X4dd0-0X4ddf  */
            '\u6A2A', '\u8861', '\u6052', '\u8F70', '\u54C4', '\u70D8', '\u8679', '\u9E3F', '\u6D2A', '\u5B8F', '\u5F18', '\u7EA2', '\u5589', '\u4FAF', '\u7334', '\u543C',   /* 0X4de0-0X4def  */
            '\u539A', '\u5019', '\u540E', '\u547C', '\u4E4E', '\u5FFD', '\u745A', '\u58F6', '\u846B', '\u80E1', '\u8774', '\u72D0', '\u7CCA', '\u6E56', '\uFFFD', '\uFFFD',   /* 0X4df0-0X4dff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4e00-0X4e0f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4e10-0X4e1f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4e20-0X4e2f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4e30-0X4e3f  */
            '\uFFFD', '\u5F27', '\u864E', '\u552C', '\u62A4', '\u4E92', '\u6CAA', '\u6237', '\u82B1', '\u54D7', '\u534E', '\u733E', '\u6ED1', '\u753B', '\u5212', '\u5316',   /* 0X4e40-0X4e4f  */
            '\u8BDD', '\u69D0', '\u5F8A', '\u6000', '\u6DEE', '\u574F', '\u6B22', '\u73AF', '\u6853', '\u8FD8', '\u7F13', '\u6362', '\u60A3', '\u5524', '\u75EA', '\u8C62',   /* 0X4e50-0X4e5f  */
            '\u7115', '\u6DA3', '\u5BA6', '\u5E7B', '\u8352', '\u614C', '\u9EC4', '\u78FA', '\u8757', '\u7C27', '\u7687', '\u51F0', '\u60F6', '\u714C', '\u6643', '\u5E4C',   /* 0X4e60-0X4e6f  */
            '\u604D', '\u8C0E', '\u7070', '\u6325', '\u8F89', '\u5FBD', '\u6062', '\u86D4', '\u56DE', '\u6BC1', '\u6094', '\u6167', '\u5349', '\u60E0', '\u6666', '\u8D3F',   /* 0X4e70-0X4e7f  */
            '\uFFFD', '\u79FD', '\u4F1A', '\u70E9', '\u6C47', '\u8BB3', '\u8BF2', '\u7ED8', '\u8364', '\u660F', '\u5A5A', '\u9B42', '\u6D51', '\u6DF7', '\u8C41', '\u6D3B',   /* 0X4e80-0X4e8f  */
            '\u4F19', '\u706B', '\u83B7', '\u6216', '\u60D1', '\u970D', '\u8D27', '\u7978', '\u51FB', '\u573E', '\u57FA', '\u673A', '\u7578', '\u7A3D', '\u79EF', '\u7B95',   /* 0X4e90-0X4e9f  */
            '\u808C', '\u9965', '\u8FF9', '\u6FC0', '\u8BA5', '\u9E21', '\u59EC', '\u7EE9', '\u7F09', '\u5409', '\u6781', '\u68D8', '\u8F91', '\u7C4D', '\u96C6', '\u53CA',   /* 0X4ea0-0X4eaf  */
            '\u6025', '\u75BE', '\u6C72', '\u5373', '\u5AC9', '\u7EA7', '\u6324', '\u51E0', '\u810A', '\u5DF1', '\u84DF', '\u6280', '\u5180', '\u5B63', '\u4F0E', '\u796D',   /* 0X4eb0-0X4ebf  */
            '\u5242', '\u60B8', '\u6D4E', '\u5BC4', '\u5BC2', '\u8BA1', '\u8BB0', '\u65E2', '\u5FCC', '\u9645', '\u5993', '\u7EE7', '\u7EAA', '\u5609', '\u67B7', '\u5939',   /* 0X4ec0-0X4ecf  */
            '\u4F73', '\u5BB6', '\u52A0', '\u835A', '\u988A', '\u8D3E', '\u7532', '\u94BE', '\u5047', '\u7A3C', '\u4EF7', '\u67B6', '\u9A7E', '\u5AC1', '\u6B7C', '\u76D1',   /* 0X4ed0-0X4edf  */
            '\u575A', '\u5C16', '\u7B3A', '\u95F4', '\u714E', '\u517C', '\u80A9', '\u8270', '\u5978', '\u7F04', '\u8327', '\u68C0', '\u67EC', '\u78B1', '\u7877', '\u62E3',   /* 0X4ee0-0X4eef  */
            '\u6361', '\u7B80', '\u4FED', '\u526A', '\u51CF', '\u8350', '\u69DB', '\u9274', '\u8DF5', '\u8D31', '\u89C1', '\u952E', '\u7BAD', '\u4EF6', '\uFFFD', '\uFFFD',   /* 0X4ef0-0X4eff  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4f00-0X4f0f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4f10-0X4f1f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4f20-0X4f2f  */
            '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD', '\uFFFD',   /* 0X4f30-0X4f3f  */
            '\uFFFD', '\u5065', '\u8230', '\u5251', '\u996F', '\u6E10', '\u6E85', '\u6DA7', '\u5EFA', '\u50F5', '\u59DC', '\u5C06', '\u6D46', '\u6C5F', '\u7586', '\u848B',   /* 0X4f40-0X4f4f  */
            '\u6868', '\u5956', '\u8BB2', '\u5320', '\u9171', '\u964D', '\u8549', '\u6912', '\u7901', '\u7126', '\u80F6', '\u4EA4', '\u90CA', '\u6D47', '\u9A84', '\u5A07',   /* 0X4f50-0X4f5f  */
            '\u56BC', '\u6405', '\u94F0', '\u77EB', '\u4FA5', '\u811A', '\u72E1', '\u89D2', '\u997A', '\u7F34', '\u7EDE', '\u527F', '\u6559', '\u9175', '\u8F7F', '\u8F83',   /* 0X4f60-0X4f6f  */
            '\u53EB', '\u7A96', '\u63ED', '\u63A5', '\u7686', '\u79F8', '\u8857', '\u9636', '\u622A', '\u52AB', '\u8282', '\u6854', '\u6770', '\u6377', '\u776B', '\u7AED',   /* 0X4f70-0X4f7f  */
            '\uFFFD', '\u6D01', '\u7ED3', '\u89E3', '\u59D0', '\u6212', '\u85C9', '\u82A5', '\u754C', '\u501F', '\u4ECB', '\u75A5', '\u8BEB', '\u5C4A', '\u5DFE', '\u7B4B',   /* 0X4f80-0X4f8f  */
            '\u65A4', '\u91D1', '\u4ECA', '\u6D25', '\u895F', '\u7D27', '\u9526', '\u4EC5', '\u8C28', '\u8FDB', '\u9773', '\u664B', '\u7981', '\u8FD1', '\u70EC', '\u6D78',   /* 0X4f90-0X4f9f  */
            '\u5C3D', '\u52B2', '\u8346', '\u5162', '\u830E', '\u775B', '\u6676', '\u9CB8', '\u4EAC', '\u60CA', '\u7CBE', '\u7CB3', '\u7ECF', '\u4E95', '\u8B66', '\u666F',   /* 0X4fa0-0X4faf  */
            '\u9888', '\u9759', '\u5883', '\u656C', '\u955C', '\u5F84', '\u75C9', '\u9756', '\u7ADF', '\u7ADE', '\u51C0', '\u70AF', '\u7A98', '\u63EA', '\u7A76', '\u7EA0',   /* 0X4fb0-0X4fbf  */
            '\u7396', '\u97ED', '\u4E45', '\u7078', '\u4E5D', '\u9152', '\u53A9', '\u6551', '\u65E7', '\u81FC', '\u8205', '\u548E', '\u5C31', '\u759A', '\u97A0', '\u62D8',   /* 0X4fc0-0X4fcf  */
            '\u72D9', '\u75BD', '\u5C45', '\u9A79', '\u83CA', '\u5C40', '\u5480', '\u77E9', '\u4E3E', '\u6CAE', '\u805A', '\u62D2', '\u636E', '\u5DE8', '\u5177', '\u8DDD',   /* 0X4fd0-0X4fdf  */
            '\u8E1E', '\u952F', '\u4FF1', '\u53E5', '\u60E7', '\u70AC', '\u5267', '\u6350', '\u9E43', '\u5A1F', '\u5026', '\u7737', '\u5377', '\u7EE2', '\u6485', '\u652B',   /* 0X4fe0-0X4fef  */
            '\u6289', '\u6398', '\u5014', '\u7235', '\u89C9', '\u51B3', '\u8BC0', '\u7EDD', '\u5747', '\u83CC', '\u94A7', '\u519B', '\u541B', '\u5CFB', '\uFFFD', '\uFFFD',   /* 0X4ff0-0X4fff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5000-0X500f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5010-0X501f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5020-0X502f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5030-0X503f  */
            '\uFFFD','\u4FCA','\u7AE3','\u6D5A','\u90E1','\u9A8F','\u5580','\u5496','\u5361','\u54AF','\u5F00','\u63E9','\u6977','\u51EF','\u6168','\u520A',   /* 0X5040-0X504f  */
            '\u582A','\u52D8','\u574E','\u780D','\u770B','\u5EB7','\u6177','\u7CE0','\u625B','\u6297','\u4EA2','\u7095','\u8003','\u62F7','\u70E4','\u9760',   /* 0X5050-0X505f  */
            '\u5777','\u82DB','\u67EF','\u68F5','\u78D5','\u9897','\u79D1','\u58F3','\u54B3','\u53EF','\u6E34','\u514B','\u523B','\u5BA2','\u8BFE','\u80AF',   /* 0X5060-0X506f  */
            '\u5543','\u57A6','\u6073','\u5751','\u542D','\u7A7A','\u6050','\u5B54','\u63A7','\u62A0','\u53E3','\u6263','\u5BC7','\u67AF','\u54ED','\u7A9F',   /* 0X5070-0X507f  */
            '\uFFFD','\u82E6','\u9177','\u5E93','\u88E4','\u5938','\u57AE','\u630E','\u8DE8','\u80EF','\u5757','\u7B77','\u4FA9','\u5FEB','\u5BBD','\u6B3E',   /* 0X5080-0X508f  */
            '\u5321','\u7B50','\u72C2','\u6846','\u77FF','\u7736','\u65F7','\u51B5','\u4E8F','\u76D4','\u5CBF','\u7AA5','\u8475','\u594E','\u9B41','\u5080',   /* 0X5090-0X509f  */
            '\u9988','\u6127','\u6E83','\u5764','\u6606','\u6346','\u56F0','\u62EC','\u6269','\u5ED3','\u9614','\u5783','\u62C9','\u5587','\u8721','\u814A',   /* 0X50a0-0X50af  */
            '\u8FA3','\u5566','\u83B1','\u6765','\u8D56','\u84DD','\u5A6A','\u680F','\u62E6','\u7BEE','\u9611','\u5170','\u6F9C','\u8C30','\u63FD','\u89C8',   /* 0X50b0-0X50bf  */
            '\u61D2','\u7F06','\u70C2','\u6EE5','\u7405','\u6994','\u72FC','\u5ECA','\u90CE','\u6717','\u6D6A','\u635E','\u52B3','\u7262','\u8001','\u4F6C',   /* 0X50c0-0X50cf  */
            '\u59E5','\u916A','\u70D9','\u6D9D','\u52D2','\u4E50','\u96F7','\u956D','\u857E','\u78CA','\u7D2F','\u5121','\u5792','\u64C2','\u808B','\u7C7B',   /* 0X50d0-0X50df  */
            '\u6CEA','\u68F1','\u695E','\u51B7','\u5398','\u68A8','\u7281','\u9ECE','\u7BF1','\u72F8','\u79BB','\u6F13','\u7406','\u674E','\u91CC','\u9CA4',   /* 0X50e0-0X50ef  */
            '\u793C','\u8389','\u8354','\u540F','\u6817','\u4E3D','\u5389','\u52B1','\u783E','\u5386','\u5229','\u5088','\u4F8B','\u4FD0','\uFFFD','\uFFFD',   /* 0X50f0-0X50ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5100-0X510f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5110-0X511f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5120-0X512f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5130-0X513f  */
            '\uFFFD','\u75E2','\u7ACB','\u7C92','\u6CA5','\u96B6','\u529B','\u7483','\u54E9','\u4FE9','\u8054','\u83B2','\u8FDE','\u9570','\u5EC9','\u601C',   /* 0X5140-0X514f  */
            '\u6D9F','\u5E18','\u655B','\u8138','\u94FE','\u604B','\u70BC','\u7EC3','\u7CAE','\u51C9','\u6881','\u7CB1','\u826F','\u4E24','\u8F86','\u91CF',   /* 0X5150-0X515f  */
            '\u667E','\u4EAE','\u8C05','\u64A9','\u804A','\u50DA','\u7597','\u71CE','\u5BE5','\u8FBD','\u6F66','\u4E86','\u6482','\u9563','\u5ED6','\u6599',   /* 0X5160-0X516f  */
            '\u5217','\u88C2','\u70C8','\u52A3','\u730E','\u7433','\u6797','\u78F7','\u9716','\u4E34','\u90BB','\u9CDE','\u6DCB','\u51DB','\u8D41','\u541D',   /* 0X5170-0X517f  */
            '\uFFFD','\u62CE','\u73B2','\u83F1','\u96F6','\u9F84','\u94C3','\u4F36','\u7F9A','\u51CC','\u7075','\u9675','\u5CAD','\u9886','\u53E6','\u4EE4',   /* 0X5180-0X518f  */
            '\u6E9C','\u7409','\u69B4','\u786B','\u998F','\u7559','\u5218','\u7624','\u6D41','\u67F3','\u516D','\u9F99','\u804B','\u5499','\u7B3C','\u7ABF',   /* 0X5190-0X519f  */
            '\u9686','\u5784','\u62E2','\u9647','\u697C','\u5A04','\u6402','\u7BD3','\u6F0F','\u964B','\u82A6','\u5362','\u9885','\u5E90','\u7089','\u63B3',   /* 0X51a0-0X51af  */
            '\u5364','\u864F','\u9C81','\u9E93','\u788C','\u9732','\u8DEF','\u8D42','\u9E7F','\u6F5E','\u7984','\u5F55','\u9646','\u622E','\u9A74','\u5415',   /* 0X51b0-0X51bf  */
            '\u94DD','\u4FA3','\u65C5','\u5C65','\u5C61','\u7F15','\u8651','\u6C2F','\u5F8B','\u7387','\u6EE4','\u7EFF','\u5CE6','\u631B','\u5B6A','\u6EE6',   /* 0X51c0-0X51cf  */
            '\u5375','\u4E71','\u63A0','\u7565','\u62A1','\u8F6E','\u4F26','\u4ED1','\u6CA6','\u7EB6','\u8BBA','\u841D','\u87BA','\u7F57','\u903B','\u9523',   /* 0X51d0-0X51df  */
            '\u7BA9','\u9AA1','\u88F8','\u843D','\u6D1B','\u9A86','\u7EDC','\u5988','\u9EBB','\u739B','\u7801','\u8682','\u9A6C','\u9A82','\u561B','\u5417',   /* 0X51e0-0X51ef  */
            '\u57CB','\u4E70','\u9EA6','\u5356','\u8FC8','\u8109','\u7792','\u9992','\u86EE','\u6EE1','\u8513','\u66FC','\u6162','\u6F2B','\uFFFD','\uFFFD',   /* 0X51f0-0X51ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5200-0X520f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5210-0X521f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5220-0X522f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5230-0X523f  */
            '\uFFFD','\u8C29','\u8292','\u832B','\u76F2','\u6C13','\u5FD9','\u83BD','\u732B','\u8305','\u951A','\u6BDB','\u77DB','\u94C6','\u536F','\u8302',   /* 0X5240-0X524f  */
            '\u5192','\u5E3D','\u8C8C','\u8D38','\u4E48','\u73AB','\u679A','\u6885','\u9176','\u9709','\u7164','\u6CA1','\u7709','\u5A92','\u9541','\u6BCF',   /* 0X5250-0X525f  */
            '\u7F8E','\u6627','\u5BD0','\u59B9','\u5A9A','\u95E8','\u95F7','\u4EEC','\u840C','\u8499','\u6AAC','\u76DF','\u9530','\u731B','\u68A6','\u5B5F',   /* 0X5260-0X526f  */
            '\u772F','\u919A','\u9761','\u7CDC','\u8FF7','\u8C1C','\u5F25','\u7C73','\u79D8','\u89C5','\u6CCC','\u871C','\u5BC6','\u5E42','\u68C9','\u7720',   /* 0X5270-0X527f  */
            '\uFFFD','\u7EF5','\u5195','\u514D','\u52C9','\u5A29','\u7F05','\u9762','\u82D7','\u63CF','\u7784','\u85D0','\u79D2','\u6E3A','\u5E99','\u5999',   /* 0X5280-0X528f  */
            '\u8511','\u706D','\u6C11','\u62BF','\u76BF','\u654F','\u60AF','\u95FD','\u660E','\u879F','\u9E23','\u94ED','\u540D','\u547D','\u8C2C','\u6478',   /* 0X5290-0X529f  */
            '\u6479','\u8611','\u6A21','\u819C','\u78E8','\u6469','\u9B54','\u62B9','\u672B','\u83AB','\u58A8','\u9ED8','\u6CAB','\u6F20','\u5BDE','\u964C',   /* 0X52a0-0X52af  */
            '\u8C0B','\u725F','\u67D0','\u62C7','\u7261','\u4EA9','\u59C6','\u6BCD','\u5893','\u66AE','\u5E55','\u52DF','\u6155','\u6728','\u76EE','\u7766',   /* 0X52b0-0X52bf  */
            '\u7267','\u7A46','\u62FF','\u54EA','\u5450','\u94A0','\u90A3','\u5A1C','\u7EB3','\u6C16','\u4E43','\u5976','\u8010','\u5948','\u5357','\u7537',   /* 0X52c0-0X52cf  */
            '\u96BE','\u56CA','\u6320','\u8111','\u607C','\u95F9','\u6DD6','\u5462','\u9981','\u5185','\u5AE9','\u80FD','\u59AE','\u9713','\u502A','\u6CE5',   /* 0X52d0-0X52df  */
            '\u5C3C','\u62DF','\u4F60','\u533F','\u817B','\u9006','\u6EBA','\u852B','\u62C8','\u5E74','\u78BE','\u64B5','\u637B','\u5FF5','\u5A18','\u917F',   /* 0X52e0-0X52ef  */
            '\u9E1F','\u5C3F','\u634F','\u8042','\u5B7D','\u556E','\u954A','\u954D','\u6D85','\u60A8','\u67E0','\u72DE','\u51DD','\u5B81','\uFFFD','\uFFFD',   /* 0X52f0-0X52ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5300-0X530f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5310-0X531f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5320-0X532f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5330-0X533f  */
            '\uFFFD','\u62E7','\u6CDE','\u725B','\u626D','\u94AE','\u7EBD','\u8113','\u6D53','\u519C','\u5F04','\u5974','\u52AA','\u6012','\u5973','\u6696',   /* 0X5340-0X534f  */
            '\u8650','\u759F','\u632A','\u61E6','\u7CEF','\u8BFA','\u54E6','\u6B27','\u9E25','\u6BB4','\u85D5','\u5455','\u5076','\u6CA4','\u556A','\u8DB4',   /* 0X5350-0X535f  */
            '\u722C','\u5E15','\u6015','\u7436','\u62CD','\u6392','\u724C','\u5F98','\u6E43','\u6D3E','\u6500','\u6F58','\u76D8','\u78D0','\u76FC','\u7554',   /* 0X5360-0X536f  */
            '\u5224','\u53DB','\u4E53','\u5E9E','\u65C1','\u802A','\u80D6','\u629B','\u5486','\u5228','\u70AE','\u888D','\u8DD1','\u6CE1','\u5478','\u80DA',   /* 0X5370-0X537f  */
            '\uFFFD','\u57F9','\u88F4','\u8D54','\u966A','\u914D','\u4F69','\u6C9B','\u55B7','\u76C6','\u7830','\u62A8','\u70F9','\u6F8E','\u5F6D','\u84EC',   /* 0X5380-0X538f  */
            '\u68DA','\u787C','\u7BF7','\u81A8','\u670B','\u9E4F','\u6367','\u78B0','\u576F','\u7812','\u9739','\u6279','\u62AB','\u5288','\u7435','\u6BD7',   /* 0X5390-0X539f  */
            '\u5564','\u813E','\u75B2','\u76AE','\u5339','\u75DE','\u50FB','\u5C41','\u8B6C','\u7BC7','\u504F','\u7247','\u9A97','\u98D8','\u6F02','\u74E2',   /* 0X53a0-0X53af  */
            '\u7968','\u6487','\u77A5','\u62FC','\u9891','\u8D2B','\u54C1','\u8058','\u4E52','\u576A','\u82F9','\u840D','\u5E73','\u51ED','\u74F6','\u8BC4',   /* 0X53b0-0X53bf  */
            '\u5C4F','\u5761','\u6CFC','\u9887','\u5A46','\u7834','\u9B44','\u8FEB','\u7C95','\u5256','\u6251','\u94FA','\u4EC6','\u8386','\u8461','\u83E9',   /* 0X53c0-0X53cf  */
            '\u84B2','\u57D4','\u6734','\u5703','\u666E','\u6D66','\u8C31','\u66DD','\u7011','\u671F','\u6B3A','\u6816','\u621A','\u59BB','\u4E03','\u51C4',   /* 0X53d0-0X53df  */
            '\u6F06','\u67D2','\u6C8F','\u5176','\u68CB','\u5947','\u6B67','\u7566','\u5D0E','\u8110','\u9F50','\u65D7','\u7948','\u7941','\u9A91','\u8D77',   /* 0X53e0-0X53ef  */
            '\u5C82','\u4E5E','\u4F01','\u542F','\u5951','\u780C','\u5668','\u6C14','\u8FC4','\u5F03','\u6C7D','\u6CE3','\u8BAB','\u6390','\uFFFD','\uFFFD',   /* 0X53f0-0X53ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5400-0X540f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5410-0X541f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5420-0X542f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5430-0X543f  */
            '\uFFFD','\u6070','\u6D3D','\u7275','\u6266','\u948E','\u94C5','\u5343','\u8FC1','\u7B7E','\u4EDF','\u8C26','\u4E7E','\u9ED4','\u94B1','\u94B3',   /* 0X5440-0X544f  */
            '\u524D','\u6F5C','\u9063','\u6D45','\u8C34','\u5811','\u5D4C','\u6B20','\u6B49','\u67AA','\u545B','\u8154','\u7F8C','\u5899','\u8537','\u5F3A',   /* 0X5450-0X545f  */
            '\u62A2','\u6A47','\u9539','\u6572','\u6084','\u6865','\u77A7','\u4E54','\u4FA8','\u5DE7','\u9798','\u64AC','\u7FD8','\u5CED','\u4FCF','\u7A8D',   /* 0X5460-0X546f  */
            '\u5207','\u8304','\u4E14','\u602F','\u7A83','\u94A6','\u4FB5','\u4EB2','\u79E6','\u7434','\u52E4','\u82B9','\u64D2','\u79BD','\u5BDD','\u6C81',   /* 0X5470-0X547f  */
            '\uFFFD','\u9752','\u8F7B','\u6C22','\u503E','\u537F','\u6E05','\u64CE','\u6674','\u6C30','\u60C5','\u9877','\u8BF7','\u5E86','\u743C','\u7A77',   /* 0X5480-0X548f  */
            '\u79CB','\u4E18','\u90B1','\u7403','\u6C42','\u56DA','\u914B','\u6CC5','\u8D8B','\u533A','\u86C6','\u66F2','\u8EAF','\u5C48','\u9A71','\u6E20',   /* 0X5490-0X549f  */
            '\u53D6','\u5A36','\u9F8B','\u8DA3','\u53BB','\u5708','\u98A7','\u6743','\u919B','\u6CC9','\u5168','\u75CA','\u62F3','\u72AC','\u5238','\u529D',   /* 0X54a0-0X54af  */
            '\u7F3A','\u7094','\u7638','\u5374','\u9E4A','\u69B7','\u786E','\u96C0','\u88D9','\u7FA4','\u7136','\u71C3','\u5189','\u67D3','\u74E4','\u58E4',   /* 0X54b0-0X54bf  */
            '\u6518','\u56B7','\u8BA9','\u9976','\u6270','\u7ED5','\u60F9','\u70ED','\u58EC','\u4EC1','\u4EBA','\u5FCD','\u97E7','\u4EFB','\u8BA4','\u5203',   /* 0X54c0-0X54cf  */
            '\u598A','\u7EAB','\u6254','\u4ECD','\u65E5','\u620E','\u8338','\u84C9','\u8363','\u878D','\u7194','\u6EB6','\u5BB9','\u7ED2','\u5197','\u63C9',   /* 0X54d0-0X54df  */
            '\u67D4','\u8089','\u8339','\u8815','\u5112','\u5B7A','\u5982','\u8FB1','\u4E73','\u6C5D','\u5165','\u8925','\u8F6F','\u962E','\u854A','\u745E',   /* 0X54e0-0X54ef  */
            '\u9510','\u95F0','\u6DA6','\u82E5','\u5F31','\u6492','\u6D12','\u8428','\u816E','\u9CC3','\u585E','\u8D5B','\u4E09','\u53C1','\uFFFD','\uFFFD',   /* 0X54f0-0X54ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5500-0X550f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5510-0X551f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5520-0X552f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5530-0X553f  */
            '\uFFFD','\u4F1E','\u6563','\u6851','\u55D3','\u4E27','\u6414','\u9A9A','\u626B','\u5AC2','\u745F','\u8272','\u6DA9','\u68EE','\u50E7','\u838E',   /* 0X5540-0X554f  */
            '\u7802','\u6740','\u5239','\u6C99','\u7EB1','\u50BB','\u5565','\u715E','\u7B5B','\u6652','\u73CA','\u82EB','\u6749','\u5C71','\u5220','\u717D',   /* 0X5550-0X555f  */
            '\u886B','\u95EA','\u9655','\u64C5','\u8D61','\u81B3','\u5584','\u6C55','\u6247','\u7F2E','\u5892','\u4F24','\u5546','\u8D4F','\u664C','\u4E0A',   /* 0X5560-0X556f  */
            '\u5C1A','\u88F3','\u68A2','\u634E','\u7A0D','\u70E7','\u828D','\u52FA','\u97F6','\u5C11','\u54E8','\u90B5','\u7ECD','\u5962','\u8D4A','\u86C7',   /* 0X5570-0X557f  */
            '\uFFFD','\u820C','\u820D','\u8D66','\u6444','\u5C04','\u6151','\u6D89','\u793E','\u8BBE','\u7837','\u7533','\u547B','\u4F38','\u8EAB','\u6DF1',   /* 0X5580-0X558f  */
            '\u5A20','\u7EC5','\u795E','\u6C88','\u5BA1','\u5A76','\u751A','\u80BE','\u614E','\u6E17','\u58F0','\u751F','\u7525','\u7272','\u5347','\u7EF3',   /* 0X5590-0X559f  */
            '\u7701','\u76DB','\u5269','\u80DC','\u5723','\u5E08','\u5931','\u72EE','\u65BD','\u6E7F','\u8BD7','\u5C38','\u8671','\u5341','\u77F3','\u62FE',   /* 0X55a0-0X55af  */
            '\u65F6','\u4EC0','\u98DF','\u8680','\u5B9E','\u8BC6','\u53F2','\u77E2','\u4F7F','\u5C4E','\u9A76','\u59CB','\u5F0F','\u793A','\u58EB','\u4E16',   /* 0X55b0-0X55bf  */
            '\u67FF','\u4E8B','\u62ED','\u8A93','\u901D','\u52BF','\u662F','\u55DC','\u566C','\u9002','\u4ED5','\u4F8D','\u91CA','\u9970','\u6C0F','\u5E02',   /* 0X55c0-0X55cf  */
            '\u6043','\u5BA4','\u89C6','\u8BD5','\u6536','\u624B','\u9996','\u5B88','\u5BFF','\u6388','\u552E','\u53D7','\u7626','\u517D','\u852C','\u67A2',   /* 0X55d0-0X55df  */
            '\u68B3','\u6B8A','\u6292','\u8F93','\u53D4','\u8212','\u6DD1','\u758F','\u4E66','\u8D4E','\u5B70','\u719F','\u85AF','\u6691','\u66D9','\u7F72',   /* 0X55e0-0X55ef  */
            '\u8700','\u9ECD','\u9F20','\u5C5E','\u672F','\u8FF0','\u6811','\u675F','\u620D','\u7AD6','\u5885','\u5EB6','\u6570','\u6F31','\uFFFD','\uFFFD',   /* 0X55f0-0X55ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5600-0X560f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5610-0X561f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5620-0X562f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5630-0X563f  */
            '\uFFFD','\u6055','\u5237','\u800D','\u6454','\u8870','\u7529','\u5E05','\u6813','\u62F4','\u971C','\u53CC','\u723D','\u8C01','\u6C34','\u7761',   /* 0X5640-0X564f  */
            '\u7A0E','\u542E','\u77AC','\u987A','\u821C','\u8BF4','\u7855','\u6714','\u70C1','\u65AF','\u6495','\u5636','\u601D','\u79C1','\u53F8','\u4E1D',   /* 0X5650-0X565f  */
            '\u6B7B','\u8086','\u5BFA','\u55E3','\u56DB','\u4F3A','\u4F3C','\u9972','\u5DF3','\u677E','\u8038','\u6002','\u9882','\u9001','\u5B8B','\u8BBC',   /* 0X5660-0X566f  */
            '\u8BF5','\u641C','\u8258','\u64DE','\u55FD','\u82CF','\u9165','\u4FD7','\u7D20','\u901F','\u7C9F','\u50F3','\u5851','\u6EAF','\u5BBF','\u8BC9',   /* 0X5670-0X567f  */
            '\uFFFD','\u8083','\u9178','\u849C','\u7B97','\u867D','\u968B','\u968F','\u7EE5','\u9AD3','\u788E','\u5C81','\u7A57','\u9042','\u96A7','\u795F',   /* 0X5680-0X568f  */
            '\u5B59','\u635F','\u7B0B','\u84D1','\u68AD','\u5506','\u7F29','\u7410','\u7D22','\u9501','\u6240','\u584C','\u4ED6','\u5B83','\u5979','\u5854',   /* 0X5690-0X569f  */
            '\u736D','\u631E','\u8E4B','\u8E0F','\u80CE','\u82D4','\u62AC','\u53F0','\u6CF0','\u915E','\u592A','\u6001','\u6C70','\u574D','\u644A','\u8D2A',   /* 0X56a0-0X56af  */
            '\u762B','\u6EE9','\u575B','\u6A80','\u75F0','\u6F6D','\u8C2D','\u8C08','\u5766','\u6BEF','\u8892','\u78B3','\u63A2','\u53F9','\u70AD','\u6C64',   /* 0X56b0-0X56bf  */
            '\u5858','\u642A','\u5802','\u68E0','\u819B','\u5510','\u7CD6','\u5018','\u8EBA','\u6DCC','\u8D9F','\u70EB','\u638F','\u6D9B','\u6ED4','\u7EE6',   /* 0X56c0-0X56cf  */
            '\u8404','\u6843','\u9003','\u6DD8','\u9676','\u8BA8','\u5957','\u7279','\u85E4','\u817E','\u75BC','\u8A8A','\u68AF','\u5254','\u8E22','\u9511',   /* 0X56d0-0X56df  */
            '\u63D0','\u9898','\u8E44','\u557C','\u4F53','\u66FF','\u568F','\u60D5','\u6D95','\u5243','\u5C49','\u5929','\u6DFB','\u586B','\u7530','\u751C',   /* 0X56e0-0X56ef  */
            '\u606C','\u8214','\u8146','\u6311','\u6761','\u8FE2','\u773A','\u8DF3','\u8D34','\u94C1','\u5E16','\u5385','\u542C','\u70C3','\uFFFD','\uFFFD',   /* 0X56f0-0X56ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5700-0X570f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5710-0X571f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5720-0X572f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5730-0X573f  */
            '\uFFFD','\u6C40','\u5EF7','\u505C','\u4EAD','\u5EAD','\u633A','\u8247','\u901A','\u6850','\u916E','\u77B3','\u540C','\u94DC','\u5F64','\u7AE5',   /* 0X5740-0X574f  */
            '\u6876','\u6345','\u7B52','\u7EDF','\u75DB','\u5077','\u6295','\u5934','\u900F','\u51F8','\u79C3','\u7A81','\u56FE','\u5F92','\u9014','\u6D82',   /* 0X5750-0X575f  */
            '\u5C60','\u571F','\u5410','\u5154','\u6E4D','\u56E2','\u63A8','\u9893','\u817F','\u8715','\u892A','\u9000','\u541E','\u5C6F','\u81C0','\u62D6',   /* 0X5760-0X576f  */
            '\u6258','\u8131','\u9E35','\u9640','\u9A6E','\u9A7C','\u692D','\u59A5','\u62D3','\u553E','\u6316','\u54C7','\u86D9','\u6D3C','\u5A03','\u74E6',   /* 0X5770-0X577f  */
            '\uFFFD','\u889C','\u6B6A','\u5916','\u8C4C','\u5F2F','\u6E7E','\u73A9','\u987D','\u4E38','\u70F7','\u5B8C','\u7897','\u633D','\u665A','\u7696',   /* 0X5780-0X578f  */
            '\u60CB','\u5B9B','\u5A49','\u4E07','\u8155','\u6C6A','\u738B','\u4EA1','\u6789','\u7F51','\u5F80','\u65FA','\u671B','\u5FD8','\u5984','\u5A01',   /* 0X5790-0X579f  */
            '\u5DCD','\u5FAE','\u5371','\u97E6','\u8FDD','\u6845','\u56F4','\u552F','\u60DF','\u4E3A','\u6F4D','\u7EF4','\u82C7','\u840E','\u59D4','\u4F1F',   /* 0X57a0-0X57af  */
            '\u4F2A','\u5C3E','\u7EAC','\u672A','\u851A','\u5473','\u754F','\u80C3','\u5582','\u9B4F','\u4F4D','\u6E2D','\u8C13','\u5C09','\u6170','\u536B',   /* 0X57b0-0X57bf  */
            '\u761F','\u6E29','\u868A','\u6587','\u95FB','\u7EB9','\u543B','\u7A33','\u7D0A','\u95EE','\u55E1','\u7FC1','\u74EE','\u631D','\u8717','\u6DA1',   /* 0X57c0-0X57cf  */
            '\u7A9D','\u6211','\u65A1','\u5367','\u63E1','\u6C83','\u5DEB','\u545C','\u94A8','\u4E4C','\u6C61','\u8BEC','\u5C4B','\u65E0','\u829C','\u68A7',   /* 0X57d0-0X57df  */
            '\u543E','\u5434','\u6BCB','\u6B66','\u4E94','\u6342','\u5348','\u821E','\u4F0D','\u4FAE','\u575E','\u620A','\u96FE','\u6664','\u7269','\u52FF',   /* 0X57e0-0X57ef  */
            '\u52A1','\u609F','\u8BEF','\u6614','\u7199','\u6790','\u897F','\u7852','\u77FD','\u6670','\u563B','\u5438','\u9521','\u727A','\uFFFD','\uFFFD',   /* 0X57f0-0X57ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5800-0X580f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5810-0X581f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5820-0X582f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5830-0X583f  */
            '\uFFFD','\u7A00','\u606F','\u5E0C','\u6089','\u819D','\u5915','\u60DC','\u7184','\u70EF','\u6EAA','\u6C50','\u7280','\u6A84','\u88AD','\u5E2D',   /* 0X5840-0X584f  */
            '\u4E60','\u5AB3','\u559C','\u94E3','\u6D17','\u7CFB','\u9699','\u620F','\u7EC6','\u778E','\u867E','\u5323','\u971E','\u8F96','\u6687','\u5CE1',   /* 0X5850-0X585f  */
            '\u4FA0','\u72ED','\u4E0B','\u53A6','\u590F','\u5413','\u6380','\u9528','\u5148','\u4ED9','\u9C9C','\u7EA4','\u54B8','\u8D24','\u8854','\u8237',   /* 0X5860-0X586f  */
            '\u95F2','\u6D8E','\u5F26','\u5ACC','\u663E','\u9669','\u73B0','\u732E','\u53BF','\u817A','\u9985','\u7FA1','\u5BAA','\u9677','\u9650','\u7EBF',   /* 0X5870-0X587f  */
            '\uFFFD','\u76F8','\u53A2','\u9576','\u9999','\u7BB1','\u8944','\u6E58','\u4E61','\u7FD4','\u7965','\u8BE6','\u60F3','\u54CD','\u4EAB','\u9879',   /* 0X5880-0X588f  */
            '\u5DF7','\u6A61','\u50CF','\u5411','\u8C61','\u8427','\u785D','\u9704','\u524A','\u54EE','\u56A3','\u9500','\u6D88','\u5BB5','\u6DC6','\u6653',   /* 0X5890-0X589f  */
            '\u5C0F','\u5B5D','\u6821','\u8096','\u5578','\u7B11','\u6548','\u6954','\u4E9B','\u6B47','\u874E','\u978B','\u534F','\u631F','\u643A','\u90AA',   /* 0X58a0-0X58af  */
            '\u659C','\u80C1','\u8C10','\u5199','\u68B0','\u5378','\u87F9','\u61C8','\u6CC4','\u6CFB','\u8C22','\u5C51','\u85AA','\u82AF','\u950C','\u6B23',   /* 0X58b0-0X58bf  */
            '\u8F9B','\u65B0','\u5FFB','\u5FC3','\u4FE1','\u8845','\u661F','\u8165','\u7329','\u60FA','\u5174','\u5211','\u578B','\u5F62','\u90A2','\u884C',   /* 0X58c0-0X58cf  */
            '\u9192','\u5E78','\u674F','\u6027','\u59D3','\u5144','\u51F6','\u80F8','\u5308','\u6C79','\u96C4','\u718A','\u4F11','\u4FEE','\u7F9E','\u673D',   /* 0X58d0-0X58df  */
            '\u55C5','\u9508','\u79C0','\u8896','\u7EE3','\u589F','\u620C','\u9700','\u865A','\u5618','\u987B','\u5F90','\u8BB8','\u84C4','\u9157','\u53D9',   /* 0X58e0-0X58ef  */
            '\u65ED','\u5E8F','\u755C','\u6064','\u7D6E','\u5A7F','\u7EEA','\u7EED','\u8F69','\u55A7','\u5BA3','\u60AC','\u65CB','\u7384','\uFFFD','\uFFFD',   /* 0X58f0-0X58ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5900-0X590f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5910-0X591f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5920-0X592f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5930-0X593f  */
            '\uFFFD','\u9009','\u7663','\u7729','\u7EDA','\u9774','\u859B','\u5B66','\u7A74','\u96EA','\u8840','\u52CB','\u718F','\u5FAA','\u65EC','\u8BE2',   /* 0X5940-0X594f  */
            '\u5BFB','\u9A6F','\u5DE1','\u6B89','\u6C5B','\u8BAD','\u8BAF','\u900A','\u8FC5','\u538B','\u62BC','\u9E26','\u9E2D','\u5440','\u4E2B','\u82BD',   /* 0X5950-0X595f  */
            '\u7259','\u869C','\u5D16','\u8859','\u6DAF','\u96C5','\u54D1','\u4E9A','\u8BB6','\u7109','\u54BD','\u9609','\u70DF','\u6DF9','\u76D0','\u4E25',   /* 0X5960-0X596f  */
            '\u7814','\u8712','\u5CA9','\u5EF6','\u8A00','\u989C','\u960E','\u708E','\u6CBF','\u5944','\u63A9','\u773C','\u884D','\u6F14','\u8273','\u5830',   /* 0X5970-0X597f  */
            '\uFFFD','\u71D5','\u538C','\u781A','\u96C1','\u5501','\u5F66','\u7130','\u5BB4','\u8C1A','\u9A8C','\u6B83','\u592E','\u9E2F','\u79E7','\u6768',   /* 0X5980-0X598f  */
            '\u626C','\u4F6F','\u75A1','\u7F8A','\u6D0B','\u9633','\u6C27','\u4EF0','\u75D2','\u517B','\u6837','\u6F3E','\u9080','\u8170','\u5996','\u7476',   /* 0X5990-0X599f  */
            '\u6447','\u5C27','\u9065','\u7A91','\u8C23','\u59DA','\u54AC','\u8200','\u836F','\u8981','\u8000','\u6930','\u564E','\u8036','\u7237','\u91CE',   /* 0X59a0-0X59af  */
            '\u51B6','\u4E5F','\u9875','\u6396','\u4E1A','\u53F6','\u66F3','\u814B','\u591C','\u6DB2','\u4E00','\u58F9','\u533B','\u63D6','\u94F1','\u4F9D',   /* 0X59b0-0X59bf  */
            '\u4F0A','\u8863','\u9890','\u5937','\u9057','\u79FB','\u4EEA','\u80F0','\u7591','\u6C82','\u5B9C','\u59E8','\u5F5D','\u6905','\u8681','\u501A',   /* 0X59c0-0X59cf  */
            '\u5DF2','\u4E59','\u77E3','\u4EE5','\u827A','\u6291','\u6613','\u9091','\u5C79','\u4EBF','\u5F79','\u81C6','\u9038','\u8084','\u75AB','\u4EA6',   /* 0X59d0-0X59df  */
            '\u88D4','\u610F','\u6BC5','\u5FC6','\u4E49','\u76CA','\u6EA2','\u8BE3','\u8BAE','\u8C0A','\u8BD1','\u5F02','\u7FFC','\u7FCC','\u7ECE','\u8335',   /* 0X59e0-0X59ef  */
            '\u836B','\u56E0','\u6BB7','\u97F3','\u9634','\u59FB','\u541F','\u94F6','\u6DEB','\u5BC5','\u996E','\u5C39','\u5F15','\u9690','\uFFFD','\uFFFD',   /* 0X59f0-0X59ff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5a00-0X5a0f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5a10-0X5a1f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5a20-0X5a2f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5a30-0X5a3f  */
            '\uFFFD','\u5370','\u82F1','\u6A31','\u5A74','\u9E70','\u5E94','\u7F28','\u83B9','\u8424','\u8425','\u8367','\u8747','\u8FCE','\u8D62','\u76C8',   /* 0X5a40-0X5a4f  */
            '\u5F71','\u9896','\u786C','\u6620','\u54DF','\u62E5','\u4F63','\u81C3','\u75C8','\u5EB8','\u96CD','\u8E0A','\u86F9','\u548F','\u6CF3','\u6D8C',   /* 0X5a50-0X5a5f  */
            '\u6C38','\u607F','\u52C7','\u7528','\u5E7D','\u4F18','\u60A0','\u5FE7','\u5C24','\u7531','\u90AE','\u94C0','\u72B9','\u6CB9','\u6E38','\u9149',   /* 0X5a60-0X5a6f  */
            '\u6709','\u53CB','\u53F3','\u4F51','\u91C9','\u8BF1','\u53C8','\u5E7C','\u8FC2','\u6DE4','\u4E8E','\u76C2','\u6986','\u865E','\u611A','\u8206',   /* 0X5a70-0X5a7f  */
            '\uFFFD','\u4F59','\u4FDE','\u903E','\u9C7C','\u6109','\u6E1D','\u6E14','\u9685','\u4E88','\u5A31','\u96E8','\u4E0E','\u5C7F','\u79B9','\u5B87',   /* 0X5a80-0X5a8f  */
            '\u8BED','\u7FBD','\u7389','\u57DF','\u828B','\u90C1','\u5401','\u9047','\u55BB','\u5CEA','\u5FA1','\u6108','\u6B32','\u72F1','\u80B2','\u8A89',   /* 0X5a90-0X5a9f  */
            '\u6D74','\u5BD3','\u88D5','\u9884','\u8C6B','\u9A6D','\u9E33','\u6E0A','\u51A4','\u5143','\u57A3','\u8881','\u539F','\u63F4','\u8F95','\u56ED',   /* 0X5aa0-0X5aaf  */
            '\u5458','\u5706','\u733F','\u6E90','\u7F18','\u8FDC','\u82D1','\u613F','\u6028','\u9662','\u66F0','\u7EA6','\u8D8A','\u8DC3','\u94A5','\u5CB3',   /* 0X5ab0-0X5abf  */
            '\u7CA4','\u6708','\u60A6','\u9605','\u8018','\u4E91','\u90E7','\u5300','\u9668','\u5141','\u8FD0','\u8574','\u915D','\u6655','\u97F5','\u5B55',   /* 0X5ac0-0X5acf  */
            '\u531D','\u7838','\u6742','\u683D','\u54C9','\u707E','\u5BB0','\u8F7D','\u518D','\u5728','\u54B1','\u6512','\u6682','\u8D5E','\u8D43','\u810F',   /* 0X5ad0-0X5adf  */
            '\u846C','\u906D','\u7CDF','\u51FF','\u85FB','\u67A3','\u65E9','\u6FA1','\u86A4','\u8E81','\u566A','\u9020','\u7682','\u7076','\u71E5','\u8D23',   /* 0X5ae0-0X5aef  */
            '\u62E9','\u5219','\u6CFD','\u8D3C','\u600E','\u589E','\u618E','\u66FE','\u8D60','\u624E','\u55B3','\u6E23','\u672D','\u8F67','\uFFFD','\uFFFD',   /* 0X5af0-0X5aff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5b00-0X5b0f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5b10-0X5b1f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5b20-0X5b2f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5b30-0X5b3f  */
            '\uFFFD','\u94E1','\u95F8','\u7728','\u6805','\u69A8','\u548B','\u4E4D','\u70B8','\u8BC8','\u6458','\u658B','\u5B85','\u7A84','\u503A','\u5BE8',   /* 0X5b40-0X5b4f  */
            '\u77BB','\u6BE1','\u8A79','\u7C98','\u6CBE','\u76CF','\u65A9','\u8F97','\u5D2D','\u5C55','\u8638','\u6808','\u5360','\u6218','\u7AD9','\u6E5B',   /* 0X5b50-0X5b5f  */
            '\u7EFD','\u6A1F','\u7AE0','\u5F70','\u6F33','\u5F20','\u638C','\u6DA8','\u6756','\u4E08','\u5E10','\u8D26','\u4ED7','\u80C0','\u7634','\u969C',   /* 0X5b60-0X5b6f  */
            '\u62DB','\u662D','\u627E','\u6CBC','\u8D75','\u7167','\u7F69','\u5146','\u8087','\u53EC','\u906E','\u6298','\u54F2','\u86F0','\u8F99','\u8005',   /* 0X5b70-0X5b7f  */
            '\uFFFD','\u9517','\u8517','\u8FD9','\u6D59','\u73CD','\u659F','\u771F','\u7504','\u7827','\u81FB','\u8D1E','\u9488','\u4FA6','\u6795','\u75B9',   /* 0X5b80-0X5b8f  */
            '\u8BCA','\u9707','\u632F','\u9547','\u9635','\u84B8','\u6323','\u7741','\u5F81','\u72F0','\u4E89','\u6014','\u6574','\u62EF','\u6B63','\u653F',   /* 0X5b90-0X5b9f  */
            '\u5E27','\u75C7','\u90D1','\u8BC1','\u829D','\u679D','\u652F','\u5431','\u8718','\u77E5','\u80A2','\u8102','\u6C41','\u4E4B','\u7EC7','\u804C',   /* 0X5ba0-0X5baf  */
            '\u76F4','\u690D','\u6B96','\u6267','\u503C','\u4F84','\u5740','\u6307','\u6B62','\u8DBE','\u53EA','\u65E8','\u7EB8','\u5FD7','\u631A','\u63B7',   /* 0X5bb0-0X5bbf  */
            '\u81F3','\u81F4','\u7F6E','\u5E1C','\u5CD9','\u5236','\u667A','\u79E9','\u7A1A','\u8D28','\u7099','\u75D4','\u6EDE','\u6CBB','\u7A92','\u4E2D',   /* 0X5bc0-0X5bcf  */
            '\u76C5','\u5FE0','\u949F','\u8877','\u7EC8','\u79CD','\u80BF','\u91CD','\u4EF2','\u4F17','\u821F','\u5468','\u5DDE','\u6D32','\u8BCC','\u7CA5',   /* 0X5bd0-0X5bdf  */
            '\u8F74','\u8098','\u5E1A','\u5492','\u76B1','\u5B99','\u663C','\u9AA4','\u73E0','\u682A','\u86DB','\u6731','\u732A','\u8BF8','\u8BDB','\u9010',   /* 0X5be0-0X5bef  */
            '\u7AF9','\u70DB','\u716E','\u62C4','\u77A9','\u5631','\u4E3B','\u8457','\u67F1','\u52A9','\u86C0','\u8D2E','\u94F8','\u7B51','\uFFFD','\uFFFD',   /* 0X5bf0-0X5bff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5c00-0X5c0f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5c10-0X5c1f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5c20-0X5c2f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5c30-0X5c3f  */
            '\uFFFD','\u4F4F','\u6CE8','\u795D','\u9A7B','\u6293','\u722A','\u62FD','\u4E13','\u7816','\u8F6C','\u64B0','\u8D5A','\u7BC6','\u6869','\u5E84',   /* 0X5c40-0X5c4f  */
            '\u88C5','\u5986','\u649E','\u58EE','\u72B6','\u690E','\u9525','\u8FFD','\u8D58','\u5760','\u7F00','\u8C06','\u51C6','\u6349','\u62D9','\u5353',   /* 0X5c50-0X5c5f  */
            '\u684C','\u7422','\u8301','\u914C','\u5544','\u7740','\u707C','\u6D4A','\u5179','\u54A8','\u8D44','\u59FF','\u6ECB','\u6DC4','\u5B5C','\u7D2B',   /* 0X5c60-0X5c6f  */
            '\u4ED4','\u7C7D','\u6ED3','\u5B50','\u81EA','\u6E0D','\u5B57','\u9B03','\u68D5','\u8E2A','\u5B97','\u7EFC','\u603B','\u7EB5','\u90B9','\u8D70',   /* 0X5c70-0X5c7f  */
            '\uFFFD','\u594F','\u63CD','\u79DF','\u8DB3','\u5352','\u65CF','\u7956','\u8BC5','\u963B','\u7EC4','\u94BB','\u7E82','\u5634','\u9189','\u6700',   /* 0X5c80-0X5c8f  */
            '\u7F6A','\u5C0A','\u9075','\u6628','\u5DE6','\u4F50','\u67DE','\u505A','\u4F5C','\u5750','\u5EA7','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5c90-0X5c9f  */
            '\u4E8D','\u4E0C','\u5140','\u4E10','\u5EFF','\u5345','\u4E15','\u4E98','\u4E1E','\u9B32','\u5B6C','\u5669','\u4E28','\u79BA','\u4E3F','\u5315',   /* 0X5ca0-0X5caf  */
            '\u4E47','\u592D','\u723B','\u536E','\u6C10','\u56DF','\u80E4','\u9997','\u6BD3','\u777E','\u9F17','\u4E36','\u4E9F','\u9F10','\u4E5C','\u4E69',   /* 0X5cb0-0X5cbf  */
            '\u4E93','\u8288','\u5B5B','\u556C','\u560F','\u4EC4','\u538D','\u539D','\u53A3','\u53A5','\u53AE','\u9765','\u8D5D','\u531A','\u53F5','\u5326',   /* 0X5cc0-0X5ccf  */
            '\u532E','\u533E','\u8D5C','\u5366','\u5363','\u5202','\u5208','\u520E','\u522D','\u5233','\u523F','\u5240','\u524C','\u525E','\u5261','\u525C',   /* 0X5cd0-0X5cdf  */
            '\u84AF','\u527D','\u5282','\u5281','\u5290','\u5293','\u5182','\u7F54','\u4EBB','\u4EC3','\u4EC9','\u4EC2','\u4EE8','\u4EE1','\u4EEB','\u4EDE',   /* 0X5ce0-0X5cef  */
            '\u4F1B','\u4EF3','\u4F22','\u4F64','\u4EF5','\u4F25','\u4F27','\u4F09','\u4F2B','\u4F5E','\u4F67','\u6538','\u4F5A','\u4F5D','\uFFFD','\uFFFD',   /* 0X5cf0-0X5cff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5d00-0X5d0f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5d10-0X5d1f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5d20-0X5d2f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5d30-0X5d3f  */
            '\uFFFD','\u4F5F','\u4F57','\u4F32','\u4F3D','\u4F76','\u4F74','\u4F91','\u4F89','\u4F83','\u4F8F','\u4F7E','\u4F7B','\u4FAA','\u4F7C','\u4FAC',   /* 0X5d40-0X5d4f  */
            '\u4F94','\u4FE6','\u4FE8','\u4FEA','\u4FC5','\u4FDA','\u4FE3','\u4FDC','\u4FD1','\u4FDF','\u4FF8','\u5029','\u504C','\u4FF3','\u502C','\u500F',   /* 0X5d50-0X5d5f  */
            '\u502E','\u502D','\u4FFE','\u501C','\u500C','\u5025','\u5028','\u507E','\u5043','\u5055','\u5048','\u504E','\u506C','\u507B','\u50A5','\u50A7',   /* 0X5d60-0X5d6f  */
            '\u50A9','\u50BA','\u50D6','\u5106','\u50ED','\u50EC','\u50E6','\u50EE','\u5107','\u510B','\u4EDD','\u6C3D','\u4F58','\u4F65','\u4FCE','\u9FA0',   /* 0X5d70-0X5d7f  */
            '\uFFFD','\u6C46','\u7C74','\u516E','\u5DFD','\u9EC9','\u9998','\u5181','\u5914','\u52F9','\u530D','\u8A07','\u5310','\u51EB','\u5919','\u5155',   /* 0X5d80-0X5d8f  */
            '\u4EA0','\u5156','\u4EB3','\u886E','\u88A4','\u4EB5','\u8114','\u88D2','\u7980','\u5B34','\u8803','\u7FB8','\u51AB','\u51B1','\u51BD','\u51BC',   /* 0X5d90-0X5d9f  */
            '\u51C7','\u5196','\u51A2','\u51A5','\u8BA0','\u8BA6','\u8BA7','\u8BAA','\u8BB4','\u8BB5','\u8BB7','\u8BC2','\u8BC3','\u8BCB','\u8BCF','\u8BCE',   /* 0X5da0-0X5daf  */
            '\u8BD2','\u8BD3','\u8BD4','\u8BD6','\u8BD8','\u8BD9','\u8BDC','\u8BDF','\u8BE0','\u8BE4','\u8BE8','\u8BE9','\u8BEE','\u8BF0','\u8BF3','\u8BF6',   /* 0X5db0-0X5dbf  */
            '\u8BF9','\u8BFC','\u8BFF','\u8C00','\u8C02','\u8C04','\u8C07','\u8C0C','\u8C0F','\u8C11','\u8C12','\u8C14','\u8C15','\u8C16','\u8C19','\u8C1B',   /* 0X5dc0-0X5dcf  */
            '\u8C18','\u8C1D','\u8C1F','\u8C20','\u8C21','\u8C25','\u8C27','\u8C2A','\u8C2B','\u8C2E','\u8C2F','\u8C32','\u8C33','\u8C35','\u8C36','\u5369',   /* 0X5dd0-0X5ddf  */
            '\u537A','\u961D','\u9622','\u9621','\u9631','\u962A','\u963D','\u963C','\u9642','\u9649','\u9654','\u965F','\u9667','\u966C','\u9672','\u9674',   /* 0X5de0-0X5def  */
            '\u9688','\u968D','\u9697','\u96B0','\u9097','\u909B','\u909D','\u9099','\u90AC','\u90A1','\u90B4','\u90B3','\u90B6','\u90BA','\uFFFD','\uFFFD',   /* 0X5df0-0X5dff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5e00-0X5e0f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5e10-0X5e1f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5e20-0X5e2f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5e30-0X5e3f  */
            '\uFFFD','\u90B8','\u90B0','\u90CF','\u90C5','\u90BE','\u90D0','\u90C4','\u90C7','\u90D3','\u90E6','\u90E2','\u90DC','\u90D7','\u90DB','\u90EB',   /* 0X5e40-0X5e4f  */
            '\u90EF','\u90FE','\u9104','\u9122','\u911E','\u9123','\u9131','\u912F','\u9139','\u9143','\u9146','\u520D','\u5942','\u52A2','\u52AC','\u52AD',   /* 0X5e50-0X5e5f  */
            '\u52BE','\u54FF','\u52D0','\u52D6','\u52F0','\u53DF','\u71EE','\u77CD','\u5EF4','\u51F5','\u51FC','\u9B2F','\u53B6','\u5F01','\u755A','\u5DEF',   /* 0X5e60-0X5e6f  */
            '\u574C','\u57A9','\u57A1','\u587E','\u58BC','\u58C5','\u58D1','\u5729','\u572C','\u572A','\u5733','\u5739','\u572E','\u572F','\u575C','\u573B',   /* 0X5e70-0X5e7f  */
            '\uFFFD','\u5742','\u5769','\u5785','\u576B','\u5786','\u577C','\u577B','\u5768','\u576D','\u5776','\u5773','\u57AD','\u57A4','\u578C','\u57B2',   /* 0X5e80-0X5e8f  */
            '\u57CF','\u57A7','\u57B4','\u5793','\u57A0','\u57D5','\u57D8','\u57DA','\u57D9','\u57D2','\u57B8','\u57F4','\u57EF','\u57F8','\u57E4','\u57DD',   /* 0X5e90-0X5e9f  */
            '\u580B','\u580D','\u57FD','\u57ED','\u5800','\u581E','\u5819','\u5844','\u5820','\u5865','\u586C','\u5881','\u5889','\u589A','\u5880','\u99A8',   /* 0X5ea0-0X5eaf  */
            '\u9F19','\u61FF','\u8279','\u827D','\u827F','\u828F','\u828A','\u82A8','\u8284','\u828E','\u8291','\u8297','\u8299','\u82AB','\u82B8','\u82BE',   /* 0X5eb0-0X5ebf  */
            '\u82B0','\u82C8','\u82CA','\u82E3','\u8298','\u82B7','\u82AE','\u82CB','\u82CC','\u82C1','\u82A9','\u82B4','\u82A1','\u82AA','\u829F','\u82C4',   /* 0X5ec0-0X5ecf  */
            '\u82CE','\u82A4','\u82E1','\u8309','\u82F7','\u82E4','\u830F','\u8307','\u82DC','\u82F4','\u82D2','\u82D8','\u830C','\u82FB','\u82D3','\u8311',   /* 0X5ed0-0X5edf  */
            '\u831A','\u8306','\u8314','\u8315','\u82E0','\u82D5','\u831C','\u8351','\u835B','\u835C','\u8308','\u8392','\u833C','\u8334','\u8331','\u839B',   /* 0X5ee0-0X5eef  */
            '\u835E','\u832F','\u834F','\u8347','\u8343','\u835F','\u8340','\u8317','\u8360','\u832D','\u833A','\u8333','\u8366','\u8365','\uFFFD','\uFFFD',   /* 0X5ef0-0X5eff  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5f00-0X5f0f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5f10-0X5f1f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5f20-0X5f2f  */
            '\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD','\uFFFD',   /* 0X5f30-0X5f3f  */
            '\uFFFD','\u8368','\u831B','\u8369','\u836C','\u836A','\u836D','\u836E','\u83B0','\u8378','\u83B3','\u83B4','\u83A0','\u83AA','\u8393','\u839C',   /* 0X5f40-0X5f4f  */
            '\u8385','\u837C','\u83B6','\u83A9','\u837D','\u83B8','\u837B','\u8398','\u839E','\u83A8','\u83BA','\u83BC','\u83C1','\u8401','\u83E5','\u83D8',   /* 0X5f50-0X5f5f  */
            '\u5807','\u8418','\u840B','\u83DD','\u83FD','\u83D6','\u841C','\u8438','\u8411','\u8406','\u83D4','\u83DF','\u840F','\u8403','\u83F8','\u83F9',   /* 0X5f60-0X5f6f  */
            '\u83EA','\u83C5','\u83C0','\u8426','\u83F0','\u83E1','\u845C','\u8451','\u845A','\u8459','\u8473','\u8487','\u8488','\u847A','\u8489','\u8478',   /* 0X5f70-0X5f7f  */
            '\uFFFD','\u843C','\u8446','\u8469','\u8476','\u848C','\u848E','\u8431','\u846D','\u84C1','\u84CD','\u84D0','\u84E6','\u84BD','\u84D3','\u84CA',   /* 0X5f80-0X5f8f  */
            '\u84BF','\u84BA','\u84E0','\u84A1','\u84B9','\u84B4','\u8497','\u84E5','\u84E3','\u850C','\u750D','\u8538','\u84F0','\u8539','\u851F','\u853A',   /* 0X5f90-0X5f9f  */
            '\u8556','\u853B','\u84FF','\u84FC','\u8559','\u8548','\u8568','\u8564','\u855E','\u857A','\u77A2','\u8543','\u8572','\u857B','\u85A4','\u85A8',   /* 0X5fa0-0X5faf  */
            '\u8587','\u858F','\u8579','\u85AE','\u859C','\u8585','\u85B9','\u85B7','\u85B0','\u85D3','\u85C1','\u85DC','\u85FF','\u8627','\u8605','\u8629',   /* 0X5fb0-0X5fbf  */
            '\u8616','\u863C','\u5EFE','\u5F08','\u593C','\u5941','\u8037','\u5955','\u595A','\u5958','\u530F','\u5C22','\u5C25','\u5C2C','\u5C34','\u624C',   /* 0X5fc0-0X5fcf  */
            '\u626A','\u629F','\u62BB','\u62CA','\u62DA','\u62D7','\u62EE','\u6322','\u62F6','\u6339','\u634B','\u6343','\u63AD','\u63F6','\u6371','\u637A',   /* 0X5fd0-0X5fdf  */
            '\u638E','\u63B4','\u636D','\u63AC','\u638A','\u6369','\u63AE','\u63BC','\u63F2','\u63F8','\u63E0','\u63FF','\u63C4','\u63DE','\u63CE','\u6452',   /* 0X5fe0-0X5fef  */
            '\u63C6','\u63BE','\u6445','\u6441','\u640B','\u641B','\u6420','\u640C','\u6426','\u6421','\u645E','\u6484','\u646D','\u6496','\uFFFD','\uFFFD'    /* 0X5ff0-0X5fff  */
    };

    public static char[] initialize(){
        return convertIndex;
    }
}

