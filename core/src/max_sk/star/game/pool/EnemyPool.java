package max_sk.star.game.pool;

import com.badlogic.gdx.audio.Sound;

import max_sk.star.game.base.SpritesPool;
import max_sk.star.game.math.Rect;
import max_sk.star.game.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final BulletPool bulletPool;
    private final Rect worldBounds;
    private final Sound bulletSound;

    public EnemyPool(BulletPool bulletPool, Rect worldBounds, Sound bulletSound) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.bulletSound = bulletSound;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, worldBounds , bulletSound);
    }
}
