# include <bits/stdc++.h>

using namespace std;
# define all(x) (x).begin(),(x).end()
# define ABS(x) ((x)<0?-(x):(x))
# define FABS(x) ((x)+eps<0?-(x):(x))
# define kase(a, t) for(int a = 1 ; a <= (t) ; ++a)
# define LEFTMOST ((63-__builtin_clzll((x)))
# define MOD(x, y) (((x)*(y))%mod)
# define MIN(a, b) ((a)<(b)?(a):(b))
# define MAX(a, b) ((a)>(b)?(a):(b))
# define mem(x, y) memset(x,y,sizeof(x))
# define NORM(x) if(x>=mod)x-=mod
# define ODD(x) (((x)&1)==0?(0):(1))
# define POPCOUNT __builtin_popcountll
# define RIGHTMOST __builtin_ctzll
# define NUMDIGIT(x, y)(((ll)(log10((x))/log10((y))))+1)
# define check(i, j) ((i >= 0 && i < R) && (j >= 0 && j < C))
# define LB(a, key) lower_bound(a.begin(),a.end(), key) -a.begin()
# define FasterIO ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0)
# define UB(a, key) upper_bound(a.begin(),a.end(), key) -a.begin()
# define Unique(V) (V).erase(unique((V).begin(),(V).end()),(V).end())

//std::mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
//#define random(a, b)        ((((rand() << 15) ^ rand()) % ((b) - (a) + 1)) + (a))
//#define ran(a, b)           rng() % ((b) - (a) + 1) + (a)


struct debugger {
    template<typename T>
    debugger &operator,(const T &v) {
        cerr << v << " ";
        return *this;
    }
} dbg;

# ifdef DEBUGMODE

# include <ctime>

clock_t tStart = clock();
# define debug(args...) {dbg,args; cerr<<endl;}
# define timeStamp debug ("Execution Time: ", (double)(clock() - tStart)/CLOCKS_PER_SEC)
# define bug printf("%d\n",__LINE__);

# else
# define debug(args...)  // Just strip off all debug tokens
# define timeStamp
# endif

typedef long long ll;
const int SIZE = 10E5;
const double eps = 1e-9;
typedef unsigned long long ull;
typedef pair<ll, ll> pll;
typedef pair<int, int> pii;
typedef vector<pll> pv;
typedef vector<ll> vl;
typedef vector<int> vi;
const int inf = (int) 10e9;
const ll INF = (ll) 10e18;
const double PI = 2 * acos(0.0);

int dx[] = {+1, -1, 0, 0};
int dy[] = {0, 0, +1, -1};
int hx[] = {+1, -1, -1, +1, -2, -2, +2, +2};
int hy[] = {+2, +2, -2, -2, +1, -1, +1, -1};
int fx[] = {+0, +0, +1, -1, -1, +1, -1, +1};
int fy[] = {-1, +1, +0, +0, +1, +1, -1, -1};
int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

template<typename T>
inline T GCD(T a, T b) {
    a = ABS(a), b = ABS(b);
    return !b ? a : GCD(b, a % b);
}

template<typename T>
inline T LCM(T x, T y) {
    T g = GCD(x, y);
    return x * (y / g);
}

template<typename T>
inline T power(T b, T p) {
    T res = 1, x = b;
    while (p) {
        if (p & 1) res = (res * x);
        x = (x * x);
        p >>= 1;
    }
    return res;
}

template<typename T>
inline T bigmod(T b, T p, T m) {
    T res = 1 % m, x = b % m;
    while (p) {
        if (p & 1) res = (res * x) % m;
        x = (x * x) % m;
        p >>= 1;
    }
    return res;
}
int arr[1000000];
int main() {
    FasterIO;

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
       // x += arr[i];
    }
   // cout << " nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn  " << endl;
    for(int i = 0; i < 5000; i++){
        if( arr[i] > s){
            s = arr[i];
           // t = i;
        }
    }
   // cout << " end" << endl;
 //   cout << t << " degree has maximum" << s << " nodes" << endl;
  //cout << *max_element(arr,arr+4000) << " max " << endl;



    return 0;
}


