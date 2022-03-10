package main.fr.lernejo;

public class LoggerFactory{
    public Logger getLogger(String name) {
        return new ConsoleLogger();
    }
}
