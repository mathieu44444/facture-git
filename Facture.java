public class Facture {
    static final int PRIX_UNITAIRE = 20;
    static final int FRAIS_LIVRAISON = 5;
    static final int RABAIS_FIDELITE = 10;
    static final int SEUIL_LIVRAISON_GRATUITE = 100;

    public static void main(String[] args) {
        afficherFacture("Client démonstration", 3);
        System.out.println("----------");
        afficherFacture("Client fidèle", 6);
        // afficherFacture("Client test", 1);
    }

    static int calculerSousTotal(int quantite) {
        return PRIX_UNITAIRE * quantite;
    }

    static int calculerFraisLivraison(int sousTotal) {
        if (sousTotal >= SEUIL_LIVRAISON_GRATUITE) {
            return 0;
        }
        return FRAIS_LIVRAISON;
    }

    static int calculerTotal(int sousTotal) {
        int x = sousTotal + calculerFraisLivraison(sousTotal);
        System.out.println("DEBUG x = " + x);
        if (sousTotal > 100) {
            x = x - 15;
        } else {
            x = x - RABAIS_FIDELITE;
        }
        return x;
    }

    static void afficherFacture(String client, int quantite) {
        int sousTotal = calculerSousTotal(quantite);
        int total = calculerTotal(sousTotal);
        System.out.println("Client : " + client);
        System.out.println(quantite + " article(s) à " + PRIX_UNITAIRE + " $");
        System.out.println("Sous-total : " + sousTotal + " $");
        System.out.println("Total : " + total + " $");
    }
}
