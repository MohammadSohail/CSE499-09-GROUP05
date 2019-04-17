///frequency of each degree
# include <bits/stdc++.h>
using namespace std;

int arr[1000000];
int main() {

    freopen("degree_as_network.txt","r",stdin);
    freopen("degreeVSnode_as_network.csv","w",stdout);

    int n,d,t;
    int c = 0,s = 0;
    //5832
    while(cin >> n >> d){
        arr[d]++;
        c++;
    }
    //cout << c << " edges " << endl;
  cout << "DegreeNumber" << "," << "NumberOFnodes" << endl;
  int x;
    for(int i = 1; i < 98; i++){
        cout << i << "," << arr[i] << endl;

    }
    for(int i = 0; i < 5000; i++){
        if( arr[i] > s){
            s = arr[i];
           // t = i;
        }
    }
 //   cout << t << " degree has maximum" << s << " nodes" << endl;

    return 0;
}


