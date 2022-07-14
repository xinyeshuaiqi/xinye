package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-07-14
 */
public class ExceptionTest {
    public static void test() throws Exception {
        AutoCloseable c = null;
        Exception tmpException = null;

        try {
            c = dummy();
        } catch (Exception e) {
            tmpException = e;
            throw e;
        } finally {
            if (c != null) {
                if (tmpException != null) {
                    try {
                        c.close();
                    } catch (Exception e) {
                        tmpException.addSuppressed(e);
                    }
                } else {
                    c.close();
                }
            }
        }
    }

    private static AutoCloseable dummy() {
        return new AutoCloseable() {
            @Override
            public void close() throws Exception {

            }
        };
    }
}
