package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {

    public static final String LOCALHOST = "localhost";
    public static final int PORT = 23334;

    public static void main(String[] args) throws IOException {
        //  Занимаем порт, определяя серверный сокет
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(LOCALHOST, PORT));

        while (true) {
            //  Ждем подключения клиента и получаем поток и для дальнейшей работы
            try (SocketChannel socketChannel = serverSocketChannel.accept()) {
                //  Определяем буфер для получения данных
                final ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);

                while (socketChannel.isConnected()) {
                    //  читаем данные из канала в буфер
                    int bytesCount = socketChannel.read(inputBuffer);
                    //  если из потока читать нельзя, перестаем работать с этим клиентом
                    if (bytesCount == -1) break;
                    //  получаем переданную от клиента строку в нужной кодировке и очищаем буфер
                    final String msg = new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8);
                    inputBuffer.clear();
                    System.out.println("Получено сообщение от клиента: " + msg);
                    //  отправляем сообщение клиента назад с пометкой ЭХО
                    socketChannel.write(ByteBuffer.wrap(("Эхо: " + msg.replaceAll("\\s+", "")).getBytes(StandardCharsets.UTF_8)));
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
