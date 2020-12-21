package builds.shopsexceptions;

public class NegativeCountException extends Exception{
    public NegativeCountException(String error){
        super(error);
    }
}
