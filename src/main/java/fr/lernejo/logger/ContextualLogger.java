package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    public Logger log;
    public String name;
    public ContextualLogger(String name,Logger logger){
        this.log = logger;
        this.name = name;
    }
    @Override
    public void log(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        this.log.log(LocalDateTime.now().format(formatter) + " " + this.name + " " + message);
    }
}
