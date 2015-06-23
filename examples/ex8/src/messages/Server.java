package messages;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/**
 * Created by denis.selutin on 6/18/2015.
 */
public class Server implements Runnable {

    public static final int portNumber = 9000;
    private static final Map<Integer, Server> registeredClients = new ConcurrentHashMap<>();

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private int port;
    private ExecutorService es;
    private List<Message> messages;

    public Server(int port, ExecutorService es) throws IOException {
        this.port = port;
        this.es = es;
        this.messages = new CopyOnWriteArrayList<>();
        log("Created on port " + this.port);
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                clientSocket = serverSocket.accept();
                synchronized (clientSocket) {
                    out = new ObjectOutputStream(clientSocket.getOutputStream());
                    in = new ObjectInputStream(clientSocket.getInputStream());
                    Object input;
                    while ((input = in.readObject()) == null) Thread.sleep(1000);
                    log("Server received Object = " + String.valueOf(input));
                    if (input instanceof Message) {
                        processMessage((Message) input);
                    }
                    out.flush();
                }
            } catch (Exception e) {
                log("Error in server...Retrying creation [" + e.getMessage() + "]");
                try {
                    serverSocket = new ServerSocket(this.port);
                } catch (IOException ex) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendMessageToClient(Message message) throws IOException {
        messages.add(message);
    }

    private void processMessage(Message message) throws IOException, InterruptedException {
        switch (message.getHeader().getType()) {
            case REGISTRATION:
                registerClient(message);
                break;
            case MESSAGE:
                sendMessage(message);
                break;
            case ADDRESSES_REQUEST:
                respondWithAddresses();
                break;
            case GET_MY_MESSAGES:
                getMyMessages();
                break;
        }
    }

    private void getMyMessages() throws IOException {
        Message mesasge = new Message();
        mesasge.setMessage(new ArrayList<>(this.messages));
        out.writeObject(mesasge);
        out.flush();
        this.messages.clear();
    }

    private void registerClient(Message message) throws IOException, InterruptedException {
        Random r = new Random();
        Integer i;
        Server receiver;
        synchronized (registeredClients) {
            while (registeredClients.containsValue(i = r.nextInt(10000) + 10000));
            receiver = new Server(i, es);
            registeredClients.put(i, receiver);
        }
        log("Server " + i);
        out.writeInt(i);
        es.execute(receiver);
        log("Registration completed for " + i);
    }

    private void sendMessage(Message message) throws IOException {
        Server r = registeredClients.get(message.getHeader().getDestinationKey());
        log("Send to " + r.port);
        if(r != null) {
            synchronized (r) {
                r.sendMessageToClient(message);
            }
        }
    }

    private void respondWithAddresses() throws IOException {
        out.writeObject(new ArrayList(registeredClients.keySet()));
        out.flush();
    }

    private void log(String mgs) {
        System.out.println("Server [" + port +"] --> " + mgs);
    }
}
