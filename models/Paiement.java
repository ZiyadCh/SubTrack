package models;

import java.util.UUID;

public class Paiement {
  protected UUID id;
  protected String dateEcheance;
  protected String datePaiement;
  protected PaiementStatut paiementStatut;
  protected UUID abonnementId;

  public Paiement(UUID id, String dateEcheance, String datePaiement, PaiementStatut paiementStatut, UUID abonnementId) {
    this.id = id;
    this.dateEcheance = dateEcheance;
    this.datePaiement = datePaiement;
    this.paiementStatut = paiementStatut;
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

  public PaiementStatut getPaiementStatut() {
    return paiementStatut;
  }

  public void setPaiementStatut(PaiementStatut paiementStatut) {
    this.paiementStatut = paiementStatut;
  }
}
