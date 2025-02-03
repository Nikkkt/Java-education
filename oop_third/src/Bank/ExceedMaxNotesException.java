package Bank;

public class ExceedMaxNotesException extends ATMException {
    public ExceedMaxNotesException(String message) {
        super(message);
    }
}
