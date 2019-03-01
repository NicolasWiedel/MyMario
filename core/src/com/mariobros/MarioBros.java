package com.mariobros;

import com.gameutils.game.GameBase;
import com.mariobros.screens.game.GameScreen;

/**
 * Die Klasse stellt eine Basis Instanz der Game Klasse dar
 */
public class MarioBros extends GameBase {

	/** Methode aus der GameBase, die nach der Instantiierung aufgerufen wird und für die
	 *  Fortsetzng des Spiel sorgt
	 */
	@Override
	public void postCreate() {
		setScreen(new GameScreen(this));
	}
}
