package exceptions;

public class UserException extends RuntimeException {

    private String msg;

    public UserException(String msg) {
        this.msg = msg;
    }
}
