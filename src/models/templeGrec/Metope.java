package models.templeGrec;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.*;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.util.BufferUtils;
import materials.BasicMaterials;
import models.blank.BlankThing;

public class Metope extends BlankThing {

    private static float default_depth = (float)1/3;
    private float largeur;
    private float hauteur;
    private float profondeur = (float)0.5f;

    private Node baseNodeMesh;

    public Metope(float width, float height){
        this.largeur = width;
        this.hauteur = height;
        this.createBaseNodeMesh();
        //this.boxCheck();
    }

    private void createBaseNodeMesh(){
        baseNodeMesh = new Node();

        Mesh mesh1 = new Mesh();
        Mesh mesh2 = new Mesh();
        Vector3f[] vectors = new Vector3f[16];
        Vector3f[] vertices1 = new Vector3f[36];
        Vector3f[] vertices2 = new Vector3f[6];

        vectors[0] = new Vector3f(0,0,0);
        vectors[1] = new Vector3f(0,this.hauteur,0);
        vectors[2] = new Vector3f(1,0,0);
        vectors[3] = new Vector3f(1,this.hauteur,0);
        vectors[4] = new Vector3f(2,0,-this.profondeur/3);
        vectors[5] = new Vector3f(2,this.hauteur,-this.profondeur/3);
        vectors[6] = new Vector3f(3,0,0);
        vectors[7] = new Vector3f(3,this.hauteur,0);
        vectors[8] = new Vector3f(5,0,0);
        vectors[9] = new Vector3f(5,this.hauteur,0);
        vectors[10] = new Vector3f(6,0,-this.profondeur/3);
        vectors[11] = new Vector3f(6,this.hauteur,-this.profondeur/3);
        vectors[12] = new Vector3f(6,0,-this.profondeur);
        vectors[13] = new Vector3f(6,this.hauteur,-this.profondeur);
        vectors[14] = new Vector3f(12,0,-this.profondeur);
        vectors[15] = new Vector3f(12,this.hauteur,-this.profondeur);

        //Mesh 1
        vertices1[0] = vectors[0];
        vertices1[1] = vectors[1];
        vertices1[2] = vectors[2];
        vertices1[3] = vectors[2];
        vertices1[4] = vectors[1];
        vertices1[5] = vectors[3];

        vertices1[6] = vectors[3];
        vertices1[7] = vectors[5];
        vertices1[8] = vectors[2];
        vertices1[9] = vectors[2];
        vertices1[10] = vectors[5];
        vertices1[11] = vectors[4];

        vertices1[12] = vectors[4];
        vertices1[13] = vectors[5];
        vertices1[14] = vectors[6];
        vertices1[15] = vectors[6];
        vertices1[16] = vectors[5];
        vertices1[17] = vectors[7];

        vertices1[18] = vectors[7];
        vertices1[19] = vectors[9];
        vertices1[20] = vectors[6];
        vertices1[21] = vectors[6];
        vertices1[22] = vectors[9];
        vertices1[23] = vectors[8];

        vertices1[24] = vectors[8];
        vertices1[25] = vectors[9];
        vertices1[26] = vectors[10];
        vertices1[27] = vectors[10];
        vertices1[28] = vectors[9];
        vertices1[29] = vectors[11];

        vertices1[30] = vectors[11];
        vertices1[31] = vectors[13];
        vertices1[32] = vectors[10];
        vertices1[33] = vectors[10];
        vertices1[34] = vectors[13];
        vertices1[35] = vectors[12];

        //Mesh 2
        vertices2[0] = vectors[12];
        vertices2[1] = vectors[13];
        vertices2[2] = vectors[14];
        vertices2[3] = vectors[14];
        vertices2[4] = vectors[13];
        vertices2[5] = vectors[15];

        Vector2f[] texCoord = new Vector2f[4];
        texCoord[0] = new Vector2f(0,0);
        texCoord[1] = new Vector2f(1,0);
        texCoord[2] = new Vector2f(0,1);
        texCoord[3] = new Vector2f(1,1);

        int[] indexes1 = new int[vertices1.length];
        for(int i=0;i<indexes1.length;i++){
            indexes1[i] = indexes1.length-i-1;
        }

        int[] indexes2 = new int[vertices2.length];
        for(int i=0;i<indexes2.length;i++){
            indexes2[i] = indexes2.length-i-1;
        }

        float[] normals1 = new float[]{

                0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1,
                1,0,1, 1,0,1, 1,0,1, 1,0,1, 1,0,1, 1,0,1,
                -1,0,1, -1,0,1, -1,0,1, -1,0,1, -1,0,1, -1,0,1,
                0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1,
                1,0,1, 1,0,1, 1,0,1, 1,0,1, 1,0,1, 1,0,1,
                1,0,0, 1,0,0, 1,0,0, 1,0,0, 1,0,0, 1,0,0,

        };

        float[] normals2 = new float[]{
                0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1, 0,0,1,
        };

        mesh1.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices1));
        mesh1.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh1.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes1));
        mesh1.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals1));
        mesh1.updateBound();

        mesh2.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertices2));
        mesh2.setBuffer(VertexBuffer.Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
        mesh2.setBuffer(VertexBuffer.Type.Index,    3, BufferUtils.createIntBuffer(indexes2));
        mesh2.setBuffer(VertexBuffer.Type.Normal, 3, BufferUtils.createFloatBuffer(normals2));
        mesh2.updateBound();

        Geometry geo1 = new Geometry("Metope1", mesh1);
        //Geometry geo2 = new Geometry("Metope2", mesh2);
        geo1.setMaterial(BasicMaterials.templeGrecBleu);
        //geo2.setMaterial(BasicMaterials.templeGrecPaleYellow);

        this.baseNodeMesh.attachChild(geo1);
        //this.baseNodeMesh.attachChild(geo2);
        this.baseNodeMesh.scale((float)1/24*this.largeur,1,1);

        this.baseNodeMesh.getChild("Metope1")
                .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        //this.baseNodeMesh.getChild("Metope2")
        //        .setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        this.baseNodeMesh.move(new Vector3f(-this.largeur/2,0,0));

        this.node.attachChild(this.baseNodeMesh);

        //Clone
        Node clone = (Node) this.baseNodeMesh.clone();
        clone.setLocalRotation(new Quaternion().fromAngles(0,0,(float)Math.PI));
        clone.move(new Vector3f(this.largeur,this.hauteur,0));
        this.node.attachChild(clone);
    }

    private void boxCheck(){
        Box b1 = new Box(this.largeur/2,this.hauteur/2,this.profondeur/2);
        Geometry b1Geom = new Geometry("B1",b1);
        b1Geom.setMaterial(BasicMaterials.blankShaded);
        this.node.attachChild(b1Geom);
        this.node.getChild("B1").setLocalTranslation(new Vector3f(0,hauteur/2,-this.profondeur/2));
    }

    public float getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(float profondeur) {
        this.profondeur = profondeur;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }
}
