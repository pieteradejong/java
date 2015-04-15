package org.world;

import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        try
        {
            //Socket socket = new Socket("http://www.kurzweilai.net", 43);
            Socket socket = new Socket("whois.internic.net", 43);
            InputStream istream = socket.getInputStream();
            OutputStream ostream = socket.getOutputStream();
            String str = "kurzweilai.net\n";
            byte buffer[] = str.getBytes();
            ostream.write(buffer);
            int ch;
            while((ch = istream.read()) != -1)
            {
                System.out.println((char) ch);
            }
            socket.close();
        }
        catch (IOException e) {
        }
        
    }
}
