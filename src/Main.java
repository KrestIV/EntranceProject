import java.io.*;

public class Main {
    final static String SAVE_FILE_ADDRESS = "src\\savedGlobalCounter.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Counter globalCounter;
        SaveLoadCounter<Counter> saveLoadCounter = new SaveLoadCounter<>();
        try {
            globalCounter = saveLoadCounter.loadFromFile(SAVE_FILE_ADDRESS);
        }catch (IOException ex){
            System.out.println("IOExeption has occured during execution. We're in trouble, captain!");
        }catch(ClassNotFoundException ex){
            System.out.println("ClassNotFoundException has occured during execution. We're in trouble, captain!");
        }

        globalCounter.setCurrentCounter(globalCounter.getCurrentCounter() + 1L);

        System.out.println("current count of the global counter is " + globalCounter.getCurrentCounter());
        try {
            saveLoadCounter.SaveToFile(globalCounter, SAVE_FILE_ADDRESS);
            System.out.println("Stream closed!");
        }catch (IOException ex){
            System.out.println("IOExeption has occured during execution. We're in trouble, captain!");
        }

    }
}