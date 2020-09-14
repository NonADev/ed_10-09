package atv03;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class No {
    public Aluno header;

    public static void main(String[] args) {
        No n = new No();
        n.addStart(new Aluno("wesley"));
        n.addStart(new Aluno("samm"));
        n.addStart(new Aluno("Paula"));
        n.addStart(new Aluno("Lari"));
        n.addStart(new Aluno("Sasa"));
        n.addEnd(new Aluno("gabi"));
        n.addEnd(new Aluno("welli"));
        n.addEnd(new Aluno("Nfew"));
        n.addEnd(new Aluno("Andi"));
        n.addEnd(new Aluno("Mathia"));
        n.addPos(new Aluno("Pettecosteu"),0);
        n.addPos(new Aluno("Pettecosteu"),1);
        n.addPos(new Aluno("Pettecosteu"),2);
        n.addPos(new Aluno("Pettecosteu"),3);
        n.addPos(new Aluno("Pettecosteu"),4);
        n.rmEnd();
        n.rmStart();
        n.rmPos(7);
        n.print();
    }

    public void rmPos(int pos){
        if(pos>=length()){
            System.out.println("null");
        }
        else {
            Aluno aux = header;
            for(int i=0;i<length();i++,aux=aux.next){
                if(pos==i){
                    aux.next.previous = aux.previous;
                    aux.previous.next = aux.next;
                    header = aux.next;
                    break;
                }
            }
        }
    }

    public void rmStart(){
        if(isListNull()){
            System.out.println("null");
        }
        else {
            Aluno aux = header.next;
            aux.previous = header.previous;
            header.previous.next = aux;
            header = aux;
        }
    }

    public void rmEnd(){
        if(isListNull()){
            System.out.println("null");
        }
        else {
            Aluno aux = header;
            while (aux.next != header) {
                aux = aux.next;
            }
            aux.previous.next = header;
            header.previous = aux.previous;
        }
    }

    public void addPos(Aluno newAluno, int pos){
        if(pos>=length()){
            System.out.println("null");
        }
        else {
            Aluno aux = header;
            for(int i=0;i<length();i++,aux=aux.next){
                if(pos==i){
                    aux.setNome(newAluno.getNome());
                    aux.setRA(newAluno.getRA());
                    aux.setSemestre(newAluno.getSemestre());
                    aux.setTurma(newAluno.getTurma());
                    break;
                }
            }
        }
    }

    public void addStart(Aluno newAluno){
        if(isListNull()){
            newAluno.next = newAluno;
            newAluno.previous = newAluno;
            header = newAluno;
        }
        else {
            Aluno aux = header;
            newAluno.next = aux;
            newAluno.previous = aux.previous;
            aux.previous = newAluno;
            newAluno.previous.next = newAluno;
            header = newAluno;
        }
    }

    public void addEnd(Aluno newAluno){
        if(isListNull()){
            newAluno.next = newAluno;
            newAluno.previous = newAluno;
            header = newAluno;
        }
        else {
            Aluno aux = header;
            while (aux.next != header) {
                aux = aux.next;
            }
            newAluno.next = header;
            newAluno.previous = aux;
            aux.next = newAluno;
            header.previous = newAluno;
        }
    }

    public void print(){
        Aluno aux = header;
        while(aux.next!=header) {
            System.out.println(aux.getNome());
            aux = aux.next;
        }
        System.out.println(aux.getNome());
    }
    public int length(){
        Aluno aux = header;
        if(header==null) return 0;
        int c=1;
        while(aux.next!=header){
            c++;
            aux = aux.next;
        }
        return c;
    }
    public boolean isListNull() {
        return header == null;
    }
    private static class Aluno{
        private int RA;
        private String nome, turma, semestre;
        private Aluno next, previous;

        public Aluno(String nome){
            setNome(nome);
        }

        public int getRA() {
            return RA;
        }

        public void setRA(int RA) {
            this.RA = RA;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTurma() {
            return turma;
        }

        public void setTurma(String turma) {
            this.turma = turma;
        }

        public String getSemestre() {
            return semestre;
        }

        public void setSemestre(String semestre) {
            this.semestre = semestre;
        }
    }
}
