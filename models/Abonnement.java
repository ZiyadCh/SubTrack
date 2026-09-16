package models;

import java.util.UUID;

public abstract class Abonnement {
  protected UUID id;
  protected String nomService;
  protected Double montantMesuelle;
  protected String dateDebut;
  protected String dateFin;

  protected Statut statut;

  public Statut getStatut() {
    return statut;
  }

  public void setStatut(Statut statut) {
    this.statut = statut;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNomService() {
    return nomService;
  }

  public void setNomService(String nomService) {
    this.nomService = nomService;
  }

  public Double getMontantMesuelle() {
    return montantMesuelle;
  }

  public void setMontantMesuelle(Double montantMesuelle) {
    this.montantMesuelle = montantMesuelle;
  }

  public String getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(String dateDebut) {
    this.dateDebut = dateDebut;
  }

  public String getDateFin() {
    return dateFin;
  }

  public void setDateFin(String dateFin) {
    this.dateFin = dateFin;
  }
}
