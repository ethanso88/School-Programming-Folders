package Application;
import Controller.BohnanzaController;

/*
Name(s):
Hitarth Patel (33%)
prework: Rules, Analysis, GameFrame GUI Diagram
Code: view package, AI, drag and drop

Idrees Syed (33%)
prework: Rules, Algorithm
Code: main controller class, turn controller


Ethan So (33%)
prework: Rules, Analysis, UML Diagram, Start Frame GUI Diagram
Code: model package, AI, turn interface

Date: 4/30/2025

Course Code: ICS4U1-03 Mr.Fernandes

Title: 2 player Bohnanza Game GUI Application (SDP 1)

Description:
- a recreation of the 2 player way to play the original Bohnanza Game online on one screen
- our game allows 2 players or 1 player and an AI to go head to head and see who can farm better in this card game and gain the most coins
- players can choose between 1v1, 1vAI, and viewing the rules from the start/title screen
- this game simulates the real mechanics of the real Bohnanza card game by enabling the same turn order, offer area, and card drawing and stacking feel
- although the process is simplified a bit as the cards stack/merge with each other if they are the same bean type

Features:
- drag and drop cards and harvesting
- images for bean cards and other items to simulate a real visual board
- music player
-
- AI turn based gameplay

Major Skills:
- implementing multiple packages using the MVC format
- using Stack and Queue data types
- inheritance and implementation for using multiple objects and methods
- Arrays, Arraylists
- control structures, imports, static variables
- working on communication to finish different code simultaneously and helping each other

Areas of Concern:
- unfinished AI
- controller
- lack of communication sometimes resulting in code mismerges, and unfinished code

 */

public class BohnanzaGameApplication {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Create controller
        BohnanzaController controller = new BohnanzaController();
    }

}