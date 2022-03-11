package fr.lernejo.guessgame;

import fr.lernejo.logger.*;



public class ComputerPlayer implements Player{
    public final Logger log = LoggerFactory.getLogger("player");
    public long minimum = 0;
    public long maximum = Integer.MAX_VALUE;

       public void setMinimum(long minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(long maximum) {
        this.maximum = maximum;
    }

    public long search(){
        return ((maximum + minimum)/2);
    }
    @Override
    public long askNextGuess() {
        return search();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true) {
            log.log("Lower");
        } else {
            log.log("Greater");
        }
    }
}
