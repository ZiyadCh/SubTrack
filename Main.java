import java.util.Scanner;
import java.util.UUID;

import models.Abonnement;
import models.AbonnementAvecEngagement;
import models.AbonnementSansEngagement;
import models.Paiement;
import dao.AbonnementDao;
import dao.PaiementDao;
import services.AbonnementService;

public class Main {
  private static AbonnementService abonnementService = new AbonnementService();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("┌────────────────────────────────┐");
      System.out.println("│      Sélectionnez une action   │");
      System.out.println("├────────────────────────────────┤");
      System.out.println("│1❯ Lister les Abonnements       │");
      System.out.println("│2❯ Ajouter un Abonnement        │");
      System.out.println("│3❯ Modifier un Abonnement       │");
      System.out.println("│4❯ Supprimer un Abonnement      │");
      System.out.println("│5❯ Paiements                    │");
      System.out.println("│6❯ Ajouter un Paiement          │");
      System.out.println("│7❯ Quitter                      │");
      System.out.println("└────────────────────────────────┘");
      switch (scanner.nextLine()) {
        case "1":
          abonnementService.listAbonnement();
          break;

        case "7":
          System.out.println("Au revoir !");
          return;

        default:
          break;
      }
    }
  }

}
