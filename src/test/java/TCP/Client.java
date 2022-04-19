package TCP;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("42.193.107.152", 1855);
        Socket socket = new Socket("127.0.0.1", 1855);
        new Ser(socket);
        Scanner sa = new Scanner(System.in);
    
        OutputStream os = null;
        try {
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(os);
        System.out.println("输入临时昵称:");
        String ing = sa.nextLine();
        ps.println(ing);
        ps.flush();
        System.out.println("输入要发送的信息(回车发送):");
        while (true){
            String a = sa.nextLine();
            ps.println(a);
            ps.flush();
        }
        
    }
    
    
}
class Ser extends Thread{
    private Socket socket;
    public Ser(Socket socket){
        this.socket = socket;
        start();
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("服务器把您踢出服务器了");
        }
    }
}


