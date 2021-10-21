package max_sk.star.game.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;


import max_sk.star.game.math.MatrixUtils;
import max_sk.star.game.math.Rect;

public class BaseScreen implements Screen, InputProcessor {


    private Rect screenBounds;
    private Rect worldBounds;
    private Rect glBounds;

    private Matrix4 worldToGl;
    private Matrix3 screenToWorld;

    private final Vector2 touch = new Vector2();

    protected SpriteBatch batch;

    @Override
    public void show() {

        batch = new SpriteBatch();
        System.out.println("show");
        screenBounds = new Rect();
        worldBounds = new Rect();
        glBounds = new Rect(0, 0, 1, 1);
        worldToGl = new Matrix4();
        screenToWorld = new Matrix3();
        batch = new SpriteBatch();
        batch.getProjectionMatrix().idt();
        Gdx.input.setInputProcessor(this);

// Сообщает Приложению что приложение использует инпут процессор(Слежение за комбинациями клавищь)
        Gdx.input.setInputProcessor(this);
    }

//    Срабатывает 60 раз в секунду delta момент времени между срабатыванием меттода
    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
    }
//  срабаытвает после метода show, каждый раз когда меняются размеры экрана
    @Override
    public void resize(int width, int height) {
        System.out.println("resize width = " + width + " height = " + height);
        screenBounds.setSize(width, height);
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);

        float aspect = width / (float) height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f * aspect);
        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);
        batch.setProjectionMatrix(worldToGl);
        resize(worldBounds);
    }

    public void resize(Rect worldBounds) {
        System.out.println("resize worldBounds.width = "
                + worldBounds.getWidth() + " worldBounds.height = " + worldBounds.getHeight());
    }

//  Срабатывает когда мы свернули экран
    @Override
    public void pause() {
        System.out.println("pause");
    }
// Срабатывает когда развернули экран
    @Override
    public void resume() {
        System.out.println("resume");
    }
//Срабатывает при переключение на другой экран или при закрытиит
    @Override
    public void hide() {
        System.out.println("hide");
        dispose();
    }

//    нужно вызывать в ручную луще в метода hide
    @Override
    public void dispose() {
        System.out.println("dispose");
        batch.dispose();
    }
// Метод получение нажатия любой клавиши
    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown: keykode - " + keycode);
        return false;
    }

// Срабытывате при отпиускании клавищы
    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyUp: keykode - " + keycode);
        return false;
    }
// Сам факт нажатия клавищы, срабыватывает при зажатиии клавищы
    @Override
    public boolean keyTyped(char character) {
        System.out.println("keyTyped: character - " + character);
        return false;
    }
// Срабытывает когда кликаем мышкой по экрану или тыкаем пальцем по экрану телефона
//    Отображает координаты нажатия мышы,номер кноки мыши номер пальца координаты
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDowntouchDown: screenX - " + screenX + " screenY - " + screenY + " pointer - " + pointer + " button - " + button);
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDown(touch, pointer, button);
        return false;
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {
        System.out.println("touchDown@@@@@ touch.X = " + touch.x + " touch.Y = " + touch.y);
        return false;
    }

// срабатывает когда мы уберавем палец с экрана
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp: screenX - " + screenX + " screenY - " + screenY + " pointer - " + pointer + " button - " + button);
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchUp(touch, pointer, button);
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button) {
        System.out.println("touchUp touch.X = " + touch.x + " touch.Y = " + touch.y);
        return false;
    }


//Срабаыватект когда мы зажымаем обект о тоскаем его по экрану
//отображает координаты и номер пальца или мыши
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchUp: screenX - " + screenX + " screenY - " + screenY + " pointer - " + pointer);
        touch.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDragged(touch, pointer);
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
        System.out.println("touchDragged touch.X = " + touch.x + " touch.Y = " + touch.y);
        return false;
    }

//    Логирует движениме мыши
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
//Скролинг колёсика мыши
    @Override
    public boolean scrolled(float amountX, float amountY) {
        System.out.println("scrolled - amountX "+  amountX + " amountY - " + amountY );
        return false;
    }
}
