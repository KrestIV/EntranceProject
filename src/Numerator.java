import java.io.Serializable;

/*Класс для демонстрации работы с абстрактным классом.
Также позволяет выполнить требование по количеству классов в проекте.
 */
public abstract class Numerator implements Serializable {
    private long currentNumber = 0L; //Счетчик

    //Геттер currentNumber
    public long getCurrentNumber() {
        return currentNumber;
    }
    //Сеттер currentNumber
    public void setCurrentNumber(long currentNumber){
        this.currentNumber = currentNumber;
    }
    //Конструктор по умолчанию
    protected Numerator(){
    }

    //Увеличивает значение нумератора
    public abstract void increase();
    //Сбрасывает нумератор
    public abstract void reset();
}
