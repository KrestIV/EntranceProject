import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException{
        Counter globalCounter = new Counter();
        System.out.println("current count of the global counter is " + globalCounter.getCurrentCounter());

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\javaProjects\\EntranceProject\\src\\savedGlobalCounter.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(globalCounter);

        objectOutputStream.close();
        System.out.println("Stream closed!");
    }
}