package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import models.Abonnement;

public class AbonnementDao {
  private static final Map<UUID, Abonnement> abonnements = new HashMap<>();

  public void add(Abonnement a) {
    abonnements.put(a.getId(), a);
  }

  public Abonnement findById(UUID id) {
    return abonnements.get(id);
  }

  public Collection<Abonnement> findAll() {
    return abonnements.values();
  }

  public void update(Abonnement a) {
    abonnements.put(a.getId(), a);
  }

  public void delete(UUID id) {
    abonnements.remove(id);
  }
}
