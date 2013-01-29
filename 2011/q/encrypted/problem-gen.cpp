/**
 * @Author : Ahmad Medhat Othman
 * @Facebook username : a.medhat.cs
 * @CodeJame userName : AMedOs
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
ifstream fhintin;
ofstream fout;

/converting numbers to text
int main () {
	fin.open ("input.in");
	fhintin.open("hint.in");
	fout.open ("problem.out");
	
	string dprob;
	fin >> dprob;
	string hint;
	fhintin >> hint;
	
	long totsz = dprob.sz; // the total size of the input 57344
	long linesz = 56; // the line size
	long nlines = totsz / linesz; // the number of lines in the file 1024
	
	int freq[10][nlines];
	mem(freq,0);
	
	int j =0;
	loop(i,totsz){
		if (i % linesz == 0) j++;
		
		if (dprob[i] == '0') {
			freq[0][j]++;
		} else if (dprob[i] == '1') {
			freq[1][j]++;
		} else if (dprob[i] == '2') {
			freq[2][j]++;
		} else if (dprob[i] == '3') {
			freq[3][j]++;
		} else if (dprob[i] == '4') {
			freq[4][j]++;
		} else if (dprob[i] == '5') {
			freq[5][j]++;
		} else if (dprob[i] == '6') {
			freq[6][j]++;
		} else if (dprob[i] == '7') {
			freq[7][j]++;
		} else if (dprob[i] == '8') {
			freq[8][j]++;
		} else if (dprob[i] == '9') {
			freq[9][j]++;
		}
	}
	
	loop(i,10) {
		loop(j,nlines) {
			cout << i << "-" << j << " -- > " << freq[i][j] <<endl;
		}
	}
	
	/*
	0 -- > 5311
	1 -- > 6004
	2 -- > 5796
	3 -- > 5709
	4 -- > 5863
	5 -- > 5706
	6 -- > 5731
	7 -- > 5737
	8 -- > 5704
	9 -- > 5783
	*/
	//hint 32
	return 0;
}
