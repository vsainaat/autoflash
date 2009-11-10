dat = []
for line in open("f:/data/prr2.dat"):
	dat.append(line.strip())
N=len(dat)

n = 80

for i in range(n):
	of = open("f:/data/aers/%d.dat"%i, "wb")
	for line in range(N/n*i, N/n*i+N/n):
		print >>of, dat[line]
	of.close()