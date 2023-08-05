import java.io.IOException;
import java.net.*;



public class Server{
    private static final short SERVER_PORT = 1234;
    
    private ServerSocket serverSocket;

    public Server (ServerSocket serverSocket){
        this.serverSocket = serverSocket;
        
    }

   
    public void startServer(){
        try{
            
            while(!serverSocket.isClosed()){
               Socket socket = serverSocket.accept();
               System.out.println("A new client is connected to the chat");
               ClientHandler clientHandler = new ClientHandler(socket);

               Thread thread = new Thread(clientHandler);
               thread.start();

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeServerSocket(){
        try{
            if(serverSocket != null){
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("server running on port: " + SERVER_PORT);
        Server server = new Server(serverSocket);
        server.startServer();
       

    }
}

