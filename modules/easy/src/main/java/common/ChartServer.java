package common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChartServer {


    public static void main(String[] args) throws IOException {

        JFrame frame=new JFrame("severt");
        JPanel panel1=new JPanel();
        frame.add(panel1);
        final TextArea textAreaw=new TextArea();
        TextArea textArear=new TextArea();
        Button buttons=new Button("SEND");
        panel1.add(textArear);
        panel1.add(textAreaw);
        panel1.add(buttons);
        frame.pack();
        frame.setVisible(true);



        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(556);
        Socket socket = serverSocket.accept();
        System.out.println("lianjie");
        InputStream inputStream = socket.getInputStream();
        byte[] bt = new byte[1024];
        final OutputStream outputStream = socket.getOutputStream();
        buttons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outputStream.write(textAreaw.getText().getBytes());
                } catch (Exception Exception) {
                    Exception.printStackTrace();
                }
            }
        });
        String data;
        int len;
        while (true) {
            len = inputStream.read(bt);

            data = new String(bt, 0, len);
            textArear.append(data);




        }






    }

}
