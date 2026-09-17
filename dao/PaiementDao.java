package dao;

import java.util.HashSet;
import java.util.UUID;

import models.Paiement;
import models.TypePaiement;

public class PaiementDao {
  private static final HashSet<Paiement> paiements = new HashSet<>();

  static {
    Paiement p1 = new Paiement(
        UUID.randomUUID(), "2026-02-01", "2026-02-01", TypePaiement.PAYE,
        UUID.fromString("123e4567-e89b-42d3-a456-556642440000"));
    paiements.add(p1);

    Paiement p2 = new Paiement(
        UUID.randomUUID(), "2026-02-05", "2026-02-09", TypePaiement.RETARD, UUID.randomUUID());
    paiements.add(p2);

    Paiement p3 = new Paiement(
        UUID.randomUUID(), "2026-03-05", null, TypePaiement.NONPAYE, UUID.randomUUID());
    paiements.add(p3);
  }

  public HashSet<Paiement> listAll() {
    return paiements;
  }

  public void add(Paiement paiement) {
    paiements.add(paiement);
  }

  public Paiement findById(UUID id) {
    return paiements.stream()
        .filter(n -> n.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public HashSet<Paiement> findAll() {
    return paiements;
  }

  public void update(Paiement paiement) {
    paiements.removeIf(n -> n.getId().equals(paiement.getId()));
    paiements.add(paiement);
  }

  public void delete(UUID id) {
    paiements.removeIf(p -> p.getId().equals(id));
  }
}
