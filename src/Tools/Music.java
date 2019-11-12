package Tools;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Music {
    private static final String MAIN_MENU_THEME = "src/Asset/Sons/menuSong.mp3";
    private static final String PIOU = "src/Asset/Sons/sonBtn.mp3";
    private static MediaPlayer mediaPlayer;
    private static MediaPlayer mediaPlayer1;

    private static double volume = 0.5;

    public static void startMainMenuMusic() {
        if( mediaPlayer != null ) mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(MAIN_MENU_THEME).toUri().toString()));
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void Piou() {
        mediaPlayer1 = new MediaPlayer(new Media(Paths.get(PIOU).toUri().toString()));
        mediaPlayer1.setCycleCount(1);
        mediaPlayer1.setVolume(volume);
        mediaPlayer1.play();
    }

    public static void setVolume(double volume) {
        Music.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(volume);
    }

/*    public static void startGameMusic() {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(Paths.get(GAME_THEME).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void setVolume(double volume) {
        Music.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(volume);
    }*/


}