package com.company;

import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        ServerSocket servSocket = null;
        try
        {
            servSocket = new ServerSocket(10007);
        }
        catch (IOException e)
        {
            System.out.println("Port 10007 unavailable");
            System.exit(1);
        }
        Socket clientSocket = null;
        System.out.println("Socket server listening for connection...");
        try
        {
            clientSocket = servSocket.accept();

        }
        catch(IOException e)
        {
            System.out.println("Failed to accept connection");
            System.exit(1);
        }
        System.out.println("Succesfully connected.");
        System.out.println("Listening for client input..");
        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while((inputLine = input.readLine()) != null)
        {
            System.out.println("Server: " + inputLine);
            output.println(inputLine);
            if(inputLine.equals("Bye"))
            {
                break;
            }
        }
        output.close();
        input.close();
        clientSocket.close();
        servSocket.close();
    }
}
