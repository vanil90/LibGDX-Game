package com.mygdx.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.components.InputComponent;
import com.mygdx.game.components.PositionComponent;

/**
 * Created by Ivan Santos on 10/02/2015.
 */
public class InputSystem extends EntitySystem {
    ImmutableArray<Entity> entities;

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(InputComponent.class, PositionComponent.class).get());
        super.addedToEngine(engine);
    }

    @Override
    public void update(float deltaTime) {
        for (Entity e : entities) {
            if (Gdx.input.isKeyPressed(Input.Keys.W))
                Mappers.position.get(e).y += 1;
            if (Gdx.input.isKeyPressed(Input.Keys.S))
                Mappers.position.get(e).y -= 1;
            if (Gdx.input.isKeyPressed(Input.Keys.A))
                Mappers.position.get(e).x -= 1;
            if (Gdx.input.isKeyPressed(Input.Keys.D))
                Mappers.position.get(e).x += 1;
        }

        super.update(deltaTime);
    }
}
