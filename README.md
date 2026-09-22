# SubTrack

Application console en **Java** pour gérer ses **abonnements** et leurs **paiements** depuis le terminal.

## Fonctionnalités

- **Abonnements** : lister, ajouter, modifier, supprimer
- **Paiements** : lister, ajouter, modifier, supprimer
- **Requêtes utiles** : paiements manqués, somme totale payée, 3 derniers paiements

Types : `AbonnementAvecEngagement` (avec durée d'engagement) / `AbonnementSansEngagement`.

Statuts : abonnement `ACTIVE`/`SUSPENDU`/`RESILIE` — paiement `PAYE`/`NONPAYE`/`RETARD`.

## Prérequis

- JDK 8 ou supérieur

## Exécution

```bash
java -cp out Main        # classes déjà compilées
```

Compilation depuis les sources :

```bash
javac -sourcepath . -d out $(find . -name "*.java")
java -cp out Main
```

## Structure

```
Main.java              # Point d'entrée + interface terminal
models/                # Modèles de données
dao/                   # Accès aux données (en mémoire)
services/              # Logique métier
exceptions/            # InvalidInputException
out/                   # Classes compilées
```

Architecture en couches : **Main → services → dao → models**.

## Données d'exemple

| Abonnement | Prix | Type | Statut |
|------------|------|------|--------|
| Netflix | 15,99 dh/mois | Sans engagement | `ACTIVE` |
| Spotify | 9,99 dh/mois | Avec engagement (12 mois) | `ACTIVE` |
| Disney+ | 11,99 dh/mois | Sans engagement | `SUSPENDU` |

## Notes

- Dates au format `AAAA-MM-JJ` (ex. `2026-01-01`).
- Champ vide lors d'une modification = inchangé.