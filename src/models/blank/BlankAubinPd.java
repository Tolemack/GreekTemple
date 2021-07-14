package models.blank;

import com.jme3.asset.AssetManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class BlankAubinPd extends BlankThing{
    public BlankAubinPd(){
        super();

        Box BoxA1 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallA1 = new Geometry("A1",BoxA1);
        wallA1.setMaterial(this.blankUnshaded);
        wallA1.setLocalTranslation(new Vector3f(0f,0f,0));
        this.node.attachChild(wallA1);

        Box BoxA2 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallA2 = new Geometry("A2",BoxA2);
        wallA2.setMaterial(this.blankUnshaded);
        wallA2.setLocalTranslation(new Vector3f(0.1f,-0.1f/2,0));
        this.node.attachChild(wallA2);

        Box BoxA3 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallA3 = new Geometry("A2",BoxA3);
        wallA3.setMaterial(this.blankUnshaded);
        wallA3.setLocalTranslation(new Vector3f(0.1f,0.3f/2,0));
        this.node.attachChild(wallA3);

        Box BoxA4 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallA4 = new Geometry("A1",BoxA4);
        wallA4.setMaterial(this.blankUnshaded);
        wallA4.setLocalTranslation(new Vector3f(0.2f,0f,0));
        this.node.attachChild(wallA4);

        Box BoxU1 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallU1 = new Geometry("A1",BoxU1);
        wallU1.setMaterial(this.blankUnshaded);
        wallU1.setLocalTranslation(new Vector3f(0.4f,0f,0));
        this.node.attachChild(wallU1);

        Box BoxU2 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallU2 = new Geometry("A1",BoxU2);
        wallU2.setMaterial(this.blankUnshaded);
        wallU2.setLocalTranslation(new Vector3f(0.6f,0f,0));
        this.node.attachChild(wallU2);

        Box BoxU3 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallU3 = new Geometry("A2",BoxU3);
        wallU3.setMaterial(this.blankUnshaded);
        wallU3.setLocalTranslation(new Vector3f(0.5f,-0.3f/2,0));
        this.node.attachChild(wallU3);

        Box BoxB1 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallB1 = new Geometry("A2",BoxB1);
        wallB1.setMaterial(this.blankUnshaded);
        wallB1.setLocalTranslation(new Vector3f(0.9f,-0.3f/2,0));
        this.node.attachChild(wallB1);

        Box BoxB2 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallB2 = new Geometry("A1",BoxB2);
        wallB2.setMaterial(this.blankUnshaded);
        wallB2.setLocalTranslation(new Vector3f(0.8f,0f,0));
        this.node.attachChild(wallB2);

        Box BoxB3 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallB3 = new Geometry("A2",BoxB3);
        wallB3.setMaterial(this.blankUnshaded);
        wallB3.setLocalTranslation(new Vector3f(0.9f,0.1f/2,0));
        this.node.attachChild(wallB3);

        Box BoxB4 = new Box(0.1f/2,0.3f/2,0.1f/2);
        Geometry wallB4 = new Geometry("A2",BoxB4);
        wallB4.setMaterial(this.blankUnshaded);
        wallB4.setLocalTranslation(new Vector3f(1.0f,-0.1f/2,0));
        this.node.attachChild(wallB4);

        Box BoxI = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallI = new Geometry("A2",BoxI);
        wallI.setMaterial(this.blankUnshaded);
        wallI.setLocalTranslation(new Vector3f(1.2f,0,0));
        this.node.attachChild(wallI);

        Box BoxN1 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallN1 = new Geometry("A2",BoxN1);
        wallN1.setMaterial(this.blankUnshaded);
        wallN1.setLocalTranslation(new Vector3f(1.4f,0,0));
        this.node.attachChild(wallN1);

        Box BoxN2 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallN2 = new Geometry("A2",BoxN2);
        wallN2.setMaterial(this.blankUnshaded);
        wallN2.setLocalTranslation(new Vector3f(1.5f,0.3f/2,0));
        this.node.attachChild(wallN2);

        Box BoxN3 = new Box(0.1f/2,0.3f/2,0.1f/2);
        Geometry wallN3 = new Geometry("A2",BoxN3);
        wallN3.setMaterial(this.blankUnshaded);
        wallN3.setLocalTranslation(new Vector3f(1.6f,-0.1f/2,0));
        this.node.attachChild(wallN3);

        Box BoxP1 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallP1 = new Geometry("A2",BoxP1);
        wallP1.setMaterial(this.blankUnshaded);
        wallP1.setLocalTranslation(new Vector3f(1.9f,0,0));
        this.node.attachChild(wallP1);

        Box BoxP2 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallP2 = new Geometry("A2",BoxP2);
        wallP2.setMaterial(this.blankUnshaded);
        wallP2.setLocalTranslation(new Vector3f(2f,0.3f/2,0));
        this.node.attachChild(wallP2);

        Box BoxP3 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallP3 = new Geometry("A2",BoxP3);
        wallP3.setMaterial(this.blankUnshaded);
        wallP3.setLocalTranslation(new Vector3f(2f,-0.1f/2,0));
        this.node.attachChild(wallP3);

        Box BoxP4 = new Box(0.1f/2,0.3f/2,0.1f/2);
        Geometry wallP4 = new Geometry("A2",BoxP4);
        wallP4.setMaterial(this.blankUnshaded);
        wallP4.setLocalTranslation(new Vector3f(2.1f,0.1f/2,0));
        this.node.attachChild(wallP4);

        Box BoxD1 = new Box(0.1f/2,0.4f/2,0.1f/2);
        Geometry wallD1 = new Geometry("A2",BoxD1);
        wallD1.setMaterial(this.blankUnshaded);
        wallD1.setLocalTranslation(new Vector3f(2.3f,0,0));
        this.node.attachChild(wallD1);

        Box BoxD2 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallD2 = new Geometry("A2",BoxD2);
        wallD2.setMaterial(this.blankUnshaded);
        wallD2.setLocalTranslation(new Vector3f(2.4f,0.3f/2,0));
        this.node.attachChild(wallD2);

        Box BoxD3 = new Box(0.1f/2,0.1f/2,0.1f/2);
        Geometry wallD3 = new Geometry("A2",BoxD3);
        wallD3.setMaterial(this.blankUnshaded);
        wallD3.setLocalTranslation(new Vector3f(2.4f,-0.3f/2,0));
        this.node.attachChild(wallD3);

        Box BoxD4 = new Box(0.1f/2,0.2f/2,0.1f/2);
        Geometry wallD4 = new Geometry("A2",BoxD4);
        wallD4.setMaterial(this.blankUnshaded);
        wallD4.setLocalTranslation(new Vector3f(2.5f,0,0));
        this.node.attachChild(wallD4);

        this.node.setLocalTranslation(new Vector3f(5f,5f,3f));
        this.node.setLocalRotation(new Quaternion().fromAngles(0,(float)Math.PI,0));
        this.node.setLocalScale(4);

        this.setBlankShaded();
    }


}
