Part of Android & Web Development - ISMIN 2021

Course followed by students of Mines St Etienne, ISMIN - M2 Computer Science.

[![Mines St Etienne](./logo.png)](https://www.mines-stetienne.fr/)

# Project template

This project template contains:
 - a skeleton NestJS app in `api`  (can be opened in Webstorm, Visual Studio Code etc)
 - a skeleton Android app in `android` (can be opened in Android Studio)

<h1 align="center">Hi 👋, I'm Eddy and Mathieu</h1>
<h3 align="center">computer science students in Mines Saint Etienne</h3>

- 📫 How to reach me **eddy.aboumansour@etu.emse.fr**


<h3 align="left">Languages and Tools:</h3>

<p align="left"> <a href="https://developer.android.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/android/android-original-wordmark.svg" alt="android" width="40" height="40"/> </a> <a href="https://nodejs.org" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nodejs/nodejs-original-wordmark.svg" alt="nodejs" width="40" height="40"/> </a> <a href="https://www.typescriptlang.org/" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/typescript/typescript-original.svg" alt="typescript" width="40" height="40"/> </a> </p>


### 🚀 Getting Started
## API

Open a terminal, go to the directory of this TP and run the following commands:

```sh
# This will install all needed dependencies
npm install

# This will run the tests once
npm run test

OR

# This will run the tests everytime a change is made in the source code
npm run test:watch

# This will build the source and put the transpiled code in `/dist` directory
npm run build
```

# Functionalités

Récupérer un résumé de toutes les données (i.e. seulement les infos les plus importantes pour l’affichage sur une carte + liste + favori ou non). 
GET /gares
Récupérer le détail d’une donnée (pour l’affichage dans l’écran de détails). Utiliser pour la recherche des données aussi
GET /gares/:titre
Mettre une donnée en favori ou non. 
PATCH /gares/:titre (avec un body)
Un endpoint pour créer de nouvelles données
POST /gares (avec un body contenant en format jason les attributs du nouveau objet)

Gérer la pagination des données sur le endpoint retournant le résumé des données


Déployé sur CleverCloud: https://console.clever-cloud.com/organisations/orga_693c81f4-6d20-46f3-901b-29afc84a379d/applications/app_6c17b1b5-9cde-405a-938c-c79a21284ea3

##Android

 - Start Android Studio
 - Select `Open an existing Android Studio project` and pick this directory

Récupération des données de l’api puis affichage sur une carte, dans une liste et sur un écran avec le détail d’une donnée

Mettre en Favori les éléments et les filtrer

Application composée au minimum de : 
3 Fragment (la liste + l’ecran avec les infos)
2 Activity
Une Toolbar sera présente et permettra de rafraîchir les données récupérées et affichées

Amélioration de l’expérience utilisateur :
Mise en place d’un système de recherche/filtre sur la liste affichée


 
