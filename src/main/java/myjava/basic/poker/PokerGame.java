package myjava.basic.poker;

import java.util.*;

public class PokerGame {
    static HashMap<Integer, String> deck = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        // Ready Cards
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A", "2"
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A", "2"};
        int count = 1;
        for (String n : number) {
            for (String c : color) {
                deck.put(count++, c+n);
            }
        }
        // Jokers
        deck.put(49, "BJ");
        deck.put(50, "RJ");
        list.addAll(deck.keySet());
    }
    public PokerGame() {
        System.out.println(deck);
        System.out.println(list);

        // Shuffle Cards
        Collections.shuffle(list);

        // Create containers
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        ArrayList<TreeSet<Integer>> players = new ArrayList<>();
        players.add(lord);
        players.add(player1);
        players.add(player2);
        players.add(player3);

        // Dealt Cards
        dealtPoker(players);

        // Show Card
        lookPoker(players);
    }

    /**
     * Traversal cards, first three goes to lord, then player 1 to 3 take one by turns.
     */
    private static void dealtPoker(ArrayList<TreeSet<Integer>> players) {
        for (int i = 0; i < list.size(); i++) {
            Integer poker = list.get(i);
            if(i<3) players.get(0).add(poker);
            else{
                switch (i%3){
                    case 0-> players.get(1).add(poker);
                    case 1-> players.get(2).add(poker);
                    case 2-> players.get(3).add(poker);
                }
            }
        }
    }

    /**
     * Check a player's card
     */
    public void lookPoker(ArrayList<TreeSet<Integer>> players){
        for (TreeSet<Integer> list : players) {
            for (Integer poker : list) {
                System.out.print(deck.get(poker) + " ");
            }
            System.out.println();
        }
    }
}
