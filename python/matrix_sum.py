# COMPLETA SOLO ESTA FUNCIÓN
def resolver(N, M, matriz):
    pass


N, M = map(int, input().split())

matriz = []

for _ in range(N):
    fila = list(map(int, input().split()))
    matriz.append(fila)

print(resolver(N, M, matriz))