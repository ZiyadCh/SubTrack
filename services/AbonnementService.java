package services;

import java.util.UUID;

import dao.AbonnementDao;
import models.Abonnement;

public class AbonnementService {
  private static AbonnementDao abonnementDao = new AbonnementDao();

  public void addAbonnement(Abonnement abonnement) {
    abonnementDao.add(abonnement);
  }

  public void modifyAbonnement(String id) {
    Abonnement abonnement = abonnementDao.findById(id);
    abonnementDao.update(abonnement);
  }

  public void listAbonnement() {
    abonnementDao.listAll().forEach(n -> System.out
        .println("nom Service:" + n.getNomService() + "\n" + "montant Mensueller:" + n.getMontantMesuelle() + "\n"
            + "date Debut:" + n.getDateDebut() + "\n" + "date Fin:" + n.getDateFin() + "\n" + "statut:" + n.getStatut()
            + "\n"));
  }
}
