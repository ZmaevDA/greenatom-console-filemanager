package entity;

public class Parser {

    public Command parseStringToCommand(String string) {
        char[] chars = string.toCharArray();
        String path = "";
        String flag = "";
        String content = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '!') {
                flag = string.substring(i, chars.length);
                return new Command(flag);
            }
            if (chars[i] == '-' && chars[i + 1] == '-') {
                path = string.substring(0, i - 1);
                for (int j = i; j < chars.length; j++) {
                    if (chars[j] == ' ') {
                        flag = string.substring(i, j);
                        break;
                    } else {
                        flag = string.substring(i, chars.length);
                    }
                }
            }
            if (chars[i] == '\"') {
                content = string.substring(i, chars.length).replaceAll("\"", "");
                break;
            }
        }
        return new Command(path, flag, content);
    }
}
