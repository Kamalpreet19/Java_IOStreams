//Problem 8. Piped Streams - Inter-Thread Communication

import java.io.*;

class WriterThread extends Thread {
    PipedOutputStream pos;

    WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            pos.write("Hello World".getBytes());
            pos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ReaderThread extends Thread {
    PipedInputStream pis;

    ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char)data);
            }
            pis.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class PipedStream {
    public static void main(String[] args) {
        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);

            new WriterThread(pos).start();
            new ReaderThread(pis).start();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
