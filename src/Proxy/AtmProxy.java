package Proxy;


import Singletons.Bank;
// import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import Singletons.TerminalPrinter;

public class AtmProxy implements Proxy.Bank {
    // Allows the user to access getATMState in the
    // Object ATMMachine
    private Pin pin;
    private Proxy.Bank realBank;
//    private int cashAmount;

    public AtmProxy(Pin pin, BankBranch x) {
        this.pin = pin;
//        this.cashAmount = cashAmount;
        realBank = x;
    }
//    public AccountState getAccountState() {
//
//        Account realAccount = new Account();
//
//        return realAccount.getAccountState();
//    }

    // Allows the user to access getCashInMachine
    // in the Object ATMMachine

    public double getBalance() {
        if(pin.checkPin(Bank.getCurrentUserUsingBank().getPin().getPinNum()))
        {
            return realBank.getBalance();
        }
        TerminalPrinter.PrintLine("Invalid Pin");
        return -1;
    }
    public void atmWithdraw(int cashOut){
        if(pin.checkPin(Bank.getCurrentUserUsingBank().getPin().getPinNum())) {
            realBank.atmWithdraw(cashOut);
        }
        else{
        	TerminalPrinter.PrintLine("Invalid Pin");
        }
    }

    public void atmDeposit(int cashIn){
        if(pin.checkPin(Bank.getCurrentUserUsingBank().getPin().getPinNum())) {
            realBank.atmDeposit(cashIn);
        }
        else{
            TerminalPrinter.PrintLine("Invalid Pin");
        }

    }

    public void setBalance(double newBalance) {
        TerminalPrinter.PrintLine("System not allowed.");
    }
}
