package models.templeGrec;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import models.blank.BlankThing;

import java.util.ArrayList;

public class GtColonneManager extends BlankThing {
    final TempleGrecProperties.Colonnes prop;
    private Colonne baseColonne;
    private static ArrayList<Colonne> colonnes = new ArrayList<>();

    public GtColonneManager(TempleGrecProperties.Colonnes prop){
        super();
        this.prop = prop;
    }

    public void draw(){
        colonnes.removeAll(colonnes);

        this.baseColonne = prop.colonne;

        int nbColonnesLarge = prop.nbColonnesLarge;
        int nbColonnesLong = prop.nbColonnesLong;
        float ecart_colonnes = prop.ecart_colonnes;

        for(int iColLarge=0; iColLarge<nbColonnesLarge; iColLarge++){
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    (ecart_colonnes*iColLarge)-(((nbColonnesLarge-1)*ecart_colonnes)/2),
                                    0,
                                    ((nbColonnesLong-1)*ecart_colonnes)/2
                            )
                    );
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    (ecart_colonnes*iColLarge)-(((nbColonnesLarge-1)*ecart_colonnes)/2),
                                    0,
                                    -((nbColonnesLong-1)*ecart_colonnes)/2
                            )
                    );
        }
        for(int iColLong=1; iColLong<nbColonnesLong-1; iColLong++){
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    ((nbColonnesLarge-1)*ecart_colonnes)/2,
                                    0,
                                    (ecart_colonnes*iColLong)-(((nbColonnesLong-1)*ecart_colonnes)/2)
                            )
                    );
            colonnes.add(new Colonne(this.baseColonne));
            colonnes.get(colonnes.size()-1).draw();
            this.node.attachChild(colonnes.get(colonnes.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    -((nbColonnesLarge-1)*ecart_colonnes)/2,
                                    0,
                                    (ecart_colonnes*iColLong)-(((nbColonnesLong-1)*ecart_colonnes)/2)
                            )
                    );
        }
    }
}
