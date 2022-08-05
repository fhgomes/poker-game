package org.fernando.gg.core.services.contracts;

public interface IGameRoomManager {

	String createGame(String roomName);
	void deleteGame(String gameRef);
	void enterInGame(String gameRef, String playerName);
	void leaveGame(String gameRef, String playerName);
	void addDeckToGame(String gameRef);

}
