package org.fernando.gg.core.services.contracts;

public interface IGamePlayersManager {

	void joinGame(String gameRef, String playerName);
	void leaveGame(String gameRef, String playerName);

}
