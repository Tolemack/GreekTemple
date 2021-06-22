package models.templeGrec;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import materials.BasicMaterials;
import models.blank.BlankThing;

import java.util.ArrayList;

public class TempleGrec extends BlankThing {

    private int nbColonnesLarge;
    private int nbColonnesLong;
    private float ecart_colonnes = 3.0f;

    private Soubassement soubassement;
    private GtColonneManager colonneManager;
    private GtMetopeManager metopeManager;
    private Architrave architrave;
    private Node metopeBox;

    private float current_hauteur_max = 0;

    public TempleGrec(int nbColonnesLarge, int nbColonnesLong){
        this.nbColonnesLarge = nbColonnesLarge;
        this.nbColonnesLong = nbColonnesLong;
        this.drawSoubassement();
        this.drawColonnes();
        this.drawArchitrave();
        this.drawMetope(4,3,0.5f);
    }

    private void drawSoubassement(){
        this.soubassement = new Soubassement(nbColonnesLarge, nbColonnesLong, ecart_colonnes);
        this.soubassement.draw();
        this.node.attachChild(soubassement.getNode());
        this.current_hauteur_max += soubassement.getHauteur();
    }

    private void drawColonnes(){
        this.colonneManager = new GtColonneManager(nbColonnesLarge, nbColonnesLong);
        this.colonneManager.setHauteur(10);
        this.colonneManager.draw();
        this.node.attachChild(colonneManager.getNode());
        this.colonneManager.getNode().move(0,this.current_hauteur_max,0);
        this.current_hauteur_max += colonneManager.getHauteur();
    }

    private void drawArchitrave(){
        this.architrave = new Architrave(nbColonnesLarge, nbColonnesLong, ecart_colonnes);
        this.architrave.draw();
        this.node.attachChild(architrave.getNode());
        this.architrave.getNode().move(0,this.current_hauteur_max,0);
        this.current_hauteur_max += architrave.getHauteur();
    }

    private void drawMetope(
            int nbMetopeLong, int nbMetopeLarge, float hauteur){
        this.metopeManager = new GtMetopeManager(
            nbMetopeLong, nbMetopeLarge, hauteur, architrave);
        this.metopeManager.draw();
        this.node.attachChild(metopeManager.getNode());
        this.metopeManager.getNode().move(0,this.current_hauteur_max,0);
        this.current_hauteur_max += metopeManager.getHauteur();
    }
}
