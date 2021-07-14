package models.templeGrec;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Roof extends BlankThing {

    //dimensions intérieures
    private float longueur=10;
    private float largeur=20;
    private float hauteur=10;

    private float epaisseur=0.5f;

    public Roof(float length, float width, float height){
        this.longueur = length;
        this.largeur = width;
        this.hauteur = height;
    }

    public void draw(){
        Mesh mesh1 = new Mesh();

        Vector3f[] vectors = new Vector3f[12];
        Vector3f[] vertices1 = new Vector3f[60];

        //Variables Utiles (voir doc)
        double a = Math.atan(hauteur/(largeur/2));
        float x = (float)(epaisseur*Math.cos(Math.toRadians(90)-a));
        float y = (float)(epaisseur*Math.sin(Math.toRadians(90)-a));
        float e2 = (float)(epaisseur/Math.cos(a));

        //Points interieurs devant
        vectors[0] = new Vector3f(0,0,0);
        vectors[1] = new Vector3f(largeur,0,0);
        vectors[2] = new Vector3f(largeur/2,hauteur,0);

        //Points exterieurs devant
        vectors[3] = new Vector3f(
                -x,
                y,
                0);
        vectors[4] = new Vector3f(
                largeur+x,
                y,
                0);
        vectors[5] = new Vector3f(
                largeur/2,
                hauteur+e2,
                0);

        //Points interieurs derriere
        vectors[6] = new Vector3f(0,0,longueur);
        vectors[7] = new Vector3f(largeur,0,longueur);
        vectors[10] = new Vector3f(largeur/2,hauteur,longueur);

        //Points exterieurs derriere
        vectors[8] = new Vector3f(
                -x,
                y,
                longueur);
        vectors[9] = new Vector3f(
                largeur+x,
                y,
                longueur);
        vectors[11] = new Vector3f(
                largeur/2,
                hauteur+e2,
                longueur);

        //Face A
        vertices1[0] = vectors[0];
        vertices1[1] = vectors[5];
        vertices1[2] = vectors[3];
        vertices1[3] = vectors[0];
        vertices1[4] = vectors[2];
        vertices1[5] = vectors[5];
        vertices1[6] = vectors[1];
        vertices1[7] = vectors[4];
        vertices1[8] = vectors[5];
        vertices1[9] = vectors[1];
        vertices1[10] = vectors[5];
        vertices1[11] = vectors[2];

        //Face B
        vertices1[12] = vectors[6];
        vertices1[13] = vectors[8];
        vertices1[14] = vectors[11];
        vertices1[15] = vectors[6];
        vertices1[16] = vectors[11];
        vertices1[17] = vectors[10];
        vertices1[18] = vectors[7];
        vertices1[19] = vectors[11];
        vertices1[20] = vectors[9];
        vertices1[21] = vectors[7];
        vertices1[22] = vectors[10];
        vertices1[23] = vectors[11];

        //Face C
        vertices1[24] = vectors[3];
        vertices1[25] = vectors[5];
        vertices1[26] = vectors[11];
        vertices1[27] = vectors[3];
        vertices1[28] = vectors[11];
        vertices1[29] = vectors[8];

        //Face D
        vertices1[30] = vectors[4];
        vertices1[31] = vectors[11];
        vertices1[32] = vectors[5];
        vertices1[33] = vectors[4];
        vertices1[34] = vectors[9];
        vertices1[35] = vectors[11];

        //Face E
        vertices1[36] = vectors[0];
        vertices1[37] = vectors[10];
        vertices1[38] = vectors[2];
        vertices1[39] = vectors[0];
        vertices1[40] = vectors[6];
        vertices1[41] = vectors[10];

        //Face F
        vertices1[42] = vectors[1];
        vertices1[43] = vectors[2];
        vertices1[44] = vectors[10];
        vertices1[45] = vectors[1];
        vertices1[46] = vectors[10];
        vertices1[47] = vectors[7];

        //Face G
        vertices1[48] = vectors[0];
        vertices1[49] = vectors[3];
        vertices1[50] = vectors[8];
        vertices1[51] = vectors[0];
        vertices1[52] = vectors[8];
        vertices1[53] = vectors[6];

        //Face H
        vertices1[54] = vectors[1];
        vertices1[55] = vectors[9];
        vertices1[56] = vectors[4];
        vertices1[57] = vectors[1];
        vertices1[58] = vectors[7];
        vertices1[59] = vectors[9];


        int[] indexes1 = new int[vertices1.length];
        for(int i=0;i<indexes1.length;i++){
            indexes1[i] = indexes1.length-i-1;
        }

        float[] normals1 = new float[]{
            0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1,
            0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1, 0,0,-1,
            0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1,
            0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1,
            -x,y,0, -x,y,0, -x,y,0, -x,y,0, -x,y,0, -x,y,0,
            x,y,0, x,y,0, x,y,0, x,y,0, x,y,0, x,y,0,
            x,-y,0, x,-y,0, x,-y,0, x,-y,0, x,-y,0, x,-y,0,
            -x,-y,0, -x,-y,0, -x,-y,0, -x,-y,0, -x,-y,0, -x,-y,0,
            -x,-y,0, -x,-y,0, -x,-y,0, -x,-y,0, -x,-y,0, -x,-y,0,
            x,-y,0, x,-y,0, x,-y,0, x,-y,0, x,-y,0, x,-y,0,
        };

        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0,0);
        texCoord[1] = new Vector2f(1,0);
        texCoord[2] = new Vector2f(0,1);
        texCoord[3] = new Vector2f(1,1);

        mesh1.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices1));
        mesh1.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh1.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes1));
        mesh1.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals1));
        mesh1.updateBound();

        Geometry geo1 = new Geometry("roof", mesh1);
        this.node.attachChild(geo1);
        this.node.getChild("roof").move(new Vector3f(-largeur/2,0,-longueur/2));
        this.setBlankShaded();
    }
}
