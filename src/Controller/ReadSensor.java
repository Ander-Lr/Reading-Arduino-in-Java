/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortList;

/**
 *
 * @author Usuario
 */
public class ReadSensor {
    
    public void ConectionArduino(){
        String puertos[] = SerialPortList.getPortNames();
        for (String n : puertos) {
            System.out.println(n);
        }
        SerialPort sp = new SerialPort("COM6");
        try {
            sp.openPort();
            sp.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            sp.addEventListener(new LecturaSerial(sp), SerialPort.MASK_RXCHAR);            
            Thread.sleep(1500);            
            // Aquí se omite el bucle de envío porque no estamos enviando datos desde Java,
            // solo estamos recibiendo datos enviados por el Arduino.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LecturaSerial implements SerialPortEventListener {
    Object object=new Object();//Retornar para Utilizar la variable
    SerialPort sp;
    public LecturaSerial(SerialPort sp) {
        this.sp = sp;
    }
    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.isRXCHAR() && spe.getEventValue() > 0) {
            try {
                String msg = sp.readString();
                if (msg != null && !msg.trim().isEmpty()) {
                    System.out.println("Recibiendo...");
                    System.out.println("Distancia medida: " + msg.trim() + " cm");
                    object=msg.trim();//guarda la variable                   
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getObject() {
        return object;//Se utilizará los datos
    }
}