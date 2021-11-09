package max_sk.star.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import max_sk.star.game.base.BaseButton;
import max_sk.star.game.math.Rect;
import max_sk.star.game.screen.GameScreen;

public class NewGameButton  extends BaseButton {

    private static final float HEIGHT = 0.05f;
    private static final float TOP_MARGIN = -0.012f;

    private final GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }

    @Override
    public void resize(Rect worldBounds) {
      setHeightProportion(HEIGHT);
      setTop(TOP_MARGIN);
    }
}
