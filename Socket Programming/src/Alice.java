import java.io.*;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

public class Alice
{
    public Alice() {
    }

    public static void main(String[]args)
    {
        try {
            ServerSocket a = new ServerSocket(1225);
            System.out.println("The server has started");
            Socket s = a.accept();
            System.out.println("Connection established");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataOutputStream dos2 = new DataOutputStream(s.getOutputStream());
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String msgin ="";

            while (!msgin.equals("end"))
            {
                msgin = dis.readUTF();
                System.out.println();
                System.out.println("The client: " + msgin);
                String messageOut = b.readLine();
                BigInteger plaintext =new BigInteger(messageOut.getBytes());
                dos.writeUTF(plaintext.toString());
                dos.flush();
                dos2.writeUTF(messageOut);
                dos2.flush();
            }
            s.close();
        } catch (IOException var11)
        {
            System.out.println(var11);
        }
    }

}
