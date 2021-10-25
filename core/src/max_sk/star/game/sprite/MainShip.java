package max_sk.star.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.base.BaseShip;
import max_sk.star.game.math.Rect;

public class MainShip extends BaseShip {

    private static float posishon;
    private static final float HEIGHT = 0.2f;
    private Rect worldBounds;

    private static Vector2 v;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("mainBlack"));
        v = new Vector2(0.0f,0.0f);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(HEIGHT);
        float x = 0;
        float y = worldBounds.getBottom() + halfHeight;
        pos.set(x, y);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
    }

    public void setPositionLeft(){
        v.x = v.x - 0.05f;

//        System.out.println("yyy left");
//        posishon = posishon - 0.015f;
//        setRight(posishon);
//        System.out.println(posishon + "         position");
    }

    public void setPositionRight(){
        v.x = v.x + 0.05f;
//        System.out.println("yyy right");
//        posishon = posishon + 0.015f;
//        setLeft(posishon);
//        System.out.println(posishon + "         position");
    }
}
