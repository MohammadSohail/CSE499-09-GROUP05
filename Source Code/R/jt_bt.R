
library("SAGx")
library("igraph")
library("poweRlaw")
library("ggplot2")


#G <- as.matrix(c(99,114,116,127,146,111, 125,143,148,157,133,139, 149, 160, 184))




G <- as.matrix(c(1266.43314, 1891.08269, 4412.3894, 31989.28866, 
                 
                 9.17391, 61.11111, 72.37705, 603.06889, 
                 
                 11752.64857, 18116.70758, 19105.3258, 24967.38829, 
                 
                 142.10986, 670945.77595, 1583160.9857, 47552794845.82855, 
                 
                 13.14198, 17.30282, 51.41424, 70.74157))


# create the class labels
g <- c(rep(1, 4),rep(2, 4),rep(3, 4), rep(4, 4), rep(5, 4))
# The groups have the medians
tapply(G, g, median)
# JT.test indicates that this trend is significant at the 5% level
JT.test(data = G, class = g, labs = c("GRP 1", "GRP 2", "GRP 3", "GRP 4", "GRP 5"), alternative = "two-sided")


