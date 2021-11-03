package max_sk.star.game.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import max_sk.star.game.base.BaseButton;
import max_sk.star.game.math.Rect;
import max_sk.star.game.singleton.GameScreenSingleton;

public class NewGame extends BaseButton {

    private final Game game;

    private static final float HEIGHT = 0.03f;
    private static final float PADDING = 0.5f;
    private static final float PADDING_LEFT = 0.25f;

    public NewGame(TextureAtlas atlas, Game game){
        super(atlas.findRegion("button_new_game"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setLeft(worldBounds.getLeft()+ PADDING_LEFT);
        setTop(worldBounds.getTop() - PADDING);
    }

    @Override
    public void action() {
        game.setScreen(GameScreenSingleton.getMenuScreen(game));
    }

}
