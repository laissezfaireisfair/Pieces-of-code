using System;
using System.Collections.Generic;

namespace Graphs
{
    /// <summary>
    /// Non-weighted, directed graph implicated as adjacency list.
    /// </summary>
    public class Graph
    {
        private List<LinkedList<int>> body;

        /// <summary>
        /// Makes graph without edges.
        /// </summary>
        /// <param name="size"> Amount of vertex </param>
        public Graph(int size)
        {
            if (size < 1)
                throw new ArgumentException("Try to make graph with not positive amount of vertex");

            body = new List<LinkedList<int>>(size);
            for (int i = 0; i < size; ++i)
                body[i] = new LinkedList<int>();
        }

        public int VertexNumber {
            get {
                if (body == null)
                    throw new InvalidOperationException("Graph is not initialised");

                return body.Count;
            }
        }

        public int EdgeNumber
        {
            get
            {
                if (body == null)
                    throw new InvalidOperationException("Graph is not initialised");

                int edgesCounter = 0;
                foreach (var neighbours in body)
                    edgesCounter += neighbours.Count;
                return edgesCounter;
            }
        }

        /// <summary>
        /// Checks if the edge can exist in the graph
        /// </summary>
        /// <param name="begin"> Begin vertex of the edge </param>
        /// <param name="end"> End vertex of the edge </param>
        public bool IsEdgeCorrect(int begin, int end)
        {
            return begin >= 0 && end >= 0 && begin < VertexNumber && end < VertexNumber;
        }


        public bool IsEdgeExist(int begin, int end)
        {
            if (!IsEdgeCorrect(begin, end))
                return false;

            if (begin == end)
                return true;

            foreach (var neighbour in body[begin])
                if (neighbour == end)
                    return true;
            return false;
        }

        public void AddEdge(int begin, int end)
        {
            if (!IsEdgeCorrect(begin, end))
                throw new ArgumentException("Can't add (" + begin + ", " + end + ") edge");

            if (!IsEdgeExist(begin, end))
                body[begin].AddFirst(end);
        }

        public LinkedList<int> GetNeighboursList(int begin)
        {
            return new LinkedList<int>(body[begin]);
        }
    }
}
