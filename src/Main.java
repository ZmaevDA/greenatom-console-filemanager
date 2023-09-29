import entity.Command;
import entity.FileManager;
import entity.Parser;
import util.Constants;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        helloMessage();
        while (true) {
            System.out.println(Constants.INPUT_COMMAND);
            String input = scanner.nextLine();
            Command command = parser.parseStringToCommand(input);
            switch (command.getFlag()) {
                case CREATE:
                    createFile(fileManager, command);
                    break;
                case READ:
                    readFromFile(fileManager, command);
                    break;
                case DELETE:
                    deleteFile(fileManager, command);
                    break;
                case WRITE:
                    writeToFile(fileManager, command);
                    break;
                case EXIT:
                    exit();
                    break;
                case HELP:
                    System.out.println(Constants.AVAILABLE_FLAG_MESSAGE);
                    break;
                default:
                    System.out.println(Constants.INPUT_ERROR);
                    break;
            }
        }
    }

    private static void helloMessage() {
        System.out.println(Constants.AVAILABLE_FLAG_MESSAGE + Constants.SAMPLE_MESSAGE);
    }

    private static void exit() {
        System.exit(0);
    }

    private static void createFile(FileManager fileManager, Command command) {
        if (fileManager.createFile(command.getPath())) {
            System.out.printf(Constants.FILE_CREATED, command.getPath());
        } else {
            System.out.printf(Constants.FILE_OVERRIDE, command.getPath());
        }
    }

    private static void readFromFile(FileManager fileManager, Command command) {
        try {
            System.out.println(fileManager.readFromFile(command.getPath()));
        } catch (RuntimeException e) {
            System.out.println(Constants.FILE_NOT_EXISTS);
        }
    }

    private static void writeToFile(FileManager fileManager, Command command) {
        try {
            if(!fileManager.writeToFile(command.getPath(), command.getContent())) {
                System.out.println(Constants.CREATE_AND_WRITE);
            }
            System.out.printf(Constants.SUCCESS_WRITE, command.getPath(), command.getContent());
        } catch (RuntimeException e) {
            System.out.println(Constants.CANT_WRITE_FILE);
        }
    }

    private static void deleteFile(FileManager fileManager, Command command) {
        if (fileManager.deleteFile(command.getPath())) {
            System.out.printf(Constants.FILE_DELETE, command.getPath());
        } else {
            System.out.printf(Constants.FILE_NOT_EXISTS);
        }
    }
}