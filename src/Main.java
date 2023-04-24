import java.util.Scanner;
public class Main {
    //Адресс файла сохранения.
    final static String SAVE_FILE_ADDRESS = "src\\savedGlobalCounter.txt";
    public static void main(String[] args){
        //Инициализация проекта, создание и попытка загрузки счетчика из файла.
        boolean runProgram = true;
        Counter globalCounter;
        SaveLoadObject<Counter> saveLoadObject = new SaveLoadObject<>();
        globalCounter = saveLoadObject.loadFromFile(new Counter(), SAVE_FILE_ADDRESS);
        System.out.println("Счетчик загружен, значение '" + globalCounter.getCurrentNumber() + "'");
        String command;

        //Основной цикл проекта
        while(runProgram){
            command = getCommand();
            switch (command) {
                case "/stop" -> {
                    runProgram = false;
                    System.out.println("Завершаю работу.\nТекущее значение счетчика равно '"
                            + globalCounter.getCurrentNumber() + "'");
                }
                case "/inc" -> {
                    globalCounter.increase();
                    System.out.println("Значение счетчика увеличено и равно '" + globalCounter.getCurrentNumber() + "'");
                }
                case "/reset" -> {
                    globalCounter.reset();
                    System.out.println("Счетчик сброшен, значение равно '" + globalCounter.getCurrentNumber() + "'");
                }
                default -> {
                    runProgram = false;
                    System.out.println("Что-то пошло не так. Завершаю программу");
                }
            }
        }
        //Завершение программы и сохранение текущего значения счетчика в файл
        saveLoadObject.SaveToFile(globalCounter, SAVE_FILE_ADDRESS);
    }

    /* Получение команды из консоли.
    Отсечение некорректных команд через регулярное выражение.
    */
    public static String getCommand(){
        System.out.println("Введите одну из реализованных команд: /inc, /stop или /reset");
        String result;
        Scanner scanner = new Scanner(System.in);
        while(true){
            scanner.reset();
            result = scanner.nextLine();
            if(result.matches("^((/reset)|(/inc)|(/stop))")) break;
            else System.out.println("Команда не распознана. Введите одну из реализованных команд: /inc, /stop или /reset");
        }


        return result; // /inc /stop /reset
    }
}