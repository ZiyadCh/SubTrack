package dao;

import java.util.HashSet;
import java.util.UUID;

import models.Abonnement;
import models.AbonnementAvecEngagement;
import models.AbonnementSansEngagement;
import models.Statut;

public class AbonnementDao {
  private static final HashSet<Abonnement> abonnements = new HashSet<>();

  static {
    abonnements.add(new AbonnementSansEngagement(
        UUID.randomUUID(), "Netflix", 15.99, "2026-01-01", "2026-12-31", Statut.ACTIVE));
    abonnements.add(new AbonnementAvecEngagement(
        UUID.randomUUID(), "Spotify", 9.99, "2026-01-01", "2026-06-30", Statut.ACTIVE, 12));
    abonnements.add(new AbonnementSansEngagement(
        UUID.randomUUID(), "Disney+", 11.99, "2026-03-01", "2026-09-30", Statut.SUSPENDU));
  }

  public void add(Abonnement a) {
    abonnements.add(a);
  }

  public Abonnement findById(UUID id) {
    return abonnements.stream()
        .filter(a -> a.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public HashSet<Abonnement> listAll() {
    return abonnements;
  }

  public void update(Abonnement a) {
    abonnements.removeIf(existing -> existing.getId().equals(a.getId()));
    abonnements.add(a);
  }

  public void delete(UUID id) {
    abonnements.removeIf(a -> a.getId().equals(id));
  }

}
