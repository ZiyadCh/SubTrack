package services;

import java.util.UUID;

import dao.AbonnementDao;
import models.Abonnement;
import models.AbonnementAvecEngagement;

public class AbonnementService {
  private static AbonnementDao abonnementDao = new AbonnementDao();

  public Abonnement findById(UUID id) {
    return abonnementDao.findById(id);
  }

  public void addAbonnement(Abonnement abonnement) {
    abonnementDao.add(abonnement);
  }

  public void modifyAbonnement(UUID id) {
    Abonnement abonnement = abonnementDao.findById(id);
    abonnementDao.update(abonnement);
  }

  public void listAbonnement() {
    abonnementDao.listAll().forEach(n -> System.out.println(
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
  }
}
