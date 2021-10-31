package max_sk.star.game.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.math.Rect;
import max_sk.star.game.pool.BulletPool;
import max_sk.star.game.sprite.Bullet;

public class Ship extends Sprite {

    protected BulletPool bulletPool;
    protected Sound bulletSound;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletV;
    protected Vector2  bulletPos;
    protected float bulletHeight;
    protected int damage;
    protected int hp;

    protected Vector2 v;
    protected Vector2 v0;

    protected float reloadTime;
    protected float reloadInterval;
    protected Rect worldBounds;

    public Ship(){

    }

    public Ship(TextureRegion region, int rows, int cols, int frames){
        super(region, rows, cols, frames);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        reloadTime +=delta;
        if (reloadTime >= reloadInterval){
            reloadTime = 0f;
            shoot();
        }
        bulletPos.set(pos);
    }

    private void shoot(){
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, bulletPos, bulletV, worldBounds, bulletHeight, damage);
        bulletSound.play();
    }
}
