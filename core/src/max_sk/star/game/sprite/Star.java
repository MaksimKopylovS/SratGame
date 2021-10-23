package max_sk.star.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.base.Sprite;
import max_sk.star.game.math.Rect;
import max_sk.star.game.math.Rnd;

public class Star extends Sprite {

    private final Vector2 v;
    private Rect worldBounds;


    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        v = new Vector2(Rnd.nextFloat(-0.005f, 0.005f), Rnd.nextFloat(-0.2f, -0.05f));
    }

    @Override
    public void resize(Rect worldBounds) {

    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
    }
}
