package com.iota.curl;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by gianluigi.davassi on 13.10.16.
 */
public class HashTest {

    private static String in = "XWGITHVPWBSPFRNQUEYLQETIVCJKRIIDKUZ9CSXBH9BKKUZCOGNLPKZXZHEGGPPWLMQHKDDAHZBSFQTNCOEJMSOLMHRPRHNWEUUAEHJURKTFWZQPSBOJGCJHWUPQSYKTVLVFKFMNQWQ9DJPBFJGXKKPYRDXDRYFBY9BIGHEYNTX9VGJTCIRVYIQHPCMCIESIUCGKMMIWHBLNC9BC9JR9CLYCPZTXPNQJOXPUDJUZEQTGWVOIEWCHPAY9EPZYCHFRQPHRZ9UZACWRJBSMRKBC9JJQSHJHPPEEYBFPHTZRGVVLJHDZ9JGLXJARNHMLWIYSUXNXRALYCMPMYOAMCKWHKNNWZPYNFTOUQORGVJRTVUYG9MX9DHLGHXFATETWQJUFPL9FLVRKEXDMVWQJOLTIXHJKBDGAJPJAHPQHT9TMWIL9QNIUQ9FBIIFDA9GUPVKXRPDRHG9IAHPJI9JRMTBJYOGVP9HZM9PNWXNFKKBSFQCOEDPDAUNEZRAYCAMBZBDVTDCANUNGZTAOAXFEUMQMSCOQF9EEVXXTXEB9IVY9DVGHBEXHMDHGJXUMIDIDIPDIAPAOGEKLVBTUFTFRRSKSAXTONHVCLGYOUUKORNGKABDQBTDSPZOWK9QD9VCKTOGMYGIHZ9YT9WYHDONULDLLSILTEUGRLKRAQFXAXNDRGECKTAERXMYOMDADLSPIVLWWNMQQBY9FHRB9LOKZNVUNVHT9I9IOLGHXOTBGAVNMR9QFCDPLDGVFGTLAEOEIDXAPSFNHJIBLMXEDLQQBGEUYKLMKRGVFFJ9AFEFILQBRWHWOOVECRMRQTSEIUHDGXRJFVZXBXSTMQA9KDIEUF9HZXYRZVZYVVEPSKDGEYWBVSEVMUDJSGYIHTPNSPWWDFII9VHAPTJHWXOWTWWSVEEKIXXUPRTTIIOEOQHHROGJIZ9Y9DSQRUVDTDHFBZMIAFTYOBJUBCOFMDTOVDWRSGCIEE9YKJCTJFZGLTFNZHNNPSKDHZZUCNDSJN9RBUOR9MYHNVLTZR9ZPHLCGXUOMGLRXCNKYMPKUFITURZCHHRKNGUZHWV9EQGNEBEXPMIRAZC9JMQL9BMDWK9NXRDEVUETPKINKDQNIJ9GJNQZJEPBDIVBJIXQWYAZCMEKFD9RFA9HUXCUBHAAVPOBRVFXRNEXDNTAIFTYEZADSWMXWEHSUKDVCCMATIDCIOFUVQYNMOXKVIDNXLGUCKQN9WVJDMHRXTHVRSHJTYFUOGKTSTDXYLM9EGYYUPMBA9JASZKKPDATFKNGLUD9IQLWFRPYQYSENKYIVXICCIOTATRVUSDKCYUA9JRUMSTMMBBHFZVCPJICNRGQZIGHEFGFMXV9VBMBMLEFJSGRDNBVODMLKCOIGDIYGCQCAUDJNVBFZGMFBV9TGOWKIFIPUOKIMJNQEBWPYVFXHCKOULMPMBN9QKWGXNM9HOJOSBJDNJJKDJWKJUWVAHNJIORACILRICNHQOQNAA9UIUTABUYOCRHLSNEKKF9BJZKX9VCAOPXOUGYFLWDZYXRVMHAXTCGJFQFOMJMSHRICSYVLSHKYWPTRLXMN9TTNBZLUTLXIDHUDTOIJAYPJ9I9JRFAHT9WOLXSJ9LOKCFXGQFZWJKNEJWURGSNBVCZYAUOBDVANKBTDCEU9W9JDIYAYVGPNGAF9WFFJL9NEYEPMJQLIMDWDVNRXOSZQAGISZIBUKTNDUHVNHOCQ9EIMWSKLREYSAKEVPUYZKMSCEGCRZVBNXXXJSEBSESONCZDNKVKSPSUUYBTDRVAIFGFYXKYRSBOFHYSQNYBQWPRQV99GBRNXWNHBEWTEECUTWPYCEGNQVBXDHLTFLVROOWHYX9TVGZVVFAZJZONCLNTEFZRBPCWPGPIKNQLQMZE9Q9CPPROOMR9QSRSRBSGMFMQ9NX9DNOOGSYRECEADHOVEBOBJTVARVDQYV9PHSDFFQODUISDRWUTAFLGQJNFIAOHOMBNPVTILCSMRTZUTPHYV9NGLXCJKKUPBOJDBDG9OSBCFHUJDXZBSBNLEKWCYPVINVRNWSDDMDPRTYHOSTSADVDRWEXPROSUYPVYNVKOBZDXUAKKVIJQKZE9JZN9EVUG9LTFDANQMUBRXBHAPL9USL9INWZCVCBFPKACSNYSOITLJAWIMCTNSCHQ9JZMYMPRGKQLABOLIEORLCNBJQMFMEAUONZMWKAT9ECRHNIRFSFRIHMGZISIJMOT9HLMOVUOGNTBXHHFZNGFLITAQRCAGBFBFOBBSTYSZMQPV99999999999999999999DOMIOTATESTWOW9999999999999PUPOYVD99A99999999C99999999MZWEZVBGFKSBSHDXAVGAJEUHCSKSRJSHCGRGGOKIPWMPTKSIHRFBEBWWYOSUGME9THEKAFFOORCRADGAK999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
    private static String tx = "XWGITHVPWBSPFRNQUEYLQETIVCJKRIIDKUZ9CSXBH9BKKUZCOGNLPKZXZHEGGPPWLMQHKDDAHZBSFQTNCOEJMSOLMHRPRHNWEUUAEHJURKTFWZQPSBOJGCJHWUPQSYKTVLVFKFMNQWQ9DJPBFJGXKKPYRDXDRYFBY9BIGHEYNTX9VGJTCIRVYIQHPCMCIESIUCGKMMIWHBLNC9BC9JR9CLYCPZTXPNQJOXPUDJUZEQTGWVOIEWCHPAY9EPZYCHFRQPHRZ9UZACWRJBSMRKBC9JJQSHJHPPEEYBFPHTZRGVVLJHDZ9JGLXJARNHMLWIYSUXNXRALYCMPMYOAMCKWHKNNWZPYNFTOUQORGVJRTVUYG9MX9DHLGHXFATETWQJUFPL9FLVRKEXDMVWQJOLTIXHJKBDGAJPJAHPQHT9TMWIL9QNIUQ9FBIIFDA9GUPVKXRPDRHG9IAHPJI9JRMTBJYOGVP9HZM9PNWXNFKKBSFQCOEDPDAUNEZRAYCAMBZBDVTDCANUNGZTAOAXFEUMQMSCOQF9EEVXXTXEB9IVY9DVGHBEXHMDHGJXUMIDIDIPDIAPAOGEKLVBTUFTFRRSKSAXTONHVCLGYOUUKORNGKABDQBTDSPZOWK9QD9VCKTOGMYGIHZ9YT9WYHDONULDLLSILTEUGRLKRAQFXAXNDRGECKTAERXMYOMDADLSPIVLWWNMQQBY9FHRB9LOKZNVUNVHT9I9IOLGHXOTBGAVNMR9QFCDPLDGVFGTLAEOEIDXAPSFNHJIBLMXEDLQQBGEUYKLMKRGVFFJ9AFEFILQBRWHWOOVECRMRQTSEIUHDGXRJFVZXBXSTMQA9KDIEUF9HZXYRZVZYVVEPSKDGEYWBVSEVMUDJSGYIHTPNSPWWDFII9VHAPTJHWXOWTWWSVEEKIXXUPRTTIIOEOQHHROGJIZ9Y9DSQRUVDTDHFBZMIAFTYOBJUBCOFMDTOVDWRSGCIEE9YKJCTJFZGLTFNZHNNPSKDHZZUCNDSJN9RBUOR9MYHNVLTZR9ZPHLCGXUOMGLRXCNKYMPKUFITURZCHHRKNGUZHWV9EQGNEBEXPMIRAZC9JMQL9BMDWK9NXRDEVUETPKINKDQNIJ9GJNQZJEPBDIVBJIXQWYAZCMEKFD9RFA9HUXCUBHAAVPOBRVFXRNEXDNTAIFTYEZADSWMXWEHSUKDVCCMATIDCIOFUVQYNMOXKVIDNXLGUCKQN9WVJDMHRXTHVRSHJTYFUOGKTSTDXYLM9EGYYUPMBA9JASZKKPDATFKNGLUD9IQLWFRPYQYSENKYIVXICCIOTATRVUSDKCYUA9JRUMSTMMBBHFZVCPJICNRGQZIGHEFGFMXV9VBMBMLEFJSGRDNBVODMLKCOIGDIYGCQCAUDJNVBFZGMFBV9TGOWKIFIPUOKIMJNQEBWPYVFXHCKOULMPMBN9QKWGXNM9HOJOSBJDNJJKDJWKJUWVAHNJIORACILRICNHQOQNAA9UIUTABUYOCRHLSNEKKF9BJZKX9VCAOPXOUGYFLWDZYXRVMHAXTCGJFQFOMJMSHRICSYVLSHKYWPTRLXMN9TTNBZLUTLXIDHUDTOIJAYPJ9I9JRFAHT9WOLXSJ9LOKCFXGQFZWJKNEJWURGSNBVCZYAUOBDVANKBTDCEU9W9JDIYAYVGPNGAF9WFFJL9NEYEPMJQLIMDWDVNRXOSZQAGISZIBUKTNDUHVNHOCQ9EIMWSKLREYSAKEVPUYZKMSCEGCRZVBNXXXJSEBSESONCZDNKVKSPSUUYBTDRVAIFGFYXKYRSBOFHYSQNYBQWPRQV99GBRNXWNHBEWTEECUTWPYCEGNQVBXDHLTFLVROOWHYX9TVGZVVFAZJZONCLNTEFZRBPCWPGPIKNQLQMZE9Q9CPPROOMR9QSRSRBSGMFMQ9NX9DNOOGSYRECEADHOVEBOBJTVARVDQYV9PHSDFFQODUISDRWUTAFLGQJNFIAOHOMBNPVTILCSMRTZUTPHYV9NGLXCJKKUPBOJDBDG9OSBCFHUJDXZBSBNLEKWCYPVINVRNWSDDMDPRTYHOSTSADVDRWEXPROSUYPVYNVKOBZDXUAKKVIJQKZE9JZN9EVUG9LTFDANQMUBRXBHAPL9USL9INWZCVCBFPKACSNYSOITLJAWIMCTNSCHQ9JZMYMPRGKQLABOLIEORLCNBJQMFMEAUONZMWKAT9ECRHNIRFSFRIHMGZISIJMOT9HLMOVUOGNTBXHHFZNGFLITAQRCAGBFBFOBBSTYSZMQPV99999999999999999999DOMIOTATESTWOW9999999999999PUPOYVD99A99999999C99999999MZWEZVBGFKSBSHDXAVGAJEUHCSKSRJSHCGRGGOKIPWMPTKSIHRFBEBWWYOSUGME9THEKAFFOORCRADGAKAUA999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
    private static String hash = "COIVKVQTQEHKZVAGBUFURRUG9CVXHWHCBIPKWNMIZDSSSRENFYYFOGTOTFMCEHLQKJ9PHKLWOH9XRHR99";

    @Test
    public void shouldHash() {
        final String hashed = IotaCurlHash.iotaCurlHash(tx, 2673);
        System.err.println(hashed);
        System.err.println(hash);
        Assert.assertEquals(hash, hashed);
    }

    @Test
    public void shouldDoHashTransform() {
        IotaCurlHash hash = new IotaCurlHash();
        int [] state = IntStream.generate(() -> 0).limit(1000).toArray();
        System.err.println(Arrays.toString(state));
        hash.doHashTransform(state);
    }

    @Test
    public void shoultTrytesToTrits() {
        int [] state = IntStream.generate(() -> 0).limit(1000).toArray();
        IotaCurlUtils.iotaCurlTrytes2Trits(state, 64, in.toCharArray(), (100-64));
        System.err.println(Arrays.toString(state));

        int [] test = { 0, 1, 1, 1, 1, 1, -1, 0, -1, -1, 0, 1, -1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, -1, 0, 1, -1, 0, 0, -1, 1, 0, 1, 0, -1, 0, -1, 1, -1, 0, -1, -1, 1, -1, -1, -1, -1, 0, 1, 0, 0, -1, -1, -1, -1, 1, 1, 0, 1, 1, 1, 1, 1, 0, -1, 0, -1, -1, 0, 1, 1, 1, 1, 1, -1, 0, 1, 0, 0, -1, 1, -1, -1, 0, 0, -1, -1, 0, 1, -1, -1, -1, -1, -1, 0, -1, -1, 1, 0, 1, -1, 0, 1, -1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assert.assertArrayEquals(Arrays.copyOfRange(state, 0, 120), test);
    }

    @Test
    public void shouldWrapTooLongSigned() {
        long input = 0xffffffffffffffffL; // any long, e.g. -1
        final String base10 = IotaCurlUtils.literalUnsignedLong(input).toString(10);
        System.err.println(base10);
        System.err.println(0xffffffffffffffffL);
        System.err.println(Long.MAX_VALUE);
    }
}