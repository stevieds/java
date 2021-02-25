public class Main {
    public static void main(String[] args) {
        Tavolo tav1 = new Tavolo(1);
        Tavolo tav2 = new Tavolo(2);
        Tavolo tav3 = new Tavolo(3);
        Coda coda = new Coda();
        Cameriere cam = new Cameriere("Matteo", coda);
        cam.inserisciOrdine(tav1,new Piatto("Carbonara"));
        cam.inserisciOrdine(tav1,new Piatto("Amatriciana"));
        cam.inserisciOrdine(tav2,new Piatto("Arrabbiata"));
        cam.inserisciOrdine(tav2,new Piatto("Agnolotti_plin"));
        cam.inserisciOrdine(tav1,new Piatto("Panna_cotta"));
        cam.inserisciOrdine(tav3,new Piatto("Antipasto"));
        cam.inserisciOrdine(tav3,new Piatto("Olive_ascolane"));
        cam.inserisciOrdine(tav3,new Piatto("Fritto_misto"));
        cam.inserisciOrdine(tav3,new Piatto("Peperonata"));
        cam.inserisciOrdine(tav3,new Piatto("Polenta"));
        //System.out.println(coda.toString());
        Cuoco cuo = new Cuoco ("Marco", coda);
        cuo.inserisciOrdine();
        //System.out.println(coda.toString());
        cam.consegna();
        cuo.inserisciOrdine();
        cuo.inserisciOrdine();
        cam.consegna();
        cuo.inserisciOrdine();
        Cuoco cuc = new Cuoco ("Luca", coda);
        cuc.inserisciOrdine();
        cam.consegna();
        cam.consegna();
        cuc.inserisciOrdine();
        System.out.println(coda.toString());

    }
}
