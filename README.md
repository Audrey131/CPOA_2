# CPOA_2

Le projet se trouve dans la branche "master" Sous ECLIPSE2/PROJET/

Le td3 sur les test se trouve dans le dossier td3_CPOA de la branche "master"

Projet: application de gestion de la société RevuesOnLine.

Répartition des tâches: 

TIJOU Allan:
    - Page Abonnements et classes/packages associés
    - Page Formules et classes/packages associés
    
MAROTTA Titouan:
    -Page Client et classes/packages associés
    -Page Durée et classes/packages associés

GIRARD Audrey:
    - Page d'accueil
    - Page Revue
    - Page Périodicitée
    - Mise en commun des classes de chacun des membres du groupe
    - GIT


INVESTISSEMENT: Allan 30%, Titouan 30%, Audrey 40%


Ce qui fonctionne:

Fenêtre Périodicitée:
    - Boutons vers l'accueil
    - Lien FXML/classe Java
    - Supprimer une périodicitée
    - Ajouter une périodicitée
    - Vérification du titre valide (non vide)
    - Liste des Périodicitée présente dans la BDD et mise à jour de celle-ci après opération (Ajout/suppression)

Fenêtre Revue:
    - Bouton vers l'accueil
    - Lien FXML/classe Java
    - Supprimer une revue
    - Ajouter une revue
    - Vérification des champs non-vides
    - Combobox avec les données périodicitée de la BDD
    - Liste des revues présentes dans la BDD et mise à jour de celle-ci après opération (Ajout/suppression)

Fenêtre Accueil:
    - Boutons vers Revue/Client/Périodicitée
    - compteur de Clients/Revues enregistrées dans la BDD

Fenêtre Abonnement:
    - Bouton vers l'accueil
    - Lien FXML/classe Java
    - Combobox Client et Durée
	
Fenêtre Client:
    - Lien FXML/classe Java
    - Ajouter un client
    - Liste des clients présents dans la BDD et mise à jour de celle-ci après opération 
    - Vérification de la validité des champs
    
Ce qui ne fonctionne pas:
    - L'application ne gère que la base de données en MySQL
    - Bouton "Détails" de la section Revue
    - Ajout d'image via un choix de fichier
    - Suppression d'un client
    - La saisie du tarif de la page revue permet de rentrer des valeurs autre qu'un flottant/entier, pareil 
pour la saisie du code postal et du numero de rue de la table clients
    - Pas de possibilitée d'ajouter les données d'un fichier CSV
    - La fenêtre abonnement n'est pas terminée.

