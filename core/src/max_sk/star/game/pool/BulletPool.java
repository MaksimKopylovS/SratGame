package max_sk.star.game.pool;

import max_sk.star.game.base.SpritesPool;
import max_sk.star.game.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
