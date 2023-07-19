package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        StringArrayToByteAdapter stream = new StringArrayToByteAdapter(new FileOutputStream("src/files/test1.bin"));
        String[] strings = {"a", "б", "вгд", "11"};
        String[] result;
        try {
            stream.write(strings);
            result = stream.readToStringArray(new FileInputStream("src/files/test1.bin"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String str : result) {
            System.out.println(str);
        }

        Client client = new Client();
        System.out.println(client.multiplyDouble(2, 2.5));
    }
}