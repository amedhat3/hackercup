#!/usr/bin/python
# imports

# Ahmed Medhat Othman
# amedhat.info

def main():
	fin = open('billboards.in', 'r')
	fout = open('billboards.out','w')
	T = long(fin.readline())
	for t in range(1, T+1):
		line = fin.readline().split()
		w = int(line[0])
		h = int(line[1])
		c = line[2:]
		maxl = 0
		for word in c:
			maxl = max(len(word), maxl)
			
		finish = False
		res = 0 
		size = 1
		while True:
			lc = 1
			lnw = 0
			for word in c:
				ww = size * len(word)
				if ww + lnw >= w:
					lc +=1
					lnw = ww + 1
				elif ww + lnw + 1 >= w:
					lc +=1
					lnw += ww
				else:
					lnw += ww + 1
				
				#print lc, size, lc*size,  h
				if lc*size > h:
					res = size -1
					finish = True
					break
				if ww > w:
					res = size - 1
					finish = True
					break
			if finish: break
			else: size +=1

		print w/maxl, h/len(c)
		fout.write('Case # {0}: {1}\n'.format(t, res))
	fin.close()
	fout.close()
		
if __name__ == '__main__':
	main()
	
	
	
