package max_sk.star.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.base.BaseButton;
import max_sk.star.game.base.Sprite;
import max_sk.star.game.math.Rect;
import max_sk.star.game.math.Rnd;

public class GameOver extends Sprite {

    private static final float HEIGHT = 0.08f;
    private static final float PADDING = 0.1f;
    private static final float PADDING_LEFT = 0.07f;
    private Rect worldBounds;
    private Boolean pressed;
    private int pointer;
    public GameOver(TextureAtlas textureAtlas) {
        super(textureAtlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setHeightProportion(HEIGHT);
        setLeft(worldBounds.getLeft()+ PADDING_LEFT);
        setTop(worldBounds.getTop() - PADDING);
    }
}
