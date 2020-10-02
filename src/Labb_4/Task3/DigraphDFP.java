package Labb_4.Task3;
import Labb_4.Digraph;
public class DigraphDFP
{
    private boolean[] marked;  // marked[v] = true if v is reachable from source(s)
    private int count;         // number of vertices reachable from source(s)

    /**
     * Computes the vertices in digraph {@code G} that are
     * reachable from the source vertex {@code s}.
     * @param G the digraph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DigraphDFP(Digraph G, int s)
    {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(Digraph G, int v)
    {
        count++;
        marked[v] = true;
        for (int w : G.adj(v))
        {
            if (!marked[w])
                dfs(G, w);
        }
    }

    /**
     * Is there a directed path from the source vertex (or any
     * of the source vertices) and vertex {@code v}?
     * @param  v the vertex
     * @return {@code true} if there is a directed path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean marked(int v)
    {
        validateVertex(v);
        return marked[v];
    }

    /**
     * Returns the number of vertices reachable from the source vertex
     * (or source vertices).
     * @return the number of vertices reachable from the source vertex
     *   (or source vertices)
     */
    public int count()
    {
        return count;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertices(Iterable<Integer> vertices)
    {
        if (vertices == null)
            throw new IllegalArgumentException("argument is null");

        for (Integer v : vertices)
        {
            if (v == null)
                throw new IllegalArgumentException("vertex is null");

            validateVertex(v);
        }
    }
}