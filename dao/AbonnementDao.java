package dao;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.UUID;

import db.JdbcConnexion;
import models.Abonnement;
import models.AbonnementAvecEngagement;
import models.AbonnementSansEngagement;
import models.Statut;

public class AbonnementDao {
  private static final HashSet<Abonnement> abonnements = new HashSet<>();

  public static ResultSet listofabonnements = JdbcConnexion.abonnementDB();

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
