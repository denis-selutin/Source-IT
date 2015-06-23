package messages;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * Created by denis.selutin on 6/18/2015.
 */
public class Client implements Runnable {
    private static final String hostName = "localhost";
    private static final int portNumber = 9000;

    private Integer registeredKey;

    public Client() throws IOException, InterruptedException {}

    private void registerSender() throws IOException, InterruptedException, ClassNotFoundException {
        Socket socket = new Socket(hostName, portNumber);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(generateRegistrationMessage());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        while((registeredKey = in.readInt()) == null) {
            Thread.sleep(1000);
        }
        socket.close();
        log("Client has been registered with key " + registeredKey);
    }

    private Message generateRegistrationMessage() {
        Message message = new Message();
        Message.Header header = new Message.Header();
        header.setType(Message.Type.REGISTRATION);
        message.setHeader(header);
        return message;
    }

    private Message generateAddressRequestMessage() {
        Message message = new Message();
        Message.Header header = new Message.Header();
        header.setType(Message.Type.ADDRESSES_REQUEST);
        message.setHeader(header);
        return message;
    }

    private Message generateGetRequestMessage() {
        Message message = new Message();
        Message.Header header = new Message.Header();
        header.setType(Message.Type.GET_MY_MESSAGES);
        message.setHeader(header);
        return message;
    }

    private Message generateMessage(Integer key, String text) {
        Message message = new Message();
        Message.Header header = new Message.Header();
        header.setType(Message.Type.MESSAGE);
        header.setSenderKey(registeredKey);
        header.setDestinationKey(key);
        message.setHeader(header);
        message.setMessage(text);
        return message;
    }

    private Message generateRandomMessage() {
        Random r = new Random();
        if(r.nextInt(2) == 0) {
            return generateAddressRequestMessage();
        } else {
            return generateGetRequestMessage();
        }
    }

    private void handleReceivedObject(Object o) throws IOException {
        if(o instanceof List) {
            List l = (List) o;
            log("Address list = " + l);
            Random r = new Random();
            for(int i = 0; i < r.nextInt(5) + 1; i++) {
                int pos = r.nextInt(l.size());
                sendMessage((Integer) l.get(pos), "Test message " + r.nextLong());
            }
        } else if(o instanceof Message) {
            Message m = (Message)o;
            log("Received messages = " + m.getMessage());
        }
    }

    private void sendMessage(Integer key, String msg) throws IOException {
        Message message = generateMessage(key, msg);
        log("Generated message = " + message);
        Socket socket = new Socket(hostName, registeredKey);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(message);
        out.flush();
        socket.close();
    }

    private void log(String mgs) {
        System.out.println("Client [" + registeredKey +"] --> " + mgs);
    }

    @Override
    public void run() {
        try {
            registerSender();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                Socket socket = new Socket(hostName, registeredKey);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                out.writeObject(generateRandomMessage());
                Object o;
                while((o = in.readObject()) == null) {Thread.sleep(1000);};
                handleReceivedObject(o);
                socket.close();
                Thread.sleep(5000 + new Random().nextInt(6000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
