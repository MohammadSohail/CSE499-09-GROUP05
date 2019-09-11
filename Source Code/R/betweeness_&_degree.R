library("igraph")
library("poweRlaw")
library("ggplot2")

# Just loading my data
edge_list <- read.csv("Amazon0302.csv")
g <- graph.data.frame(edge_list)

write.csv(betweenness(g), file = "betweeness_Amazon0302.csv")

write.csv(degree(g), file = "degree_Amazon0302.csv")
