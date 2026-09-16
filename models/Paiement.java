package models;

import java.util.UUID;

public class Paiement {
  protected UUID id;
  protected String idAbonnement;
  protected String dateEcheance;
  protected String datePaiement;
  protected TypePaiement typePaiement;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getIdAbonnement() {
    return idAbonnement;
  }

  public void setIdAbonnement(String idAbonnement) {
    this.idAbonnement = idAbonnement;
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
