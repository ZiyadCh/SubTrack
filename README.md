# SubTrack

Application console en **Java** pour gérer ses **abonnements** et leurs **paiements** directement depuis le terminal.

## Fonctionnalités

Menu interactif avec 12 options :

- **Abonnements** : lister, ajouter, modifier, supprimer
- **Paiements** : lister par abonnement, ajouter, modifier, supprimer
- **Requêtes utiles** :
  - Paiements manqués (non payés)
  - Somme totale payée pour un abonnement
  - 3 derniers paiements par échéance

Deux types d'abonnements pris en charge :

| Type | Description |
|------|-------------|
| `AbonnementAvecEngagement` | Avec durée d'engagement en mois |
| `AbonnementSansEngagement` | Sans engagement |

Statuts possibles :

- **Abonnement** : `ACTIVE`, `SUSPENDU`, `RESILIE`
- **Paiement** : `PAYE`, `NONPAYE`, `RETARD`

## Stack technique

- **Langage** : Java 8
- **Base de données** : PostgreSQL via JDBC *(en cours de développement)*
- **Stockage actuel** : en mémoire (`HashSet`)
- **Dépendances** : aucune (JDK uniquement)

## Prérequis

- JDK 8 ou supérieur

## Compilation et exécution

### Lancer directement (classes déjà compilées)

```bash
java -cp out Main
```

### Compiler depuis les sources

```bash
javac -sourcepath . -d out $(find . -name "*.java")
java -cp out Main
```

## Structure du projet

```
SubTrack/
├── Main.java              # Point d'entrée + interface terminal
├── models/                # Modèle de données
│   ├── Abonnement.java            # Classe abstraite de base
│   ├── AbonnementAvecEngagement.java
│   ├── AbonnementSansEngagement.java
│   ├── Paiement.java
│   ├── PaiementStatut.java        # Enum : PAYE, NONPAYE, RETARD
│   └── Statut.java                # Enum : ACTIVE, SUSPENDU, RESILIE
├── dao/                   # Accès aux données (en mémoire)
│   ├── AbonnementDao.java
│   └── PaiementDao.java
├── services/              # Logique métier
│   ├── AbonnementService.java
│   └── PaiementService.java
├── db/                    # Connexion PostgreSQL (WIP)
│   └── JdbcConnexion.java
├── exceptions/
│   └── InvalidInputException.java
└── out/                   # Classes compilées
```

Architecture en couches : **Main (UI) → services (logique métier) → dao (stockage) → models**.

## Données d'exemple

L'application démarre avec des données d'exemple préchargées :

- **Netflix** — 15,99 €/mois — *sans engagement* — `ACTIVE`
- **Spotify** — 9,99 €/mois — *avec engagement (12 mois)* — `ACTIVE`
- **Disney+** — 11,99 €/mois — *sans engagement* — `SUSPENDU`

## Notes

- Les dates sont saisies au format `AAAA-MM-JJ` (ex. `2026-01-01`).
- Lors d'une modification, laissez un champ vide pour le laisser inchangé.
- La connexion PostgreSQL (`db/JdbcConnexion.java`) est en cours de développement et n'est pas encore utilisée.
