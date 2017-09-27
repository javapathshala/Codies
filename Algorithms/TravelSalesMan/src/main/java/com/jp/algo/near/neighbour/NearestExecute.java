/*
 * Copyright (c) Java Pathshala.
 * All rights reserved.
 *
 * This program is protected by copyright law but you are authorise to learn
 * & gain ideas from it. Its unauthorised use is explicitly prohibited &
 * any addition & removal of material. If want to
 * suggest any changes, you are welcome to provide your comments on GitHub
 * Social Code Area. Its unauthorised use gives Java Pathshala the right to
 * obtain retention orders and to prosecute the authors of any infraction.
 * www.javapathshala.com
 */
package com.jp.algo.near.neighbour;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 *
 *
 * @author Dimit Chadha
 * @since 1.0
 * @version 1.0
 */
public class NearestExecute
{

    Scanner scanner = null;

    public static void main(String[] args)
    {

        NearestExecute nearestExecute = new NearestExecute();
        int adjacency_matrix[][] = nearestExecute.createMatrix();

        nearestExecute.findRoute(adjacency_matrix);

    }

    private int[][] createMatrix()
    {
        int number_of_nodes;
        System.out.println("Enter the number of nodes(cities) in the graph");
        scanner = new Scanner(System.in);
        number_of_nodes = scanner.nextInt();
        System.out.println("Number of places - " + number_of_nodes);

        System.out.println("Enter the weights(distance between cities. Create Adjacency matrix");
        int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
        for (int i = 1; i <= number_of_nodes; i++)
        {
            for (int j = 1; j <= number_of_nodes; j++)
            {
                adjacency_matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        return adjacency_matrix;
    }

    private void findRoute(int[][] adjacencyMatrix)
    {
        System.out.println("the cites are visited as follows");
        Stack<Integer> stack = new Stack<Integer>();
        int numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1); // starting node
        int element, dst = 0, i;

        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");

        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }

            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
    }

}
