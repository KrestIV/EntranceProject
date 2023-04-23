import java.util.Scanner;
public class Main {
    final static String SAVE_FILE_ADDRESS = "src\\savedGlobalCounter.txt";
    public static void main(String[] args){
        //Инициализация проекта, создание и попытка загрузки счетчика из файла.
        boolean runProgram = true;
        Counter globalCounter;
        SaveLoadObject<Counter> saveLoadObject = new SaveLoadObject<>();
        globalCounter = saveLoadObject.loadFromFile(new Counter(), SAVE_FILE_ADDRESS);
        System.out.println("Счетчик загружен, значение '" + globalCounter.getCurrentCounter() + "'");
        String command;

        //Основной цикл проекта
        while(runProgram){
            command = getCommand();
            switch (command){
            case "/stop": runProgram = false;
                System.out.println("Завершаю работу");
                break;
            case "/inc": globalCounter.setCurrentCounter(globalCounter.getCurrentCounter() + 1L);
                System.out.println("Значение счетчика увеличено и равно '" + globalCounter.getCurrentCounter() + "'");
                break;
            case "/reset": globalCounter.setCurrentCounter(0L);
                System.out.println("Счетчик сброшен, значение равно '" + globalCounter.getCurrentCounter() + "'");
                break;
            default: runProgram = false;
                System.out.println("Что-то пошло не так. Завершаю программу");
                break;
            }
        }

        saveLoadObject.SaveToFile(globalCounter, SAVE_FILE_ADDRESS);
        System.out.println("Счетчик успешно сохранён со значением '" + globalCounter.getCurrentCounter() + "'");



    }

    public static String getCommand(){
        System.out.println("Введите одну из реализованных команд: /inc, /stop или /reset");
        String result;
        Scanner scanner = new Scanner(System.in);
        while(true){
            scanner = scanner.reset();
            result = scanner.nextLine();
            if(result.matches("^((/reset)|(/inc)|(/stop))")) break;
            else System.out.println("Команда не распознана. Введите одну из реализованных команд: /inc, /stop или /reset");
        }


        return result; // /inc /stop /reset
    }
}