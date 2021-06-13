package models.templeGrec;

import com.jme3.math.Vector3f;
import models.blank.BlankThing;

import java.util.ArrayList;

public class TempleGrec extends BlankThing {
    private Soubassement soubassement;
    private ArrayList<Colonne> colonnes_largeur;
    private ArrayList<Colonne> colonnes_longueur;
    private float ecart_colonnes = 3.0f;
    private Architrave architrave;

    public TempleGrec(int nbColonnesLarge, int nbColonnesLong){
        this.drawColonnes(nbColonnesLarge,nbColonnesLong);
        this.drawSoubassement(nbColonnesLarge,nbColonnesLong);
        colonnes_largeur.forEach((col)->col.getNode()
                .move(0,Soubassement.getDefault_hauteur_marches()*Soubassement.getDefault_nombre_marches(),0));
        colonnes_longueur.forEach((col)->col.getNode()
                .move(0,Soubassement.getDefault_hauteur_marches()*Soubassement.getDefault_nombre_marches(),0));
        this.drawArchitrave(nbColonnesLarge, nbColonnesLong);
        architrave.getNode().move(0,
                Soubassement.getDefault_hauteur_marches()*Soubassement.getDefault_nombre_marches()+6,
                0);
    }

    private void drawSoubassement(int nbColonnesLarge, int nbColonnesLong){
        float soubassementLarge = ecart_colonnes*(nbColonnesLarge-0.5f)
                +(Soubassement.getDefault_hauteur_marches()*Soubassement.getDefault_nombre_marches()*2);
        float soubassementLong = ecart_colonnes*(nbColonnesLong-0.5f)
                +(Soubassement.getDefault_hauteur_marches()*Soubassement.getDefault_nombre_marches()*2);
        soubassement = new Soubassement(soubassementLarge, soubassementLong);
        this.node.attachChild(soubassement.getNode());
    }

    private void drawColonnes(int nbColonnesLarge, int nbColonnesLong){
        colonnes_largeur = new ArrayList<>();
        for(int iColLarge=0; iColLarge<nbColonnesLarge; iColLarge++){
            colonnes_largeur.add(new Colonne());
            this.node.attachChild(colonnes_largeur.get(colonnes_largeur.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    (ecart_colonnes*iColLarge)-(((nbColonnesLarge-1)*ecart_colonnes)/2),
                                    0,
                                    ((nbColonnesLong-1)*ecart_colonnes)/2
                            )
                    );
            colonnes_largeur.add(new Colonne());
            this.node.attachChild(colonnes_largeur.get(colonnes_largeur.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    (ecart_colonnes*iColLarge)-(((nbColonnesLarge-1)*ecart_colonnes)/2),
                                    0,
                                    -((nbColonnesLong-1)*ecart_colonnes)/2
                            )
                    );
        }
        colonnes_longueur = new ArrayList<>();
        for(int iColLong=1; iColLong<nbColonnesLong-1; iColLong++){
            colonnes_longueur.add(new Colonne());
            this.node.attachChild(colonnes_longueur.get(colonnes_longueur.size()-1).getNode());
            this.node.getChild(this.node.getQuantity()-1)
                    .setLocalTranslation(
                            new Vector3f(
                                    ((nbColonnesLarge-1)*ecart_colonnes)/2,
                                    0,
                                    (ecart_colonnes*iColLong)-(((nbColonnesLong-1)*ecart_colonnes)/2)
                            )
                    );
            colonnes_longueur.add(new Colonne());
            this.node.attachChild(colonnes_longueur.get(colonnes_longueur.size()-1).getNode());
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

    public void drawArchitrave(int nbColonnesLarge, int nbColonnesLong){
        float architraveLarge = ecart_colonnes*(nbColonnesLarge-0.5f);
        float architraveLong = ecart_colonnes*(nbColonnesLong-0.5f);
        architrave = new Architrave(architraveLarge, architraveLong);
        this.node.attachChild(architrave.getNode());
    }
}
