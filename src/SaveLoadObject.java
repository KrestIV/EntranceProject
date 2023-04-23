import java.io.*;

/*Обобщенный класс для удобной
сериализации/десериализации объектов
Ещё не разобрался не слишком ли такое обращение с открытием/закрытием
стримов позорно для показа людям*/
public class SaveLoadObject<E> {
    //Streams for input and output
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    public SaveLoadObject(){

    }
    public void SaveToFile(E object, String address){
        try {
            fileOutputStream = new FileOutputStream(address);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);

            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException ex){
            System.out.println("Ошибка при сохранении файла. Нет доступа.");
        }
    }
    public E loadFromFile(E defaultResultObject, String address){
        try {
        fileInputStream = new FileInputStream(address);
        objectInputStream = new ObjectInputStream(fileInputStream);
        defaultResultObject = (E)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        }catch (IOException ex){
            System.out.println("Файл с сохраненным значением не был найден. Создан новый " + defaultResultObject);
        }catch(ClassNotFoundException ex){
            System.out.println("Ошибка чтения файла. Создан новый " + defaultResultObject);
        }
        return defaultResultObject;
    }
}
