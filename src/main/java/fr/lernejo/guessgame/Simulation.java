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
            long guess = player.askNextGuess();
            if (numberToGuess == guess)
            {
                return true;
            }
            else
            {
                if (guess < numberToGuess)
                {
                    player.respond(true);
                    return false;
                }
                else
                {
                    player.respond(false);
                    return false;
                }

            }
        }

        public void loopUntilPlayerSucceed() {
            while (nextRound() == false)
            {
                nextRound();
            }
        }
    }

