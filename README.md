Part of Android & Web Development - ISMIN 2021

Course followed by students of Mines St Etienne, ISMIN - M2 Computer Science.

[![Mines St Etienne](./logo.png)](https://www.mines-stetienne.fr/)

# Project template

This project template contains:
 - a skeleton NestJS app in `api`  (can be opened in Webstorm, Visual Studio Code etc)
 - a skeleton Android app in `android` (can be opened in Android Studio)

Hi 👋, we are Eddy and Mathieu,
Computer Science students at Ecole des Mines de Saint Etienne
📫 How to reach us **eddy.aboumansour@etu.emse.fr**,**mathieu.sinleesou@etu.emse.fr**





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

# Features

- Retrieval of a summary of all data (i.e. only the most relevant part will be displayed on the map + listed + added to favorites or not): 
GET /gares
- Addition of the paging to the API requesting GET /gares. The query is now the same as:
GET /gares?page=1&&limit=10 (default value)
- Retrieval of the details of a specific train station (for display in the details screen). Also used for data requests:
GET /gares/:titre (also with paging)
- Addition of a train station in favorites or not:
PATCH /gares/:titre (with a body { favoris:true/false })
- Addition of an endpoint to create new data:
POST /gares (with a body containing new object's attributes in json format)

- Deployed on CleverCloud: https://console.clever-cloud.com/organisations/orga_693c81f4-6d20-46f3-901b-29afc84a379d/applications/app_6c17b1b5-9cde-405a-938c-c79a21284ea3

## Android

 - Start Android Studio
 - Select `Open an existing Android Studio project` and pick this directory
 
# Features

- Retrieval of API's data then display in a list, on a map, or a screen containing the detail of a specific train station
- Addition of elements in the favorites list, then filter it
- Application composed of: 
3 Fragments (Train stations list, train station positions on a map, application's information)
2 Activities (3 Fragments + Detail of each train station)
- A Toolbar was implemented, allowing to refresh retrieved data and display it, to search train station by 'title' or name, and to see the favorites list.


<h3 align="left">Languages and Tools:</h3>

<p align="left"> <a href="https://developer.android.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/android/android-original-wordmark.svg" alt="android" width="40" height="40"/> </a> <a href="https://nodejs.org" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/nodejs/nodejs-original-wordmark.svg" alt="nodejs" width="40" height="40"/> </a> <a href="https://www.typescriptlang.org/" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/typescript/typescript-original.svg" alt="typescript" width="40" height="40"/> </a> </p>


