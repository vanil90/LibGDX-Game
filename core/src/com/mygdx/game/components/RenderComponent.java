package com.mygdx.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class RenderComponent extends Component {
    public Texture texture;

    public RenderComponent(Texture texture) {
        this.texture = texture;
    }
}
