library("igraph")
library("poweRlaw")
library("ggplot2")

# Just loading my data
edge_list <- read.csv("com-amazon.ungraph.csv")
g <- as.matrix(graph.data.frame(edge_list))

e <- eigen(g)
e$values