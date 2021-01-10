using Microsoft.VisualStudio.TestTools.UnitTesting;
using BfsInGraph;
using Graphs;

namespace BfsInGraphTests
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void AcyclicSuccessfulSearch()
        {
            var graph = new Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(1, 2);
            graph.AddEdge(2, 3);
            graph.AddEdge(3, 4);

            int distance0to4 = graph.GetShortestWayLength(0, 4);

            Assert.AreEqual(4, distance0to4);
        }

        [TestMethod]
        public void CyclicSuccessfulSearch()
        {
            var graph = new Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(1, 2);
            graph.AddEdge(2, 3);
            graph.AddEdge(3, 4);
            graph.AddEdge(4, 0);

            int distance0to4 = graph.GetShortestWayLength(0, 4);

            Assert.AreEqual(4, distance0to4);
        }

        [TestMethod]
        public void ManyWaysSuccessfulSearch()
        {
            var graph = new Graph(5);
            graph.AddEdge(0, 1);
            graph.AddEdge(1, 2);
            graph.AddEdge(2, 3);
            graph.AddEdge(3, 4);
            graph.AddEdge(4, 0);
            graph.AddEdge(0, 3);
            graph.AddEdge(0, 2);
            graph.AddEdge(2, 3);

            int distance0to4 = graph.GetShortestWayLength(0, 4);

            Assert.AreEqual(2, distance0to4);
        }

        [TestMethod]
        public void EmptyGraphTest()
        {
            var graph = new Graph(5);

            int distance0to4 = graph.GetShortestWayLength(0, 4);

            Assert.AreEqual(-1, distance0to4);
        }

        [TestMethod]
        public void NoWayButWayBackTest()
        {
            var graph = new Graph(5);
            graph.AddEdge(4, 0);
            graph.AddEdge(3, 0);
            graph.AddEdge(2, 0);
            graph.AddEdge(1, 0);
            graph.AddEdge(3, 2);
            graph.AddEdge(2, 1);

            int distance0to4 = graph.GetShortestWayLength(0, 4);

            Assert.AreEqual(-1, distance0to4);
        }
    }
}
