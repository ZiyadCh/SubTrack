package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

import db.JdbcConnexion;
import models.Paiement;
import models.PaiementStatut;

public class PaiementDao {
  private static final HashSet<Paiement> paiements = new HashSet<>();

  private Paiement mapRow(ResultSet rs) throws SQLException {
    return new Paiement(
        rs.getObject("id", UUID.class),
        rs.getDate("date_echeance").toString(),
        rs.getDate("date_paiement").toString(),
        PaiementStatut.valueOf(rs.getString("statut")),
        rs.getObject("abonnement_id", UUID.class));
  }

  public ArrayList<Paiement> listAll() throws SQLException {
    ArrayList<Paiement> result = new ArrayList<>();
    String query = "select * from paiement";

    try (Connection conn = JdbcConnexion.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query)) {
      while (rs.next()) {
        result.add(mapRow(rs));
      }
    }
    return result;
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
