package max_sk.star.game.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.base.Ship;
import max_sk.star.game.math.Rect;
import max_sk.star.game.pool.BulletPool;

public class EnemyShip extends Ship {

    private static final float START_SHIP = 0.5f;
    private int count = 0;

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

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setTop(START_SHIP);
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

    public void setV(Vector2 v){
        this.v.set(v);
    }

    public void goEnemyShip(final Vector2 v){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    if(count == 5){
                        count = 0;
                        setV(v);
                    }
                }
            }
        }).start();
    }
}
