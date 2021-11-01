package max_sk.star.game.util;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.math.Rect;
import max_sk.star.game.math.Rnd;
import max_sk.star.game.pool.EnemyPool;
import max_sk.star.game.sprite.EnemyShip;

public class EnemyEmitter {

    private static final float GENERATE_INTERVAL = 4f;

    private static final float ENEMY_SMALL_HEIGHT = 0.1f;
    private static final float ENEMY_SMALL_BULLET_HEIGHT = 0.01f;
    private static final int ENEMY_SMALL_BULLE_DAMEGE = 1;
    private static final float ENEMY_SMALL_RELOAD_INTERVAL = 1f;
    private static final int ENEMY_SMALL_HP = 1;

    private static final float ENEMY_MEDIUM_HEIGHT = 0.15f;
    private static final float ENEMY_MEDIUM_BULLET_HEIGHT = 0.02f;
    private static final int ENEMY_MEDIUM_BULLE_DAMEGE = 5;
    private static final float ENEMY_MEDIUM_RELOAD_INTERVAL = 2f;
    private static final int ENEMY_MEDIUM_HP = 5;

    private static final float ENEMY_BIG_HEIGHT = 0.2f;
    private static final float ENEMY_BIG_BULLET_HEIGHT = 0.03f;
    private static final int ENEMY_BIG_BULLE_DAMEGE = 10;
    private static final float ENEMY_BIG_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_BIG_HP = 10;

    private final EnemyPool enemyPool;
    private final Rect worldBounds;
    private float generateTimer;
    private final TextureRegion[] enemySmallRegions;
    private final TextureRegion[] enemyMediumRegions;
    private final TextureRegion[] enemyBigRegions;

    private final Vector2 startEnemy = new Vector2(0f, -0.0f);
    private final Vector2 enemySmallV = new Vector2(0f, -0.4f);
    private final Vector2 enemyMediumV = new Vector2(0f, -0.3f);
    private final Vector2 enemyBigV = new Vector2(0f, -0.2f);
    private final Vector2 enemySmallBulletV = new Vector2(0f, -0.35f);
    private final Vector2 enemyMediumBulletV = new Vector2(0f, -0.25f);
    private final Vector2 enemyBigBulletV = new Vector2(0f, -0.3f);
    private final TextureRegion bulletRegion;
    private static EnemyShip enemy;
    private int count;

    public EnemyEmitter(EnemyPool enemyPool, Rect worldBounds, TextureAtlas atlas) {
        this.enemyPool = enemyPool;
        this.worldBounds = worldBounds;
        bulletRegion = atlas.findRegion("bulletEnemy");
        enemySmallRegions = Regions.split(atlas.findRegion("enemy0"), 1, 2, 2);
        enemyMediumRegions = Regions.split(atlas.findRegion("enemy1"), 1, 2, 2);
        enemyBigRegions = Regions.split(atlas.findRegion("enemy2"), 1, 2, 2);
        count = 0;
    }

    public void generate(float delta) {
        generateTimer += delta;
        if (generateTimer >= GENERATE_INTERVAL) {
            generateTimer = 0f;
            enemy = enemyPool.obtain();
            float type = (float) Math.random();
            if (type < 0.5f) {
                enemy.set(
                        enemySmallRegions,
                        startEnemy,
                        bulletRegion,
                        ENEMY_SMALL_BULLET_HEIGHT,
                        enemySmallBulletV,
                        ENEMY_SMALL_BULLE_DAMEGE,
                        ENEMY_SMALL_HP,
                        ENEMY_SMALL_RELOAD_INTERVAL,
                        ENEMY_SMALL_HEIGHT
                );
                enemy.goEnemyShip(enemySmallV);
            } else if (type < 0.8f) {
                enemy.set(
                        enemyMediumRegions,
                        startEnemy,
                        bulletRegion,
                        ENEMY_MEDIUM_BULLET_HEIGHT,
                        enemyMediumBulletV,
                        ENEMY_MEDIUM_BULLE_DAMEGE,
                        ENEMY_MEDIUM_HP,
                        ENEMY_MEDIUM_RELOAD_INTERVAL,
                        ENEMY_MEDIUM_HEIGHT);
                enemy.goEnemyShip(enemyMediumV);
            } else {
                enemy.set(
                        enemyBigRegions,
                        startEnemy,
                        bulletRegion,
                        ENEMY_BIG_BULLET_HEIGHT,
                        enemyBigBulletV,
                        ENEMY_BIG_BULLE_DAMEGE,
                        ENEMY_BIG_HP,
                        ENEMY_BIG_RELOAD_INTERVAL,
                        ENEMY_BIG_HEIGHT);
                enemy.goEnemyShip(enemyBigV);
            }
            enemy.pos.x = Rnd.nextFloat(
                    worldBounds.getLeft() + enemy.getHalfWidth(),
                    worldBounds.getRight() - enemy.getHalfWidth()
            );
           enemy.resize(worldBounds);
        }
    }

    public EnemyPool getEnemyPool(){
        return enemyPool;
    }
}