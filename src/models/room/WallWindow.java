package models.room;

import com.jme3.math.Vector2f;

public class WallWindow {
    private float width;
    private float height;
    private Vector2f position;

    public WallWindow(float width, float height, Vector2f position){
        this.setWidth(width);
        this.setHeight(height);
        this.setPosition(position);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }
}
