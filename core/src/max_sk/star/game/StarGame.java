package max_sk.star.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import max_sk.star.game.screen.MenuScreen;
import max_sk.star.game.vector.Vector;

public class StarGame extends Game {

	@Override
	public void create () {
//		Вданный метод передаётся любой клас наследник от Screan
		setScreen(new MenuScreen(this));
	}
}
