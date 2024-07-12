import javax.swing.*;


/**
 * The ScoreManager class is responsible for managing the game score and timer.
 * It extends the Thread class to run as a separate thread for updating the timer.
 * 
 * @author anes_
 */
public class ScoreManager extends Thread {
    /**
     * The minutes component of the timer
     */
    private int minutes;
    
    /**
     * The seconds component of the timer
     */
    private int seconds;
    
    /**
     * The score for the black player
     */
    private int scoreBlack;
    
    /**
     * The score for the white player
     */
    private int scoreWhite;
    
    /**
     * The label to display the timer
     */
    private JLabel lblTimer;
    
    /**
     *  The label to display the white player's score
     */
    private JLabel lblScoreWhite;
    
    /**
     * The label to display the black player's score
     */
    private JLabel lblScoreBlack;
    
    /**
     * The formatted minutes for the timer display
     */
    private String formattedMinutes;
    
    /**
     * The formatted seconds for the timer display
     */
    private String formattedSeconds;
    
    /**
     * The turn of the players
     */
    private boolean turn;
    
    /**
     * The statistics manager object
     */
    private StatisticsManager statisticsManager;

    /**
     * Constructs a ScoreManager object with the specified labels for the timer and scores.
     *
     * @param lblTimer       the label to display the timer
     * @param lblScoreWhite  the label to display the white player's score
     * @param lblScoreBlack  the label to display the black player's score
     * @param statisticsManager the statisticsManager that updates the statistics
     */
    public ScoreManager(JLabel lblTimer, JLabel lblScoreWhite, JLabel lblScoreBlack, StatisticsManager statisticsManager) {
        minutes = 0;
        seconds = 0;
        scoreBlack = 0;
        scoreWhite = 0;
        this.lblTimer = lblTimer;
        this.lblScoreWhite = lblScoreWhite;
        this.lblScoreBlack = lblScoreBlack;
        this.statisticsManager = statisticsManager;
    }

    /**
     * Overrides the run() method of the Thread class.
     * This method updates the timer and statistics every second.
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                updateTimerLabel();
                statisticsManager.addSeconds(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Updates the timer label with the current time.
     */
    private void updateTimerLabel() {
        formattedMinutes = String.format("%02d", minutes);
        formattedSeconds = String.format("%02d", seconds);
        SwingUtilities.invokeLater(() -> {
            lblTimer.setText(formattedMinutes + ":" + formattedSeconds);
        });
    }
    
    /**
     * Sets the score for the players and updates the corresponding labels.
     *
     * @param score  true if the white player scored, false if the black player scored
     */
    public void setScore(boolean score) {
        System.out.println("SETSCOREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        System.out.println("turn = " + turn);
        System.out.println("score = " + score);
        
        if (score) {
            statisticsManager.setGamesPlayed();
            if (turn) {
                statisticsManager.setGamesWon();
                scoreWhite++;
            } else {
                statisticsManager.setGamesLost();
            }
            
            lblScoreWhite.setText(Integer.toString(scoreWhite));
            
            
        } else {
            statisticsManager.setGamesPlayed();
            if (!turn) {
                statisticsManager.setGamesWon();
                scoreBlack++;
            } else {
                statisticsManager.setGamesLost();
            }
            
            lblScoreBlack.setText(Integer.toString(scoreBlack));
            
        }
    }
    
    /**
     * Sets the turn of the players.
     *
     * @param turn  true if it's the white player's turn, false if it's the black player's turn
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
