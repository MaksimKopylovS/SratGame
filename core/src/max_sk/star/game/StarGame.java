package max_sk.star.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StarGame extends ApplicationAdapter {
	SpriteBatch spriteBatch;
	Texture seaTexture;

	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		seaTexture = new Texture("sea.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		spriteBatch.begin();
		spriteBatch.draw(seaTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
		seaTexture.dispose();
	}
}
