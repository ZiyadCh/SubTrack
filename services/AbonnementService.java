package services;

import models.Abonnement;
import dao.AbonnementDao;

public class AbonnementService {
  private static AbonnementDao abonnementDao = new AbonnementDao();

  public void addAbonnement(Abonnement abonnement) {
    abonnementDao.add(abonnement);
  }

  public void listAbonnement() {
  }
}
