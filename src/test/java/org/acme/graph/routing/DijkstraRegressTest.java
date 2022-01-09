package org.acme.graph.routing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.acme.graph.TestGraphFactory;
import org.acme.graph.errors.NotFoundException;
import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Path;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests fonctionnels sur DijkstraPathFinder
 * 
 * @author MBorne
 *
 */
public class DijkstraRegressTest {

	private Graph graph;

	private DijkstraPathFinder finder;

	public static final double EPSILON = 1.0e-15;

	@Before
	public void setUp() throws Exception {
		this.graph = TestGraphFactory.createGraph01();
		this.finder = new DijkstraPathFinder(graph);
	}

	@Test
	public void testABFound() {
		Path path = finder.findPath(graph.findVertex("a"), graph.findVertex("b"));
		assertNotNull(path.getEdges());
		assertEquals(0, path.getLength(),EPSILON);
	}

	@Test
	public void testBANotFound() {
		//Path path = finder.findPath(graph.findVertex("b"), graph.findVertex("a"));
		NotFoundException exc = Assert.assertThrows(NotFoundException.class, ()-> finder.findPath(graph.findVertex("b"), graph.findVertex("a")));
		//assertNull("Path not found from 'b' to 'a'",exc.getMessage());
		assertEquals("Path not found from 'b' to 'a'",exc.getMessage());
	}

	@Test
	public void testACFoundWithCorrectOrder() {
		Path path = finder.findPath(graph.findVertex("a"), graph.findVertex("c"));
		assertNotNull(path.getEdges());
		assertEquals(0, path.getLength(),EPSILON);

		int index = 0;
		{
			Edge edge = path.getEdges().get(index++);
			assertEquals("a", edge.getSource().getId());
			assertEquals("b", edge.getTarget().getId());
		}
		{
			Edge edge = path.getEdges().get(index++);
			assertEquals("b", edge.getSource().getId());
			assertEquals("c", edge.getTarget().getId());
		}
	}
}
