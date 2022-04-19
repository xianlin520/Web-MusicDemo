package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    private static List<Socket> all_sockets = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        Executor ex = new ThreadPoolExecutor(3, 5, 2,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        ServerSocket ss = new ServerSocket(1855);
        System.out.println("等待接受数据--" + new Date());
        while (true) {
            Socket serverData = ss.accept();
            InputStream is = serverData.getInputStream();
            all_sockets.add(serverData);
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String rad = null;
                    String ing = "ing";
                    boolean i = true;
                    System.out.println(serverData.getRemoteSocketAddress() + "上线");
                    while (true) {
                        try {
                            if ((rad = br.readLine()) == null) break;
                        } catch (IOException e) {
                            System.out.println(ing + "---已下线");
                            try {
                                sendMsgToAll(ing + " ---已下线");
                            } catch (Exception exc) {
                                exc.printStackTrace();
                            }
                            Server.all_sockets.remove(serverData);
                            break;
                        }
                        if (i) {
                            ing = rad;
                            i = false;
                        } else {
                            try {
                                String sr = ing + "发送的:" + rad;
                                System.out.println(sr);
                                sendMsgToAll(sr);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        
                    }
                }
    
                private void sendMsgToAll(String sr) throws Exception {
                    for (Socket socket : all_sockets) {
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        ps.println(sr);
                        ps.flush();
                    }
                }
    
            });
        }
    }
}


