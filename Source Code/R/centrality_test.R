library("igraph")
library("poweRlaw")
library("ggplot2")

# Just loading my data
edge_list <- read.csv("artist_edges.csv")
g <- graph.data.frame(edge_list)
#palette <- c("purple","blue","green","yellow","orange","red")
#par(mfrow=c(1,2))


#b<- betweenness(g)
#edge_betweenness(g)

write.csv(betweenness(g), file = "degree.csv")

write.csv(degree(g), file = "degree.csv")

write_graph(degree(g), "twitter_combined_out.txt")

degree.centrality = function(g, mode) {
  A = get.adjacency(g);
  o = rep(1, n);
  if (mode == "in") c = o %*% A else
    if (mode == "out") c = A %*% o else 
      c = o %*% (A + t(A)); 
    return(as.vector(c));
}  

# degree centrality
c.d   <- degree(g)
col <- as.integer(5*(c.d-min(c.d))/diff(range(c.d))+1)
set.seed(1)
plot(g,vertex.color=palette[col],main="Degree Centrality",
     layout=layout.fruchterman.reingold)

# eigenvalue centrality
c.e   <- evcent(g)$vector
col <- as.integer(5*(c.e-min(c.e))/diff(range(c.e))+1)
set.seed(1)
plot(g,vertex.color=palette[col],main="Eigenvalue Centrality",
     layout=layout.fruchterman.reingold)
