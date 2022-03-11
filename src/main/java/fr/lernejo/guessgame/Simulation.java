package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

public class Simulation {
         private final Logger logger = LoggerFactory.getLogger("simulation");
        private final Player player;  //TODO add variable type
        private long numberToGuess; //TODO add variable type

        public Simulation(Player player) {
            this.player = player;
        }

        public void initialize(long numberToGuess) {
            this.numberToGuess = numberToGuess;
        }

        /**
         * @return true if the player have guessed the right number
         */
        private boolean nextRound() {
            if (this.player instanceof HumanPlayer) {
                long guess = player.askNextGuess();
                if (numberToGuess == guess) {
                    return true;
                } else {
                    if (guess < numberToGuess) {
                        player.respond(true);
                        return false;
                    } else {
                        player.respond(false);
                        return false;
                    }
                }
            }
            else if (this.player instanceof ComputerPlayer){
                    long guess = ((ComputerPlayer) player).search();
                    if (numberToGuess == guess) {
                        return true;
                    } else {
                        if (guess < numberToGuess) {
                            player.respond(true);
                            ((ComputerPlayer) player).setMaximum(guess);
                        } else {
                            player.respond(false);
                            ((ComputerPlayer) player).setMinimum(guess);
                        }
                    }
                }
            return false;
        }

    public void loopUntilPlayerSucceed(long max) {
        long iteration = 0;
        long time = System.currentTimeMillis();
        while (!nextRound() && iteration++ < max) ;
        long timeStamp = System.currentTimeMillis();

        long durationParty = timeStamp - time;

        if (iteration >= max)
        {
            logger.log("Maybe next time !");
        }
        else
        {
            logger.log("Congrats!");
        }
    }
    }

