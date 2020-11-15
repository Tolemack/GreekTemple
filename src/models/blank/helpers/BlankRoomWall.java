package models.blank.helpers;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import models.blank.BlankWall;

public class BlankRoomWall {
    private String name;
    private BlankWall blankwall;
    private Vector3f translation;
    private Quaternion rotation;
    private boolean draw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlankWall getBlankwall() {
        return blankwall;
    }

    public void setBlankwall(BlankWall blankwall) {
        this.blankwall = blankwall;
    }

    public Vector3f getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3f translation) {
        this.translation = translation;
    }

    public Quaternion getRotation() {
        return rotation;
    }

    public void setRotation(Quaternion rotation) {
        this.rotation = rotation;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
