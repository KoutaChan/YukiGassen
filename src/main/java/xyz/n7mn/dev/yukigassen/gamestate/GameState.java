package xyz.n7mn.dev.yukigassen.gamestate;

public enum GameState {
    LOBBY, STARTING, PLAYING, ENDING;

    private static GameState state;

    public static void setState(GameState state)
    { GameState.state = state;}
    public static GameState getState()
    { return state; }
}
