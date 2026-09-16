import java.util.Scanner;
import java.util.UUID;

import models.Abonnement;
import models.AbonnementAvecEngagement;
import models.AbonnementSansEngagement;
import models.Paiement;
import models.Statut;
import dao.AbonnementDao;
import dao.PaiementDao;
import services.AbonnementService;

public class Main {
  private static AbonnementService abonnementService = new AbonnementService();
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

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
        case "2":
          addAbonnementUI();
          break;
        case "3":
          modifyAbonnementUI();
          break;

        case "7":
          System.out.println("Au revoir !");
          return;

        default:
          System.out.println("Choisir un nombre correspondant!!");
          break;
      }
    }
  }

  private static void addAbonnementUI() {
    System.out.println("Nom du service:");
    String nomService = scanner.nextLine();

    System.out.println("Montant mensuel:");
    Double montantMensuel = Double.parseDouble(scanner.nextLine());

    System.out.println("Date de debut :");
    String dateDebut = scanner.nextLine();

    System.out.println("Date de fin :");
    String dateFin = scanner.nextLine();

    System.out.println("Statut (ACTIVE, SUSPENDU, RESILIE):");
    String statut = scanner.nextLine();

    Abonnement abonnement = new AbonnementSansEngagement(
        UUID.randomUUID(), nomService, montantMensuel, dateDebut, dateFin, Statut.valueOf(statut));

    abonnementService.addAbonnement(abonnement);
  }

  private static void modifyAbonnementUI() {
    System.out.println("ID d'abonnemnt");
    String id = scanner.nextLine();
    Abonnement abonnement = abonnementService.findById(UUID.fromString(id));
    if (abonnement == null) {
      System.out.println("Aucun abonnement trouve.");
      return;
    }

    System.out.println("Entrer Nouveau donnes(laisser vide pour Aucun changement)");
    System.out.println("Nouveau nom du service :");
    String nomService = scanner.nextLine();
    if (!nomService.isEmpty()) {
      abonnement.setNomService(nomService);
    }

    System.out.println("Nouveau montant mensuel :");
    String montantMensuel = scanner.nextLine();
    if (!montantMensuel.isEmpty()) {
      abonnement.setMontantMesuelle(Double.parseDouble(montantMensuel));
    }

    System.out.println("Nouvelle date de debut :");
    String dateDebut = scanner.nextLine();
    if (!dateDebut.isEmpty()) {
      abonnement.setDateDebut(dateDebut);
    }

    System.out.println("Nouvelle date de fin :");
    String dateFin = scanner.nextLine();
    if (!dateFin.isEmpty()) {
      abonnement.setDateFin(dateFin);
    }

    System.out.println("Nouveau statut :");
    String statut = scanner.nextLine();
    if (!statut.isEmpty()) {
      abonnement.setStatut(Statut.valueOf(statut));
    }

    if (abonnement instanceof AbonnementAvecEngagement) {
      System.out.println("Nouvelle duree d'engagement en mois (vide = inchanger):");
      String duree = scanner.nextLine();
      if (!duree.isEmpty()) {
        ((AbonnementAvecEngagement) abonnement).setDureeEngagementMois(Integer.parseInt(duree));
      }
    }

    abonnementService.modifyAbonnement(abonnement.getId());
    System.out.println("modifie avec success");
  }
}
