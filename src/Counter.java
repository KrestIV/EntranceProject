import java.io.Serializable;

public class Counter extends Numerator implements Serializable {
    //Поле для корректной сериализации/десериализации
    private static final long serialVersionUID = 1L;
    //Конструктор по умолчанию
    public Counter(){
    }
    //Переопределение объектного метода
    @Override
    public String toString(){
        return "Счетчик";
    }

    //Увеличение счетчика на единицу
    @Override
    public void increase(){
        this.setCurrentNumber(this.getCurrentNumber() + 1L);
    }

    //Сброс счетчика на ноль
    @Override
    public void reset(){
        this.setCurrentNumber(0L);
    }
}
