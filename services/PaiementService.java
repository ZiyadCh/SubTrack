package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Stream;

import dao.PaiementDao;
import models.Paiement;

public class PaiementService {
  private static PaiementDao paiementDao = new PaiementDao();

  public Stream<Paiement> listPaiements(UUID abonnementId) {
    return new ArrayList<Paiement>(paiementDao.listAll())
        .stream()
        .filter(n -> n.getAbonnementId().equals(
            abonnementId));
  }

  public Stream<Paiement> derniersPaiements(int n) {
    return new ArrayList<Paiement>(paiementDao.listAll())
        .stream()
        .sorted(Comparator.comparing(Paiement::getDateEcheance).reversed())
        .limit(n);
  }

  public Paiement findById(UUID id) {
    return paiementDao.findById(id);
  }

  public void addPaiement(Paiement paiement) {
    paiementDao.add(paiement);
  }

  public void modifyPaiement(UUID id) {
    Paiement paiement = paiementDao.findById(id);
    paiementDao.update(paiement);
  }

  public void supprimerPaiement(UUID id) {
    paiementDao.delete(id);
  }
}
