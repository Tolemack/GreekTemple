package models.templeGrec;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Colonne extends BlankThing {
    private final float default_largeur_base = 1.5f;

    private boolean hauteurChapFixe = true;

    private int axisSamples = 2;
    private int radialSamples = 16;
    private float hauteur;
    private float largeur_base = default_largeur_base;
    private float ratio_chapiteau = 0.1f;

    public Colonne(float hauteur){
        super();
        this.hauteur = hauteur;
    }

    public Colonne(Colonne colonne){
        super();
        this.axisSamples = colonne.axisSamples;
        this.radialSamples = colonne.radialSamples;
        this.hauteur = colonne.hauteur;
        this.largeur_base = colonne.largeur_base;
        this.ratio_chapiteau = colonne.ratio_chapiteau;
        this.hauteurChapFixe = colonne.hauteurChapFixe;
    }

    public void draw(){
        Cylinder c1 = new Cylinder(
                axisSamples,
                radialSamples,
                largeur_base/2,
                largeur_base/3,
                hauteur-(hauteur*ratio_chapiteau),
                false,
                false);
        Geometry c1Geom = new Geometry("C1",c1);
        c1Geom.setMaterial(BasicMaterials.templeGrecPaleYellow);
        Cylinder c2 = new Cylinder(
                axisSamples,
                radialSamples,
                largeur_base/3,
                largeur_base/2,
                (hauteur*ratio_chapiteau)/2,
                false,
                false);
        Geometry c2Geom = new Geometry("C2",c2);
        c2Geom.setMaterial(BasicMaterials.templeGrecBleu);
        Cylinder c3 = new Cylinder(
                axisSamples,
                radialSamples,
                largeur_base/2,
                largeur_base/2,
                (hauteur*ratio_chapiteau)/2,
                true,
                false);
        Geometry c3Geom = new Geometry("C3",c3);
        c3Geom.setMaterial(BasicMaterials.templeGrecRouge);

        //Attacher Nodes
        this.node.attachChild(c1Geom);
        this.node.attachChild(c2Geom);
        this.node.attachChild(c3Geom);

        //Translaton/Rotation   (h-(h*r))/2 | (h-(h*r))+((h*r)/2)/2 | h-(((h*r)/2)/2)
        float h = hauteur;
        float r= ratio_chapiteau;
        this.node.getChild("C1").setLocalTranslation(new Vector3f(0,(h-h*r)/2,0));
        this.node.getChild("C1").setLocalRotation(new Quaternion().fromAngles((float)Math.PI/2,0,0));
        this.node.getChild("C1").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("C2").setLocalTranslation(new Vector3f(0,(h*r)/4+h-h*r,0));
        this.node.getChild("C2").setLocalRotation(new Quaternion().fromAngles((float)Math.PI/2,0,0));
        this.node.getChild("C2").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("C3").setLocalTranslation(new Vector3f(0,-(h*r)/4+h,0));
        this.node.getChild("C3").setLocalRotation(new Quaternion().fromAngles((float)Math.PI/2,0,0));
        this.node.getChild("C3").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }

    private void boxCheck(){
        Box b1 = new Box(largeur_base/2,hauteur/2,largeur_base/2);
        Geometry b1Geom = new Geometry("B1",b1);
        b1Geom.setMaterial(BasicMaterials.blankShaded);
        this.node.attachChild(b1Geom);
        this.node.getChild("B1").setLocalTranslation(new Vector3f(largeur_base/2,hauteur/2,0));
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        if(hauteurChapFixe){
            this.ratio_chapiteau = this.getHauteurChapiteau()/hauteur;
        }
        this.hauteur = hauteur;
    }

    public float getLargeurBase() {
        return largeur_base;
    }

    public void setLargeurBase(float largeurBase) {
        this.largeur_base = largeurBase;
    }

    public float getRatioChapiteau() {
        return ratio_chapiteau;
    }

    public void setRatioChapiteau(float ratioChapiteau) {
        this.ratio_chapiteau = ratioChapiteau;
        this.hauteurChapFixe = false;
    }

    public void setHauteurChapiteau(float hauteurChapiteau){
        this.ratio_chapiteau = hauteurChapiteau/this.hauteur;
        this.hauteurChapFixe = true;
    }

    public float getHauteurChapiteau(){
        return this.hauteur*this.ratio_chapiteau;
    }
}
