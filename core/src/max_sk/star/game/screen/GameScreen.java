package max_sk.star.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import max_sk.star.game.base.BaseScreen;
import max_sk.star.game.math.Rect;
import max_sk.star.game.sprite.Background;
import max_sk.star.game.sprite.MainShip;
import max_sk.star.game.sprite.Star;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 64;

    private TextureAtlas atlas;
    private TextureAtlas atlasMainShip;
    private Texture bg;
    private Background background;

    private Star[] stars;
    private MainShip mainShip;

    @Override
    public void show() {
        super.show();
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        atlasMainShip = new TextureAtlas("textures/mainShip.pack");
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        stars = new Star[STAR_COUNT];
        mainShip = new MainShip(atlasMainShip);

        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
        atlasMainShip.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keycode " + keycode );

        if (keycode == 21){
            mainShip.setPositionLeft();
        }
        if (keycode == 22){
            mainShip.setPositionRight();
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println(character + " character");
        if (character == 'a'){
            mainShip.setPositionLeft();
        }
        if (character == 'd'){
            mainShip.setPositionRight();
        }
        return super.keyTyped(character);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return super.touchUp(touch, pointer, button);
    }

    private void update(float delta) {
        mainShip.update(delta);
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        mainShip.draw(batch);
        batch.end();
    }
}
