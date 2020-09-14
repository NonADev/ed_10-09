package atv02;

public class Temperatura {
    public No header;

    public static void main(String[] args) {
        Temperatura t = new Temperatura();
        t.addStart(3.0);
        t.addStart(2.0);
        t.addStart(2.0);
        t.addStart(2.0);
        t.addStart(1.0);
        t.addEnd(4.0);
        t.addEnd(4.0);
        t.addEnd(4.0);
        t.addEnd(4.0);
        t.addEnd(4.0);
        t.addPos(0,14.0);
        t.addPos(0,14.0);
        t.addPos(0,14.0);
        t.addPos(0,14.0);
        t.addPos(0,2.0);
//        t.rmStart();
//        t.rmStart();
//        t.rmStart();
//        t.rmStart();
//        t.rmStart();
//        t.rmPos(0);
//        t.rmPos(0);
//        t.rmPos(0);
//        t.rmPos(0);
//        t.rmPos(0);
        t.rmEnd();
        t.rmEnd();
        t.rmEnd();
        t.rmEnd();
        t.rmEnd();
        t.print();
    }

    //  verificar se a lista está vazia, retornando true se estiver vazia e false se nãoestiver
    public boolean isListNull() {
        return header == null;
    }

    public int length(){
        No aux = header;
        int toReturn=0;
        if(isListNull()) return 0;
        do{
            toReturn++;
            aux = aux.next;
        }while(aux.next!=null);
        return toReturn;
    }

    //    remover a temperatura do início da lista, retornando o valor que foi removido, caso a
    //    operação não possa ser realizada, mostre mensagem avisando;
    public void rmStart(){
        if(header==null) System.out.println("avisando");
        else header = header.next;
    }

//    remover a temperatura do final da lista, retornando o valor que foi removido, caso a
//    operação não possa ser realizada, mostre mensagem avisando;
    public void rmEnd(){
        if(header==null) System.out.println("avisando");
        else {
            No aux = header;
            while(aux.next.next!=null){
                aux = aux.next;
            }
            aux.next = null;
        }
    }

    //    -remover a temperatura de determinada posição da lista, retornando o valor que foi
    //    removido, caso a operação não possa ser realizada, mostre mensagem avisando;
    public void rmPos(int pos){
        No aux = header;
        if(pos<length()){
            for(int i=0;i<length();i++,aux=aux.next){
                if(pos==0){
                    header = header.next;
                    break;
                }
                else if(i+1==pos){
                    aux.next=aux.next.next;
                    break;
                }
            }
        }
        else{
            System.out.println("Index indisponivel");
        }
    }

    //    adicionar uma temperatura em determinada posição da lista, caso a operação não
    //    possa ser realizada, mostre mensagem avisando;
    public void addPos(int pos, Double temperatura){
        if(pos<length()){
            No aux = header;
            for(int i=0;i<length();i++,aux=aux.next){
                if(i==pos){
                    aux.temperatura = temperatura;
                    break;
                }
            }
        }
        else{
            System.out.println("Index indisponivel");
        }
    }

    //  adicionar uma temperatura no início da lista, caso a operação não possa ser realizada,
    //  mostre mensagem avisando;
    public void addStart(Double temperatura) {
        if (isListNull()) {
            header = new No();
            header.temperatura = temperatura;
        } else {
            No newNo = new No();
            newNo.temperatura = temperatura;
            newNo.next = header;
            header = newNo;
        }
    }

    //  adicionar uma temperatura no final da lista, caso a operação não possa ser realizada,
    //  mostre mensagem avisando;
    public void addEnd(Double temperatura) {
        No aux = header;
        while (aux.next != null) {
            aux = aux.next;
        }
        No newNo = new No();
        newNo.temperatura = temperatura;
        aux.next = newNo;
    }

    public void print(){
        No aux = header;
        while(aux.next!=null){
            System.out.println(aux.temperatura);
            aux = aux.next;
        }
        System.out.println(aux.temperatura);
    }

    private static class No {
        public No next;
        public Double temperatura;
    }

}
