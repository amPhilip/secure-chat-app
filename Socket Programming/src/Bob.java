import java.io.*;
import java.net.Socket;

public class Bob
{
    public Bob() {
    }

    public static void main(String[] args) {
        try {
            Socket as = new Socket("127.0.0.1", 1225);
            DataInputStream dis = new DataInputStream(as.getInputStream());
            DataInputStream dis2 = new DataInputStream(as.getInputStream());
            DataOutputStream dos = new DataOutputStream(as.getOutputStream());
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String msgin1 = "";

            while(!msgin1.equals("end")) {
                String msgout = b.readLine();
                if(msgout != "") {
                    dos.writeUTF(msgout);
                    msgin1 = dis.readUTF();
                    System.out.println();
                    System.out.println("Server Encrypted Message: " + msgin1);
                    String msgin2 = dis2.readUTF();
                    System.out.println("Server Decrypted Message " + msgin2);
                }
            }
        } catch (IOException var9) {
            System.out.println(var9);
        }

    }
}
