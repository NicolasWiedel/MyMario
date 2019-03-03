package com.mariobros.screens.loading;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.gameutils.game.GameBase;
import com.gameutils.screen.loading.LoadingScreenBase;
import com.mariobros.GameConfig;
import com.mariobros.assets.AssetDescriptors;
import com.mariobros.screens.game.GameScreen;

/**
 * created by Nicolas Wiedel on 03.03.2019
 */
public class LoadingScreen extends LoadingScreenBase {

    // == attributes ==
    private TmxMapLoader mapLoader;
    private TiledMap map;

    //== construktor ==
    public LoadingScreen(GameBase game){
        super(game);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("level1.tmx");
    }

    @Override
    protected Array<AssetDescriptor> getAssetDescriptors() {
        return AssetDescriptors.ALL;
    }

    @Override
    protected void onLoadDone() {
        game.setScreen(new GameScreen(game));
    }

    @Override
    protected float getHudWidth() {
        return GameConfig.LOADING_SCREEN_WIDTH;
    }

    @Override
    protected float getHudHeight() {
        return GameConfig.LOADING_SCREEN_HEIGHT;
    }

    public TiledMap getMap() {
        return map;
    }
}
