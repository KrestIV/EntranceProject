import java.io.*;

/*Обобщенный класс для удобной
сериализации/десериализации объектов
Ещё не разобрался не слишком ли такое обращение с открытием/закрытием
стримов позорно для показа людям*/
public class SaveLoadCounter<E> {
    //Streams for input and output
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    public SaveLoadCounter(){

    }
    public void SaveToFile(E object, String address)throws IOException{
        fileOutputStream = new FileOutputStream(address);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);

        objectOutputStream.close();
        fileOutputStream.close();
    }
    public E loadFromFile(String address) throws IOException, ClassNotFoundException{
        fileInputStream = new FileInputStream(address);
        objectInputStream = new ObjectInputStream(fileInputStream);
        E result = (E)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return result;
    }
}
