package demo.ipConsulting.exception;


import lombok.Getter;

public class IPAddressException extends RuntimeException{

    private static final long serialVersionUID = 7438255799694047836L;

    @Getter
    private final String failingService;

    public IPAddressException (final String failingService){
        super();
        this.failingService = failingService;
    }

    public IPAddressException (final String failingService, final String message){
        super(message);
        this.failingService = failingService;
    }

    public IPAddressException (final String failingService, final Throwable cause){
        super(cause);
        this.failingService = failingService;
    }

    public IPAddressException (final String failingService, final String message, final Throwable cause){
        super(message, cause);
        this.failingService = failingService;
    }
}
