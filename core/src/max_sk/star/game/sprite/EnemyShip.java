package max_sk.star.game.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.base.Ship;
import max_sk.star.game.math.Rect;
import max_sk.star.game.pool.BulletPool;

public class EnemyShip extends Ship {


    public EnemyShip(BulletPool bulletPool, Rect worldBounds, Sound bulletSound){
        this.bulletPool = bulletPool;
        this.worldBounds =worldBounds;
        this.bulletSound = bulletSound;
        this.bulletV = new Vector2();
        this.bulletPos = new Vector2();
        this.v = new Vector2();
        this.v0 = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        bulletPos.set(this.pos.x, getBottom());
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }

    public void set(
        TextureRegion[] regions,
        Vector2 v,
        TextureRegion bulletRegion,
        float bulletHeight,
        Vector2 bulletV,
        int damage,
        int hp,
        float reloadInterval,
        float height
    ){
        this.regions = regions;
        this.v.set(v);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV = bulletV;
        this.hp = hp;
        this.reloadInterval = reloadInterval;
        setHeightProportion(height);

    }
}
