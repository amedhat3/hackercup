#!/usr/bin/python
# imports

# Ahmed Medhat Othman
# http://amedhat.info

import re

def main():
	fin = open('balanced_smileystxt.txt', 'r')
	fout = open('balanced.out','w')
	T = long(fin.readline())
	for t in range(1, T+1):
		line = fin.readline()
		par = []
		i = 0 
		res = ''
		
		r1 = []
		r2 = []
		
		l1 = []
		l2 = []
		
		for ch in line:
			ch = ch.lower()
			#print ch
			if ch == ' ' or ch == ':' or re.match("^[a-z]*$", ch) or ch == '\n' or ch == '\t':
				pass
			elif ch == '(':
				if i-1 >= 0:
					if line[i-1] != ':':
						l1.append(i)
					else:
						#smile :(
						l2.append(i)
				else:
					l1.append(i)
					
			elif  ch == ')':
				if i-1 >= 0:
					if line[i-1] != ':':
						r1.append(i)
					else:
						#smile :)
						r2.append(i)
				else:
					r1.append(i)
			else:
				res = 'NO'
				break;
			i += 1
		
		#print r1, r2
		#print l1, l2
		
		ma = max(len(r1), len(l1))
		
		i =0
		j =0
		
		m = len(r1)-1
		n = len(r2)-1
		
		if not res:
			for l in range(ma):
				if i < len(l1):
					if m >= 0 and l1[i] < r1[m]:
							i += 1
							m -= 1
					elif n >= 0 and l1[i] < r2[n]:
						i += 1
						n -= 1
					else:
						res = "NO"
						break
				elif m >= 0:
					if j < len(l2) and r1[m] > l2[j]:
						j += 1
						m -= 1
					else:
						res = "NO"
						break
			if not res:
				res = 'YES'
		
		fout.write('Case # {0}: {1}\n'.format(t, res))
		
		
	fin.close()
	fout.close()

if __name__ == '__main__':
	main()
	
	
	
