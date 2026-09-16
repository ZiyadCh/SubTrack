package dao;

import java.util.HashSet;
import java.util.UUID;

import models.Abonnement;

public class AbonnementDao {
  private static final HashSet<Abonnement> abonnements = new HashSet<>();

  public void add(Abonnement a) {
    abonnements.add(a);
  }

  public Abonnement findById(UUID id) {
    return abonnements.stream()
        .filter(a -> a.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public HashSet<Abonnement> findAll() {
    return abonnements;
  }

  public void update(Abonnement a) {
    abonnements.removeIf(existing -> existing.getId().equals(a.getId()));
    abonnements.add(a);
  }

  public void delete(UUID id) {
    abonnements.removeIf(a -> a.getId().equals(id));
  }

  public void list() {
    abonnements.forEach(a -> System.out.println(
        "id: " + a.getId() + " | nomService: " + a.getNomService() + " | montantMesuelle: " + a.getMontantMesuelle()
            + " | dateDebut: " + a.getDateDebut() + " | dateFin: " + a.getDateFin() + " | statut: " + a.getStatut()));
  }
}
