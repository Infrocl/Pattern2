package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket client;

    public Client() {
        try {
            client = new Socket("localhost", 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double multiplyDouble(double firstNumber, double secondNumber) {
        double result = 0;
        try (DataInputStream input = new DataInputStream(client.getInputStream());
             DataOutputStream output = new DataOutputStream(client.getOutputStream())) {
            output.writeDouble(firstNumber);
            output.writeDouble(secondNumber);
            result = input.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
