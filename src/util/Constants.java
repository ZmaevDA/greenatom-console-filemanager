package util;

public class Constants {

    public static final String FILE_CREATED = "Файл %s успешно создан!\n";
    public static final String FILE_OVERRIDE = "Файл %s был перезаписан!\n";
    public static final String FILE_DELETE = "Файл %s успешно удален!\n";
    public static final String SUCCESS_WRITE = "В файл %s успешно записана строка %s!\n";
    public static final String INPUT_ERROR = "Ошибка при вводе команды\nПример команды c:\\\\testdata\\myfile.txt --write \"blablabla\"\n";
    public static final String CREATE_AND_WRITE = "Не удалось найти файл по данному пути. Он был автоматически создан!\n";
    public static final String FILE_NOT_EXISTS = "Не удалось найти файл по данному пути!\n";
    public static final String AVAILABLE_FLAG_MESSAGE = "Доступные флаги:\n" +
            "1) <абсолютный путь к файлу> --write <содержимое>\n" +
            "2) <абсолютный путь к файлу> --read\n" +
            "3) <абсолютный путь к файлу> --create\n" +
            "4) <абсолютный путь к файлу> --delete\n" +
            "5) !exit\n" +
            "6) !help\n";
    public static final String SAMPLE_MESSAGE = "Пример использования:\nc:\\\\testdata\\myfile.txt --create (создаст пустой файл)\n" +
            "c:\\\\testdata\\myfile.txt --write \"blablabla\" (запишет в файл строку blablabla) и т.п.\n";
    public static final String INPUT_COMMAND = "Введите команду";
    public static final String CANT_WRITE_FILE = "Невозможно записать файл по данному пути!";
}
