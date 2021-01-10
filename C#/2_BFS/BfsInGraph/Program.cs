using System;
using System.Collections.Generic;
using Graphs;

namespace BfsInGraph
{
    public static class GraphSearchExtension
    {
        /// <summary>
        /// Founds length of the shortest way from start to finish.
        /// If way does not exist, it returns -1
        /// </summary>
        public static int GetShortestWayLength(this Graphs.Graph graph, int start, int finish)
        {
            if (!graph.IsEdgeCorrect(start, finish))
                throw new ArgumentException("Search called for invalid vertex");

            int[] distances = new int[graph.VertexNumber];
            for (int i = 0; i < graph.VertexNumber; ++i)
                distances[i] = -1;
            distances[start] = 0;
            Queue<int> vertexToColor = new Queue<int>();
            vertexToColor.Enqueue(start);
            while(vertexToColor.Count != 0)
            {
                int vertexNow = vertexToColor.Dequeue();
                foreach (var neighbour in graph.GetNeighboursList(vertexNow))
                {
                    if (distances[neighbour] == -1 || distances[vertexNow] + 1 < distances[neighbour])
                    {
                        distances[neighbour] = distances[vertexNow] + 1;
                        vertexToColor.Enqueue(neighbour);
                    }
                }
            }
            return distances[finish];
        }
    }

    class Program
    {
        /// <summary>
        /// Reads size, amount of edges and edges list
        /// </summary>
        static Graph AskGraphFromConsole()
        {
            Console.WriteLine("Type graph size (amount of vertexes):");
            int graphSize = int.Parse(Console.ReadLine());
            var graph = new Graphs.Graph(graphSize);
            Console.WriteLine("Type amount of edges:");
            int edgesAmount = int.Parse(Console.ReadLine());
            for (int i = 0; i < edgesAmount; ++i)
            {
                Console.WriteLine("Type edge (just pair of numbers):");
                string[] edgeInput = Console.ReadLine().Split(' ');
                if (edgeInput.Length < 2)
                    throw new Exception("Bad input");
                int begin = int.Parse(edgeInput[0]);
                int end = int.Parse(edgeInput[1]);
                graph.AddEdge(begin, end);
            }
            return graph;
        }

        static void Main(string[] args)
        {
            try
            {
                Graph graph = AskGraphFromConsole();
                Console.WriteLine(graph);
                Console.WriteLine("Type start and end vertexes to search way length:");
                string[] wayInput = Console.ReadLine().Split(' ');
                if (wayInput.Length < 2)
                    throw new Exception("Bad input");
                int start = int.Parse(wayInput[0]);
                int finish = int.Parse(wayInput[1]);
                int distance = graph.GetShortestWayLength(start, finish);
                Console.WriteLine($"Distance between {start} and {finish} is {distance}");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
