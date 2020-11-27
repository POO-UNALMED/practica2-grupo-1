package excepciones;

public class Excepciones extends Throwable {

    static final long serialVersionUID = -3387516993124229948L;

    public Excepciones() {
        super();
    }

    public Excepciones(String message) {
        super(message);
    }

    public Excepciones(String message, Throwable cause) {
        super(message, cause);
    }

    public Excepciones(Throwable cause) {
        super(cause);
    }

    protected Excepciones(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
