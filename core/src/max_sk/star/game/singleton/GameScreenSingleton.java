package max_sk.star.game.singleton;

import com.badlogic.gdx.Game;

import max_sk.star.game.screen.GameScreen;

public class GameScreenSingleton {

    private static GameScreen gameScreen;

    public static GameScreen getMenuScreen(Game game) {
        if (gameScreen == null) {
            gameScreen = new GameScreen(game);
        }
        return gameScreen;
    }
}
