package models.templeGrec;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

import java.util.ArrayList;

public class GtMetopeManager extends BlankThing {

    private ArrayList<Metope> metopes;
    private Node metopeBox;

    private int nbMetopeLong;
    private int nbMetopeLarge;
    private float hauteur;
    private float longueurArchitrave;
    private float largeurArchitrave;

    public GtMetopeManager(

        int nbMetopeLong, int nbMetopeLarge, float hauteur, Architrave architrave){

        this.nbMetopeLong = nbMetopeLong;
        this.nbMetopeLarge = nbMetopeLarge;
        this.hauteur = hauteur;
        this.longueurArchitrave = architrave.getLongueur();
        this.largeurArchitrave = architrave.getLargeur();
        this.metopes = new ArrayList<>();

    }

    public void draw(){
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
        this.node.attachChild(this.metopeBox);
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }
}
