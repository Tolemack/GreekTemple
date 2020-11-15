import com.jme3.app.SimpleApplication;

import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.math.ColorRGBA;

import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.EdgeFilteringMode;
import models.blank.*;
import models.blank.helpers.BlankWindow;

import java.awt.*;
import java.util.ArrayList;

/**
 * Sample 5 - how to map keys and mousebuttons to actions
 */
public class HelloJME3 extends SimpleApplication {

    public static final int SHADOWMAP_SIZE = 1024;
    private DirectionalLightShadowRenderer dlsr;
    private DirectionalLightShadowFilter dlsf;

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
        this.setLighting();
    }

    private void setScene(){
        //Skybox
        SkyboxRoom roomSky = new SkyboxRoom(assetManager, 50,50,50);
        roomSky.putSimpleDummyGrass(assetManager);
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
        BlankRoom3 room3 = new BlankRoom3(assetManager, 5, 3, 3);
        room3.addWindow("frontWall", new BlankWindow(2,1,new Vector2f(3.5f,1.5f)));
        room3.addWindow("frontWall", new BlankWindow(1,2,new Vector2f(1,1)));
        room3.addWindow("backWall", new BlankWindow(1,1,new Vector2f(4.4f,1.5f)));
        room3.amputeWall("leftWall");
        //room3.amputeWall("rightWall");
        room3.amputeWall("roof");
        room3.draw();
        room3.setMulticolorShaded(assetManager);

        rootNode.attachChild(room3.getNode());
    }

    private void setLighting(){
        DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White);
        sun.setDirection(new Vector3f(-.5f,-.5f,-.5f).normalizeLocal());

        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(0.5f));

        rootNode.addLight(sun);
        rootNode.addLight(al);

        dlsr = new DirectionalLightShadowRenderer(assetManager, SHADOWMAP_SIZE, 3);
        dlsr.setLight(sun);
        dlsr.setLambda(0.55f);
        dlsr.setShadowIntensity(0.8f);
        dlsr.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
        //dlsr.displayDebug();
        viewPort.addProcessor(dlsr);

        dlsf = new DirectionalLightShadowFilter(assetManager, SHADOWMAP_SIZE, 3);
        dlsf.setLight(sun);
        dlsf.setLambda(0.55f);
        dlsf.setShadowIntensity(0.8f);
        dlsf.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
        dlsf.setEnabled(false);

        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
        fpp.addFilter(dlsf);

        viewPort.addProcessor(fpp);
    }
}