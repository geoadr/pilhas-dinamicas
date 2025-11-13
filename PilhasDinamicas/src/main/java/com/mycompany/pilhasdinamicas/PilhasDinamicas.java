/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pilhasdinamicas;

/**
 *
 * @author GeoDantas
 */

import java.util.Random;

class Nodo {
    int valor;
    Nodo proximo;

    Nodo(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Pilha {
    Nodo topo;

    void empilhar(int valor) {
        Nodo novo = new Nodo(valor);
        novo.proximo = topo;
        topo = novo;
    }

    Integer desempilhar() {
        if (topo == null) return null;
        int valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    boolean vazia() {
        return topo == null;
    }

    void imprimir(String nome) {
        System.out.println(nome + ":");
        Nodo atual = topo;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class PilhasDinamicas {
    public static void main(String[] args) {
        Random random = new Random();

        Pilha p1 = new Pilha();
        Pilha p2 = new Pilha();
        Pilha p3 = new Pilha();

        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(9) + 1;
            if (num >= 1 && num <= 3)
                p1.empilhar(num);
            else if (num >= 4 && num <= 6)
                p2.empilhar(num);
            else
                p3.empilhar(num);
        }

        System.out.println("pilhas apos a fase 1:\n");
        p1.imprimir("p1");
        p2.imprimir("p2");
        p3.imprimir("p3");

        System.out.println("iniciando a  fase 2:\n");

        for (int i = 0; i < 100; i++) {
            int destino = random.nextInt(3) + 1;
            Pilha alvo, pilha1, pilha2;

            if (destino == 1) {
                alvo = p1;
                pilha1 = p2;
                pilha2 = p3;
            } else if (destino == 2) {
                alvo = p2;
                pilha1 = p1;
                pilha2 = p3;
            } else {
                alvo = p3;
                pilha1 = p1;
                pilha2 = p2;
            }

            if (pilha1.vazia() || pilha2.vazia()) {
                System.out.println("encerrou por que uma das pilhas esta vazia.");
                break;
            }

            int v1 = pilha1.desempilhar();
            int v2 = pilha2.desempilhar();

            System.out.println("empilhando os numeros" + v1 + " e " + v2 + " na pilha " + destino + "\n");

            alvo.empilhar(v2);
            alvo.empilhar(v1);

            System.out.println("situação atual:\n");
            p1.imprimir("p1");
            p2.imprimir("p2");
            p3.imprimir("p3");
        }

        System.out.println(" fim.");
    }
}
