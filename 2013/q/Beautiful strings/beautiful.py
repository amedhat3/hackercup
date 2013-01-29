#!/usr/bin/python
# imports

# Ahmed Medhat Othman
# http://amedhat.info
import operator
import re

def main():
	fin = open('beautiful.in', 'r')
	fout = open('beautiful.out','w')
	T = long(fin.readline())
	for t in range(1, T+1):
		line = fin.readline()
		count = {}
		for ch in line:
			ch = ch.lower()
			if ch != ' ' and ch != '\n' and ch != '\t' and re.match("^[A-Za-z]*$", ch):
				if ch not in count:
					count[ch] = 0
				count[ch] += 1
		s_count = sorted(count.iteritems(), key=operator.itemgetter(1), reverse=True)
		c = 26
		res = 0
		for l in s_count:
			res += l[1] * c
			c -= 1
		fout.write('Case # {0}: {1}\n'.format(t, res))
	fin.close()
	fout.close()
		
if __name__ == '__main__':
	main()
