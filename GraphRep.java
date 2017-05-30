/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Ben Spenciner, worked with Zach B.
 */
class GraphRep {
    boolean[][] matrix = new boolean[10000][10000];
    void nSpan() {
        ArrayList<Long> time = new ArrayList<>();
        long begin = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            matrix[0][i] = true;
        }
        time.add(System.nanoTime() - begin);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10000; j++) {
                matrix[i][j] = true;
            }
        }
        time.add(System.nanoTime() - begin);
        for (int i = 10; i < 100; i++) {
            for (int j = 0; j < 10000; j++) {
                matrix[i][j] = true;
            }
        }
        time.add(System.nanoTime() - begin);
        for (int i = 100; i < 1000; i++) {
            for (int j = 0; j < 10000; j++) {
                matrix[i][j] = true;
            }
        }
        time.add(System.nanoTime() - begin);
        for (int i = 1000; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                matrix[i][j] = true;
            }
        }
        time.add(System.nanoTime() - begin);
        for (int i = 0; i < time.size(); i++) {
            System.out.println(time.get(i));
        }
    }
    static class vertex {
        LinkedList<vertex> links = new LinkedList<>();
        vertex() {
        }
        vertex(LinkedList links) {
            this.links = links;
        }
        void link(vertex v) {
            this.links.add(v);
        }
    }
    static class Graph {
        ArrayList<vertex> vertices = new ArrayList<>();
        Graph() {
        }
        Graph(ArrayList<vertex> vertices) {
            this.vertices = vertices;
        }
        void add(int size) {
            for (int i = 0; i < size; i++) {
                vertices.add(new vertex());
            }
        }
        void nSpan() {
            int n = 0;
            ArrayList<Long> time = new ArrayList<>();
            long begin = System.nanoTime();
            for (int i = 0; i < 10000; i++) {
                vertices.get(i).link(vertices.get(i));
            }
            time.add(System.nanoTime() - begin);
            for (int i = 0; i < 10000; i++) {
                for (int j = 0; j < 10; j++) {
                    vertices.get(i).link(vertices.get(j));
                }
            }
            time.add(System.nanoTime() - begin);
            for (int i = 0; i < 10000; i++) {
                for (int j = 11; j < 100; j++) {
                    vertices.get(i).link(vertices.get(j));
                }
            }
            time.add(System.nanoTime() - begin);
            for (int i = 0; i < 10000; i++) {
                for (int j = 101; j < 1000; j++) {
                    vertices.get(i).link(vertices.get(j));
                }
            }
            time.add(System.nanoTime() - begin);
            for (int i = 0; i < 10000; i++) {
                for (int j = 1001; j < 10000; j++) {
                    vertices.get(i).link(vertices.get(j));
                }
            }
            time.add(System.nanoTime() - begin);
            for (int i = 0; i < time.size(); i++) {
                System.out.println(time.get(i));
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("List times");
        Graph nSpan = new Graph();
        nSpan.add(10000);
        nSpan.nSpan();
        System.out.println("Matrix times");
        GraphRep matrix = new GraphRep();
        matrix.nSpan();
    }
}