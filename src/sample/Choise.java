package sample;

public class Choise {
String choise;
int a=0;

public String ch () {

    do {
        a = (int) (Math.random() * 10);
        if (a>0 && a<4){
            choise="k";}
        else if (a>3 && a<7){
            choise="n";}
        else if (a>6 && a<10){
            choise="b";}
    } while (a>9 || a<1);
    return choise;
}
}
