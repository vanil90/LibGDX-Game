package com.mygdx.game.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.RenderComponent;

public class Mappers {
    public static ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
    public static ComponentMapper<RenderComponent> render = ComponentMapper.getFor(RenderComponent.class);
}
