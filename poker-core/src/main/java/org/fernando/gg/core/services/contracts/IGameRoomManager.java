package org.fernando.gg.core.services.contracts;

public interface IGameRoomManager {

	String createGame(String roomName);
	void deleteGame(String gameRef);
	void joinGame(String gameRef, String playerName);
	void leaveGame(String gameRef, String playerName);
	void addDeckToGame(String gameRef);

}
