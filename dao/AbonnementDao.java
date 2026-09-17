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
        UUID.fromString("123e4567-e89b-42d3-a456-556642440000"), "Netflix", 15.99, "2026-01-01", "2026-12-31",
        Statut.ACTIVE));
    abonnements.add(new AbonnementAvecEngagement(
        UUID.randomUUID(), "Spotify", 9.99, "2026-01-01", "2026-06-30", Statut.ACTIVE, 12));
    abonnements.add(new AbonnementSansEngagement(
        UUID.randomUUID(), "Disney+", 11.99, "2026-03-01", "2026-09-30", Statut.SUSPENDU));
  }

  public void add(Abonnement abonnement) {
    abonnements.add(abonnement);
  }

  public Abonnement findById(UUID id) {
    return abonnements.stream()
        .filter(n -> n.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public HashSet<Abonnement> listAll() {
    return abonnements;
  }

  public void update(Abonnement abonnement) {
    abonnements.removeIf(n -> n.getId().equals(abonnement.getId()));
    abonnements.add(abonnement);
  }

  public void delete(UUID id) {
    abonnements.removeIf(n -> n.getId().equals(id));
  }

}
