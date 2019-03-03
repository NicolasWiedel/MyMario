package com.mariobros.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;

/**
 * created by Nicolas Wiedel on 03.03.2019
 */
public class AssetDescriptors {

    // == constants ==
    public static final Array<AssetDescriptor> ALL = new Array<AssetDescriptor>();

    public static final Array<TiledMap> LEVELS = new Array<TiledMap>();

    public static TiledMap level1;

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.SCORE_FONT,BitmapFont.class);

    // == static init ==
    static{
        ALL.add(
              FONT
        );

        LEVELS.add(
              level1
        );
    }

    // == constructor ==
    private AssetDescriptors(){}
}
