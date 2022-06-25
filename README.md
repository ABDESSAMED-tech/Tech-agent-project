# Tech-agent-project
## Enoncé du TP

L’objectif de ce TP est d’implémenter des agents intelligents sous la plateforme JADE ou autre. Le TP est composé de deux parties et un rapport à rédiger.

# Première partie : Implémentation d’un système expert 

Dans cette partie, il est demandé aux étudiants d’implémenter le système expert des véhicules donné dans le livre : Constructing Intelligent Agents with Java. Voir chapitres 3 et 4 du livre : page 119-35.
Puis adapter ce système expert au domaine commercial. L’acheteur doit renseigner un formulaire d’un ensemble d’informations telles que le type de produit souhaité, la marque, le prix proposé….  
En parallèle, le système expert vendeur est géré par des règles (à concevoir) qui déterminent son comportement de vendeur. 
## Note : 
- Au moins 10 règles pour le  domaine commercial. 
- L’existence d’au moins une  règle qui appel une autre : une clause d’une règle doit être définie par une autre règle :
- Bicycle: If vehicleType=Cycle and num_wheels=2 and motor=no Then vehicle=Bicycle
- Cycle: If num_wheels  < 4 Then vehicleType=Cycle
- L’interface permet de basculer entre les deux systèmes experts (exemples) : l’exemple des véhicules et votre exemple.
- Concevoir des règles de tel sorte dans la phase d’inférence plusieurs règles peuvent être déclenchées au même temps.
- Donner au moteur d’inférence une stratégie de résolution des conflits dans le cas où plusieurs règles peuvent être déclenchées au même temps.
- Afficher le conflict set
- L’interface doit afficher la règle déclenchée à chaque étape.
- Un seul moteur d’inférence pour les deux exemples.

# Deuxième Partie : 
Implémentation d’un environnement commercial à base d’agents intelligents sous forme d’un système expert en utilisant la plateforme JADE (Java ou Python)

L’environnement est composé d’un agent central et de trois agents annexes.  Chaque agent annexe s’occupe de la vente de produits d’une ou plusieurs catégories, en se basant sur le système expert développé dans la partie 1. 
Le rôle de l’agent central est de recevoir la requête d’achat sous forme d’un formulaire et transmet la requête de l’acheteur aux agents annexes. Le formulaire détermine la base de connaissances utilisée par chaque agent annexe.
Chaque agent utilise sa propre base de règles pour transmettre à l’agent central les détails du produit suivant les critères donnés par l’acheteur (ou la non disponibilité du produit : quantité, couleur,…). A son tour, l’agent central transmet la réponse à l’acheteur via une autre interface.  
L’acheteur choisit et valide une réponse qui lui convient le plus. Cette validation simule l’achat du produit et l’agent annexe met à jour la quantité de son stock.

L’agent central structure les réponses données par chaque agent annexe. Il calcule le prix total si le nombre d’article achetés est supérieur à un. Introduit les promotions dans le calcul des prix. Il affiche : prix unitaire, prix total, nom du point de vente (magasin,…), trie les résultats suivant le prix/nom du magasin,…

  
# Note :
Chaque projet doit tenir compte des points ci-dessous :
- Les trois agents annexes ont au moins deux articles en commun.  
- L’acheteur peut acheter un autre produit dès qu’il valide l’achat du premier.   
- L’acheteur peut acheter un produit complet (exemple : un ordinateur) d’un agent annexe ou une ou plusieurs parties d’un produit (exemple : disque dur, mémoire, microprocesseur, …) de plusieurs agents annexes.
- L’interface doit permettre à l’acheteur de faire entrer les critères une à une (par exemple : en envoi le nom de l’article et on valide. On envoi la couleur et on valide,... ou envoyer le tout à la fois et valider à la fin.
- Chaque agent annexe propose des réductions suivant la quantité achetée.
- Pour la gestion de stocks, chaque agent annexe propose des réductions sur la période de fin d’année (un mois, deux semaines, …).
- Toutes les informations échangées entre l’agent central et les agents annexes doivent être affichées sur l’interface.
# Capteur d'écran
![image](https://user-images.githubusercontent.com/82515052/175789875-a7f4d12f-0e08-4eb7-8e2b-fb4b88bf4385.png)
![image](https://user-images.githubusercontent.com/82515052/175789884-5c7f9d45-a3d3-470e-86ef-5e1153e1ea95.png)
![image](https://user-images.githubusercontent.com/82515052/175789904-7034daff-7ff7-48d4-862f-483e72b648da.png)
![image](https://user-images.githubusercontent.com/82515052/175789968-d0ec58ba-83a2-4a5a-9b78-b850c4c57fe7.png)

