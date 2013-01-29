/**
 * @Author : Ahmad Medhat Othman
 * @Facebook username : a.medhat.cs
 * @CodeJame username : AMedOs
 * @TopCoder Handel : AMedOs
 * @Email :a.medhat.cs@gmail.com
 * */
#include <stdio.h>
#include <iostream>
#include <string>
#include <string.h>
#include <fstream>
#include <sstream>
#include <algorithm>
#include <math.h>
#include <vector>

using namespace std;

#define pb push_back
#define all(v) v.begin(),v.end()
#define sz  size()
//#define sz(x)  (int)x.size()

#define loop(i,m) for(ui i=0;i<m;i++)
#define loop2(i,m) for(i=0;i<m;i++)

#define loop4m(i,x,m) for(ui i=x;i<m;i++)
#define loop4m2(i,x,m) for(ui i=x;i<=m;i++)

#define mem(a,b) memset(a,b,sizeof(a))
#define mp make_pair
const double pi=acos(-1.0);
const double eps=1e-11;

typedef long long ll;
typedef unsigned int ui;
typedef stringstream ss;
typedef pair<int, int> pii;
typedef vector<pii> vpii;
typedef vector<string> vs;
typedef vector<vs> vvs;
typedef vector<int> vi;
typedef vector<vector<int> > vvi;

ifstream fin;
ofstream fout;

struct eqstr{
  bool operator()(int s1, int s2) const {
    return s1==s2;
  }
};


int main () {
	fin.open ("input.in");
	fout.open ("output.out");

	ui N,x;
	fin >> N;
	ui totsz = 46342;
	ui hold[totsz];
	
	loop(i,totsz)
	{
		hold[i] = i*i;
	}
	
	loop(i,N)
	{
		fin >> x;
		int res = 0; 
		for (ui j =0 ; j < totsz && hold[j] <= x/2.0 ; j++)
		{
			if (sqrt(x-hold[j]) == (((int)sqrt(x-hold[j]))*1.0))res++;
		}
		fout << res << endl;
	}
	return 0;
}
