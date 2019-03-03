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

    public static final Array<String> LEVELS = new Array<String>();

    public static TiledMap level1;

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.SCORE_FONT,BitmapFont.class);

    public static final String LEVEL1 = AssetPaths.LEVEL1_MAP;

    // == static init ==
    static{
        ALL.addAll(
                FONT
        );

        LEVELS.addAll(
                LEVEL1
        );
    }

    // == constructor ==
    private AssetDescriptors(){}
}
