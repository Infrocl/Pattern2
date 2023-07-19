package org.example;

import java.io.*;

public class StringArrayToByteAdapter extends DataOutputStream {

    public StringArrayToByteAdapter(OutputStream out) {
        super(out);
    }

    public void write(String[] strings) throws IOException {
        super.write(strings.length);
        for (String str : strings) {
            super.writeUTF(str);
        }
    }

    public String[] readToStringArray(InputStream in) throws IOException {
        DataInputStream input = new DataInputStream(in);
        String[] strings = new String[input.read()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = input.readUTF();
        }
        return strings;
    }
}
