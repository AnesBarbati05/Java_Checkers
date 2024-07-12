import java.io.*;
import javax.swing.JOptionPane;

/**
 * The StatisticsManager class manages game statistics.
 * The statistics include the number of games played, games won, games lost,
 * total time played, win streak, win percentage, and player name.
 * The statistics are saved and read from a text file.
 * 
 * @author anes_
 */
public class StatisticsManager {
    /**
     * Number of games played
     */
    private int gamesPlayed;
    
    /**
     * Number of games won
     */
    private int gamesWon;
    
    /**
     * Number of games lost
     */
    private int gamesLost;
    
    /**
     * Total time played (formatted as "mm:ss")
     */
    private String timePlayed;
    
    /**
     * Current win streak
     */
    private int winStreak;
    
    /**
     * Percentage of games won
     */
    private double winPercentage;
    
    /**
     * Player name
     */
    private String name;

    /**
     * Path of the file that stores the game statics
     */
    private static final String FILE_PATH = "statistics.txt";

    /**
     * Constructs a new instance of StatisticsManager.
     * If the statistics file doesn't exist, it initializes the statistics with default values.
     * Otherwise, it reads the statistics from the file.
     */
    public StatisticsManager() {
        if (!isFileExists()) {
            initializeStatistics();
        } else {
            readStatisticsFromFile();
        }
    }

    /**
     * Increases the number of games played by 1 and saves the updated statistics to the file.
     */
    public void setGamesPlayed() {
        gamesPlayed++;
        saveStatisticsToFile();
    }

    /**
     * Increases the number of games won by 1, updates the win streak, win percentage,
     * and saves the updated statistics to the file.
     */
    public void setGamesWon() {
        gamesWon++;
        updateWinStreak();
        updateWinPercentage();
        saveStatisticsToFile();
    }

    /**
     * Increases the number of games lost by 1, resets the win streak, updates the win percentage,
     * and saves the updated statistics to the file.
     */
    public void setGamesLost() {
        gamesLost++;
        resetWinStreak();
        updateWinPercentage();
        saveStatisticsToFile();
    }

    /**
     * Adds the specified number of seconds to the total time played,
     * updates the time played value, and saves the updated statistics to the file.
     *
     * @param seconds The number of seconds to add to the total time played.
     */
    public void addSeconds(int seconds) {
        int currentTotalSeconds = timeToSeconds(timePlayed);
        int newTotalSeconds = currentTotalSeconds + seconds;
        timePlayed = secondsToTime(newTotalSeconds);
        saveStatisticsToFile();
    }

    /**
     * Converts the time in "mm:ss" format to total seconds.
     *
     * @param time The time in "mm:ss" format.
     * @return The total number of seconds.
     */
    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    /**
     * Converts the total seconds to time in "mm:ss" format.
     *
     * @param seconds The total number of seconds.
     * @return The time in "mm:ss" format.
     */
    private String secondsToTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    /**
     * Sets the win streak to the specified value and saves the updated statistics to the file.
     *
     * @param winStreak The new win streak value.
     */
    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
        saveStatisticsToFile();
    }

    /**
     * Initializes the statistics with default values and saves them to the file.
     */
    public void initializeStatistics() {
        gamesPlayed = 0;
        gamesWon = 0;
        gamesLost = 0;
        timePlayed = "00:00";
        winStreak = 0;
        winPercentage = 0.0;
        name = JOptionPane.showInputDialog("inserisci nome");
        saveStatisticsToFile();
    }

    /**
     * Reads the statistics from the file and updates the instance variables.
     * If an error occurs during reading, the stack trace is printed.
     */
    private void readStatisticsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            String[] parts = line.split(";");
            gamesPlayed = Integer.parseInt(parts[0]);
            gamesWon = Integer.parseInt(parts[1]);
            gamesLost = Integer.parseInt(parts[2]);
            timePlayed = parts[3];
            winStreak = Integer.parseInt(parts[4]);
            winPercentage = Double.parseDouble(parts[5].replace("%", ""));
            name = parts[6];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the current statistics to the file.
     * If an error occurs during writing, the stack trace is printed.
     */
    private void saveStatisticsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String statistics = gamesPlayed + ";" + gamesWon + ";" + gamesLost + ";" + timePlayed + ";" +
                    winStreak + ";" + winPercentage + ";" + name;
            writer.write(statistics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the statistics file exists.
     *
     * @return true if the file exists, false otherwise.
     */
    private boolean isFileExists() {
        File file = new File(FILE_PATH);
        return file.exists();
    }

    /**
     * Updates the win percentage based on the number of games played and won.
     * If no games have been played, the win percentage is set to 0.0.
     */
    private void updateWinPercentage() {
        if (gamesPlayed != 0) {
            winPercentage = (((double) gamesWon) / (double)gamesPlayed) * 100.0;
        } else {
            winPercentage = 0.0;
        }
    }

    /**
     * Increases the win streak by 1.
     */
    private void updateWinStreak() {
        winStreak++;
    }

    /**
     * Resets the win streak to 0.
     */
    private void resetWinStreak() {
        winStreak = 0;
    }

    /**
     * Retrieves the player name.
     *
     * @return The player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the number of games played.
     *
     * @return The number of games played.
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * Retrieves the number of games won.
     *
     * @return The number of games won.
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * Retrieves the number of games lost.
     *
     * @return The number of games lost.
     */
    public int getGamesLost() {
        return gamesLost;
    }

    /**
     * Retrieves the total time played in "mm:ss" format.
     *
     * @return The total time played.
     */
    public String getTimePlayed() {
        return timePlayed;
    }

    /**
     * Retrieves the current win streak.
     *
     * @return The win streak.
     */
    public int getWinStreak() {
        return winStreak;
    }

    /**
     * Retrieves the win percentage.
     *
     * @return The win percentage.
     */
    public double getWinPercentage() {
        return winPercentage;
    }
}
