package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    public Logger log1;
    public Logger log2;
    public CompositeLogger(Logger log1, Logger log2){
        this.log1 = log1;
        this.log2 = log2;
    }
    @Override
    public void log(String message) {
        this.log1.log(message);
        this.log2.log(message);
    }
}
