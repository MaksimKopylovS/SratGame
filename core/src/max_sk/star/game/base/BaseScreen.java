package max_sk.star.game.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class BaseScreen implements Screen, InputProcessor {

    protected SpriteBatch spriteBatch;

    @Override
    public void show() {
        System.out.println("show");
        spriteBatch = new SpriteBatch();
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
        System.out.println("resize: width = " + width + " height = " + height);
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
        spriteBatch.dispose();
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
        System.out.println("touchDown: screenX - " + screenX + " screenY - " + screenY + " pointer - " + pointer + " button - " + button);
        return false;
    }
// срабатывает когда мы уберавем палец с экрана
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp: screenX - " + screenX + " screenY - " + screenY + " pointer - " + pointer + " button - " + button);
        return false;
    }

//Срабаыватект когда мы зажымаем обект о тоскаем его по экрану
//отображает координаты и номер пальца или мыши
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchUp: screenX - " + screenX + " screenY - " + screenY + " pointer - " + pointer);
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
