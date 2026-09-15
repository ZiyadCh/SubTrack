package models;

import java.util.UUID;

public class AbonnementAvecEngagement extends Abonnement {
  private int dureeEngagementMois;

  public int getDureeEngagementMois() {
    return dureeEngagementMois;
  }

  public void setDureeEngagementMois(int dureeEngagementMois) {
    this.dureeEngagementMois = dureeEngagementMois;
  }

  public AbonnementAvecEngagement(UUID id, String nomService, Double montantMesuelle, String dateDebut, String dateFin,
      Statut statut, int dureeEngagementMois) {
    this.id = id;
    this.nomService = nomService;
    this.montantMesuelle = montantMesuelle;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.statut = statut;
    this.dureeEngagementMois = dureeEngagementMois;
  }
}
