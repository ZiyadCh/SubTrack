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
        .filter(p -> p.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public HashSet<Paiement> findAll() {
    return paiements;
  }

  public void update(Paiement p) {
    paiements.removeIf(existing -> existing.getId().equals(p.getId()));
    paiements.add(p);
  }

  public void delete(UUID id) {
    paiements.removeIf(p -> p.getId().equals(id));
  }
}