package com.mygdx.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.components.InputComponent;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.RenderComponent;
import com.mygdx.game.systems.InputSystem;
import com.mygdx.game.systems.RenderSystem;

public class MyGdxGame extends ApplicationAdapter {
    Engine engine = new Engine();

    @Override
    public void create() {
        Entity derp = new Entity();

        derp.add(new PositionComponent(100.0f, 100.0f));
        derp.add(new RenderComponent(new Texture("badlogic.jpg")));
        derp.add(new InputComponent());

        engine.addSystem(new InputSystem());
        engine.addSystem(new RenderSystem());
        engine.addEntity(derp);
    }

    @Override
    public void render() {
        engine.update(Gdx.graphics.getDeltaTime());

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();
    }
}
