package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static final int PORT = 23334;
    public static final String HOSTNAME = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        // Определяем сокет сервера
        InetSocketAddress socketAddress = new InetSocketAddress(HOSTNAME, PORT);
        final SocketChannel socketChannel = SocketChannel.open();
        //  подключаемся к серверу
        socketChannel.connect(socketAddress);

        // Получаем входящий и исходящий потоки информации
        try (Scanner scanner = new Scanner(System.in)) {
            //  Определяем буфер для получения данных
            final ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);

            String msg;
            while (true) {

                System.out.println("Enter message for server...");
                msg = scanner.nextLine();
                if ("end".equals(msg)) break;

                socketChannel.write(
                        ByteBuffer.wrap(
                                msg.getBytes(StandardCharsets.UTF_8)));

                Thread.sleep(2000);

                int bytesCount = socketChannel.read(inputBuffer);
                System.out.println(new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8).trim());
                inputBuffer.clear();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            socketChannel.close();
        }
    }
}
