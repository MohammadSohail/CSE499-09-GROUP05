
library("SAGx")
library("igraph")
library("poweRlaw")
library("ggplot2")


#G <- as.matrix(c(99,114,116,127,146,111, 125,143,148,157,133,139, 149, 160, 184))




G <- as.matrix(c(7.41288, 14.12593, 25.35185, 28.03077, 
                 
                 6.4918, 7.33333, 16.78261, 44.63556, 
                 
                 6.59556, 7.19828, 7.23276, 7.35436, 
                 
                 2.53323, 4.03565, 5.52985, 10.44595, 
                 
                 274.49438, 395.11327, 577.41975, 678.02817))


# create the class labels
g <- c(rep(1, 4),rep(5, 4),rep(3, 4), rep(2, 4), rep(4, 4))
# The groups have the medians
tapply(G, g, median)
# JT.test indicates that this trend is significant at the 5% level
JT.test(data = G, class = g, labs = c("GRP 1", "GRP 2", "GRP 3", "GRP 4", "GRP 5"), alternative = "two-sided")


