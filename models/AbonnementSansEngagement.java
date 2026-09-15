package models;

import java.util.UUID;

public class AbonnementSansEngagement extends Abonnement {

  public AbonnementSansEngagement(UUID id, String nomService, Double montantMesuelle, String dateDebut, String dateFin,
      Statut statut) {
    this.id = id;
    this.nomService = nomService;
    this.montantMesuelle = montantMesuelle;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.statut = statut;
  }
}
