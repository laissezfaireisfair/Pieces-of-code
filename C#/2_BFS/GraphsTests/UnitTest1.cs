using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;

namespace GraphsTests
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void MakingTest()
        {
            var graph = new Graphs.Graph(5);
            Assert.AreEqual(graph.VertexNumber, 5);
            Assert.AreEqual(graph.EdgeNumber, 0);
        }

        [TestMethod]
        public void FillingTest()
        {
            var graph = new Graphs.Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(1, 2);
            graph.AddEdge(2, 3);
            graph.AddEdge(3, 4);
            Assert.AreEqual(graph.VertexNumber, 5);
            Assert.AreEqual(graph.EdgeNumber, 4);
            Assert.IsTrue(graph.IsEdgeExist(0, 1));
            Assert.IsTrue(graph.IsEdgeExist(1, 2));
            Assert.IsTrue(graph.IsEdgeExist(2, 3));
            Assert.IsTrue(graph.IsEdgeExist(3, 4));
            Assert.IsFalse(graph.IsEdgeExist(0, 2));
            Assert.IsFalse(graph.IsEdgeExist(0, 3));
            Assert.IsFalse(graph.IsEdgeExist(0, 4));
            Assert.IsFalse(graph.IsEdgeExist(4, 0));
        }

        [TestMethod]
        public void CycleGraphTest()
        {
            var graph = new Graphs.Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(1, 2);
            graph.AddEdge(2, 3);
            graph.AddEdge(3, 4);
            graph.AddEdge(4, 0);
            Assert.AreEqual(graph.VertexNumber, 5);
            Assert.AreEqual(graph.EdgeNumber, 5);
            Assert.IsTrue(graph.IsEdgeExist(0, 1));
            Assert.IsTrue(graph.IsEdgeExist(1, 2));
            Assert.IsTrue(graph.IsEdgeExist(2, 3));
            Assert.IsTrue(graph.IsEdgeExist(3, 4));
            Assert.IsTrue(graph.IsEdgeExist(4, 0));
            Assert.IsFalse(graph.IsEdgeExist(0, 2));
            Assert.IsFalse(graph.IsEdgeExist(0, 3));
            Assert.IsFalse(graph.IsEdgeExist(0, 4));
        }

        /// <summary>
        /// Check for throwing an exception when you try to make graph without vertex
        /// </summary>
        [TestMethod]
        public void GraphNullSizeTest()
        {
            try
            {
                var graph = new Graphs.Graph(0);
                Assert.Fail(); // ArgumentException should be already threw there
            }
            catch (ArgumentException)
            {
                return;
            }
        }

        [TestMethod]
        public void CircleEdgeTest()
        {
            var graph = new Graphs.Graph(2);
            graph.AddEdge(0, 1);
            bool isEdge0to0 = graph.IsEdgeExist(0, 0);
            bool isEdge1to1 = graph.IsEdgeExist(1, 1);
            Assert.IsTrue(isEdge0to0);
            Assert.IsTrue(isEdge1to1);
        }

        [TestMethod]
        public void BadEdgesTest()
        {
            var graph = new Graphs.Graph(2);
            graph.AddEdge(0, 1);

            Assert.IsFalse(graph.IsEdgeExist(0, 2));
            Assert.IsFalse(graph.IsEdgeExist(0, -1));
            Assert.IsFalse(graph.IsEdgeExist(-1, 0));
            Assert.IsFalse(graph.IsEdgeExist(-1, 2));
        }

        private bool AreNeighboursEqual(List<int> expectedNeighbours, LinkedList<int> actualNeighbours)
        {
            if (expectedNeighbours.Count != actualNeighbours.Count)
                return false;
            foreach (int neighbour in actualNeighbours)
            {
                if (!expectedNeighbours.Contains(neighbour)) // Order does not matter
                    return false;
            }
            return true;
        }

        [TestMethod]
        public void NeighboursTest()
        {
            var graph = new Graphs.Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(0, 2);
            graph.AddEdge(0, 3);
            graph.AddEdge(4, 0);

            var expectedNeighbours = new List<int> {1, 2, 3};
            LinkedList<int> neighbours = graph.GetNeighboursList(0);

            Assert.IsTrue(AreNeighboursEqual(expectedNeighbours, neighbours));
        }

        [TestMethod]
        public void EmptyNeighboursTest()
        {
            var graph = new Graphs.Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(0, 2);
            graph.AddEdge(0, 3);
            graph.AddEdge(4, 0);

            var expectedNeighbours = new List<int>();
            LinkedList<int> neighbours = graph.GetNeighboursList(1);

            Assert.IsTrue(AreNeighboursEqual(expectedNeighbours, neighbours));
        }

        [TestMethod]
        public void StringTest()
        {
            var graph = new Graphs.Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(1, 2);
            graph.AddEdge(2, 3);
            graph.AddEdge(3, 4);
            graph.AddEdge(4, 0);
            string expected = "0: 1\n" +
                "1: 2\n" +
                "2: 3\n" +
                "3: 4\n" +
                "4: 0";

            string actual = graph.ToString();

            Assert.AreEqual(expected, actual);
        }
    }
}
