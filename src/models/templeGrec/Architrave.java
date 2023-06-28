package models.templeGrec;

import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Architrave extends BlankThing {

    private static float default_hauteur = 1;
    private float largeur;
    private float longueur;
    private float epaisseur = 0;
    private float hauteur = default_hauteur;
    private float ratio = 0.75f;
    private float marge = hauteur*(1-ratio);

    public Architrave(int nbColonnesLarge, int nbColonnesLong, float ecartColonnes){
        super();
        largeur = ecartColonnes*(nbColonnesLarge-0.5f);
        longueur = ecartColonnes*(nbColonnesLong-0.5f);
    }

    public void draw(){

        if (this.epaisseur == 0) {
            this.drawEpaisseur0();
        } else {
            this.drawEpaisseur1();
        }

    }

    private void drawEpaisseur1(){
        this.drawEpaisseur1couche1();
        this.drawEpaisseur1couche2();
    }

    private void drawEpaisseur1couche1(){
        Box faceBox = new Box(
                largeur/2-epaisseur,
                hauteur/2*ratio,
                epaisseur/2
        );
        Geometry faceBoxGeom = new Geometry("faceBox",faceBox);
        faceBoxGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box backBox = new Box(
                largeur/2-epaisseur,
                hauteur/2*ratio,
                epaisseur/2
        );
        Geometry backBoxGeom = new Geometry("backBox",backBox);
        backBoxGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box leftBox = new Box(
                epaisseur/2,
                hauteur/2*ratio,
                longueur/2
        );
        Geometry leftBoxGeom = new Geometry("leftBox",leftBox);
        leftBoxGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box rightBox = new Box(
                epaisseur/2,
                hauteur/2*ratio,
                longueur/2
        );
        Geometry rightBoxGeom = new Geometry("rightBox",rightBox);
        rightBoxGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        this.node.attachChild(faceBoxGeom);
        this.node.attachChild(backBoxGeom);
        this.node.attachChild(leftBoxGeom);
        this.node.attachChild(rightBoxGeom);

        this.node.getChild("faceBox").setLocalTranslation(
                new Vector3f(0,hauteur/2*ratio,longueur/2-epaisseur/2)
        );
        this.node.getChild("backBox").setLocalTranslation(
                new Vector3f(0,hauteur/2*ratio,-longueur/2+epaisseur/2)
        );
        this.node.getChild("leftBox").setLocalTranslation(
                new Vector3f(-largeur/2+epaisseur/2,hauteur/2*ratio,0)
        );
        this.node.getChild("rightBox").setLocalTranslation(
                new Vector3f(largeur/2-epaisseur/2,hauteur/2*ratio,0)
        );

        this.node.getChild("faceBox").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("backBox").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("leftBox").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("rightBox").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }

    private void drawEpaisseur1couche2(){
        Box faceBox2 = new Box(
                largeur/2-epaisseur,
                hauteur/2*(1-ratio),
                epaisseur/2+marge/2
        );
        Geometry faceBox2Geom = new Geometry("faceBox2",faceBox2);
        faceBox2Geom.setMaterial(BasicMaterials.templeGrecRouge);

        Box backBox2 = new Box(
                largeur/2-epaisseur,
                hauteur/2*(1-ratio),
                epaisseur/2+marge/2
        );
        Geometry backBox2Geom = new Geometry("backBox2",backBox2);
        backBox2Geom.setMaterial(BasicMaterials.templeGrecRouge);

        Box leftBox2 = new Box(
                epaisseur/2+marge/2,
                hauteur/2*(1-ratio),
                longueur/2+marge
        );
        Geometry leftBox2Geom = new Geometry("leftBox2",leftBox2);
        leftBox2Geom.setMaterial(BasicMaterials.templeGrecRouge);

        Box rightBox2 = new Box(
                epaisseur/2+marge/2,
                hauteur/2*(1-ratio),
                longueur/2+marge
        );
        Geometry rightBox2Geom = new Geometry("rightBox2",rightBox2);
        rightBox2Geom.setMaterial(BasicMaterials.templeGrecRouge);

        this.node.attachChild(faceBox2Geom);
        this.node.attachChild(backBox2Geom);
        this.node.attachChild(leftBox2Geom);
        this.node.attachChild(rightBox2Geom);

        this.node.getChild("faceBox2").setLocalTranslation(
                new Vector3f(0,(hauteur/2*(1-ratio))+(hauteur*ratio),longueur/2-epaisseur/2+marge/2)
        );
        this.node.getChild("backBox2").setLocalTranslation(
                new Vector3f(0,(hauteur/2*(1-ratio))+(hauteur*ratio),-longueur/2+epaisseur/2-marge/2)
        );
        this.node.getChild("leftBox2").setLocalTranslation(
                new Vector3f(-largeur/2+epaisseur/2-marge/2,(hauteur/2*(1-ratio))+(hauteur*ratio),0)
        );
        this.node.getChild("rightBox2").setLocalTranslation(
                new Vector3f(largeur/2-epaisseur/2+marge/2,(hauteur/2*(1-ratio))+(hauteur*ratio),0)
        );

        this.node.getChild("faceBox2").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("backBox2").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("leftBox2").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.getChild("rightBox2").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }

    private void drawEpaisseur0(){
        Box b1 = new Box(
                largeur/2,
                hauteur/2*ratio,
                longueur/2
        );
        Geometry b1Geom = new Geometry("B1",b1);
        b1Geom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box b2 = new Box(
                largeur/2+marge,
                hauteur/2*(1-ratio),
                longueur/2+marge
        );
        Geometry b2Geom = new Geometry("B2",b2);
        b2Geom.setMaterial(BasicMaterials.templeGrecRouge);

        this.node.attachChild(b1Geom);
        this.node.attachChild(b2Geom);

        this.node.getChild("B1").setLocalTranslation(
                new Vector3f(0,hauteur/2*ratio,0)
        );
        this.node.getChild("B1").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        this.node.getChild("B2").setLocalTranslation(
                new Vector3f(0,(hauteur/2*(1-ratio))+(hauteur*ratio),0)
        );
        this.node.getChild("B2").setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
    }

    public float getLargeur() {
        return largeur;
    }

    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    public float getLongueur() {
        return longueur;
    }

    public void setLongueur(float longueur) {
        this.longueur = longueur;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public float getFullLongueur() {
        return longueur+2*marge;
    }

    public float getFullLargeur() {
        return largeur+2*marge;
    }

    public float getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(float epaisseur) {
        this.epaisseur = epaisseur;
    }
}
