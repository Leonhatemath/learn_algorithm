package JVM;

/**
 * @author WangXu
 * @date 2019/3/13 0013 - 19:43
 */
public class ReferenceCountingGC {
    public static void main(String[] args) {
        testGC();
    }

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

}


