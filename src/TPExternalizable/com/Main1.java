package TPExternalizable.com;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Main1 {
    public static void main(String[] args) {
        String file = "chat.ser";

        // 1) Création d'un historique de chat
        List<ChatMessage> history = new ArrayList<>();
        history.add(new ChatMessage("Reda", "Bonjour"));
        history.add(new ChatMessage("Hind", "Salaaam"));
        history.add(new ChatMessage("Ahmed",   "bien et toi"));

        // 2) Sauvegarde
        try {
            ChatHistory.save(file, history);
            System.out.println("Historique sauvegardé dans " + file);
        } catch (IOException e) {
            System.err.println("Erreur sauvegarde : " + e.getMessage());
            return;
        }

        // 3) Chargement
        List<ChatMessage> loaded;
        try {
            loaded = ChatHistory.load(file);
            System.out.println("Historique chargé :");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur chargement : " + e.getMessage());
            return;
        }

        // 4) Affichage
        for (ChatMessage msg : loaded) {
            System.out.printf("  [%d chars] %s%n",
                msg.getLength(), msg);
        }
    }
}