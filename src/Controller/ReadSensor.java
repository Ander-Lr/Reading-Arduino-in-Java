/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortList;
import view.PetFrame;

/**
 *
 * @author Usuario
 */
public class ReadSensor {

    private PetFrame petFrame;

    public ReadSensor(PetFrame petFrame) {
        this.petFrame = petFrame;
    }

    public void ConectionArduino() {
        String puertos[] = SerialPortList.getPortNames();
        for (String n : puertos) {
            System.out.println(n);
        }
        SerialPort sp = new SerialPort("COM6");
        try {
            sp.openPort();
            sp.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            LecturaSerial lecturaSerial = new LecturaSerial(sp, petFrame);
            sp.addEventListener(lecturaSerial, SerialPort.MASK_RXCHAR);
            
            Thread.sleep(1500);
            // Aquí se omite el bucle de envío porque no estamos enviando datos desde Java,
            // solo estamos recibiendo datos enviados por el Arduino.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LecturaSerial implements SerialPortEventListener {

    private SerialPort sp;
    private PetFrame petFrame;

    public LecturaSerial(SerialPort sp, PetFrame petFrame) {
        this.sp = sp;
        this.petFrame = petFrame;
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.isRXCHAR() && spe.getEventValue() > 0) {
            try {
                String msg = sp.readString();
                if (msg != null && !msg.trim().isEmpty()) {
                    System.out.println("Recibiendo...");
                    System.out.println("Distancia medida: " + msg.trim() + " cm");
                    
                    petFrame.updateStatus(msg.trim()); // Actualizar la UI
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
