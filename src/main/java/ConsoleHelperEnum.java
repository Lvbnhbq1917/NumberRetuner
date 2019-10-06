import javax.print.DocFlavor;

public interface ConsoleHelperEnum {
    String GREETING = "Приветствую Вас!";
    String BYE_BYE = "Удачного Вам дня! Приложение закрывается.";
    String CHOOSE_FILE_DESTINATION = "Пожалуйста укажите полный путь файла из которого Вы хотите извлечь все числа,\n" +
            "согласно приведенному ниже образцу:\n" +
            "C:\\Files\\Имя_Вашего_файла";
    String MAKE_CHOISE = "Пожалуйста, сделайте Ваш выбор\n" +
            "отработать другой файл - введите в консоль 1\n" +
            "закончить приложение - введите в консоль 0";
    String ERROR = "Произошла ошибка! Попробуйте снова!";
    String NUMBER_NOT_FOUND = "В указанном Вами файле не было обнаружено чисел.";
    String FILE_DESTINATION_NOT_FOUND = "Файл по указанному Вами пути не найден.";
}
