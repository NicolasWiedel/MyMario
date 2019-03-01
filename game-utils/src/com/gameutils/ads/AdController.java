package com.gameutils.ads;

/**
 * Created by Nicolas Wiedel on 05.01.2019.
 */
public interface AdController {

    void showBanner();

    void showInterstitial();

    boolean isNetworkConnected();
}
