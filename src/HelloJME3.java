import com.jme3.app.SimpleApplication;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.math.ColorRGBA;

import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.EdgeFilteringMode;
import materials.BasicMaterials;
import models.blank.*;
import models.blank.helpers.BlankWindow;
import models.templeGrec.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Sample 5 - how to map keys and mousebuttons to actions
 */
public class HelloJME3 extends SimpleApplication {

    public static final int SHADOWMAP_SIZE = 1024;
    private DirectionalLightShadowRenderer dlsr;
    private DirectionalLightShadowFilter dlsf;

    private TempleGrecProperties templeGrecProperties = new TempleGrecProperties();
    private TempleGrec templeGrec = new TempleGrec(templeGrecProperties);

    final private ActionListener actionListener = new ActionListener(){
        @Override
        public void onAction(String name, boolean pressed, float tpf){
            System.out.println(name + " = " + pressed);
            if(pressed) {
                switch (name) {
                    case "incrementLarge":
                        templeGrecProperties.incrementNbColonnesLarge();
                        break;
                    case "decrementLarge":
                        templeGrecProperties.decrementNbColonnesLarge();
                        break;
                    case "incrementLong":
                        templeGrecProperties.incrementNbColonnesLong();
                        break;
                    case "decrementLong":
                        templeGrecProperties.decrementNbColonnesLong();
                        break;
                    case "incrementStairs":
                        templeGrecProperties.incrementNbMarches();
                        break;
                    case "decrementStairs":
                        templeGrecProperties.decrementNbMarches();
                        break;
                    case "incrementColSize":
                        templeGrecProperties.incrementColonneSize();
                        break;
                    case "decrementColSize":
                        templeGrecProperties.decrementColonneSize();
                        break;
                }
                templeGrec.clear();
                templeGrec.draw();
            }
        }
    };

    public static void main(String[] args) {
        HelloJME3 app = new HelloJME3();
        app.start();
    }
    private boolean isRunning = true;

    @Override
    public void simpleInitApp() {
        //Other Params
        this.setScene();
        this.flyCam.setMoveSpeed(10);
        this.cam.setLocation(new Vector3f(0,10,-40));
        this.cam.setRotation(new Quaternion().fromAngles(
                (float)(10*Math.PI/180),
                0,
                0)
        );

        this.setLighting();

        inputManager.addMapping("incrementLarge",new KeyTrigger(KeyInput.KEY_NUMPAD6));
        inputManager.addMapping("decrementLarge",new KeyTrigger(KeyInput.KEY_NUMPAD4));
        inputManager.addMapping("incrementLong",new KeyTrigger(KeyInput.KEY_NUMPAD8));
        inputManager.addMapping("decrementLong",new KeyTrigger(KeyInput.KEY_NUMPAD2));
        inputManager.addMapping("incrementStairs",new KeyTrigger(KeyInput.KEY_NUMPAD7));
        inputManager.addMapping("decrementStairs",new KeyTrigger(KeyInput.KEY_NUMPAD1));
        inputManager.addMapping("incrementColSize",new KeyTrigger(KeyInput.KEY_NUMPAD9));
        inputManager.addMapping("decrementColSize",new KeyTrigger(KeyInput.KEY_NUMPAD3));
        inputManager.addListener(actionListener, "incrementLarge");
        inputManager.addListener(actionListener, "decrementLarge");
        inputManager.addListener(actionListener, "incrementLong");
        inputManager.addListener(actionListener, "decrementLong");
        inputManager.addListener(actionListener, "incrementStairs");
        inputManager.addListener(actionListener, "decrementStairs");
        inputManager.addListener(actionListener, "incrementColSize");
        inputManager.addListener(actionListener, "decrementColSize");
    }

    private void setScene(){
        //Load Materials
        BasicMaterials basicMaterials = new BasicMaterials(this.getAssetManager());
        //basicMaterials.setTempleBlue();

        //Skybox
        SkyboxRoom roomSky = new SkyboxRoom(400,400,400);
        roomSky.putSimpleDummyGrass();
        rootNode.attachChild(roomSky.getNode());

        //Scene

        //BlankRoom
        /*BlankRoom room = new BlankRoom(assetManager, 5, 3, 3);
        room.removeWall("Floor");
        room.setBlankShaded(assetManager);*/

        //BlankWall with Windows
        /*ArrayList<BlankWindow> windows = new ArrayList<BlankWindow>();
        windows.add(new BlankWindow(1.5f,1.0f, new Vector2f(1.5f,1.5f)));
        windows.add(new BlankWindow(1.5f,1.0f, new Vector2f(4.5f,1.5f)));
        BlankWall wall = new BlankWall(assetManager, 6.0f, 3, windows);
        //wall.setBlankShaded(assetManager);*/

        //BlankRoom3
        /*BlankRoom3 room3 = new BlankRoom3(assetManager, 5, 3, 3);
        room3.addWindow("frontWall", new BlankWindow(2,1,new Vector2f(3.5f,1.5f)));
        room3.addWindow("frontWall", new BlankWindow(1,2,new Vector2f(1,1)));
        room3.addWindow("backWall", new BlankWindow(1,1,new Vector2f(4.4f,1.5f)));
        //room3.amputeWall("leftWall");
        //room3.amputeWall("rightWall");
        //room3.amputeWall("roof");
        room3.draw();
        room3.setMulticolorShaded(assetManager);
        rootNode.attachChild(room3.getNode());*/

        //BlankRoof
        /*BlankRoof br = new BlankRoof(5,3,3);
        rootNode.attachChild(br.getNode());*/

        //Colonne
        /*Colonne colonne = new Colonne();
        rootNode.attachChild(colonne.getNode());*/

        //Soubassement
        /*Soubassement soubassement = new Soubassement(4,8);
        rootNode.attachChild(soubassement.getNode());*/

        //Metope
        /*Metope metope = new Metope(4,2);
        rootNode.attachChild(metope.getNode());*/

        //Architrave
        /*Architrave architrave = new Architrave(4,8);
        rootNode.attachChild(architrave.getNode());*/

        //Temple
        templeGrec.draw();
        rootNode.attachChild(templeGrec.getNode());

        /*Roof roof = new Roof();
        roof.draw();
        rootNode.attachChild(roof.getNode());*/
    }

    private void setLighting(){
        DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White);
        sun.setDirection(new Vector3f(.3f,-.4f,.5f).normalizeLocal());

        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(0.5f));

        rootNode.addLight(sun);
        rootNode.addLight(al);

        dlsr = new DirectionalLightShadowRenderer(assetManager, 4096, 1);
        dlsr.setLight(sun);
        dlsr.setLambda(0.55f);
        dlsr.setShadowIntensity(0.3f);
        dlsr.setEdgeFilteringMode(EdgeFilteringMode.Dither);
        //dlsr.displayDebug();
        viewPort.addProcessor(dlsr);

        /*dlsf = new DirectionalLightShadowFilter(assetManager, SHADOWMAP_SIZE, 1);
        dlsf.setLight(sun);
        dlsf.setLambda(0.55f);
        dlsf.setShadowIntensity(0.8f);
        dlsf.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
        dlsf.setEnabled(false);*/

        //FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
        //fpp.addFilter(dlsf);

        //viewPort.addProcessor(fpp);
    }
}