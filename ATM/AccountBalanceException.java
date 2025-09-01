package atm;

public class AccountBalanceException extends Exception{
    public AccountBalanceException(String message){
        super(message);
    }
}