package main;

import socketServer.IOServer;


public class Main {
	public static final int SERVER_PORT = 1234;
	public static void main(String[] args){
		IOServer server = new IOServer(SERVER_PORT);
		server.runServer();
	}
}
