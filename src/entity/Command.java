package entity;

public class Command {
    private String path;
    private String content;
    private Flag flag;

    public Command(String path, String flag, String content) {
        this.path = path;
        this.content = content;
        this.flag = setFlag(flag);
    }

    public Command(String flag) {
        this.flag = setFlag(flag);
    }

    private Flag setFlag(String str) {
        switch (str) {
            case "--write":
                return Flag.WRITE;
            case "--delete":
                return Flag.DELETE;
            case "--create":
                return Flag.CREATE;
            case "--read":
                return Flag.READ;
            case "!exit":
                return Flag.EXIT;
            case "!help":
                return Flag.HELP;
            default:
                return Flag.UNRECOGNIZED;
        }
    }

    public String getPath() {
        return path;
    }

    public String getContent() {
        return content;
    }

    public Flag getFlag() {
        return flag;
    }
}
