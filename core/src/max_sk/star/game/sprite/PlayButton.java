package max_sk.star.game.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import max_sk.star.game.base.BaseButton;
import max_sk.star.game.math.Rect;
import max_sk.star.game.screen.GameScreen;
import max_sk.star.game.singleton.GameScreenSingleton;

public class PlayButton extends BaseButton {

    private static final float HEIGHT = 0.25f;
    private static final float PADDING = 0.03f;

    private final Game game;

    public PlayButton(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setLeft(worldBounds.getLeft() + PADDING);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void action() {
        game.setScreen(GameScreenSingleton.getMenuScreen(game));
    }

    public PlayButton getAction(){
        return this;
    }
}

