package dao;

import java.util.HashSet;
import java.util.UUID;

import models.Paiement;

public class PaiementDao {
  private static final HashSet<Paiement> paiements = new HashSet<>();

  public void add(Paiement p) {
    paiements.add(p);
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
    paiements.removeIf(n -> n.getId().equals(n.getId()));
    paiements.add(paiement);
  }

  public void delete(UUID id) {
    paiements.removeIf(p -> p.getId().equals(id));
  }
}
