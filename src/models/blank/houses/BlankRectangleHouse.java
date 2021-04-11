/*package models.blank.houses;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;
import models.blank.BlankRoom3;
import models.blank.BlankThing;
import models.blank.helpers.BlankWindow;

public class BlankRectangleHouse extends BlankThing {
    int floorNumber = 1;
    float floorHeight = 3;
    float floorLength;
    float floorWidth;
    float position;

    BlankRoom3[] array_blankRoom3;

    public BlankRectangleHouse(AssetManager assetManager){
        super(assetManager);
        node = new Node("BlankRectangleHouse");
        //1 Porte
        //X fenetres régulièrement espacées
        //1 toit triangulaire
        //Etages carrés, 1 seule pièce
        //pas d'escaliers (peut être plus tard)
    }

    public BlankRectangleHouse(AssetManager assetManager, float floorLength, float floorWidth){
        super(assetManager);
        this.floorLength = floorLength;
        this.floorWidth = floorWidth;
        node = new Node("BlankRectangleHouse");

        array_blankRoom3 = new BlankRoom3[2];
        br3 = new BlankRoom3(assetManager, floorLength, floorHeight, floorWidth);
        /*br3.draw();
        br3.setMulticolorShaded(assetManager);
        node.attachChild(br3.getNode());*/

        /*room3.addWindow("frontWall", new BlankWindow(2,1,new Vector2f(3.5f,1.5f)));
        room3.addWindow("frontWall", new BlankWindow(1,2,new Vector2f(1,1)));
        room3.addWindow("backWall", new BlankWindow(1,1,new Vector2f(4.4f,1.5f)));*//*
    }

    public void draw(){

    }
}*/
