package models.templeGrec;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

import java.util.ArrayList;

public class GtMetopeManager extends BlankThing {

    TempleGrecProperties.Metope prop;

    private ArrayList<Metope> metopes;
    private Node metopeBox;

    private int nbMetopeLong;
    private int nbMetopeLarge;
    private float hauteur;
    private float epaisseur;
    private float longueurArchitrave;
    private float largeurArchitrave;

    public GtMetopeManager(TempleGrecProperties.Metope prop){
        this.prop = prop;
    }

    public void draw(){

        this.metopes = new ArrayList<>();

        this.nbMetopeLong = prop.nbMetopeLong;
        this.nbMetopeLarge = prop.nbMetopeLarge;
        this.hauteur = prop.hauteur;
        this.epaisseur = prop.epaisseur;
        this.longueurArchitrave = prop.longueurArchitrave;
        this.largeurArchitrave = prop.largeurArchitrave;

        float largeurMetopeLong = longueurArchitrave/nbMetopeLong;
        float largeurMetopeLarg = largeurArchitrave/nbMetopeLarge;

        for(int i = 0; i<nbMetopeLarge; i++){
            this.metopes.add(new Metope(largeurMetopeLarg,hauteur));
            this.metopes.get(this.metopes.size()-1).getNode().move(
                -largeurArchitrave/2
                    +largeurMetopeLarg/2
                    +(i*largeurMetopeLarg),
                0,
                longueurArchitrave/2
            );
            this.node.attachChild(this.metopes.get(this.metopes.size()-1).getNode());

            this.metopes.add(new Metope(largeurMetopeLarg,hauteur));
            this.metopes.get(this.metopes.size()-1).getNode().rotate(
                    new Quaternion().fromAngles(0,(float)Math.PI,0)
            );
            this.metopes.get(this.metopes.size()-1).getNode().move(
                    -largeurArchitrave/2
                            +largeurMetopeLarg/2
                            +(i*largeurMetopeLarg),
                    0,
                    -longueurArchitrave/2
            );
            this.node.attachChild(this.metopes.get(this.metopes.size()-1).getNode());
        }

        for(int i = 0; i<nbMetopeLong; i++){
            this.metopes.add(new Metope(largeurMetopeLong,hauteur));
            this.metopes.get(this.metopes.size()-1).getNode().rotate(
                    new Quaternion().fromAngles(0,(float)-Math.PI/2,0)
            );
            this.metopes.get(this.metopes.size()-1).getNode().move(
                    -largeurArchitrave/2,
                    0,
                    -longueurArchitrave/2
                            +largeurMetopeLong/2
                            +(i*largeurMetopeLong)
            );
            this.node.attachChild(this.metopes.get(this.metopes.size()-1).getNode());

            this.metopes.add(new Metope(largeurMetopeLong,hauteur));
            this.metopes.get(this.metopes.size()-1).getNode().rotate(
                    new Quaternion().fromAngles(0,(float)Math.PI/2,0)
            );
            this.metopes.get(this.metopes.size()-1).getNode().move(
                    largeurArchitrave/2,
                    0,
                    -longueurArchitrave/2
                            +largeurMetopeLong/2
                            +(i*largeurMetopeLong)
            );
            this.node.attachChild(this.metopes.get(this.metopes.size()-1).getNode());
        }
        this.drawMetopeBox();
    }

    private void drawMetopeBox(){
        if(this.epaisseur == 0){
            this.drawMetopeBoxEpaisseur0();
        } else {
            this.drawMetopeBoxEpaisseur1();
        }
    }

    private void drawMetopeBoxEpaisseur0(){
        this.metopeBox = new Node();
        float profondeurMetope = this.metopes.get(0).getProfondeur();
        float hauteur_metope = this.metopes.get(0).getHauteur();
        Box metopeBoxB = new Box(
                largeurArchitrave/2-profondeurMetope,
                hauteur_metope/2,
                longueurArchitrave/2-profondeurMetope
        );
        Geometry metopeBoxGeom = new Geometry("metopeBox",metopeBoxB);
        metopeBoxGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);
        this.metopeBox.attachChild(metopeBoxGeom);
        this.metopeBox.getChild("metopeBox").setLocalTranslation(
                new Vector3f(
                        0,
                        hauteur_metope/2,
                        0)
        );
        this.metopeBox.getChild("metopeBox")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.node.attachChild(this.metopeBox);
    }

    private void drawMetopeBoxEpaisseur1(){
        this.metopeBox = new Node();
        float profondeurMetope = this.metopes.get(0).getProfondeur();
        float hauteur_metope = this.metopes.get(0).getHauteur();

        Box metopeBoxFront = new Box(
                largeurArchitrave/2-epaisseur,
                hauteur_metope/2,
                epaisseur/2-profondeurMetope/2
        );
        Geometry metopeBoxFrontGeom = new Geometry("metopeBoxFront",metopeBoxFront);
        metopeBoxFrontGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box metopeBoxBack = new Box(
                largeurArchitrave/2-epaisseur,
                hauteur_metope/2,
                epaisseur/2-profondeurMetope/2
        );
        Geometry metopeBoxBackGeom = new Geometry("metopeBoxBack",metopeBoxBack);
        metopeBoxBackGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box metopeBoxLeft = new Box(
                epaisseur/2-profondeurMetope/2,
                hauteur_metope/2,
                longueurArchitrave/2-profondeurMetope
        );
        Geometry metopeBoxLeftGeom = new Geometry("metopeBoxLeft",metopeBoxLeft);
        metopeBoxLeftGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        Box metopeBoxRight = new Box(
                epaisseur/2-profondeurMetope/2,
                hauteur_metope/2,
                longueurArchitrave/2-profondeurMetope
        );
        Geometry metopeBoxRightGeom = new Geometry("metopeBoxRight",metopeBoxRight);
        metopeBoxRightGeom.setMaterial(BasicMaterials.templeGrecPaleYellow);

        this.metopeBox.attachChild(metopeBoxFrontGeom);
        this.metopeBox.getChild("metopeBoxFront").setLocalTranslation(
                new Vector3f(
                        0,
                        hauteur_metope/2,
                        -longueurArchitrave/2+epaisseur/2+profondeurMetope/2)
        );

        this.metopeBox.attachChild(metopeBoxBackGeom);
        this.metopeBox.getChild("metopeBoxBack").setLocalTranslation(
                new Vector3f(
                        0,
                        hauteur_metope/2,
                        longueurArchitrave/2-epaisseur/2-profondeurMetope/2)
        );

        this.metopeBox.attachChild(metopeBoxLeftGeom);
        this.metopeBox.getChild("metopeBoxLeft").setLocalTranslation(
                new Vector3f(
                        -largeurArchitrave/2+epaisseur/2+profondeurMetope/2,
                        hauteur_metope/2,
                        0)
        );

        this.metopeBox.attachChild(metopeBoxRightGeom);
        this.metopeBox.getChild("metopeBoxRight").setLocalTranslation(
                new Vector3f(
                        largeurArchitrave/2-epaisseur/2-profondeurMetope/2,
                        hauteur_metope/2,
                        0)
        );

        this.metopeBox.getChild("metopeBoxFront")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.metopeBox.getChild("metopeBoxBack")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.metopeBox.getChild("metopeBoxLeft")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.metopeBox.getChild("metopeBoxRight")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        this.node.attachChild(this.metopeBox);
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public float getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(float epaisseur) {
        this.epaisseur = epaisseur;
    }
}
