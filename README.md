

# TP1 Synchronisation
# Compte rendu



```java

    // Création d'un buffer, producteur et d'un consommateur
    Buffer b = new Buffer(10);
    Producteur p = new Producteur(b);
    Consommateur c1 = new Consommateur(b, 1);

public void depot(double value) {

        // On acquire le semaphore du producteur
        // Le semaphore permet de réduire la taille du buffer à - 1
        // Cela enléve un espace pour que le producteur puisse ajouté 

        semProducteur.acquire();
        for(int i=0; i<size;i++){
            if(buffer[i] == 0){
                buffer[i] = value;
                break;
            }
        }

        // On realease le semaphore du consomateur pour lui permettre de récupérer une valeur
        // En faisantt un realease on fait ++ à la taille ce qui nous permet de récupérer la bonne case mémoire du buffer qui lui est autorisé d'accèes
        semConso.realease();
        
    }

    // On fait la même chose avec retrait
    public double retrait() {
        double value = 0;
        semConso.acquire();
        
        for(int i = 0;i<size ;i++){
            if(buffer[i] != 0){
                value = buffer[i];
                System.out.println("position : "+ i+ " buffer: "+ buffer[i]);
                buffer[i] = 0;
                break;
            }
        }
        semProducteur.realease();
        return value;
    }
``` 