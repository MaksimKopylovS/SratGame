package max_sk.star.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import max_sk.star.game.base.Sprite;
import max_sk.star.game.math.Rect;

public class CalibriTextur extends Sprite {
    public CalibriTextur(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.10f);
        pos.set(worldBounds.pos);
    }




}
