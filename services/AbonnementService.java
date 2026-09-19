package services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.AbonnementDao;
import models.Abonnement;
import models.PaiementStatut;

public class AbonnementService {
  private static AbonnementDao abonnementDao = new AbonnementDao();
  private static PaiementService paiementService = new PaiementService();

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

  public ArrayList<Abonnement> listAbonnement() {
    return new ArrayList<>(abonnementDao.listAll());
  }

  public Double sum(UUID id) {
    Abonnement abonnement = abonnementDao.findById(id);
    return paiementService.listPaiements(id)
        .filter(n -> n.getPaiementStatut() == PaiementStatut.PAYE)
        .mapToDouble(n -> abonnement.getMontantMesuelle())
        .sum();

  }

  public void supprimerAbonnement(UUID id) {
    abonnementDao.delete(id);
  }
}
