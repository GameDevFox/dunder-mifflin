package dundermifflin.exception;

public class DunderMifflinRuntimeException extends RuntimeException {

    public DunderMifflinRuntimeException() {}

    public DunderMifflinRuntimeException(String s) {
        super(s);
    }

    public DunderMifflinRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DunderMifflinRuntimeException(Throwable throwable) {
        super(throwable);
    }

    public DunderMifflinRuntimeException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
