package com.mygdx.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.RenderComponent;


public class RenderSystem extends EntitySystem {
    ImmutableArray<Entity> entities;
    SpriteBatch batch;

    public RenderSystem() {
        batch = new SpriteBatch();
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, RenderComponent.class).get());
        super.addedToEngine(engine);
    }

    @Override
    public void removedFromEngine(Engine engine) {

        super.removedFromEngine(engine);
    }

    @Override
    public void update(float deltaTime) {
        float r, g, b;
        r = 100 / 256f;
        g = 149 / 256f;
        b = 237 / 256f;

        Gdx.gl20.glClearColor(r, g, b, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        for (Entity e : entities) {
            Texture texture = Mappers.render.get(e).texture;
            float x = Mappers.position.get(e).x;
            float y = Mappers.position.get(e).y;

            batch.draw(texture, x, y);
        }
        batch.end();

        super.update(deltaTime);
    }
}
