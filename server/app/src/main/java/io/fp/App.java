/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package io.fp;
import java.io.IOException;
import java.net.*;


public class App {
    static final int PORT = 7896;
    public static void main(String[] args)
        throws IOException {
      ServerSocket s = new ServerSocket(PORT);
      System.out.println("Server Started");
      try {
        while(true) {
          // Blocks until a connection occurs:
          Socket socket = s.accept();
          try {
            new GuessGameThread(socket);
          } catch(IOException e) {
            // If it fails, close the socket,
            // otherwise the thread will close it:
            socket.close();
          }
        }
      } finally {
        s.close();
      }
    }
  } ///:~ 