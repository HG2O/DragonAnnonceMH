# 🐉 DragonAnnounce
> Plugin d'annonce quand l'ender dragon est mort pour annoncer en grande pompe la mort de l'Ender Dragon sur ton serveur Minecraft.
> Il fonctionne avec Leaves 1.21.4

![Minecraft](https://img.shields.io/badge/Minecraft-1.21.4-brightgreen?style=flat-square&logo=minecraft)
![Leaves](https://img.shields.io/badge/Leaves-Compatible-green?style=flat-square)
![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

---

## 📖 Description

**DragonAnnounce** est un plugin léger et performant pour serveurs **Leaves 1.21.4** qui déclenche une annonce spectaculaire dès qu'un joueur tue l'Ender Dragon.

- 🎆 Feux d'artifice en étoile autour du dragon
- 📢 Titre + sous-titre + message chat pour tous les joueurs
- 🎵 Sons épiques (mort du dragon + fanfare)
- 💀 Drop automatique de la **tête de dragon**
- ⚙️ Entièrement configurable via `config.yml`

---

## ✨ Fonctionnalités

| Fonctionnalité | Description |
|---|---|
| 📣 Annonce globale | Titre, sous-titre et message chat envoyés à tous les joueurs en ligne |
| 🎆 Feux d'artifice | Burst de 4 feux d'artifice violets/blancs autour de la position du dragon |
| 🔊 Sons | `ENDER_DRAGON_DEATH` + `CHALLENGE_COMPLETE` joués pour chaque joueur |
| 🐉 Tête de dragon | Droppée automatiquement à la mort du dragon |
| ⏱️ Cooldown | Anti-spam de 10 secondes entre deux annonces |

---

## 🚀 Installation

1. Télécharge le fichier `.jar` depuis les [Releases](https://github.com/HG2O/DragonAnnounce/releases)
2. Place-le dans le dossier `/plugins` de ton serveur Leaves
3. Redémarre le serveur
4. Modifie le `config.yml` généré selon tes préférences
5. Utilise `/reload confirm` ou redémarre pour appliquer les changements

---

## ⚙️ Configuration

Le fichier `config.yml` est généré automatiquement au premier démarrage.

```yaml
# Titre affiché à tous les joueurs (supporte %player%)
title: "🐉 ENDER DRAGON VAINCU 🐉"

# Sous-titre affiché en dessous du titre
subtitle: "%player% a tué le dragon !"

# Message envoyé dans le chat
chat-message: "%player% a tué l'Ender Dragon !"
```

### Variables disponibles

| Variable | Description |
|---|---|
| `%player%` | Remplacé par le nom du joueur qui a tué le dragon |

---

## 🛠️ Compilation (développeurs)

### Prérequis
- Java 21+
- Maven 3.8+

### Build

```bash
git clone https://github.com/HG2O/DragonAnnounce.git
cd DragonAnnounce
mvn clean package
```

Le `.jar` compilé se trouve dans `target/DragonAnnounce-1.0-SNAPSHOT.jar`.

### Dépendances

```xml
<dependency>
    <groupId>org.leavesmc.leaves</groupId>
    <artifactId>leaves-api</artifactId>
    <version>1.21.4-R0.1-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```

---

## 🔧 Compatibilité

| Plateforme | Supporté |
|---|---|
| Leaves 1.21.4 | ✅ Oui |
| Paper 1.21.4 | ✅ Oui |
| Folia | ✅ Oui |
| Spigot / Bukkit | ⚠️ Non recommandé |

---

## 📜 Licence

Ce projet est sous licence **MIT** — libre d'utilisation, modification et redistribution.

---

## 👤 Auteur

Développé par **HG2O**.

> *« Le End tremble sous vos pieds »* 🐉
