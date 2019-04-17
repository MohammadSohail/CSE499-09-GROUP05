///count the degree of each node
# include <bits/stdc++.h>
using namespace std;

int arr[1000000];
int main() {

    freopen("as_network.txt","r",stdin);
    freopen("degree_as_network.txt","w",stdout);
    int u,v,t;
    int c = 0,s = 0;
    while(cin >> u >> v){
        arr[u]++;
        arr[v]++;
        c++;
    }
    // cout << c << " edges " << endl;
   ///cout << "Nodes" << "," << "Degree" << endl;
    for(int i = 0; i < 20777; i++){
        cout << i << " " << arr[i] << endl;
    }

    for(int i = 0; i < 100000; i++){
        if( arr[i] > s){
            s = arr[i];
            t = i;
        }
    }
 // cout << t << " node has " << s << " degree" << endl; ///2556 111

    return 0;
}

