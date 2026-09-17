import java.util.Scanner;
import java.util.UUID;

import models.Abonnement;
import models.AbonnementAvecEngagement;
import models.AbonnementSansEngagement;
import models.Paiement;
import models.Statut;
import models.TypePaiement;
import dao.AbonnementDao;
import dao.PaiementDao;
import services.AbonnementService;
import services.PaiementService;

public class Main {
  private static AbonnementService abonnementService = new AbonnementService();
  private static PaiementService paiementService = new PaiementService();
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    while (true) {
      System.out.println("┌─────────────────────────────────────┐");
      System.out.println("│      Selectionnez une action        │");
      System.out.println("├─────────────────────────────────────┤");
      System.out.println("│1❯ Lister les Abonnements            │");
      System.out.println("│2❯ Ajouter un Abonnement             │");
      System.out.println("│3❯ Modifier un Abonnement            │");
      System.out.println("│4❯ Supprimer un Abonnement           │");
      System.out.println("│5❯ Lister les Paiements d'un abonemnt│");
      System.out.println("│6❯ Ajouter un Paiement               │");
      System.out.println("│7❯ Modifier un Paiement              │");
      System.out.println("│8❯ Supprimer un Paiement             │");
      System.out.println("│9❯ Quitter                           │");
      System.out.println("└─────────────────────────────────────┘");
      switch (scanner.nextLine()) {
        case "1":
          abonnementService.listAbonnement().forEach(n -> System.out.println(
              "Id: " + n.getId() + "\n"
                  + "Nom service: " + n.getNomService() + "\n"
                  + "Montant mensuel: " + n.getMontantMesuelle() + "\n"
                  + "Date debut: " + n.getDateDebut() + "\n"
                  + "Date fin: " + n.getDateFin() + "\n"
                  + "Statut: " + n.getStatut() + "\n"
                  + "Duree engagement en mois: "
                  + (n instanceof AbonnementAvecEngagement
                      ? ((AbonnementAvecEngagement) n).getDureeEngagementMois()
                      : null)
                  + "\n"));
          break;
        case "2":
          addAbonnementUI();
          break;
        case "3":
          modifyAbonnementUI();
          break;
        case "4":
          supprimerAbonnementUI();
          break;

        case "5":
          System.out.println("Id de l'abonnement:");
          UUID abonnementId = UUID.fromString(scanner.nextLine());
          paiementService.listPaiements(abonnementId).forEach(p -> System.out.println(
              "Id: " + p.getId() + "\n"
                  + "Date echeance: " + p.getDateEcheance() + "\n"
                  + "Date paiement: " + p.getDatePaiement() + "\n"
                  + "Type paiement: " + p.getTypePaiement() + "\n"));
          break;

        case "6":
          addPaiementUI();
          break;

        case "7":
          modifyPaiementUI();
          break;

        case "8":
          supprimerPaiementUI();
          break;

        case "9":
          System.out.println("Au revoir !");
          return;
        default:
          System.out.println("Choisir un nombre correspondant!!");
          break;
      }
    }
  }

  private static void addAbonnementUI() {
    int type = 2;

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
    int dureeEngagement = 0;

    System.out.println("Type d'abonnement:");
    System.out.println("1❯ Avec engagement");
    System.out.println("2❯ Sans engagement");
    switch (scanner.nextLine()) {
      case "1":
        type = 1;
        System.out.println("Duree d'engagement:");
        dureeEngagement = scanner.nextInt();
        scanner.nextLine();
        break;

      case "2":
        type = 2;
        break;

      default:
        break;
    }
    Abonnement abonnement = null;

    if (type == 2) {
      abonnement = new AbonnementSansEngagement(
          UUID.randomUUID(), nomService, montantMensuel, dateDebut, dateFin, Statut.valueOf(statut));
    } else if (type == 1) {
      abonnement = new AbonnementAvecEngagement(
          UUID.randomUUID(), nomService, montantMensuel, dateDebut, dateFin, Statut.valueOf(statut), dureeEngagement);
    }

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
      System.out.println("Nouvelle duree d'engagement en mois :");
      String duree = scanner.nextLine();
      if (!duree.isEmpty()) {
        ((AbonnementAvecEngagement) abonnement).setDureeEngagementMois(Integer.parseInt(duree));
      }
    }

    abonnementService.modifyAbonnement(abonnement.getId());
    System.out.println("modifie avec success");
  }

  private static void supprimerAbonnementUI() {
    System.out.println("Id d'abonnement a supprimer:");
    String id = scanner.nextLine();
    abonnementService.supprimerAbonnement(UUID.fromString(id));
  }

  private static void supprimerPaiementUI() {
    System.out.println("Id du paiement a supprimer:");
    String id = scanner.nextLine();
    paiementService.supprimerPaiement(UUID.fromString(id));
  }

  private static void addPaiementUI() {
    System.out.println("Id de l'abonnement:");
    UUID abonnementId = UUID.fromString(scanner.nextLine());

    System.out.println("Date d'echeance :");
    String dateEcheance = scanner.nextLine();

    System.out.println("Date de paiement :");
    String datePaiement = scanner.nextLine();

    System.out.println("Type de paiement (PAYE, NONPAYE, RETARD):");
    String typePaiement = scanner.nextLine();

    Paiement paiement = new Paiement(
        UUID.randomUUID(), dateEcheance, datePaiement, TypePaiement.valueOf(typePaiement), abonnementId);

    paiementService.addPaiement(paiement);
  }

  private static void modifyPaiementUI() {
    System.out.println("ID du paiement");
    String id = scanner.nextLine();
    Paiement paiement = paiementService.findById(UUID.fromString(id));
    if (paiement == null) {
      System.out.println("Aucun paiement trouve.");
      return;
    }

    System.out.println("Entrer Nouveau donnes(laisser vide pour Aucun changement)");
    System.out.println("Nouvelle date d'echeance :");
    String dateEcheance = scanner.nextLine();
    if (!dateEcheance.isEmpty()) {
      paiement.setDateEcheance(dateEcheance);
    }

    System.out.println("Nouvelle date de paiement :");
    String datePaiement = scanner.nextLine();
    if (!datePaiement.isEmpty()) {
      paiement.setDatePaiement(datePaiement);
    }

    System.out.println("Nouveau type de paiement (PAYE, NONPAYE, RETARD):");
    String typePaiement = scanner.nextLine();
    if (!typePaiement.isEmpty()) {
      paiement.setTypePaiement(TypePaiement.valueOf(typePaiement));
    }

    // System.out.println("Nouvel id de l'abonnement :");
    // String abonnementId = scanner.nextLine();
    // if (!abonnementId.isEmpty()) {
    // paiement.setAbonnementId(UUID.fromString(abonnementId));
    // }

    paiementService.modifyPaiement(paiement.getId());
    System.out.println("modifie avec success");
  }
}
