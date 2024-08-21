package prueba1;

import Controller.ReadSensor;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortList;

public class Prueba1 {

    public static void main(String[] args) {
        ReadSensor read=new ReadSensor();
        read.ConectionArduino();
        
        
    }
}


