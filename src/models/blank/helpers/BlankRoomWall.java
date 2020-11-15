package models.blank.helpers;

import com.jme3.asset.AssetManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import models.blank.BlankWall;

public class BlankRoomWall extends BlankWall{
    private String name;
    private Vector3f translation;
    private Quaternion rotation;
    private boolean draw;

    public BlankRoomWall(AssetManager assetManager, String name, BlankWall blankWall){
        super(assetManager, blankWall.getWidth(), blankWall.getHeight());
        this.name=name;
        this.translation = new Vector3f(0,0,0);
        this.rotation = new Quaternion().fromAngles(0,0,0);
        this.draw = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
