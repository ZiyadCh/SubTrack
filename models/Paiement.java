package models;

import java.util.UUID;

public class Paiement {
  protected UUID id;
  protected String dateEcheance;
  protected String datePaiement;
  protected TypePaiement typePaiement;
  protected UUID abonnementId;

  public Paiement(UUID id, String dateEcheance, String datePaiement, TypePaiement typePaiement, UUID abonnementId) {
    this.id = id;
    this.dateEcheance = dateEcheance;
    this.datePaiement = datePaiement;
    this.typePaiement = typePaiement;
    this.abonnementId = abonnementId;
  }

  public UUID getAbonnementId() {
    return abonnementId;
  }

  public void setAbonnementId(UUID abonnementId) {
    this.abonnementId = abonnementId;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDateEcheance() {
    return dateEcheance;
  }

  public void setDateEcheance(String dateEcheance) {
    this.dateEcheance = dateEcheance;
  }

  public String getDatePaiement() {
    return datePaiement;
  }

  public void setDatePaiement(String datePaiement) {
    this.datePaiement = datePaiement;
  }

  public TypePaiement getTypePaiement() {
    return typePaiement;
  }

  public void setTypePaiement(TypePaiement typePaiement) {
    this.typePaiement = typePaiement;
  }
}
