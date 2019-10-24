/*
package Music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;
import java.util.Random;

public class EffetsSonores {
    private static final String mange = "src/Asset/Sons/mange.mp3";
    private static final String[] moi = {
            "src/Asset/Sons/moi.mp3",
            "src/Asset/Sons/moi2.mp3",
            "src/Asset/Sons/oui1.mp3",
            "src/Asset/Sons/oui2.mp3"
    };
    private static final String[] phrase = {
            "src/Asset/Sons/phrase.mp3",
            "src/Asset/Sons/phrase2.mp3",
            "src/Asset/Sons/phrase3.mp3"
    };

    private static final String pas = "src/Asset/Sons/pas.mp3";
    private static final String victory = "src/Asset/Sons/victory.mp3";
    private static MediaPlayer mediaPlayer;
    private static double volume =1;


    public static void playEffectsMange() {

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get(mange).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
    public static void playEffectsPas() {

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get(pas).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }
    public static void playEffectsVictory() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get(victory).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void playEffectsMoi() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get(moi[new Random().nextInt(4)]).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void playEffectsPhrase() {
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get(phrase[new Random().nextInt(2)]).toUri().toString()));
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public static void setVolume(double volume) {
        EffetsSonores.volume = volume;
        if(mediaPlayer!=null) mediaPlayer.setVolume(volume);
    }
}
*/
