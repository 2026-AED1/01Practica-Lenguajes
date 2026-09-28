#include <iostream>
using namespace std;

const int MAX = 1000;

// COMPLETA SOLO ESTA FUNCIÓN
int resolver(int N, int M, int matriz[MAX][MAX]) {
}

int main() {
    int N, M;
    cin >> N >> M;

    int matriz[MAX][MAX];

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> matriz[i][j];
        }
    }

    cout << resolver(N, M, matriz) << '\n';

    return 0;
}