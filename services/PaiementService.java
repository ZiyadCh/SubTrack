package services;

import java.util.ArrayList;

import dao.PaiementDao;
import models.Paiement;

public class PaiementService {
  private static PaiementDao paiementDao = new PaiementDao();

  public ArrayList<Paiement> listPaiements() {
    return new ArrayList<>(paiementDao.listAll());
  }
}
