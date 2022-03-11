package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory{
    public static Logger getLogger(String name) {
        return new ContextualLogger(new FileLogger("message.txt"), name);
    }
}
