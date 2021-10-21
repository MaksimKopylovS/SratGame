package max_sk.star.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;


import max_sk.star.game.base.BaseScreen;
import max_sk.star.game.math.Rect;
import max_sk.star.game.sprite.Background;
import max_sk.star.game.sprite.CalibriTextur;


public class MenuScreen extends BaseScreen {

    private static final float SPEAD = 0.001f;

    Texture seaBackGroundTexture;
    Texture gullTexture;

    private Rect touch;
    private Rect v;
    private Rect vTo;

    private Background background;
    private CalibriTextur calibriTextur;
    private Vector2 vectorV;

    @Override
    public void show() {
        super.show();
        seaBackGroundTexture= new Texture("sea.jpg");
        background = new Background(seaBackGroundTexture);
        gullTexture = new Texture("gull.jpg");
        calibriTextur = new CalibriTextur(gullTexture);
        touch = new Rect(0.0f,0.0f, 0.10f, 0.10f);
        vTo = new Rect(0.0f,0.0f, 0.10f, 0.10f);
        v = new Rect(0,0, 0.10f, 0.10f);
        vectorV = new Vector2();

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        calibriTextur.resize(worldBounds);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        calibriTextur.draw(batch);
        batch.end();
        calibriTextur.set(vTo);

        toFollow();
    }

    @Override
    public void dispose() {
        super.dispose();
        seaBackGroundTexture.dispose();
        gullTexture.dispose();
    }

    @Override
    public boolean touchDown(Vector2 vector, int pointer, int button) {
        System.out.println( vector.x + "  " +  vector.y);
//        Вычитаем из высоты экрана screenY для выравнивания позиции по оиси y
        touch.set(new Rect((float) vector.x, (float) vector.y, 0.10f, 0.10f));
        vectorV.set(getFolowMe(touch, vTo, SPEAD));
        v.set(new Rect(vectorV.x, vectorV.y, 0.10f, 0.10f));
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }


    public Vector2 getFolowMe(Rect one, Rect two, float spead){
        return new Vector2().set(one.getPos().cpy().sub(two.getPos()).setLength(spead));
    }

    public void toFollow(){
        if (vTo.getPos().dst(touch.getPos()) <= v.getPos().len()){
            vTo.set(touch);
        }else{
            vTo.getPos().add(v.getPos());
        }
    }

}
