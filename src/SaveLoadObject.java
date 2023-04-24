import java.io.*;

/*Обобщенный класс для удобной
сериализации/десериализации объектов.
Можно было обойтись без использования обобщения.
*/
public class SaveLoadObject<E> {
    //Стандартный конструктор
    public SaveLoadObject(){
    }
    //Сохранение объекта objectToSave в файл по адресу address
    public void SaveToFile(E objectToSave, String address){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(address);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(objectToSave);
            System.out.println(objectToSave.toString() + " успешно сохранён в файл");
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException ex){
            System.out.println("Ошибка при сохранении файла. Нет доступа.");
        }
    }
    //Загрузка объекта из файла по адресу address. При ошибке в процессе выполнения будет возвращен defaultResultObject
    public E loadFromFile(E defaultResultObject, String address){
        try {
            FileInputStream fileInputStream = new FileInputStream(address);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
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
