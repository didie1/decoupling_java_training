package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    public final Logger log = LoggerFactory.getLogger("player");
    public Scanner scan = new Scanner(System.in);
    @Override
    public long askNextGuess() {
        log.log("Type in a number");
        long guess = scan.nextInt();
        scan.nextLine();
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == false)
        {
            log.log("Lower");
        }
        else
        {
            log.log("Greater");
        }
    }
}
