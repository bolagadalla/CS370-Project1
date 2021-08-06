package Proxy;

public class Pin {
    private int pinNum;
    
    public int getPinNum() {
		return pinNum;
	}

	public Pin(int pinNum){
        this.pinNum = pinNum;
    }
    
    public boolean checkPin(int pin) 
    {
        if(pinNum == pin){
            return true;
        }else{return false;}
    }

}
