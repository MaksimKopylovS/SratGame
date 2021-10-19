package max_sk.star.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


import max_sk.star.game.base.BaseScreen;


public class MenuScreen extends BaseScreen {

    private static final float SPEAD = 2f;

    Texture seaBackGroundTexture;
    Texture gullTexture;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 vTo;



    @Override
    public void show() {
        super.show();
        seaBackGroundTexture= new Texture("sea.jpg");
        gullTexture = new Texture("gull.jpg");
        touch = new Vector2();

        vTo = new Vector2();
        touch.setLength(1.4f);
        v = new Vector2(-1,1);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(seaBackGroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.draw(gullTexture, vTo.x,vTo.y);
        spriteBatch.end();

        toFollow();
    }

    @Override
    public void dispose() {
        super.dispose();
        seaBackGroundTexture.dispose();
        gullTexture.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(vTo)).setLength(SPEAD);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDragged(screenX, screenY, pointer);
    }

    public void toFollow(){
        if (vTo.dst(touch) <= v.len()){
            vTo.set(touch);
        }else{
            vTo.add(v);
        }
    }

}
