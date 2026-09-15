package models;

import java.util.UUID;

public class Paiement {
  protected UUID id;
  protected String idAbonnement;
  protected String dateEcheance;
  protected String datePaiement;
  protected TypePaiement typePaiement;
}
